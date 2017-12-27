package com.powergrid.integration.controller.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class UserProductHistoryVo {

    private Integer id;

    private Integer userId;

    private Integer productId;

    private Timestamp time;
}
