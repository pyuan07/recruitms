package com.recruit.recruitms.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String iso;

    private String code;

    private String name;
}