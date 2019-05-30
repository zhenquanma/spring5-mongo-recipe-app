package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.models.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryCommandToCategoryTest {

    CategoryCommandToCategory converter;

    public static final String ID = "1";
    public static final String DESCRIPTION = "description";

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject(){
        converter.convert(null);
    }

    @Test
    public void testEmptyObject(){
        converter.convert(new CategoryCommand());
    }

    @Test
    public void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}