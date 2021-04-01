package com.hanss.mealup.webservices.restservices.meal;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealJpaRepository extends JpaRepository<Meal, Long>{
	List<Meal> findByUsername(String username);
}