package view;

import model.Entity;
import service.ConfigParser;
import service.UserInputValidator;

import java.util.Iterator;
import java.util.Map;

public class Menu {
    private final int EXIT = 0;
    private final int CHOICE_1 = 1;
    private final int CHOICE_2 = 2;
    private final int CHOICE_3 = 3;
    private final int CHOICE_4 = 4;
    private final int CHOICE_5 = 5;
    private final int LOSE = 888;
    private final int WINNER = 999;
    private UserInputValidator kb;
//    private ConfigParser configParser;
    private Map<Integer, Entity> entityMap;
    private Entity entity;


    public void start() {
        kb = new UserInputValidator();
//        configParser = new ConfigParser();
        entityMap = new ConfigParser().getEntityMap();
        printHello();
        startProgram();
        kb.closeKB();
    }

    private void printHello() {
        System.out.println(" --------------------------------------------------------------------------------------");
        System.out.println("|                                                                                      |");
        System.out.println("|                             IT'S TIME TO GAME                                        |");
        System.out.println("|                                                                                      |");
        System.out.println(" -------------------------------------------------------------------------------------- ");
    }


    public void startProgram(){
        int choice = 100;
        do {
            entity = getEntityFromMap(choice);
            choice = kb.readInt();

            switch (choice) {
                case EXIT:
                    System.out.println("Exit..");
                    System.out.println("*** GAME OVER ***");
                    System.exit(0);
                    break;
                case CHOICE_1:
                    entity = getEntityFromMap(entity.getChoice1());
//                    choice = kb.readInt();
                    break;
                case CHOICE_2:
                    entity = getEntityFromMap(entity.getChoice2());
//                    choice = kb.readInt();
                    break;
                case CHOICE_3:
                    entity = getEntityFromMap(entity.getChoice3());
//                    choice = kb.readInt();
                    break;
                case CHOICE_4:
                    entity = getEntityFromMap(entity.getChoice4());
//                    choice = kb.readInt();
                    break;
                case CHOICE_5:
                    entity = getEntityFromMap(entity.getChoice5());
//                    choice = kb.readInt();
                    break;
                case LOSE:
                    //TODO LOSE
                    System.out.println("== You LOSE! ==");
                    System.out.println("*** GAME OVER ***");
                    System.exit(0);
                    break;
                case WINNER:
                    System.out.println("--- >>> You WIN! <<< ---");
                    //TODO WINNER
                    break;
            }
        } while (choice != EXIT);

    }

    private Entity getEntityFromMap(int key){
        Iterator<Map.Entry<Integer, Entity>> it = entityMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Entity> entry = it.next();
            if (entry.getKey() == key) {
                entity = entry.getValue();
                System.out.println(entity.getMenuContent());
                System.out.println(entity.getMenuChoiceOptions());
                return entity;
            }
        }
        return entity;
    }

}
