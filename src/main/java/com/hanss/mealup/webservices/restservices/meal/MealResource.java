package com.hanss.mealup.webservices.restservices.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/users/{username}/meals/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id){
        Meal meal = mealService.deleteById(id);
        if (meal!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
