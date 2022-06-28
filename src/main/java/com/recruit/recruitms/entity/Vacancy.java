package com.recruit.recruitms.entity;

import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Vacancy extends Auditable<String> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private Long vacancyId;

    @NotBlank(message = "Vacancy's title is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Vacancy's Description is required")
    @Column(nullable = false)
    private String description;

    @OneToOne
    private Category category;

    private Integer numberOfOpening;

    private Integer mimExperience;

    private Float minSalary;

    private Float maxSalary;

    private Boolean enableQuiz;

    private String remarks;
}
