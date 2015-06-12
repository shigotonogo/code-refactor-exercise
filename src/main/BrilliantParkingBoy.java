import java.util.Optional;

import static java.util.Comparator.comparingDouble;

public class BrilliantParkingBoy extends ParkingBoy {
    public BrilliantParkingBoy(String name) {
        super(name);
    }

    @Override
    public Optional<ParkingLot> getParkingLot() {
        return getParks().stream().sorted(
                comparingDouble(ParkingLot::getUtilizationRate))
                .findFirst();
    }
}
