public interface Parkable extends Nameable {
    ParkingLot park(Car car);

    boolean canPark();

    Car getCar(Car car);
}
