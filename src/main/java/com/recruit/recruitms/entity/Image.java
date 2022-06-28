package com.recruit.recruitms.entity;

import com.recruit.recruitms.security.auditable.Auditable;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Image extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column
    private String name;

    @Column(nullable = false, length = 100000)
    private byte[] image;

}