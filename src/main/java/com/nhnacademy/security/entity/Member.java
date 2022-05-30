package com.nhnacademy.security.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Members")
public class Member {

    @Id
    @Column(name = "member_id")
    private String memberId;

    private String name;

    private String pwd;

}
