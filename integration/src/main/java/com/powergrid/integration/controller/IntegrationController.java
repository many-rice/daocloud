package com.powergrid.integration.controller;

import com.powergrid.integration.controller.converter.*;
import com.powergrid.integration.controller.vo.*;
import com.powergrid.integration.entity.*;
import com.powergrid.integration.service.IntegrationService;
import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/integration")
public class IntegrationController {
    @Autowired
    private IntegrationService integrationService;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private IntegrationConverter integrationconverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserProductHistoryConverter userProductHistoryConverter;

    @Autowired
    private UserIntegrationHistoryConverter userIntegrationHistoryConverter;

    /**
     * 查询某一个用户拥有的积分
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public UserIntegration findIntegrationByUser(@PathVariable("userId") Integer userId){
            return integrationService.findIntegrationByUser(userId);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId){
        integrationService.deleteUser(userId);
        return ResponseEntity.ok("删除成功");
    }

    @PostMapping()
    public UserVo addUser(@RequestBody UserVo userVo){
        User user=userConverter.reverse().convert(userVo);
        return userConverter.convert(integrationService.addUser(user));
    }

    /**
     * 查询用户行为能获取多少积分的对照表
     * @return
     */
    @GetMapping()
    public Iterable<Integration> findAll(){
        return integrationService.findAll();
    }

    /**
     * 用户获取积分
     * @return
     */
    @PostMapping()
    public UserIntegrationHistory gainIntegration(@RequestParam("userId") Integer userId,
                                                  @RequestParam("integrationId") Integer integrationId){
        return integrationService.gainIntegration(userId,integrationId);
    }

    /**
     * 用户兑换商品
     * @param userId
     * @param productId
     * @return
     */
    @PostMapping("/ProductHistory")
    public UserProductHistory useIntegration(@RequestParam("userId") Integer userId,
                                             @RequestParam("productId") Integer productId){
        return integrationService.useIntegration(userId,productId);
    }

    /**
     * 增加兑换商品
     * @param productVo
     * @return
     */
    @PostMapping("/product")
    public ProductVo addProduct(@RequestBody @Valid ProductVo productVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("商品参数不能为空");
        }
        Product product=productConverter.reverse().convert(productVo);
        return productConverter.convert(integrationService.addProduct(product));
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam("productId") Integer productId){
        integrationService.deleteProduct(productId);
        return ResponseEntity.ok("删除成功");
    }

    /**
     * 查看用户获取积分的历史记录
     * @param userId
     * @return
     */
    @GetMapping("/history")
    public Iterable<UserIntegrationHistory> findUserIntegrationHistoryByUser(@RequestParam("userId") Integer userId){
            return integrationService.findUserIntegrationHistoryByUser(userId);
    }

    /**
     * 查看所有获取积分记录
     * @return
     */
    @GetMapping("/allHistory")
    public Iterable<UserIntegrationHistoryVo> findUserIntegrationHistoryAll(){
        return userIntegrationHistoryConverter.convertAll(integrationService.findUserIntegrationHistoryAll());
    }

    /**
     * 查看用户兑换商品的历史记录
     * @param userId
     * @return
     */
    @GetMapping("/productHistory")
    public Iterable<UserProductHistory> findUserProductHistoryByUser(@RequestParam("userId") Integer userId){
        return integrationService.findUserProductHistoryByUser(userId);
    }

    public Iterable<UserProductHistoryVo> findUserProductHistoryAll(){
        return userProductHistoryConverter.convertAll(integrationService.findUserProductHistoryAll());
    }

    /**
     * 增加用户行为能获取多少积分的对照表的项
     * @param integrationVo
     * @param bindingResult
     * @return
     */
    @PutMapping()
    public IntegrationVo addIntegration(@RequestBody @Valid IntegrationVo integrationVo,BindingResult bindingResult){
         if(bindingResult.hasErrors()){
             throw new IllegalArgumentException("参数不能为空");
         }
         Integration integration=integrationconverter.reverse().convert(integrationVo);
         return integrationconverter.convert(integrationService.addIntegration(integration));
    }

    /**
     * 删除用户行为能获取多少积分的对照表的项
     * @param integrationId
     * @return
     */
    @DeleteMapping("/{integrationId}")
    public ResponseEntity deleteIntegration(@PathVariable  Integer integrationId){
        integrationService.deleteIntegration(integrationId);
        return ResponseEntity.status(HttpStatus.OK).body("删除成功");
    }
}
