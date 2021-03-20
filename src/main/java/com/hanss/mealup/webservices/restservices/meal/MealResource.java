package com.hanss.mealup.webservices.restservices.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MealResource {
    @Autowired
    private MealHardcodedService mealService;

    @GetMapping("/users/{username}/meals")
    public List<Meal> getAllMeals(@PathVariable String username){
        return mealService.findAll();
    }
}
