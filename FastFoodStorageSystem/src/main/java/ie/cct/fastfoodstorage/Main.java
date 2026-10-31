package ie.cct.fastfoodstorage;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        FoodStack storage = new FoodStack();

        System.out.println("=== FAST FOOD STORAGE SYSTEM ===");

        // Add food items
        storage.add(new FoodItem(
                FoodType.BURGER, 250, LocalDate.now().plusDays(3)));

        storage.add(new FoodItem(
                FoodType.PIZZA, 400, LocalDate.now().plusDays(5)));

        storage.add(new FoodItem(
                FoodType.FRIES, 150, LocalDate.now().plusDays(2)));

        System.out.println("\nThree food items added successfully.");

        // Display all items
        storage.display();

        // Check the top item
        System.out.println("\nTop item:");
        System.out.println(storage.peek());

        // Search for a food type
        System.out.println("\nSearching for Pizza:");

        FoodItem found = storage.search(FoodType.PIZZA);

        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Pizza not found.");
        }

        // Remove the top item
        System.out.println("\nRemoving the top item:");
        FoodItem removed = storage.remove();
        System.out.println("Removed: " + removed.getName());

        // Display the remaining items
        storage.display();

        // Show the current size
        System.out.println("\nItems remaining: " + storage.size());
        System.out.println("Maximum capacity: " + storage.getCapacity());

        System.out.println("\n=== TEST COMPLETED ===");
    }
}