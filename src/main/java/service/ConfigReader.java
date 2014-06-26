package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConfigReader {
    private Map<Integer, String[]> gameConfigValues;
    private String fileNamePath = "src/main/resources/game_default.src";

    public Map<Integer, String[]> configReadFromFile(String fileName){
        Map<Integer, String[]> config = new HashMap<Integer, String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            Integer key;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                String[] valuesArr = line.split("~");
                key = Integer.parseInt(valuesArr[0]);
                String[] values = Arrays.copyOfRange(valuesArr, 1, valuesArr.length);
                System.out.println();
                config.put(key, values);
            }
            System.out.println("Configuration read!");
            printConfigAll(config);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    public void printConfigAll(Map<Integer, String[]> gameConfigValues){
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String[]> entry = it.next();
            System.out.println("KEY = " + entry.getKey());
            System.out.println("VALUES = " + Arrays.toString(entry.getValue()));
        }
    }

    public static void main(String[] args) {
        String fileNamePath = "src/main/resources/game_default.src";
        ConfigReader cr = new ConfigReader();
        cr.configReadFromFile(fileNamePath);
    }
}
