import service.Controller;

public class Main {
    public static void main(String[] args) {
        Controller program = new Controller();
        if (args != null && args.length > 0 && program.verifyConfigFile(args[0])) {
            System.out.println("run '" + args[0] + "' configuration...");
        } else {
            System.out.println("run default configuration...");
        }
        program.startProgram();


    }
}
