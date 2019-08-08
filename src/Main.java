import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Elevator currentElevator = new Elevator();
            currentElevator.setCurrentFloor(i * 2);
//            currentElevator.setIdle(true);
            elevators.add(currentElevator);
        }
        elevators.get(3).setIdle(true);
        elevators.get(2).setTargetFloor(6);
        BasicElevatorSelectionAlgorithm basic = new BasicElevatorSelectionAlgorithm();
        System.out.println(basic.getElevator(elevators, 5).getCurrentFloor());
    }
}
