package com.powergrid.integration.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="integration_events")
public class Integration {
    @Id
    @GeneratedValue
    private Integer id;
    private String action;
    private Integer point;

    @Tolerate
    public Integration(){

    }
}
