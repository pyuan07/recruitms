package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="User")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private Enum.ObjectState objectState;

    public User(String name, String email, String username, String password, LocalDate dob, Enum.ObjectState objectState) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.objectState = objectState;
    }
}
