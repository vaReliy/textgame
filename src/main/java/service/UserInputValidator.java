package service;

import java.io.*;

public class UserInputValidator {
    private BufferedReader kb;

    public UserInputValidator() {
    }




    public String inputLineFromKB() {
        String line = "";
        try {
            kb = new BufferedReader(new InputStreamReader(System.in));
            line = kb.readLine();
        } catch (Exception e) {
            System.err.println(e);
        } /* TODO close kb! */
        return line;
    }

    public boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
//            System.err.println(e);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }

    public Integer toNumber(String value){
        int val = -1;
        try {
            val = Integer.parseInt(value);
        } catch (NumberFormatException e) {
//            System.err.println(e); // ignore
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return val;
    }

    public Integer readInt(){
        return toNumber(inputLineFromKB());
    }

    public void closeKB(){
        if (kb != null) {
            try {
                kb.close();
            } catch (IOException e) {/*ignore*/}
        }
    }
}
