import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class EnhancedUnitConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== ENHANCED UNIT CONVERTER ===");
            System.out.println("1. Length Converter (meters, km, miles)");
            System.out.println("2. Weight Converter (kg, lb)");
            System.out.println("3. Volume Converter (liters, gallons)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dynamicConverter(sc, "Length");
                    break;
                case 2:
                    dynamicConverter(sc, "Weight");
                    break;
                case 3:
                    dynamicConverter(sc, "Volume");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    // DYNAMIC CONVERTER
    public static void dynamicConverter(Scanner sc, String type) {
        Map<String, Double> units = new HashMap<>();

        switch (type) {
            case "Length":
                units.put("meters", 1.0);
                units.put("km", 1000.0);
                units.put("miles", 1609.34);
                break;
            case "Weight":
                units.put("kg", 1.0);
                units.put("lb", 0.453592);
                break;
            case "Volume":
                units.put("liters", 1.0);
                units.put("gallons", 3.78541);
                break;
        }

        System.out.println("Available units: " + units.keySet());
        System.out.print("Enter FROM unit: ");
        String fromUnit = sc.next().toLowerCase();
        System.out.print("Enter TO unit: ");
        String toUnit = sc.next().toLowerCase();
        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        if (units.containsKey(fromUnit) && units.containsKey(toUnit)) {
            double valueInBase = value * units.get(fromUnit);
            double convertedValue = valueInBase / units.get(toUnit);
            System.out.println(value + " " + fromUnit + " = " + convertedValue + " " + toUnit);
        } else {
            System.out.println("Invalid units entered!");
        }
    }
}





