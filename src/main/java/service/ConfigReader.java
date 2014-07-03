package service;

import java.io.*;
import java.util.*;


public class ConfigReader {
    private Map<Integer, String[]> gameConfigValues;
    private boolean isCorrectReadConfig = false;
    private String fileNamePath = "src/main/resources/game_default.cfg";
//    private String fileNamePath = "game_default.cfg";


    public ConfigReader() {
    }

    protected Map<Integer, String[]> configReadFromFile(){
        Map<Integer, String[]> config = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNamePath));
            String line;
            Integer key;
            while ((line = br.readLine()) != null) {
                String[] valuesArr = line.split("~");
                key = Integer.parseInt(valuesArr[0]);
                String[] values = Arrays.copyOfRange(valuesArr, 1, valuesArr.length);
                config.put(key, values);
            }
            System.out.println("Configuration read!");
            gameConfigValues = correctStringsEntersInConfig(config);
            isCorrectReadConfig = true;
        } catch (FileNotFoundException fnfe) {
            System.err.println("Wrong filename: " + fnfe);
            System.exit(0);
        } catch (NumberFormatException nfe) {
            System.err.println("Wrong values in config data file! Configuration not load!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    protected boolean verifyConfigKeys(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            Integer key;
            while ((line = br.readLine()) != null) {
                String[] valuesArr = line.split("~");
                key = Integer.parseInt(valuesArr[0]);
            }
            fileNamePath = fileName;
            return true;
        } catch (FileNotFoundException fnfe) {
            System.err.println("Wrong filename: " + fnfe);
            System.exit(0);
        } catch (NumberFormatException nfe) {
            System.err.println("Wrong values in config data file! Configuration not load!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    protected void printConfigAll(){
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String[]> entry = it.next();
            System.out.println("KEY = " + entry.getKey());
            System.out.println("\tVALUES = " + Arrays.toString(entry.getValue()));
        }
    }

    private Map<Integer, String[]> correctStringsEntersInConfig(Map<Integer, String[]> gameConfigValues){
        Iterator<Map.Entry<Integer, String[]>> it = gameConfigValues.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String[]> entry = it.next();
            for (int i = 0; i < entry.getValue().length; i++) {
                 entry.getValue()[i] = convertEnters(new StringBuilder(entry.getValue()[i]));
            }
        }
        return gameConfigValues;
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

}
