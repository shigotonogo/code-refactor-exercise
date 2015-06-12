import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReporterTest {

    @Test
    public void testReport() throws Exception {

        ParkingBoy boy = new ParkingBoy("lisi");
        boy.manageLot(new ParkingLot("parking lot 1", 5, 1));
        ParkingManager parkingManager = new ParkingManager("zhangsan", boy, new ParkingLot("parking lot 2", 5, 0));

        String report = new Reporter().report(parkingManager);
        assertThat(report, is(
                "ParkingManager - zhangsan\n" +
                 "    ParkingBoy - lisi\n" +
                 "        ParkingLot - parking lot 1\n" +
                 "    ParkingLot - parking lot 2\n"
        ));
    }
}