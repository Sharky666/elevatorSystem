import java.util.ArrayList;

public class ElevatorService {
    private static ElevatorService instance = new ElevatorService();
    private ArrayList<Elevator> elevators;

    private ElevatorService() {}

    public void addElevator(Elevator elevator) {
        this.elevators.add(elevator);
    }

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }

    public static ElevatorService getInstance() {
        return instance;
    }
}
