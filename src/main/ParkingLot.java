import java.util.HashMap;

public class ParkingLot implements Parkable {
    private boolean isFull;
    private HashMap<String, Car> cars = new HashMap<>();
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

    public ParkingLot park(Car car) {
        cars.put(car.getId(), car);
        this.availableLots--;
        return this;
    }

    public Car getCar(Car car) {
        Car gotCar = cars.get(car.getId());
        if (gotCar != null) {
            this.availableLots++;
            return gotCar;
        }
        return null;
    }

    public int getAvailableLots() {
        return availableLots;
    }

    public double getUtilizationRate() {

        return (getTotal() - getAvailableLots()) * 1.0f / getTotal();
    }

    public int getTotal() {
        return total;
    }
}
