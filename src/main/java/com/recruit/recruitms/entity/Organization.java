package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Organization extends Auditable<String> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID organizationId;

    @NotBlank(message = "Organization's Name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Organization's Description is required")
    @Column(nullable = false)
    private String description;

    @NotEmpty(message = "Organization's Address is required")
    @Column(nullable = false)
    private String address;

    @OneToOne
    private Country country;

    @NotEmpty(message = "Contact Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Contact number is required")
    @Column(nullable = false)
    private String phone;

    private String website;

    @OneToOne
    private User owner;

    public Organization(String name, String description, String address, Country country,String email, String phone, String website, User owner,Enum.ObjectState objectState) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.owner = owner;

        super.setObjectState(objectState);
    }
}
