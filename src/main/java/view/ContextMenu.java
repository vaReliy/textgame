package view;

public class ContextMenu {
    private String menuData = "Hello!\n" +
            "It's is a default menu data!\n" +
            "Please, enter your choice:\n";

    private String choiceOptions = "1.\tContinue\n" +
            "2.\tStay\n" +
            "0.\tExit from game";

    public ContextMenu() {
    }

    public String getMenuData() {
        return menuData;
    }

    public void setMenuData(String menuData) {
        this.menuData = menuData;
    }

    public String getChoiceOptions() {
        return choiceOptions;
    }

    public void setChoiceOptions(String choiceOptions) {
        this.choiceOptions = choiceOptions;
    }

    public void printMenuData(String menuData){
        System.out.println(menuData);
    }

    public void printChoiceOptions(String choiceOptions){
        System.out.println(choiceOptions);
    }

    public void printMenu() {
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        printMenuData(menuData);
        printChoiceOptions(choiceOptions);
    }
}
