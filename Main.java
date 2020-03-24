package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        String filePath = "";
        if (args.length > 0 && !args[0].matches("\\s+")) {
            filePath = args[0];
        }

        System.out.println("file" + filePath + "end");
        PhoneBookController phoneBookController = new PhoneBookController(filePath);

        do {
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            action = scanner.nextLine();
            String result = phoneBookController.handleAction(action);
            if (result.length() > 0) {
                System.out.println(result + "\n");
            }
        } while (!action.equals("exit"));
    }
}
