
public class Vehicle {
    private int currentSpeed;
    private int currentGear;
    private String engineState = "off";

    // Constructor
    Vehicle() {
        System.out.println("-");
    }

    // Method to slow down
    int slowDown(int speedDecrease) {
        if (currentSpeed - speedDecrease >= 0) {
            currentSpeed -= speedDecrease;
        } else {
            currentSpeed = 0;
        }
        return currentSpeed;
    }

    // Method to accelerate
    int accelerate(int speedIncrease) {
        currentSpeed += speedIncrease;
        return currentSpeed;
    }

    // Set the engine state
    void setEngineState(String engineState) {
        this.engineState = engineState;
    }

    // Get the engine state
    String getEngineState() {
        return this.engineState;
    }

    // Start engine method
    void startEngine() {
        if (engineState.equals("off")) {
            engineState = "on";
            System.out.println("Engine started.");
        } else {
            System.out.println("Engine is already running.");
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        car.startEngine();
        System.out.println("Engine State: " + car.getEngineState());
        System.out.println("Accelerating by 20: " + car.accelerate(20));
        System.out.println("Slowing down by 5: " + car.slowDown(5));
    }
}
