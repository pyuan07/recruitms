package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(
        name="user",
        uniqueConstraints = {
                @UniqueConstraint(name="user_email_unique",columnNames = "email"),
                @UniqueConstraint(name="user_username_unique",columnNames = "username")
        }
)
//public class User extends Auditable<String> {
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false, columnDefinition = "TEXT")
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

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(nullable = false)
        private Enum.ObjectState objectState;

    public User(String fullName, String email, String username, String password, LocalDate dob, Enum.ObjectState objectState) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.objectState = objectState;
    }

    public boolean isEnabled(){
        return objectState == Enum.ObjectState.ACTIVE;
    }
}
