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
    private boolean isCorrectReadConfig = false;
    private String fileNamePath = "src/main/resources/game_default.cfg";


    public ConfigReader() {
        gameConfigValues = configReadFromFile(fileNamePath);
    }

    public ConfigReader(String fileNamePath) {
        gameConfigValues = configReadFromFile(fileNamePath);
    }

    private Map<Integer, String[]> configReadFromFile(String fileName){
        Map<Integer, String[]> config = new HashMap<Integer, String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            Integer key;
            while ((line = br.readLine()) != null) {
                String[] valuesArr = line.split("~");
                key = Integer.parseInt(valuesArr[0]);
                String[] values = Arrays.copyOfRange(valuesArr, 1, valuesArr.length);
                System.out.println();
                config.put(key, values);
            }
            System.out.println("Configuration read!");
            correctStringsEntersInConfig(config);
//            printConfigAll(config);
            isCorrectReadConfig = true;
        } catch (FileNotFoundException fnfe) {
            System.err.println("Wrong filename: " + fnfe);
        } catch (NumberFormatException nfe) {
            System.err.println("Wrong values in config data file! Configuration not load!");
//            nfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    private void printConfigAll(){
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String[]> entry = it.next();
            System.out.println("KEY = " + entry.getKey());
            System.out.println("\tVALUES = " + Arrays.toString(entry.getValue()));
        }
    }

    private void correctStringsEntersInConfig(Map<Integer, String[]> gameConfigValues){
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String[]> entry = it.next();
            for (int i = 0; i < entry.getValue().length; i++) {
                 entry.getValue()[i] = convertEnters(new StringBuilder(entry.getValue()[i]));
            }
        }
    }

    private String convertEnters(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'n' && sb.charAt(i - 1) == '\\') {
                sb.insert(i, '\n').deleteCharAt(i - 1).deleteCharAt(i);
            }
        }
        return sb.toString();
    }


    public Map<Integer, String[]> getGameConfig(){
        if (isCorrectReadConfig){
            return gameConfigValues;
        }
        return null;
    }

    /*public static void main(String[] args) {
        ConfigReader cr = new ConfigReader();
        cr.printConfigAll();
    }*/
}
