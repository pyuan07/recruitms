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

    public Tag(String name, Enum.TagType tagType, Long totalUsed) {
        this.name = name;
        this.tagType = tagType;
        this.totalUsed = totalUsed;
        super.setObjectState(Enum.ObjectState.ACTIVE);
    }
}
