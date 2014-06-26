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
        int choise;
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.printMenu();
        choise = kb.readInt();
        System.out.println("\nYou entered '" + choise + "'.");
        contextMenu.printMenu();
        choise = kb.readInt();
        System.out.println("\nYou entered '" + choise + "'.");
        contextMenu.printMenu();
        choise = kb.readInt();
        System.out.println("\nYou entered '" + choise + "'.");
    }


}
