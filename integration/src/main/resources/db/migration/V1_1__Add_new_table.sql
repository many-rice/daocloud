#积分事件参照表
CREATE TABLE `integration_events` (
  `id`    BIGINT AUTO_INCREMENT,
  `action`  VARCHAR(200),
  `point`  INT,
  PRIMARY KEY (`id`)
)
  CHARACTER SET = utf8;
#用户
CREATE TABLE  `user`(
  `id` BIGINT AUTO_INCREMENT,
  `name` CHAR(50),
  `phone` CHAR(30),
  PRIMARY KEY(`id`)
)
  CHARACTER SET = utf8;
#商品
CREATE TABLE `product`(
  `id` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(100),
  `point` INT,
  PRIMARY KEY (`id`)
)
  CHARACTER SET = utf8;
#用户积分表
CREATE TABLE `user_integration`(
  `id` BIGINT AUTO_INCREMENT,
  `user_id` BIGINT,
  `point` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
)
  CHARACTER SET = utf8;
#用户获取积分历史表
CREATE TABLE `user_integration_history`(
   `id` BIGINT AUTO_INCREMENT,
   `user_id` BIGINT,
   `integration_id` BIGINT,
  `time` DATETIME,
   PRIMARY KEY (`id`),
   FOREIGN KEY(`user_id`) REFERENCES `user`(`id`),
   FOREIGN KEY(`integration_id`) REFERENCES `integration_events`(`id`)
)
  CHARACTER SET = utf8;
#用户兑换商品历史表
CREATE TABLE `user_product_history`(
  `id` BIGINT AUTO_INCREMENT,
  `user_id` BIGINT,
  `product_id` BIGINT,
  `time` DATETIME,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
)
  CHARACTER SET = utf8;