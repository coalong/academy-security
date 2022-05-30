package com.nhnacademy.security.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Members")
public class User {
    @Column(name = "member_id")
    @Id
    String id;
    String name;
    String pwd;
}
