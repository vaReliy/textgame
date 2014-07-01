package service;

import org.junit.*;
import static junit.framework.Assert.*;

public class UserInputValidatorTest {
    private UserInputValidator validator;
    private String inputStringText;
    private String inputStringCorrectValue;
    private String inputStringCorrectNegativeValue;
    private String inputStringNoCorrectValue;

    @Before
    public void setUp() throws Exception {
        inputStringText = "Test string";
        inputStringCorrectValue = "1203";
        inputStringCorrectNegativeValue = "-33";
        inputStringNoCorrectValue = "1122 ";
        validator = new UserInputValidator();
    }

    @Test
    public void testIsNumberCorrect() {
        assertTrue(validator.isNumber(inputStringCorrectValue));
    }

    @Test
    public void testIsNumberCorrectNegativeValue() {
        assertTrue(validator.isNumber(inputStringCorrectNegativeValue));
    }

    @Test
    public void testIsNumberNoCorrectValue() {
        assertFalse(validator.isNumber(inputStringNoCorrectValue));
    }

    @Test
    public void testIsNumberFromString() {
        assertFalse(validator.isNumber(inputStringText));
    }

    @Test
    public void testToNumberCorrect() {
        int value = validator.toNumber(inputStringCorrectValue);
        boolean result = false;
        if (value != -1) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void testToNumberCorrectNegativeValue() {
        int value = validator.toNumber(inputStringCorrectNegativeValue);
        boolean result = false;
        if (value != -1 && value < 0) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void testToNumberNoCorrectValue() {
        int value = validator.toNumber(inputStringNoCorrectValue);
        boolean result = false;
        if (value == -1) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void testToNumberFromString() {
        int value = validator.toNumber(inputStringText);
        boolean result = false;
        if (value == -1) {
            result = true;
        }
        assertTrue(result);
    }

}