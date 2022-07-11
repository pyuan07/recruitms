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
public class Schedule extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @OneToOne
    @JoinColumn(name = "applicationId")
    private Application application;

    @OneToOne
    @JoinColumn(name = "scheduleTimeslotId")
    private ScheduleTimeslot scheduleTimeslot;

    private String meetingUrl;

    @Column
    private String remarks;


}
