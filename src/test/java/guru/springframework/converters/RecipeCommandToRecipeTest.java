package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.NotesCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.models.Difficulty;
import guru.springframework.models.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    public static final String ID = "1";
    public static final String DESCRIPTION = "description";
    public static final Integer PREP_TIME = new Integer(5);
    public static final Integer COOK_TIME = new Integer(8);
    public static final Integer SERVINGS = new Integer(3);
    public static final String SOURCE = "Some Source";
    public static final String URL = "Some URL";
    public static final String DIRECTION = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final String CAT_ID_1 = "1";
    public static final String CAT_ID_2 = "2";
    public static final String INGRED_ID_1 = "3";
    public static final String INGRED_ID_2 = "4";
    public static final String NOTES_ID = "5";


    RecipeCommandToRecipe recipeConverter;


    @Before
    public void setUp() throws Exception {
        recipeConverter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(recipeConverter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(recipeConverter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception{
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setDirections(DIRECTION);
        recipeCommand.setDifficulty(DIFFICULTY);

        NotesCommand notes = new NotesCommand();
        notes.setId(NOTES_ID);

        recipeCommand.setNotes(notes);

        CategoryCommand category1 = new CategoryCommand();
        category1.setId(CAT_ID_1);

        CategoryCommand category2 = new CategoryCommand();
        category2.setId(CAT_ID_2);

        recipeCommand.getCategories().add(category1);
        recipeCommand.getCategories().add(category2);

        IngredientCommand ingredient1 = new IngredientCommand();
        ingredient1.setId(INGRED_ID_1);

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGRED_ID_2);

        recipeCommand.getIngredients().add(ingredient1);
        recipeCommand.getIngredients().add(ingredient2);

        Recipe recipe = recipeConverter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}

