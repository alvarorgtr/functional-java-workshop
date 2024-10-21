package exercises.model;

public enum FoodType {
    SWEETS("sweets"),
    VEGETABLES("vegetables"),
    MEAT("meat"),
    FISH("fish"),
    GRAINS("grains"),
    DAIRY("dairy");

    private final String name;

    FoodType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
