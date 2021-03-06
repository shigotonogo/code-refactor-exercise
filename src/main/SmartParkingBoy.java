import java.util.Optional;

import static java.util.Comparator.comparingInt;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(String name) {
        super(name);
    }

    @Override
    public Optional<ParkingLot> getParkingLot() {
        return getParks().stream()
                .sorted(comparingInt(ParkingLot::getAvailableLots).reversed())
                .findFirst();
    }
}