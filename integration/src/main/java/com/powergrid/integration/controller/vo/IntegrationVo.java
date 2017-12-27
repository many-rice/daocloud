package com.powergrid.integration.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntegrationVo {
    private Integer id;
    @NotBlank
    private String action;
    @NotNull
    private Integer point;
}
