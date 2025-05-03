package LiftProgram;

import java.util.Scanner;

public class UserDataExtration {
    public void getUserData() {
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
            System.out.print("Enter destination floor : ");
            int destInput = scanner.nextInt();

            try {
                int srcFloor = Integer.parseInt(srcInput);
                int destFloor = destInput;
                if (srcFloor == destFloor) {
                    System.out.println("You are already on the destination floor.");
                } else {
                    System.out.println("Moving lift from floor " + srcFloor + " to floor " + destFloor + "...");
                    System.out.println("Lift arrived at floor " + destFloor);
                }
                int dir=0;
                if(destFloor>srcFloor){
                    dir=1;
                }
                LiftData obj=new LiftData(dir,destFloor,srcFloor);
            } catch (Exception e) {
                System.out.println("Invalid floor number. Please enter integers only.");
            }

            System.out.println(); 
        }

        scanner.close();


    }
}
