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
    private Set<Entity> entitySet;
    private boolean isCreatedContent;


    public boolean isCreatedContent() {
        return isCreatedContent;
    }

    public Set<Entity> getGameContent(){
        createEntities();
        if (entitySet != null) {
            return entitySet;
        }
        return null;
    }


    private void createEntities() {
        entitySet = new HashSet<Entity>();
        gameConfigValues = new ConfigReader().getGameConfig();
        if (gameConfigValues != null) {
            Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Integer, String[]> entry = it.next();
                Entity entity = setEntityFields(entry.getKey(), entry.getValue());
                entitySet.add(entity);
            }
        }
        isCreatedContent = true;
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
        for (Entity entity: entitySet) {
            System.out.println(entity);
        }
    }


}
