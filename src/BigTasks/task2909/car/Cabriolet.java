package BigTasks.task2909.car;

public class Cabriolet extends Car{

    @Override
    public int getMaxSpeed() { return MAX_CABRIOLET_SPEED;}

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }
}