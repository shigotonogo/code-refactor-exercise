public class Reporter {

    public static final int INDENT_SIZE = 4;

    public String report(ParkingManager parkingManager) {
        int indentLevel = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", ParkingManager.class.getSimpleName(), parkingManager.getName()));
        newLine(sb);

        for (Parkable parkable : parkingManager.getParkables()) {

            if (parkable instanceof ParkingBoy) {
                report(sb, indentLevel, ((ParkingBoy) parkable));
            } else if (parkable instanceof ParkingLot) {
                report(sb, indentLevel, ((ParkingLot) parkable));
            }
        }
        return sb.toString();
    }

    private void report(StringBuilder sb, int indentLevel, ParkingBoy parkingBoy) {
        indent(sb, indentLevel * INDENT_SIZE);
        sb.append(String.format("%s - %s", parkingBoy.getClass().getSimpleName(), parkingBoy.getName()));
        newLine(sb);

        for (ParkingLot parkingLot : parkingBoy.getParks()) {
            report(sb, indentLevel + 1, parkingLot);
        }
    }

    private void report(StringBuilder sb, int indentLevel, ParkingLot parkingLot) {
        indent(sb, indentLevel * INDENT_SIZE);
        sb.append(String.format("%s - %s", parkingLot.getClass().getSimpleName(), parkingLot.getName()));
        newLine(sb);
    }

    private void newLine(StringBuilder sb) {
        sb.append(System.getProperty("line.separator"));
    }

    private void indent(StringBuilder sb, int spaces) {
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
    }
}