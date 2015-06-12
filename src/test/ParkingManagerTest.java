import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class ParkingManagerTest {

    private ParkingManager parkingManager;
    private Car car;
    private ParkingBoy boy;
    private ParkingLot lot;
    private ParkingLot lot1;

    @Before
    public void setUp() throws Exception {
        boy = new ParkingBoy("");
        lot1 = new ParkingLot("", 5, 1);
        boy.manageLot(lot1);
        lot = new ParkingLot("", 5, 0);
        parkingManager = new ParkingManager("", boy, lot);
        car = new Car("1");
    }

    @Test
    public void testCanParkWhenSelfManagedLotIsFull() throws Exception {
        parkingManager.park(car);

        assertThat(lot1.getCar(car).getId(), is(car.getId()));
        assertThat(lot.getCar(car), is(nullValue()));
    }

    @Test
    public void testCanPark() throws Exception {
        lot = new ParkingLot("", 5, 1);
        parkingManager = new ParkingManager("", boy, lot);
        parkingManager.park(car);

        assertThat(lot1.getCar(car).getId(), is(car.getId()));
        assertThat(lot.getCar(car), is(nullValue()));
    }

}
