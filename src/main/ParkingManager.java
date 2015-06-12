import java.io.PrintStream;
import java.util.Optional;
import java.util.stream.Stream;

public class ParkingManager implements Parkable {
    private Parkable[] parkables;
    private String name;

    public ParkingManager(String name, Parkable... parkables) {
        this.parkables = parkables;
        this.name = name;
    }

    @Override
    public ParkingLot park(Car car) {
        Optional<Parkable> optional = Stream.of(parkables).filter(Parkable::canPark).findFirst();
        if (optional.isPresent()) {
            Parkable parkable = optional.get();
            return parkable.park(car);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Parkable[] getParkables() {
        return parkables;
    }

    @Override
    public boolean canPark() {
        return Stream.of(parkables).anyMatch(Parkable::canPark);
    }

    @Override
    public Car getCar(Car car) {
        for (Parkable parkable : parkables) {
            Car got = parkable.getCar(car);
            if (got != null) {
                return got;
            }
        }
        return null;
    }

    public void report(PrintStream out) {
        String report = new Reporter().report(this);
        out.println(report);
    }

    public static void main(String[] args) {
        ParkingBoy boy = new ParkingBoy("lisi");
        boy.manageLot(new ParkingLot("parking lot 1", 5, 1));
        boy.manageLot(new ParkingLot("parking lot 3", 5, 1));
        boy.manageLot(new ParkingLot("parking lot 4", 5, 1));
        ParkingManager parkingManager = new ParkingManager("zhangsan", boy, new ParkingLot("parking lot 2", 5, 0));
        parkingManager.report(System.out);
    }
}
