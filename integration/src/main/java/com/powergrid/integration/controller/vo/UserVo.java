package com.powergrid.integration.controller.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVo {
    private Integer id;
    private String name;
    private String phone;
}
