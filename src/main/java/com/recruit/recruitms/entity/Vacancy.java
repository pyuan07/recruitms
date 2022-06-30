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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name="vacancy_tag",
            joinColumns = @JoinColumn(name="vacancyId"),
            inverseJoinColumns = @JoinColumn(name="tagId")
    )
    private Set<Tag> tag;

    @OneToOne
    private Category category;

    @OneToOne
    private Country country;

    @OneToOne
    private Organization organization;

    private Integer numberOfOpening;

    private Float minSalary;

    private Float maxSalary;

    private Boolean enableQuiz;

    private String remarks;
}
