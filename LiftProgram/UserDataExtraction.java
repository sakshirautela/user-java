import java.util.Scanner;
public class UserDataExtraction extends Thread{
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lift System Started.");
        System.out.println("To use the lift, enter source and destination floors.");
        System.out.println("Type 'exit' at any prompt to quit.");

        while (true) {
            System.out.print("Enter source floor (or 'exit'): ");
            String srcInput = scanner.nextLine();

            if (srcInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Lift Application.");
                break;
            }

            System.out.print("Enter destination floor (or 'exit'): ");
            String destInputStr = scanner.nextLine();

            if (destInputStr.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Lift Application.");
                break;
            }

            try {
                int srcFloor = Integer.parseInt(srcInput);
                int destFloor = Integer.parseInt(destInputStr);

                if (srcFloor == destFloor) {
                    System.out.println("You are already on the destination floor.\n");
                } else {
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        scanner.close();
    }
}
