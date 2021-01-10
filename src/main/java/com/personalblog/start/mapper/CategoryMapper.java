package com.personalblog.start.mapper;


import com.personalblog.start.dto.CategoryRequestDto;
import com.personalblog.start.dto.CategoryResponseDto;
import com.personalblog.start.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDto toCategoryResponseDto(Category category);
    List<CategoryResponseDto> toCategoryResponseDtoList(List<Category> categoryList);

    Category toCategory(CategoryRequestDto categoryRequestDto);
}
