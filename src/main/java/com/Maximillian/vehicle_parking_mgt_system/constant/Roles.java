package com.Maximillian.vehicle_parking_mgt_system.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {

    USER("ROLE_USER"),

    ADMIN("ROLE_ADMIN");

    private final String role;
}
