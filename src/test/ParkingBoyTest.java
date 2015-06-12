import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ywdong on 6/9/15.
 */
public class ParkingBoyTest {

    private ParkingLot lot1;
    private ParkingLot lot2;
    private Car car;

    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(2, 5);
        lot2 = new ParkingLot(3, 5);
        car = new Car("1");
    }

    @Test
    public void testBoyCanParkCarToTheNotFullLot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        lot1 = new ParkingLot(0, 5);
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(lot2));
    }

    @Test
    public void testBoyCanParkCarToTheFirstLotWhenAllLotsCanPark() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(lot1));
    }

    @Test
    public void testBoyCannotParkCarWhenAllLotsCannotPark() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        lot1 = new ParkingLot(0, 5);
        lot2 = new ParkingLot(0, 5);
        parkingBoy.manageLot(lot1).manageLot(lot2);

        ParkingLot park = parkingBoy.park(car);

        assertThat(park, is(nullValue()));
    }
}
