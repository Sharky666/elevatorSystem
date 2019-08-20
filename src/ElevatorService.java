import java.util.ArrayList;

public class ElevatorService {
    private static final ElevatorService instance = new ElevatorService();
    private ArrayList<Elevator> elevators = new ArrayList<>();

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
