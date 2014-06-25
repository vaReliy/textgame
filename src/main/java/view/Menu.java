package view;

import service.UserInputValidator;

public class Menu {
    private UserInputValidator kb;

    public void start() {
        kb = new UserInputValidator();
        printHello();

        kb.closeKB();
    }

    private void printHello() {
        System.out.println("Enter String:");
        String str = kb.inputLineFromKB();
        System.err.println(kb.isNumber(str));
        System.out.println("Enter number:");
        str = kb.inputLineFromKB();
        System.err.println(kb.isNumber(str));
        System.out.println("Enter String:");
        str = kb.inputLineFromKB();
        System.err.println(kb.isNumber(str));
        System.out.println("Enter number:");
        str = kb.inputLineFromKB();
        System.err.println(kb.isNumber(str));
    }


}
