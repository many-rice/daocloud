package com.powergrid.integration.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name="user_integration_history")
public class UserIntegrationHistory {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="integration_id")
    private Integer integrationId;
    @Column(name = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    @Tolerate
    public UserIntegrationHistory(){

    }
}
