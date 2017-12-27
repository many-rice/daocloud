package com.powergrid.integration.controller.converter;

import com.google.common.base.Converter;
import com.powergrid.integration.controller.vo.IntegrationVo;
import com.powergrid.integration.controller.vo.ProductVo;
import com.powergrid.integration.entity.Integration;
import com.powergrid.integration.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class IntegrationConverter  extends Converter<Integration, IntegrationVo> {
    @Override
    protected IntegrationVo doForward(Integration integration) {
        return IntegrationVo.builder()
                            .id(integration.getId())
                            .action(integration.getAction())
                            .point(integration.getPoint())
                            .build();
    }

    @Override
    protected Integration doBackward(IntegrationVo integrationVo) {
        return Integration.builder()
                            .id(integrationVo.getId())
                            .action(integrationVo.getAction())
                            .point(integrationVo.getPoint())
                            .build();
    }
}
