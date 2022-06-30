package com.recruit.recruitms.dto.request;

import com.recruit.recruitms.entity.Organization;
import com.recruit.recruitms.enumeration.Enum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrganizationRequest {
    private String name;
    private String description;
    private String address;
    private String countryISO;
    private String email ;
    private String phone ;
    private String website ;
    private UUID owner;
    private Enum.ObjectState objectState;

}
