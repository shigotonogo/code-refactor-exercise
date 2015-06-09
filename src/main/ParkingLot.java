import java.util.HashMap;

public class ParkingLot {
    private boolean isFull;
    private HashMap<String, Car> cars = new HashMap<String, Car>();
    private int availableLots = 0;

    public ParkingLot(int available) {
        this.availableLots = available;
    }

    public ParkingLot() {
    }

    public boolean canPark() {
        return !isFull;
    }

    public void isFull(boolean full) {
        this.isFull = full;
    }

    public void park(Car car) {
        cars.put(car.getId(), car);
        this.availableLots--;
    }

    public Car getCar(Car car) {
        Car gettedCar = cars.get(car.getId());
        if (gettedCar != null) {
            this.availableLots++;
            return gettedCar;
        }
        return null;
    }

    public int getAvailableLots() {
        return availableLots;
    }
}
