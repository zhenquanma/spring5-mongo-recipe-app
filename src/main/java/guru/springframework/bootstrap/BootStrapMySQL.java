package guru.springframework.bootstrap;

import guru.springframework.models.Category;
import guru.springframework.models.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(categoryRepository.count() == 0L) {
            log.debug("Loading Categories");
            loadCategories();
        }

        if(unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUOM();
        }
    }


    private void loadCategories() {
        Category american = new Category();
        american.setDescription("American");
        categoryRepository.save(american);

        Category chinese = new Category();
        chinese.setDescription("Chinese");
        categoryRepository.save(chinese);

        Category italian = new Category();
        italian.setDescription("Italian");
        categoryRepository.save(italian);

        Category mexican = new Category();
        mexican.setDescription("Mexican");
        categoryRepository.save(mexican);

        Category fastFood = new Category();
        fastFood.setDescription("Fast Food");
        categoryRepository.save(fastFood);
    }

    private void loadUOM() {
        UnitOfMeasure teaspoon = new UnitOfMeasure();
        teaspoon.setDescription("Teaspoon");
        unitOfMeasureRepository.save(teaspoon);

        UnitOfMeasure tablespoon = new UnitOfMeasure();
        tablespoon.setDescription("Tablespoon");
        unitOfMeasureRepository.save(tablespoon);

        UnitOfMeasure cup = new UnitOfMeasure();
        cup.setDescription("Cup");
        unitOfMeasureRepository.save(cup);

        UnitOfMeasure pint = new UnitOfMeasure();
        pint.setDescription("Pint");
        unitOfMeasureRepository.save(pint);

        UnitOfMeasure dash = new UnitOfMeasure();
        dash.setDescription("Dash");
        unitOfMeasureRepository.save(dash);

        UnitOfMeasure each = new UnitOfMeasure();
        each.setDescription("each");
        unitOfMeasureRepository.save(each);

        UnitOfMeasure pinch = new UnitOfMeasure();
        pinch.setDescription("Pinch");
        unitOfMeasureRepository.save(pinch);

        UnitOfMeasure ounce = new UnitOfMeasure();
        ounce.setDescription("Ounce");
        unitOfMeasureRepository.save(ounce);

        UnitOfMeasure pound = new UnitOfMeasure();
        pound.setDescription("Pound");
        unitOfMeasureRepository.save(pound);
    }

}
