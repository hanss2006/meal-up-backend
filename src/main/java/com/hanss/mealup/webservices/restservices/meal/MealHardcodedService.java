package com.hanss.mealup.webservices.restservices.meal;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MealHardcodedService {
    private static List<Meal> meals = new ArrayList<>();
    private static Long idCouner = 0L;

    static {
        meals.add(new Meal(++idCouner, "user", "Potato", 111, new Date()));
        meals.add(new Meal(++idCouner, "user", "Beans", 22, new Date()));
        meals.add(new Meal(++idCouner, "user", "Cake", 55, new Date()));
        meals.add(new Meal(++idCouner, "user", "Tea", 11, new Date()));
    }

    public List<Meal> findAll(){
        return meals;
    }

    public Meal save(Meal meal){
        if(meal.getId()==-1 || meal.getId()==0){
            meal.setId(++idCouner);
            meals.add(meal);
        } else {
            deleteById(meal.getId());
            meals.add(meal);
        }
        return meal;
    }

    public  Meal deleteById(long id){
        Meal meal = findById(id);
        if (meal==null) return null;
        if (meals.remove(meal)){
            return meal;
        }
        return null;
    }

    public Meal findById(long id) {
        for (Meal meal:meals){
            if (meal.getId() == id){
                return meal;
            }
        }
        return null;

    }
}
