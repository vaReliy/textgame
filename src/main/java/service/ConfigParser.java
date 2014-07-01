package service;

import model.Entity;
import java.util.*;

public class ConfigParser {

    public ConfigParser() {
    }

    public Map<Integer, Entity> createEntitiesContent(Map<Integer, String[]> gameConfigValues) {
        Map<Integer, Entity> entityMap = new HashMap<>();
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String[]> entry = it.next();
            Entity entity = setEntityFields(entry.getKey(), entry.getValue());
            entityMap.put(entity.getKey(), entity);
        }
            return entityMap;
    }

    private Entity setEntityFields(Integer key, String[] values){
        Entity entity = null;
        int MAX_CHOICE = 0;
        int CHOICE_1 = 1;
        int CHOICE_2 = 2;
        int CHOICE_3 = 3;
        int CHOICE_4 = 4;
        int CHOICE_5 = 5;
        int STATUS_GAME = 6;
        int MENU_CONTENT = 7;
        int MENU_CHOISE_OPTIONS = 8;
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

}
