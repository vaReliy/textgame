package service;

import org.junit.*;
import static junit.framework.Assert.*;

public class UserInputValidatorTest {
    private UserInputValidator validator;
    private String inputString;

    @Before
    public void setUp() throws Exception {
        inputString = "Test string";
        validator = new UserInputValidator();
    }

    @Test
    public void testIsNumber() {
        assertTrue(validator.isNumber("12033321"));
        assertFalse(validator.isNumber(inputString));
        assertFalse(validator.isNumber(" 1122"));
        assertFalse(validator.isNumber(" 11  22"));
        assertFalse(validator.isNumber("223 "));
        assertFalse(validator.isNumber("!223"));
        assertTrue(validator.isNumber("-1"));
        assertTrue(validator.isNumber("0"));
        assertTrue(validator.isNumber("-3"));
        assertFalse(validator.isNumber("-3 "));
    }

    @Test
    public void testToNumber() {
        System.out.println("testToNumber: " + validator.toNumber("12033321"));
        System.out.println("testToNumber: " + validator.toNumber("inputString"));
        System.out.println("testToNumber: " + validator.toNumber(" 1122"));
        System.out.println("testToNumber: " + validator.toNumber(" 11  22"));
        System.out.println("testToNumber: " + validator.toNumber("223 "));
        System.out.println("testToNumber: " + validator.toNumber("!223"));
        System.out.println("testToNumber: " + validator.toNumber("-1"));
        System.out.println("testToNumber: " + validator.toNumber("0"));
        System.out.println("testToNumber: " + validator.toNumber("-3"));
        System.out.println("testToNumber: " + validator.toNumber("-3 "));
    }
}