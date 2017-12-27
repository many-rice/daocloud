package com.powergrid.integration.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.powergrid.integration.entity.Integration;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVo {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Integer point;
}
