import java.util.ArrayList;

public class Main {
    private static final int ELEVATOR_NUMBER = 2;
    public static void main(String[] args) {
        ElevatorService elevatorService = ElevatorService.getInstance();
        ElevatorController elevatorController = new ElevatorController();
        for (int i = 0; i < ELEVATOR_NUMBER; i++) {
            Elevator currentElevator = new Elevator();
            currentElevator.setCurrentFloor(i * 2);
            elevatorService.addElevator(currentElevator);
        }
        elevatorController.callElevator(5);
    }
}
