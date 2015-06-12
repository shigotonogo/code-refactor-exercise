/**
 * Created by ywdong on 6/12/15.
 */
public interface Parkable {
    ParkingLot park(Car car);

    boolean canPark();

    Car getCar(Car car);
}
