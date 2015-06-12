import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingBoyTest {

    private ParkingLot lot1;
    private ParkingLot lot2;
    private Car car;

    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot("", 5, 2);
        lot2 = new ParkingLot("", 5, 3);
        car = new Car("1");
    }

    @Test
    public void testBoyCanParkCarToTheNotFullLot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy("");
        lot1 = new ParkingLot("", 5, 0);
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(lot2));
    }

    @Test
    public void testBoyCanParkCarToTheFirstLotWhenAllLotsCanPark() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy("");
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(lot1));
    }

    @Test
    public void testBoyCannotParkCarWhenAllLotsCannotPark() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy("");
        lot1 = new ParkingLot("", 5, 0);
        lot2 = new ParkingLot("", 5, 0);
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(nullValue()));
    }

    @Test
    public void testBoyCanGetCar() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy("");
        parkingBoy.manageLot(lot1).manageLot(lot2);

        parkingBoy.park(car);
        assertThat(parkingBoy.getCar(car).getId(), is(car.getId()));
    }
}
