package com.Maximillian.vehicle_parking_mgt_system.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRequestDto {

    private String categoryName;
}
