import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicElevatorSelectionAlgorithm implements ElevatorAlgorithm {

    @Override
    public Elevator getElevator(ArrayList<Elevator> elevators, int sourceFloor) {
        Stream<Elevator> sortedElevators = elevators.stream().sorted(new Comparator<Elevator>() {
            @Override
            public int compare(Elevator e1, Elevator e2) {
//                the ratio of the distance from the two elevators to the source floor minus each other
                int ratio = calculateDistance(sourceFloor, e1.getCurrentFloor()) - calculateDistance(sourceFloor, e2.getCurrentFloor());
//                if the distance of the two elevators is equal and the passing state is not equal
//                TODO: give priority to idle elevators, if one elevator is not passing by, and the other is idle: the if doesn't execute
                if (ratio == 0) {
                    if (e1.isIdle() != e2.isIdle()) {
//                    if e1 is idle, return -1, else 1
                        return e1.isIdle() ? -1 : 1;
                    }
                    else if (isPassing(e1, sourceFloor) != isPassing(e2, sourceFloor)) {
//                    if e1 is passing, return -1, else 1
                        return isPassing(e1, sourceFloor) ? -1 : 1;
                    }

                }
//                    return -1, 0 or 1 based upon the ratio
                    return Integer.compare(ratio, 0);
            }
        });
        List<Elevator> elevatorList = (sortedElevators.collect(Collectors.toList()));
        for (Elevator elevator : elevatorList) {
            System.out.println(elevator.getCurrentFloor() + (elevator.isIdle() ? " idle" : ""));
        }
        System.out.println("BITCH");
        return elevatorList.get(0);
    }

    private int calculateDistance(int sourceFloor, int currentFloor) {
       return Math.abs(sourceFloor - currentFloor);
    }
    private boolean isPassing(Elevator elevator, int sourceFloor) {
        if (elevator.isIdle()) {
            return false;
        }
        int targetFloorVector = elevator.getCurrentFloor() - elevator.getTargetFloor();
        int sourceFloorVector = elevator.getCurrentFloor() - sourceFloor;

        if (targetFloorVector * sourceFloorVector > 0 && Math.abs(targetFloorVector) > Math.abs(sourceFloorVector)) {
            return true;
        }
        return false;
    }
}
