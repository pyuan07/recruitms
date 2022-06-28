package com.recruit.recruitms.entity;

import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "resume_programming_language")
public class ResumeProgrammingLanguage extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeProgrammingLanguageId;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private ProgrammingLanguage programmingLanguage;

    @Column
    private Integer experienceYear;

}
