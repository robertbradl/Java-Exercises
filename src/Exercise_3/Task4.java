package Exercise_3;

public class Task4 {
    public static void main(String[] args) {
        double rotTime = 40; // rotation time in seconds
        int rotPerkWh = 75; // rotation per kWh
        double costPerkWh = 0.40; // cost per kWh (in euros)

        // current consumption
        double consumption = 3600 / (rotTime * rotPerkWh);

        // expected daily consumption
        double consumptionDaily = consumption * 24;

        // expected daily cost
        double costDaily = consumptionDaily * costPerkWh;


        System.out.printf("Current consumption: %.2f kW%n", consumption);
        System.out.printf("Expected consumption per day: %.2f kWh%n", consumptionDaily);
        System.out.printf("Expected daily cost: %.2f EUR%n", costDaily);

        String warnung = "WARNING!".repeat((int) Math.floor(costDaily / 5));
        System.out.println(warnung);
    }
}
