package com.keycloak_provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
