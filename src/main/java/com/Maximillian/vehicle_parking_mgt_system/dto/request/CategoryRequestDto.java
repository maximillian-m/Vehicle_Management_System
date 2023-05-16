package com.Maximillian.vehicle_parking_mgt_system.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequestDto {

    @NotBlank(message = "Category cannot be blank")
    @Size(message = "Category character length cannot be less than 2 and more than 100", min = 2, max = 100)
    private String categoryName;
}
