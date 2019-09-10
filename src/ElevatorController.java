public class ElevatorController {
    private final ElevatorSelectionAlgorithm elevatorSelectionAlgorithm = new BasicElevatorSelectionAlgorithm();
    private final ElevatorService elevatorService = ElevatorService.getInstance();
    public void callElevator(int sourceFloor) {
        Elevator elevator = elevatorSelectionAlgorithm.getElevator(elevatorService.getElevators(), sourceFloor);
        elevator.addTargetFloor(sourceFloor);
    }
}
