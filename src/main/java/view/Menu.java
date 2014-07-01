package view;

import model.Entity;
import service.Controller;
import service.UserInputValidator;
import java.util.*;

public class Menu {
    private final int EXIT = 0;
    private final int CHOICE_1 = 1;
    private final int CHOICE_2 = 2;
    private final int CHOICE_3 = 3;
    private final int CHOICE_4 = 4;
    private final int CHOICE_5 = 5;
    private Entity entity;


    public void printHello() {
        System.out.println(" ---------------------------------------------------------------------");
        System.out.println("|  Как ужасно болит голова и нет воспоминаний о последних событиях..  |");
        System.out.println("|  Ощущение не знакомого места не покидает тебя..                     |");
        System.out.println("|  В глазах начинает проясняться, ты встаешь и..                      |");
        System.out.println(" --------------------------------------------------------------------- ");
    }


    public void startProgram(UserInputValidator kb){
        int choice = 100;
        do {
            entity = getEntityContent(choice);
            choice = kb.readInt();

            switch (choice) {
                case EXIT:
                    System.out.println("Exit..");
                    System.out.println("*** GAME OVER ***");
                    System.exit(0);
                    break;
                case CHOICE_1:
                    entity = getEntityContent(entity.getChoice1());
                    break;
                case CHOICE_2:
                    entity = getEntityContent(entity.getChoice2());
                    break;
                case CHOICE_3:
                    entity = getEntityContent(entity.getChoice3());
                    break;
                case CHOICE_4:
                    entity = getEntityContent(entity.getChoice4());
                    break;
                case CHOICE_5:
                    entity = getEntityContent(entity.getChoice5());
                    break;
            }
        } while (choice != EXIT);

    }

    private Entity getEntityContent(int key){
        Map<Integer, Entity> entityMap = Controller.getEntityMap();
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
                System.err.println("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
                System.err.println("--- --- --- --- YOU LOSE. Re-try in next time ;) -- --- --- ---");
                System.err.println("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
                System.exit(0);
            }
            if (entity.getMenuChoiceOptions().equals(youWin)) {
                System.err.println(entity.getMenuContent());
                System.err.println("*** *** *** **** *** *** *** ******** *** **** *** *** *** *** ***");
                System.err.println("*** *** *** **** *** *** *** YOU WIN! *** *** **** *** *** *** ***");
                System.err.println("*** *** *** **** *** *** *** ******** *** **** *** *** *** *** ***");
                System.exit(0);
            }
        }
    }

}
