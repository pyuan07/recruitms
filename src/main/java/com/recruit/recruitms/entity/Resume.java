package com.recruit.recruitms.entity;

import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Resume extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID resumeId;

//    @OneToOne
//    @JoinColumn(name = "fk_image_id")
    private String profilePicture;

    @OneToOne
    private User candidate;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name="resume_tag",
            joinColumns = @JoinColumn(name="resumeId"),
            inverseJoinColumns = @JoinColumn(name="tagId")
    )
    private List<Tag> tags;

    @OneToOne
    private Country country;

    @Column
    private Integer totalExperienceYear;

    @Column
    private Float salaryExpectation;

    @Lob
    @Column
    private String remarks;

    @Column(nullable = false)
    private String resumePdf;

    public Resume(String profilePicture, User candidate, List<Tag> tags, Country country, Integer totalExperienceYear, Float salaryExpectation, String remarks, String resumePdf, Enum.ObjectState objectState) {
        this.profilePicture = profilePicture;
        this.candidate = candidate;
        this.tags = tags;
        this.country = country;
        this.totalExperienceYear = totalExperienceYear;
        this.salaryExpectation = salaryExpectation;
        this.remarks = remarks;
        this.resumePdf = resumePdf;
        super.setObjectState(objectState);
    }
}
