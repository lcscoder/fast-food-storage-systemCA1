package ie.cct.fastfoodstorage;

public enum FoodType {

    BURGER("Burger"),
    PIZZA("Pizza"),
    FRIES("Fries"),
    SANDWICH("Sandwich"),
    HOTDOG("Hotdog");

    private final String displayName;

    FoodType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}