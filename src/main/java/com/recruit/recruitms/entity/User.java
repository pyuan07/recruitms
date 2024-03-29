package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(
    uniqueConstraints = {
            @UniqueConstraint(name="user_email_unique",columnNames = "email"),
            @UniqueConstraint(name="user_username_unique",columnNames = "username")
    }
)
public class User extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID userId;

    @Column(columnDefinition = "TEXT")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false)
    @Email
    private String email;

    @NotBlank(message = "Username is required")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.Role roles;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Enum.Gender gender;


    public User(String fullName, String email, String username, String password, Enum.Role role, LocalDate dob, Enum.Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = role;
        this.dob = dob;
        this.gender = gender;
    }

}
