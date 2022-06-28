package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
public class Employer implements Serializable {
    @Id
    @Column(name="id")
    private UUID userId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private Organization organization;


}
