package com.powergrid.integration.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@Table(name="user_product_history")
@Entity
public class UserProductHistory {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="product_id")
    private Integer productId;
    @Column(name = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    @Tolerate
    public UserProductHistory(){

    }
}
