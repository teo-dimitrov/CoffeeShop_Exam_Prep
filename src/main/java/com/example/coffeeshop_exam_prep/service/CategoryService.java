package com.example.coffeeshop_exam_prep.service;

import com.example.coffeeshop_exam_prep.model.entity.Category;
import com.example.coffeeshop_exam_prep.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
