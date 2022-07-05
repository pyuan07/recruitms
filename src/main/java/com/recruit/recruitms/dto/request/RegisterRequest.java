package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.enumeration.Enum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String fullName;
    private Enum.Gender gender;


    private Enum.Role role;
    public String getPassword() {
        return password;
    }
}
