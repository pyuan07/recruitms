package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class ScheduleTimeslot extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleTimeslotId;

    @OneToOne
    @JoinColumn(name = "vacancyId")
    private Vacancy vacancy;

    @Column(nullable = false)
    private Date availableDateTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.InterviewApproach interviewApproach;

    @OneToOne
    @JoinColumn(name = "candidateId")
    private User bookedBy;

}
