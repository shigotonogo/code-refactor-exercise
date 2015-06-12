public interface Parkable {
    ParkingLot park(Car car);

    boolean canPark();

    Car getCar(Car car);
}
