package com.powergrid.integration.controller.converter;

import com.google.common.base.Converter;
import com.powergrid.integration.controller.vo.UserProductHistoryVo;
import com.powergrid.integration.entity.UserProductHistory;
import org.springframework.stereotype.Component;

@Component
public class UserProductHistoryConverter extends Converter<UserProductHistory, UserProductHistoryVo> {
    @Override
    protected UserProductHistoryVo doForward(UserProductHistory userProductHistory) {
        return UserProductHistoryVo.builder()
                                    .userId(userProductHistory.getUserId())
                                    .productId(userProductHistory.getProductId())
                                    .time(userProductHistory.getTime())
                                    .build();
    }

    @Override
    protected UserProductHistory doBackward(UserProductHistoryVo userProductHistoryVo) {
        return UserProductHistory.builder()
                                    .id(userProductHistoryVo.getId())
                                    .productId(userProductHistoryVo.getProductId())
                                    .time(userProductHistoryVo.getTime())
                                    .build();
    }

    @Override
    public Iterable<UserProductHistoryVo> convertAll(Iterable<? extends UserProductHistory> fromIterable) {
        return super.convertAll(fromIterable);
    }
}
