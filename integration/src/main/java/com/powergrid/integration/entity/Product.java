package com.powergrid.integration.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer point;

    @Tolerate
    public Product(){

    }
}
