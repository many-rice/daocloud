package com.powergrid.integration.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="user_integration")
public class UserIntegration {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    private Integer point;

    @Tolerate
    public UserIntegration(){

    }
}
