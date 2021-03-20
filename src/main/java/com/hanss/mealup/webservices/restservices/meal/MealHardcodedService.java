package com.hanss.mealup.webservices.restservices.meal;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MealHardcodedService {
    private static List<Meal> meals = new ArrayList<>();
    private static int idCouner = 0;

    static {
        meals.add(new Meal(++idCouner, "user", "Potato", 111, new Date()));
        meals.add(new Meal(++idCouner, "user", "Beans", 22, new Date()));
        meals.add(new Meal(++idCouner, "user", "Cake", 55, new Date()));
        meals.add(new Meal(++idCouner, "user", "Tea", 11, new Date()));
    }

    public List<Meal> findAll(){
        return meals;
    }
}
