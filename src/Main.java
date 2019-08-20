import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ElevatorService elevatorService = ElevatorService.getInstance();
        ElevatorController elevatorController = new ElevatorController();
        for (int i = 0; i < 5; i++) {
            Elevator currentElevator = new Elevator();
            currentElevator.setCurrentFloor(i * 2);
            elevatorService.addElevator(currentElevator);
        }
        elevatorController.callElevator(5);
     }
}
