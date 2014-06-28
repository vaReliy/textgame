package view;

import model.Entity;
import service.*;
import java.util.*;

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
    private Map<Integer, Entity> entityMap;
    private Entity entity;


    public void start() {
        kb = new UserInputValidator();
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
                    break;
                case CHOICE_2:
                    entity = getEntityFromMap(entity.getChoice2());
                    break;
                case CHOICE_3:
                    entity = getEntityFromMap(entity.getChoice3());
                    break;
                case CHOICE_4:
                    entity = getEntityFromMap(entity.getChoice4());
                    break;
                case CHOICE_5:
                    entity = getEntityFromMap(entity.getChoice5());
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
                actionListener(entity);
                System.out.println(entity.getMenuContent());
                System.out.println(entity.getMenuChoiceOptions());
                return entity;
            }
        }
        return entity;
    }

    private void actionListener(Entity entity){
        String youLose = "DEAD";
        String youWin = "WIN";
        if (entity != null) {
            if (entity.getMenuChoiceOptions().equals(youLose)) {
                System.err.println(entity.getMenuContent());
                System.err.println("--- --- --- --- YOU LOSE. Re-try in next time ;) --- --- --- ---");
                System.exit(0);
            }
            if (entity.getMenuChoiceOptions().equals(youWin)) {
                System.err.println(entity.getMenuContent());
                System.err.println("*** *** *** **** *** *** *** YOU WIN! *** *** **** *** *** *** ***");
                System.exit(0);
            }
        }
    }

}
