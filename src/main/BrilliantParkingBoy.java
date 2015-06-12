import java.util.Optional;

import static java.util.Comparator.comparingDouble;

public class BrilliantParkingBoy extends ParkingBoy {
    public BrilliantParkingBoy() {
        super();
    }

    @Override
    public Optional<ParkingLot> getParkingLot() {
        return getParks().stream().sorted(
                comparingDouble(ParkingLot::getUtilizationRate))
                .findFirst();
    }
}
