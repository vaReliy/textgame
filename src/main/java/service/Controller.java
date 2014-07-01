package service;

import model.Entity;
import view.Menu;

import java.util.Map;

public class Controller {
    private UserInputValidator kb;
    private ConfigReader configReader = new ConfigReader();
    private static Map<Integer, Entity> entityMap;
    private Menu menu;

    public Controller() {
    }

    public static Map<Integer, Entity> getEntityMap() {
        return entityMap;
    }


    public void startProgram(){
        menu = new Menu();
        ConfigParser parser = new ConfigParser();
        kb = new UserInputValidator();
        Map<Integer, String[]> config = configReader.configReadFromFile();
        entityMap = parser.createEntitiesContent(config);

        menu.printHello();
        menu.startProgram(kb);

        kb.closeKB();
    }

    public boolean verifyConfigFile(String configFileName) {
        return configReader.verifyConfigKeys(configFileName);
    }

}
