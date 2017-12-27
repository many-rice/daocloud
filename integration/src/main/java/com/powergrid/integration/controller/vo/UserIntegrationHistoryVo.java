package com.powergrid.integration.controller.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class UserIntegrationHistoryVo {
    private Integer id;
    private Integer userId;
    private Integer integrationId;
    private Timestamp time;
}
