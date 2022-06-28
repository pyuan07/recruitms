package com.recruit.recruitms.entity;

import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table
public class Resume extends Auditable<String> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private Long resumeId;

    @OneToOne
    @JoinColumn(name = "fk_image_id")
    private Image profilePicture;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name="resume_tag",
            joinColumns = @JoinColumn(name="resumeId"),
            inverseJoinColumns = @JoinColumn(name="tagId")
    )
    private Set<Tag> tag;

    @Column
    private Integer totalExperienceYear;

    @Column
    private Float salaryExpectation;

    @Column
    private String remarks;

    @Lob
    @Column(nullable = false)
    private byte[] resumePdf;
}
