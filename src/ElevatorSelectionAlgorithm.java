import java.util.ArrayList;

public  interface ElevatorSelectionAlgorithm {
    /**
     * Returns an elevator that best fits the given scenario according to the algorithm
     * @param elevators List of elevators
     * @param sourceFloor What floor the order was made from
     * @return Elevator
     */
    public Elevator getElevator(ArrayList<Elevator> elevators, int sourceFloor);
}
