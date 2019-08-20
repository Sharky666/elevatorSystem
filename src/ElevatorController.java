public class ElevatorController {
    private final BasicElevatorSelectionAlgorithm basicElevatorSelectionAlgorithm = new BasicElevatorSelectionAlgorithm();
    private final ElevatorService elevatorService = ElevatorService.getInstance();
    public ElevatorController() {}
    public void callElevator(int sourceFloor) {
        Elevator elevator = basicElevatorSelectionAlgorithm.getElevator(elevatorService.getElevators(), sourceFloor);
        elevator.addTargetFloor(sourceFloor);
    }
}
