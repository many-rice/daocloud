package com.powergrid.integration.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name= "phone")
    private String phone;

    @Tolerate
    public User()
    {

    }
}
