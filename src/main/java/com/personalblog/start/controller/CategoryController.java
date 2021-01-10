package com.personalblog.start.controller;

import com.personalblog.start.dto.CategoryRequestDto;
import com.personalblog.start.dto.CategoryResponseDto;
import com.personalblog.start.mapper.CategoryMapper;
import com.personalblog.start.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("categories")
public class CategoryController {

    private static final CategoryMapper categoryMapper=CategoryMapper.INSTANCE;
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDto> getCategoryList(){
        return categoryMapper.toCategoryResponseDtoList(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id){
        return categoryMapper.toCategoryResponseDto(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        categoryService.addCategory(categoryMapper.toCategory(categoryRequestDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryRequestDto categoryRequestDto, @PathVariable Long id){
        categoryService.updateCategory(id, categoryMapper.toCategory(categoryRequestDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
