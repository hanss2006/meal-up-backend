package com.hanss.mealup.webservices.restservices.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MealResource {
    @Autowired
    private MealHardcodedService mealService;

    @GetMapping("/users/{username}/meals/{id}")
    public Meal getAllMeals(@PathVariable String username, @PathVariable long id){
        return mealService.findById(id);
    }

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

    @PutMapping("/users/{username}/meals/{id}")
    public ResponseEntity<Meal> updateMeal(
            @PathVariable String username, @PathVariable long id, @RequestBody Meal meal
    ){
        Meal mealUpdated = mealService.save(meal);
        return new ResponseEntity<Meal>(meal, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/meals")
    public ResponseEntity<Meal> updateMeal(
            @PathVariable String username, @RequestBody Meal meal
    ){
        Meal mealCreated = mealService.save(meal);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mealCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
