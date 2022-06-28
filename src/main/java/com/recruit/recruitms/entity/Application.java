package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Application extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @OneToOne
    @JoinColumn(name = "candidateId")
    private Candidate candidate;

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

    @OneToOne
    @JoinColumn(name = "staffId")
    private Staff viewBy;

    @Lob
    @Column(nullable = false)
    private byte[] resumePdf;
}