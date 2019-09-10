import java.util.ArrayList;

public class Elevator {
    private boolean isIdle = true;
    private ElevatorMovementThread movementThread;
    private int currentFloor;
    private ArrayList<Integer> targetFloors = new ArrayList<>();
    public static final int DOOR_TIMER = 2000;

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ArrayList<Integer> getTargetFloors() {
        return targetFloors;
    }

    public void addTargetFloor(int targetFloor)
    {
        this.targetFloors.add(targetFloor);
        if (this.isIdle) {
            this.startMovement();
        };
    }

    private void startMovement() {
        this.movementThread = new ElevatorMovementThread(this);
        this.movementThread.start();
    }
}
