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

    public String report() {

        return null;
    }
}
