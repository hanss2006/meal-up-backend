package com.hanss.mealup.webservices.restservices.meal;

import java.util.Date;

public class Meal {
    private long id;
    private String username;
    private String description;
    private int calories;
    private Date mealDate;

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
