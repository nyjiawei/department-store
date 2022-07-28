
 DROP TABLE IF EXISTS `goods_property`;  
 CREATE TABLE `goods_property`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `goods_id` int(11)  DEFAULT NULL COMMENT '商品ID',
 `name_id` int(11)  DEFAULT NULL COMMENT '属性名ID',
 `value_id` int(11)  DEFAULT NULL COMMENT '属性值ID',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格表';
 
 
 
 DROP TABLE IF EXISTS `order`;  
 CREATE TABLE `order`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `order_no` varchar(32)  DEFAULT NULL COMMENT '订单编号表中唯一',
 `delivery_address_id` int(11)  NOT NULL COMMENT '配送地址ID',
 `create_time` datetime  DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
 `payment_time` datetime  DEFAULT NULL COMMENT '付款时间',
 `status` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单状态:未付款,已付款,已发货,已签收,退货申请,退货中,已退货,取消交易',
 `user_id` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID',
 `goods_count` int(11)  DEFAULT NULL COMMENT '商品计数',
 `amount_total` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品总价',
 `order_amount_total` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单实付',
 `order_logistics_id` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单物流编号 订单物流表自动编号',
 `logistics_fee` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '运费',
 `pay_channel` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付渠道',
 `escrow_trade_no` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单支付单号 (第三方支付流水号)',
 `invoice_id` int(11)  DEFAULT NULL COMMENT '发票ID',
 `need_invoice` tinyint(1)  DEFAULT 0 COMMENT '是否需要发票',
 `comment` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户备注',
 `is_deleted` tinyint(1)  DEFAULT 0 COMMENT '逻辑删除',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单';


 DROP TABLE IF EXISTS `goods_property_value`;  
 CREATE TABLE `goods_property_value`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name_id` int(11)  DEFAULT NULL COMMENT '属性名ID',
 `value` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '值',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性值表';


 DROP TABLE IF EXISTS `goods`;  
 CREATE TABLE `goods`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `cid` int(11)  NOT NULL COMMENT '分类ID',
 `title` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
 `pro_no` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编码',
 `keywords` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键字，方便搜索',
 `img` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主图',
 `price` decimal(10,2) NOT NULL COMMENT '价格',
 `desc` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
 `pv` int(11)  DEFAULT 0 COMMENT '点击量，统计流量',
 `status` int(11)  DEFAULT 1 COMMENT '商品状态 -1 已删除 0 下架 1 上架',
 `add_time` datetime   DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表';


 DROP TABLE IF EXISTS `goods_content`;  
 CREATE TABLE `goods_content`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11)  NOT NULL COMMENT '商品ID',
 `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细描述，可以是富文本',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品详细描述';


 DROP TABLE IF EXISTS `order_logistics`;  
 CREATE TABLE `order_logistics`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `order_id` int(11)  DEFAULT NULL COMMENT '订单ID',
 `express_no` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流单号',
 `consignee_name` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人可能更新或删除，因此要在这里记录',
 `consignee_mobile` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货手机可能更新或删除，因此要在这里记录',
 `consignee_address` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货地址表可能更新或删除，因此要在这里记录',
 `consignee_zip` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收货地址邮编可能更新或删除，因此要在这里记录',
 `logistics_type` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流公司：如顺丰、圆通等',
 `logistics_id` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流商家表自动编号',
 `logistics_fee` decimal(10,2) DEFAULT NULL COMMENT '显示给客户的订单运费',
 `agency_fee` decimal(10,2)  DEFAULT NULL COMMENT '快递公司代收货款费率，如货值的2%-5%，一般月结',
 `delivery_amount` decimal(10,2)  DEFAULT 0 COMMENT '实际支付给物流公司的金额',
 `order_logistics_status` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流状态',
 `logistics_settlement_status` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流结算状态 ：未结算，已结算，部分结算',
 `logistics_result_last` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流最后状态描述',
 `logistics_create_time` datetime  DEFAULT NULL COMMENT '发货时间',
 `logistics_update_time` datetime  DEFAULT NULL COMMENT '物流更新时间',
 `logistics_settlement_time` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流结算时间',
 `logistics_pay_channel` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流支付渠道',
 `logistics_pay_no` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流支付单号',
 `reconciliation_status` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流公司已对账状态 :已对账,未对账',
 `reconciliation_time` datetime   DEFAULT NULL COMMENT '物流公司对账日期',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单物流表';


 DROP TABLE IF EXISTS `user`;  
 CREATE TABLE `user`  ( 
 `id` varchar(64) NOT NULL COMMENT '使用uuid',
 `user_role_id` int(11)  DEFAULT NULL COMMENT '权限ID',
 `user_level_id` int(11)  DEFAULT NULL COMMENT '等级ID',
 `username` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名/登录名',
 `password` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码，用盐加密',
 `nick` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
 `mobile` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
 `email` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
 `img` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
 `salt` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐，加密用',
 `birth` datetime   DEFAULT NULL COMMENT '生日',
 `sex` tinyint(1)  NOT NULL COMMENT '性别:0女 ,1男',
 `point` int(11)  DEFAULT 0 COMMENT '积分',
 `reg_time` datetime  DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
 `remark` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
 `login_count` int(8) DEFAULT NULL COMMENT '登录次数',
 `is_deleted` tinyint(1)  DEFAULT 0 COMMENT '逻辑删除',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';


 DROP TABLE IF EXISTS `goods_category`;  
 CREATE TABLE `goods_category`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `pid` int(11)  DEFAULT NULL COMMENT '上级分类ID',
 `ord` int(11)  DEFAULT 0 COMMENT '排序数值',
 `title` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签',
 `status` tinyint(11)  DEFAULT 1 COMMENT '状态 1正常 ，0 禁用',
 `add_time` datetime   DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类表';


 DROP TABLE IF EXISTS `order_detail`;  
 CREATE TABLE `order_detail`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `order_no` varchar(32)  NOT NULL COMMENT '订单编号',
 `pro_no` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编号',
 `goods_name` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名可能删除,所以这里要记录，不能直接读商品表',
 `goods_price` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品价格可能变更或删除,所以这里要记录，不能直接读商品表',
 `goods_marque` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品品牌',
 `goods_store_barcode` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品仓库条码',
 `goods_mode_desc` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '记录详细商品型号，如颜色、规格、包装等',
 `goods_mode_params` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'JSON格式，记录单位编号、颜色编号、规格编号等',
 `discount_rate` int(11)  DEFAULT NULL COMMENT '打几折',
 `discount_amount` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '折扣金额',
 `number` int(11)  DEFAULT NULL COMMENT '购买数量',
 `subtotal` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小记金额',
 `goods_exists` tinyint(1)  DEFAULT NULL COMMENT '商品还有效吗',
 `remark` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '';


 DROP TABLE IF EXISTS `goods_property_name`;  
 CREATE TABLE `goods_property_name`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `cid` int(11)  DEFAULT NULL COMMENT '所属类目ID,与商品信息表中的cid对应 与商品类目表中的ID对应',
 `title` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性名,例如：颜色 版本 尺寸',
 `value_id` int(11)  DEFAULT NULL COMMENT '类目属性值表ID',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性,用于定制商品配置纬度';
 DROP TABLE IF EXISTS `user_delivery_address`;


 CREATE TABLE `user_delivery_address`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `country` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '国家',
 `province` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省份',
 `city` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '城市',
 `area` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地区/县',
 `address` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '街道详细地址',
 `mobile` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机',
 `is_default` tinyint(1)  DEFAULT 0 COMMENT '是否设置为默认',
 `user_id` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户ID',
 `is_deleted` tinyint(1)  DEFAULT NULL COMMENT '逻辑删除',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户配送地址表';


 DROP TABLE IF EXISTS `goods_sku`;  
 CREATE TABLE `goods_sku`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11)  DEFAULT NULL COMMENT '商品ID',
 `properties` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性键值对，property_name:property_value 关联两张表的ID',
 `properties_value` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性键 如颜色:绿色;大小:xl',
 `price` decimal(10,2) DEFAULT NULL COMMENT '不同规格商品价格，可有可无值',
 `stock` int(11)  NOT NULL COMMENT '库存',
 `weight` int(11)  DEFAULT NULL COMMENT '重量，克',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品库存量表';


 DROP TABLE IF EXISTS `user_roles`;  
 CREATE TABLE `user_roles`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `role_name` varchar(64)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名',
 `comment` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
 `is_deleted` tinyint(1)  DEFAULT NULL COMMENT '逻辑删除',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户权限表';



 DROP TABLE IF EXISTS `goods_img`;  
 CREATE TABLE `goods_img`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11)  NOT NULL COMMENT '商品ID',
 `property_value_id` int(11)  NOT NULL COMMENT '商品属性值ID',
 `img` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片URL',
 `add_time` datetime   DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品图片表';