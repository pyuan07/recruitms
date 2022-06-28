package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Tag extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum.TagType tagType;

    @Column(nullable = false)
    private Long totalUsed;
    
}
