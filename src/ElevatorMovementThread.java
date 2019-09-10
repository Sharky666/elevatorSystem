public class ElevatorMovementThread extends Thread {
    private Elevator elevator;
    public ElevatorMovementThread(Elevator elevator) {
        this.elevator = elevator;
    }

    private void moveToNextFloor() throws Exception {
//        the distance of the elevator from the sourceFloor
        int distance = (elevator.getCurrentFloor() - elevator.getTargetFloors().get(0));
//        the direction the elevator needs to take in order to get to the sourceFloor
        int yVector = Integer.compare(0, distance);
        for (int i = 0; i < Math.abs(distance); i++) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + yVector);
            System.out.println(elevator.getCurrentFloor());
            Thread.sleep(1000);
        }
        elevator.getTargetFloors().remove(0);
    }

    @Override
    public void run() {
        this.elevator.setIdle(false);
        while (elevator.getTargetFloors().size() > 0) {
            try {
                System.out.println("moving");
                this.moveToNextFloor();
                System.out.println("landing...");
                Thread.sleep(2000);
            }
            catch (Exception e) {
               System.out.println(e);
            }
        }
        this.elevator.setIdle(true);
    }
}
