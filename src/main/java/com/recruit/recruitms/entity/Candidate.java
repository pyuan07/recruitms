package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Candidate implements Serializable {
    @Id
    @Column(name="id")
    private UUID userId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "fk_resume_id")
    private Resume resume;

    public Candidate(UUID userId, User user) {
        this.userId = userId;
        this.user = user;
    }
}
