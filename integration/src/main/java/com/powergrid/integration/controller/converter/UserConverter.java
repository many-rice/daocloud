package com.powergrid.integration.controller.converter;


import com.google.common.base.Converter;
import com.powergrid.integration.controller.vo.UserVo;
import com.powergrid.integration.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User,UserVo>{
    @Override
    protected UserVo doForward(User user) {
        return UserVo.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .phone(user.getPhone())
                        .build();
    }

    @Override
    protected User doBackward(UserVo userVo) {
        return User.builder()
                    .id(userVo.getId())
                    .name(userVo.getName())
                    .phone(userVo.getPhone())
                    .build();
    }
}
