import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicElevatorSelectionAlgorithm implements ElevatorSelectionAlgorithm {

    @Override
    public Elevator getElevator(ArrayList<Elevator> elevators, int sourceFloor) {
        // Sort elevators by priority based upon the algorithm
        Stream<Elevator> sortedElevators = elevators.stream().sorted(new Comparator<Elevator>() {
            @Override
            public int compare(Elevator e1, Elevator e2) {
                // The difference in distance of the two elevators from the source floor
                // if the distance of the two elevators from the source floor is equal 0 will be returned.
                // Otherwise, if the Int is signed, then e1 is closer to the source floor and vice versa
                int r = Integer.compare(calculateDistance(sourceFloor, e1.getCurrentFloor()) - calculateDistance(sourceFloor, e2.getCurrentFloor()), 0);

                // Since the distance is equal, more logic is required to determine the preferred elevator
                if (r == 0) {
                    if (e1.isIdle() != e2.isIdle()) {
                        // Idle elevators are preferred
                        return e1.isIdle() ? -1 : 1;
                    }
                    else if (isPassing(e1, sourceFloor) != isPassing(e2, sourceFloor)) {
                        // Elevators passing by the source floor are preferred
                        return isPassing(e1, sourceFloor) ? -1 : 1;
                    }

                }
                // Closest elevator is preferred
                return r;
            }
        });

        List<Elevator> elevatorList = sortedElevators.collect(Collectors.toList());

        // Return the elevator that fits the scenario the best
        return elevatorList.get(0);
    }

    private int calculateDistance(int sourceFloor, int currentFloor) {
       return Math.abs(sourceFloor - currentFloor);
    }

    private boolean isPassing(Elevator elevator, int sourceFloor) {
        if (elevator.isIdle()) {
            return false;
        }
        int targetFloorVector = elevator.getCurrentFloor() - elevator.getTargetFloors().get(0);
        int sourceFloorVector = elevator.getCurrentFloor() - sourceFloor;

        if (targetFloorVector * sourceFloorVector > 0 && Math.abs(targetFloorVector) > Math.abs(sourceFloorVector)) {
            return true;
        }
        return false;
    }
}
