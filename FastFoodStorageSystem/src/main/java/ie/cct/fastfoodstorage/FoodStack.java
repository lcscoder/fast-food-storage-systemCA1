package ie.cct.fastfoodstorage;

public class FoodStack {

    private static final int CAPACITY = 8;

    private final FoodItem[] items;
    private int top;

    public FoodStack() {
        items = new FoodItem[CAPACITY];
        top = -1;
    }

    // Add a food item to the top of the stack
    public void add(FoodItem item) {

        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null.");
        }

        if (isFull()) {
            throw new IllegalStateException(
                    "Storage is full. Maximum capacity is 8 food items."
            );
        }

        top++;
        items[top] = item;
    }

    // Remove and return the food item at the top
    public FoodItem remove() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Storage is empty. There are no food items to remove."
            );
        }

        FoodItem removedItem = items[top];
        items[top] = null;
        top--;

        return removedItem;
    }

    // Return the top food item without removing it
    public FoodItem peek() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Storage is empty. There is no top item."
            );
        }

        return items[top];
    }

    // Display all food items from top to bottom
    public void display() {

        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("\nFood items in storage (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }

    // Search for a food type in the stack
    public FoodItem search(FoodType name) {

        if (name == null) {
            throw new IllegalArgumentException(
                    "Food type cannot be null."
            );
        }

        for (int i = top; i >= 0; i--) {
            if (items[i].getName() == name) {
                return items[i];
            }
        }

        return null;
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check whether the stack has reached its capacity
    public boolean isFull() {
        return top == CAPACITY - 1;
    }

    // Return the number of stored food items
    public int size() {
        return top + 1;
    }

    // Return the maximum storage capacity
    public int getCapacity() {
        return CAPACITY;
        
        
    }
    public void displayTo(javax.swing.JTextArea outputArea) {

    for (int i = top; i >= 0; i--) {
        outputArea.append(items[i].toString() + "\n");
    }
}
    
}