package model;

public class Entity {
    private Integer key;
    private Integer maxChoiceNumber;
    private Integer choice1;
    private Integer choice2;
    private Integer choice3;
    private Integer choice4;
    private Integer choice5;
    private String menuContent;
    private String menuChoiceOptions;
    private String statusGame;

    public Entity() {
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getMaxChoiceNumber() {
        return maxChoiceNumber;
    }

    public void setMaxChoiceNumber(Integer maxChoiceNumber) {
        this.maxChoiceNumber = maxChoiceNumber;
    }

    public Integer getChoice1() {
        return choice1;
    }

    public void setChoice1(Integer choice1) {
        this.choice1 = choice1;
    }

    public Integer getChoice2() {
        return choice2;
    }

    public void setChoice2(Integer choice2) {
        this.choice2 = choice2;
    }

    public Integer getChoice3() {
        return choice3;
    }

    public void setChoice3(Integer choice3) {
        this.choice3 = choice3;
    }

    public Integer getChoice4() {
        return choice4;
    }

    public void setChoice4(Integer choice4) {
        this.choice4 = choice4;
    }

    public Integer getChoice5() {
        return choice5;
    }

    public void setChoice5(Integer choice5) {
        this.choice5 = choice5;
    }

    public String getMenuContent() {
        return menuContent;
    }

    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }

    public String getMenuChoiceOptions() {
        return menuChoiceOptions;
    }

    public void setMenuChoiceOptions(String menuChoiceOptions) {
        this.menuChoiceOptions = menuChoiceOptions;
    }

    public String isStatusGame() {
        return statusGame;
    }

    public void setStatusGame(String statusGame) {
        this.statusGame = statusGame;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "key=" + key +
                ", maxChoiceNumber=" + maxChoiceNumber +
                ", choice1=" + choice1 +
                ", choice2=" + choice2 +
                ", choice3=" + choice3 +
                ", choice4=" + choice4 +
                ", choice5=" + choice5 +
                ", menuContent='" + menuContent + '\'' +
                ", menuChoiceOptions='" + menuChoiceOptions + '\'' +
                ", statusGame='" + statusGame + '\'' +
                '}';
    }
}
