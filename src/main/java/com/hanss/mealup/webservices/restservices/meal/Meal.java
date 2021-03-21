package com.hanss.mealup.webservices.restservices.meal;

import java.util.Date;
import java.util.Objects;

public class Meal {
    private long id;
    private String username;
    private String description;
    private int calories;
    private Date mealDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id == meal.id && calories == meal.calories && username.equals(meal.username) && description.equals(meal.description) && mealDate.equals(meal.mealDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, description, calories, mealDate);
    }

    public Meal(long id, String username, String description, int calories, Date mealDate) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.calories = calories;
        this.mealDate = mealDate;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public Date getMealDate() {
        return mealDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setMealDate(Date mealDate) {
        this.mealDate = mealDate;
    }
}
