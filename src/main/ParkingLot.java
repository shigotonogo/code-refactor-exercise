import java.util.HashMap;

public class ParkingLot {
    private boolean isFull;
    private HashMap<String, Car> cars = new HashMap<String, Car>();

    public boolean canPark() {
        return !isFull;
    }

    public void isFull(boolean full) {
        this.isFull = full;
    }

    public void park(Car car) {
        cars.put(car.getId(), car);
    }

    public Car getCar(Car car) {
        return cars.get(car.getId());
    }
}
