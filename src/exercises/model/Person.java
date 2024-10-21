package exercises.model;

import java.util.Set;

public class Person {
    private String name;
    private int age;
    private FoodType favouriteFood;
    private Set<FoodType> allergies;
    private Diet diet;

    public Person(String name, int age, FoodType favouriteFood, Set<FoodType> allergies, Diet diet) {
        this.name = name;
        this.age = age;
        this.favouriteFood = favouriteFood;
        this.allergies = allergies;
        this.diet = diet;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public FoodType getFavouriteFood() {
        return favouriteFood;
    }

    public Set<FoodType> getAllergies() {
        return allergies;
    }

    public Diet getDiet() {
        return diet;
    }
}