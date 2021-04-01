package com.hanss.mealup.webservices.restservices.meal;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class MealJpaResource {

    @Autowired
    private MealHardcodedService mealService;

    @Autowired
    private MealJpaRepository mealJpaRepository;


    @GetMapping("/jpa/users/{username}/meals")
    public List<Meal> getAllTodos(@PathVariable String username){
        return mealJpaRepository.findByUsername(username);
        //return todoService.findAll();
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Meal getTodo(@PathVariable String username, @PathVariable long id){
        return mealJpaRepository.findById(id).get();
        //return todoService.findById(id);
    }

    // DELETE /users/{username}/todos/{id}
    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username, @PathVariable long id) {

        mealJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    //Edit/Update a Todo
    //PUT /users/{user_name}/todos/{todo_id}
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Meal> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Meal meal){

        meal.setUsername(username);

        Meal mealUpdated = mealJpaRepository.save(meal);

        return new ResponseEntity<Meal>(meal, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username, @RequestBody Meal meal){

        meal.setUsername(username);

        Meal createdTodo = mealJpaRepository.save(meal);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
