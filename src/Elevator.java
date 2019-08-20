import java.util.ArrayList;

public class Elevator {
    private boolean isIdle = true;
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
            this.moveToTargetFloor();
        };
    }

    private void moveToTargetFloor() {
        this.setIdle(false);
        int distance = (this.currentFloor - this.targetFloors.get(0));
        int yVector = Integer.compare(0, distance);
        for (int i = 0; i < Math.abs(distance); i++) {
            this.currentFloor += yVector;
            System.out.println(this.getCurrentFloor());
        }
        this.targetFloors.clear();
        this.setIdle(true);
    }
}
