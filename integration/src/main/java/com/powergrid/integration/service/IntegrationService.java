package com.powergrid.integration.service;

import com.powergrid.integration.controller.vo.UserIntegrationHistoryVo;
import com.powergrid.integration.entity.*;
import com.powergrid.integration.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IntegrationService {
    @Autowired
    private UserIntegrationRepository userIntegrationRepository;

    @Autowired
    private IntegrationRepository integrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserIntegrationHistroyRepository userIntegrationHistroyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserProductHistoryRepository userProductHistoryRepository;

    public UserIntegration findIntegrationByUser(Integer userId){
        return userIntegrationRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("用户不存在"));
    }
    public Iterable<Integration> findAll(){
        return integrationRepository.findAll();
    }
    @Transactional
    public UserIntegrationHistory gainIntegration(Integer userId, Integer integrationId){
        Integration integration=integrationRepository.findOne(integrationId);
        Assert.notNull(integration,"用户行为不存在");
        UserIntegration userIntegration=userIntegrationRepository.findOne(userId);
        Assert.notNull(userIntegration,"用户不存在");
        //增加用户积分
        Integer originPoint=userIntegration.getPoint();
        userIntegration.setPoint(originPoint + integration.getPoint());
        userIntegrationRepository.save(userIntegration);
        //创建用户获取积分记录
        UserIntegrationHistory userIntegrationHistory = UserIntegrationHistory.builder()
                                                            .integrationId(integration.getId())
                                                            .userId(userId)
                                                            .time(Timestamp.valueOf(LocalDateTime.now()))
                                                            .build();
        userIntegrationHistroyRepository.save(userIntegrationHistory);
        return userIntegrationHistory;
    }

    @Transactional
    public UserProductHistory useIntegration(Integer userId,Integer productId){
        UserIntegration userIntegration=userIntegrationRepository.findOne(userId);
        Assert.notNull(userIntegration,"用户不存在");
        Product product=productRepository.findOne(productId);
        Assert.notNull(product,"商品不存在");

        if(product.getPoint() > userIntegration.getPoint()){
            throw new IllegalArgumentException("用户积分不足");
        }
        //扣除用户积分
        Integer originIntegration=userIntegration.getPoint();
        userIntegration.setPoint(originIntegration - product.getPoint());
        //生成用户积分兑换历史
        UserProductHistory userProductHistory=UserProductHistory.builder()
                                                    .userId(userId)
                                                    .productId(productId)
                                                    .time(Timestamp.valueOf(LocalDateTime.now()))
                                                    .build();
        userProductHistoryRepository.save(userProductHistory);
        return userProductHistory;
    }

    public Product addProduct(Product product){
        Product old=productRepository.findByName(product.getName());
        if(old != null){
            throw new IllegalArgumentException("商品已存在");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Integer userId){
        Product product=productRepository.findOne(userId);
        Assert.notNull(product,"商品不存在");
        productRepository.delete(product);
    }

    public Iterable<UserIntegrationHistory> findUserIntegrationHistoryByUser(Integer userId){
        return userIntegrationHistroyRepository.findByUserId(userId);
    }

    public Iterable<UserProductHistory> findUserProductHistoryByUser(Integer userId){
        return userProductHistoryRepository.findByUserId(userId);
    }

    public Integration addIntegration(Integration integration){
        Integration old=integrationRepository.findByAction(integration.getAction());
        Assert.isNull(old,"用户行为已经存在");
        return integrationRepository.save(integration);
    }

    public void deleteIntegration(Integer integrationId){
        Integration old= integrationRepository.findOne(integrationId);
        Assert.notNull(old,"用户行为不存在");
        integrationRepository.delete(old);
    }

    public void deleteUser(Integer userId){
        User old=userRepository.findOne(userId);
        Assert.isNull(old,"用户已存在");
        userRepository.delete(userId);
        return ;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public Iterable<UserIntegrationHistory> findUserIntegrationHistoryAll(){
        return userIntegrationHistroyRepository.findAll();
    }

    public Iterable<UserProductHistory> findUserProductHistoryAll(){
        return userProductHistoryRepository.findAll();
    }

    public void test(){
    }
}
