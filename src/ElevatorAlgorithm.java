import java.util.ArrayList;

public  interface ElevatorAlgorithm {
    /**
     *
     * @param elevators List of elevators
     * @param sourceFloor What floor the order was made from
     * @return
     */
    public Elevator getElevator(ArrayList<Elevator> elevators, int sourceFloor);
}
