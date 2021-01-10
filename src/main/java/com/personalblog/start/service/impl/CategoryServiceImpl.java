package com.personalblog.start.service.impl;

import com.personalblog.start.exception.ErrorResponse;
import com.personalblog.start.exception.NotFoundException;
import com.personalblog.start.model.Category;
import com.personalblog.start.repository.CategoryRepository;
import com.personalblog.start.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Optional<Category> categoryDb = categoryRepository.findById(id);
        if(categoryDb.isPresent()) {
            categoryDb.get().setCategoryName(category.getCategoryName());
            categoryRepository.save(category);
        } else{
                throw new NotFoundException(new ErrorResponse("404", "Category Not Found"));
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorResponse("404", "Category Not Found")));
            categoryRepository.delete(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorResponse("404", "Category Not Found")));
    }
}
