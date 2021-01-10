package com.personalblog.start.service;

import com.personalblog.start.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();
    void addCategory(Category category);
    void updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    Category getCategoryById(Long id);
}
