package service;

import model.Entity;
import java.util.*;

public class ConfigParser {
    private final int MAX_CHOICE = 0;
    private final int CHOICE_1 = 1;
    private final int CHOICE_2 = 2;
    private final int CHOICE_3 = 3;
    private final int CHOICE_4 = 4;
    private final int CHOICE_5 = 5;
    private final int STATUS_GAME = 6;
    private final int MENU_CONTENT = 7;
    private final int MENU_CHOISE_OPTIONS = 8;
    private Map<Integer, String[]> gameConfigValues;
    private Map<Integer, Entity> entityMap;
    private boolean isCreatedContent;

    public ConfigParser() {
        createEntities();
    }

    public boolean isCreatedContent() {
        return isCreatedContent;
    }

    public Map<Integer, Entity> getEntityMap() {
        if(entityMap == null){
            createEntities();
            return entityMap;
        }
        return entityMap;
    }

    private void createEntities() {
        if (gameConfigValues == null) {
            gameConfigValues = new ConfigReader().getGameConfig();
            isCreatedContent = false;
            entityMap = new HashMap<Integer, Entity>();
            Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String[]> entry = it.next();
                Entity entity = setEntityFields(entry.getKey(), entry.getValue());
                entityMap.put(entity.getKey(), entity);
            }
            isCreatedContent = true;
        }
    }

    private Entity setEntityFields(Integer key, String[] values){
        Entity entity = null;
        try {
            entity = new Entity();
            entity.setKey(key);
            entity.setMaxChoiceNumber(Integer.parseInt(values[MAX_CHOICE]));
            entity.setChoice1(Integer.parseInt(values[CHOICE_1]));
            entity.setChoice2(Integer.parseInt(values[CHOICE_2]));
            entity.setChoice3(Integer.parseInt(values[CHOICE_3]));
            entity.setChoice4(Integer.parseInt(values[CHOICE_4]));
            entity.setChoice5(Integer.parseInt(values[CHOICE_5]));
            entity.setStatusGame(values[STATUS_GAME]);
            entity.setMenuContent(values[MENU_CONTENT]);
            entity.setMenuChoiceOptions(values[MENU_CHOISE_OPTIONS]);
        } catch (Exception e) {
            System.err.println("ERROR in setEntityFields: " + e);
            entity = null;
//            e.printStackTrace();
        }
        return entity;
    }

    public void printContent(){
        for (Map.Entry<Integer, Entity> entity: entityMap.entrySet()) {
            System.out.println(entity.getValue().getKey());
        }
    }


}
