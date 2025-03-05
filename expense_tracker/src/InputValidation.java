import java.util.Set;

public class InputValidation {
    private static final double MIN_AMOUNT = 0.0;
    private static final double MAX_AMOUNT = 1000.0;
    private static final Set<String> VALID_CATEGORIES = Set.of("food", "travel", "bills", "entertainment", "other");

    public static double validateAmount(double amount) {
        if (amount <= MIN_AMOUNT || amount >= MAX_AMOUNT) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than 1000.");
        }
        return amount;
    }

    public static String validateCategory(String category) {
        if (!VALID_CATEGORIES.contains(category)) {
            throw new IllegalArgumentException("Category must be one of: food, travel, bills, entertainment, other");
        }
        return category;
    }
}
