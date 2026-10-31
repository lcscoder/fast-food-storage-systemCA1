
package ie.cct.fastfoodstorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FoodItem {

    private final FoodType name;
    private final int weightGrams;
    private final LocalDate bestBefore;
    private final LocalDateTime storedAt;

    public FoodItem(FoodType name, int weightGrams, LocalDate bestBefore) {

        if (name == null) {
            throw new IllegalArgumentException("Food type cannot be empty.");
        }

        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }

        if (bestBefore == null) {
            throw new IllegalArgumentException("Best-before date is required.");
        }

        LocalDate today = LocalDate.now();

        if (bestBefore.isBefore(today)) {
            throw new IllegalArgumentException("Best-before date cannot be in the past.");
        }

        if (ChronoUnit.DAYS.between(today, bestBefore) > 14) {
            throw new IllegalArgumentException(
                    "Best-before date cannot exceed 14 days from today."
            );
        }

        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.storedAt = LocalDateTime.now();
    }

    public FoodType getName() {
        return name;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getStoredAt() {
        return storedAt;
    }

    @Override
    public String toString() {
        return "Food: " + name
                + " | Weight: " + weightGrams + " g"
                + " | Best before: " + bestBefore
                + " | Stored at: " + storedAt;
    }
}
