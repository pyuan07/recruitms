package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Application extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @OneToOne
    @JoinColumn(name = "candidateId")
    private User candidate;

    @OneToOne
    @JoinColumn(name = "resumeId")
    private Resume resume;

    @OneToOne
    @JoinColumn(name = "vacancyId")
    private Vacancy vacancy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.ApplicationStatus status;

    @Column
    private String remarks;

    public Application(User candidate, Resume resume, Vacancy vacancy, Enum.ApplicationStatus status, String remarks, Enum.ObjectState objectState) {
        this.candidate = candidate;
        this.resume = resume;
        this.vacancy = vacancy;
        this.status = status;
        this.remarks = remarks;
        super.setObjectState(objectState);
    }
}
