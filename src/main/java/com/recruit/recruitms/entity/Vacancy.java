package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Vacancy extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Tag> tags;

    @OneToOne
    private Country country;

    @OneToOne
    private Organization organization;

    private Integer numberOfOpening;

    private Float minSalary;

    private Float maxSalary;

    private Boolean enableQuiz;

    private String remarks;

    public Vacancy(String name,
                   String description,
                   List<Tag> tag,
                   Country country,
                   Organization organization,
                   Integer numberOfOpening,
                   Float minSalary,
                   Float maxSalary,
                   Boolean enableQuiz,
                   String remarks,
                   Enum.ObjectState objectState) {
        this.name = name;
        this.description = description;
        this.tags = tag;
        this.country = country;
        this.organization = organization;
        this.numberOfOpening = numberOfOpening;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.enableQuiz = enableQuiz;
        this.remarks = remarks;
        super.setObjectState(objectState);
    }

}
