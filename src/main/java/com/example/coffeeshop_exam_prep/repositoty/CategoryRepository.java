package com.example.coffeeshop_exam_prep.repositoty;

import com.example.coffeeshop_exam_prep.model.entity.Category;
import com.example.coffeeshop_exam_prep.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
