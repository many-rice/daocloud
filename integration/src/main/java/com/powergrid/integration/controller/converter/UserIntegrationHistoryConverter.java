package com.powergrid.integration.controller.converter;

import com.google.common.base.Converter;
import com.powergrid.integration.controller.vo.UserIntegrationHistoryVo;
import com.powergrid.integration.entity.UserIntegration;
import com.powergrid.integration.entity.UserIntegrationHistory;
import org.springframework.stereotype.Component;

@Component
public class UserIntegrationHistoryConverter extends Converter<UserIntegrationHistory,UserIntegrationHistoryVo>{
    @Override
    protected UserIntegrationHistoryVo doForward(UserIntegrationHistory userIntegrationHistory) {
        return UserIntegrationHistoryVo.builder()
                                        .id(userIntegrationHistory.getId())
                                        .userId(userIntegrationHistory.getUserId())
                                        .time(userIntegrationHistory.getTime())
                                        .build();
    }

    @Override
    protected UserIntegrationHistory doBackward(UserIntegrationHistoryVo userIntegrationHistoryVo) {
        return UserIntegrationHistory.builder()
                                        .id(userIntegrationHistoryVo.getId())
                                        .integrationId(userIntegrationHistoryVo.getIntegrationId())
                                        .time(userIntegrationHistoryVo.getTime())
                                        .build();
    }

    @Override
    public Iterable<UserIntegrationHistoryVo> convertAll(Iterable<? extends UserIntegrationHistory> fromIterable) {
        return super.convertAll(fromIterable);
    }
}
