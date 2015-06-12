import java.util.HashMap;

public class ParkingLot {
    private boolean isFull;
    private HashMap<String, Car> cars = new HashMap<String, Car>();
    private int availableLots = 0;
    private int total;

    public ParkingLot(int available, int total) {
        this.availableLots = available;
        this.total = total;
        this.isFull = this.availableLots == 0;
    }

    public boolean canPark() {
        return !isFull;
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

    public int getTotal() {
        return total;
    }
}
