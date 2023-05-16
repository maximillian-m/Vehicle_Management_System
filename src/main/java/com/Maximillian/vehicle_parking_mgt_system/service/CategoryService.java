package com.Maximillian.vehicle_parking_mgt_system.service;

import com.Maximillian.vehicle_parking_mgt_system.dto.request.CategoryRequestDto;
import com.Maximillian.vehicle_parking_mgt_system.dto.request.UpdateRequestDto;
import com.Maximillian.vehicle_parking_mgt_system.dto.response.CategoryResponseDto;


public interface CategoryService {

    CategoryResponseDto addCategory (CategoryRequestDto request);

    CategoryResponseDto editCategory(UpdateRequestDto request, String categoryId);

    void deleteCategory (String categoryId);
}
