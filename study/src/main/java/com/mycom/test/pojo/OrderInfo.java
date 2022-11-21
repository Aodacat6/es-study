/*
 *    Copyright (c) 2018-2025, hrois All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: hrois
 */

package com.mycom.test.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;




/**
 * 订单信息 
 *
 * @author wangysh
 * @date 2021-06-10 16:31:08
 */
@Data
@Document(indexName = "order_info_index", shards = 1, replicas = 1)
public class OrderInfo  {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	@Id
	@Field(type = FieldType.Keyword)
	@ExcelProperty("order_id")
	private String orderId;

	/**
	 * PO号
	 */
	@Field(type = FieldType.Keyword)
	@ExcelProperty("po_no")
	private String poNo;

	/**
	 * poId
	 */
	@ExcelProperty("po_id")
	@Field(type = FieldType.Long)
	private Long poId;



	/**
	 * 下家PO号
	 */
	@Field(type = FieldType.Keyword)
	@ExcelProperty("last_po_no")
	private String lastPoNo;

	/**
	 * 下单日期
	 */
	@Field(type = FieldType.Keyword)
	@ExcelProperty("po_date")
	private String poDate;

	/**
	 * zbo号
	 */
	@ExcelProperty("zbo_id")
	@Field(type = FieldType.Long)
	private Long zboId;

	/**
	 * sap返回的编号
	 */
	@Field(type = FieldType.Keyword)
	@ExcelProperty("sap_no")
	private String sapNo;

	/**
	 * 合同编号
	 */
	@Field(type = FieldType.Text)
	@ExcelProperty("contract_no")
	private String contractNo;


	@ExcelProperty("sale_org_code")
	@Field(type = FieldType.Keyword)
	private Integer saleOrgCode;


	 @ExcelProperty("sale_org_name")
	 @Field(type = FieldType.Text)
	 private String saleOrgName;

	@Field(type = FieldType.Keyword)
	 @ExcelProperty("sale_area")
	private String saleArea;

	@Field(type = FieldType.Text)
	 @ExcelProperty("sale_area_name")
	private String saleAreaName;

	@Field(type = FieldType.Keyword)
	 @ExcelProperty("dept_id")
	private String deptId;

	@Field(type = FieldType.Keyword)
	 @ExcelProperty("dept_code")
	private String deptCode;

	@Field(type = FieldType.Text)
	 @ExcelProperty("dept_code_name")
	private String deptCodeName;



	@ExcelProperty("cust_manager")
	@Field(type = FieldType.Keyword)
	private String custManager;


	 @ExcelProperty("cust_manager_name")
	 @Field(type = FieldType.Keyword)
	 private String custManagerName;


	 @ExcelProperty("assistant_cust_manager")
	 @Field(type = FieldType.Keyword)
	 private String assistantCustManager;


	 @ExcelProperty("assistant_cust_manager_name")
	 @Field(type = FieldType.Keyword)
	 private String assistantCustManagerName;


	 @ExcelProperty("payer")
	 @Field(type = FieldType.Keyword)
	 private String payer;


	 @ExcelProperty("payer_name")
	 @Field(type = FieldType.Text)
	 private String payerName;


	@ExcelProperty("regional_manager")
	@Field(type = FieldType.Keyword)
	private String regionalManager;


	 @ExcelProperty("regional_manager_name")
	 @Field(type = FieldType.Keyword)
	 private String regionalManagerName;


	@ExcelProperty("prod_manager")
	@Field(type = FieldType.Keyword)
	private String prodManager;


	 @ExcelProperty("prod_manager_name")
	 @Field(type = FieldType.Keyword)
	 private String prodManagerName;


	@ExcelProperty("exec_manager")
	@Field(type = FieldType.Keyword)
	private String execManager;


	 @ExcelProperty("exec_manager_name")
	 @Field(type = FieldType.Keyword)
	 private String execManagerName;

/*
/*
	*//**
	 * 订舱经理
	 *//*
	private String transManager;

	*//**
	 * 订舱经理名称
	 *//*
	private String transManagerName;

	*//**
	 * 收汇经理
	 *//*
	@NotBlank(message = "收汇经理不能为空")
	@NotNull(message = "收汇经理不能为空")
	private String recManager;

	*//**
	 * 收汇经理名称
	 *//*
	private String recManagerName;

	*//**
	 * 单证经理
	 *//*
	private String docManager;

	*//**
	 * 单证经理名称
	 *//*
	private String docManagerName;

	*//**
	 * 是否买断 0 代理 1 买断
	 *//*
	private String buyoutFlag = "0";

	*//**
	 * 是否锁定汇率,0=不锁定，1=锁定
	 *//*
	private String lockexchangeFlag = "0";

	*//**
	 * 船公司
	 *//*
	private String vendorCode;

	*//**
	 * 船公司名称
	 *//*
	private String vendorName;

	*//**
	 * 售达方
	 *//*
	@NotBlank(message = "售达方不能为空")
	@NotNull(message = "售达方不能为空")
	private String slodTo;

	*//**
	 * 售达方名称
	 *//*
	private String slodToName;

	*//**
	 * 收票方
	 *//*
	@NotBlank(message = "收票方不能为空")
	@NotNull(message = "收票方不能为空")
	private String billTo;

	*//**
	 * 收票方名称
	 *//*
	private String billToName;

	*//**
	 * 送达方
	 *//*
	@NotBlank(message = "送达方不能为空")
	@NotNull(message = "送达方不能为空")
	private String shipTo;

	*//**
	 * 送达方名称
	 *//*
	private String shipToName;

	*//**
	 * 装运条件
	 *//*
	private String shippingCond;

	*//**
	 * 装运条件名称
	 *//*
	private String shippingCondName;

	*//**
	 * 运输方式
	 *//*
	@NotBlank(message = "运输方式不能为空")
	@NotNull(message = "运输方式不能为空")
	private String shipMent;

	*//**
	 * 运输方式名称
	 *//*
	private String shipMentName;

	*//**
	 * 始发港
	 *//*
	@NotBlank(message = "始发港不能为空")
	@NotNull(message = "始发港不能为空")
	private String portStartCode;

	*//**
	 * 始发港名称
	 *//*
	private String portStartName;

	*//**
	 * 目的港
	 *//*
	@NotBlank(message = "目的港不能为空")
	@NotNull(message = "目的港不能为空")
	private String portEndCode;

	*//**
	 * 目的港名称
	 *//*

	private String portEndName;

	*//**
	 * 目的港国家
	 *//*

	private String portEndCountry;

	*//**
	 * 目的港国家名称
	 *//*

	private String portEndCountryName;

	*//**
	 * 装运方式
	 *//*

	private String transType;

	*//**
	 * 装运方式名称
	 *//*

	private String transName;

	*//**
	 * 交货冻结
	 *//*

	private Integer deliveryBlock;

	*//**
	 * 订单锁定
	 *//*

	private Integer isLock;

	*//**
	 * 发票冻结
	 *//*

	private Integer invoiceBlock;

	*//**
	 * 出运期
	 *//*

	@NotBlank(message = "出运期不能为空")
	@NotNull(message = "出运期不能为空")
	private String shipDate;

	*//**
	 * 定价日期
	 *//*

	@NotBlank(message = "定价日期不能为空")
	@NotNull(message = "定价日期不能为空")
	private String priceDate;

	*//**
	 * 付款条件
	 *//*

	private String contractPaycondition;

	*//**
	 * 付款条件周期
	 *//*

	private Integer payConditionOnePeriod;

	*//**
	 * 付款条件名称
	 *//*

	private String contractPayconditionName;

	*//**
	 * 成交方式
	 *//*

	private String contractDealstyle;

	*//**
	 * 成交方式名称
	 *//*

	private String contractDealstyleName;

	*//**
	 * 成交方式2
	 *//*
	@NotBlank(message = "成交方式2不能为空")
	@NotNull(message = "成交方式2不能为空")

	private String incoterms;

	*//**
	 * 付款方式
	 *//*

	private String contractPaystyle;

	*//**
	 * 付款方式名称
	 *//*

	private String contractPaystyleName;

	*//**
	 * 出具发票日期
	 *//*

	@NotBlank(message = "出具发票日期不能为空")
	@NotNull(message = "出具发票日期不能为空")
	private String billingDate;

	*//**
	 * 提供服务日期
	 *//*

	@NotBlank(message = "提供服务日期不能为空")
	@NotNull(message = "提供服务日期不能为空")
	private String servDate;

	*//**
	 * 原币对美元汇率
	 *//*

	private BigDecimal toUsaExchange;

	*//**
	 * 兑人民币汇率
	 *//*

	private BigDecimal toCnyExchange;

	*//**
	 * 币种
	 *//*

	private String currency;

	*//**
	 * 客户组
	 *//*

	private String customerGroup;

	*//**
	 * 客户组名称
	 *//*

	private String customerGroupName;

	*//**
	 * 价格清单
	 *//*

	private String priceList;

	*//**
	 * 价格清单名称
	 *//*

	private String priceListName;

	*//**
	 * 价格组
	 *//*

	private String priceGroup;

	*//**
	 * 价格组名称
	 *//*

	private String priceGroupName;

	*//**
	 * 订单原因
	 *//*

	@NotBlank(message = "订单原因不能为空")
	@NotNull(message = "订单原因不能为空")
	private String orderReason;

	*//**
	 * 订单原因名称
	 *//*

	private String orderReasonName;

	*//**
	 * 使用【保险类别】
	 *//*

	@NotBlank(message = "使用【保险类别】不能为空")
	@NotNull(message = "使用【保险类别】不能为空")
	private String used;

	*//**
	 * 使用【保险类别】名称
	 *//*

	private String usedName;

	*//**
	 * 创建订单类型 0：ZOR 1：ZOC 2：ZFO 3：ZORF 4：ZORG 5：ZORM 6:备件
	 *//*
	private Integer createOrderType;

	*//**
	 * 订单类型
	 *//*

	private String orderType;

	*//**
	 * 订单类型名称
	 *//*

	private String orderTypeName;

	*//**
	 * 总数量
	 *//*
	private Integer sumQuantity;

	*//**
	 * 剩余数量
	 *//*

	private Integer remainingQuantity;

	*//**
	 * 总额
	 *//*

	private BigDecimal sumAmount;

	*//**
	 * 是否导HGVS,0=不需要，1=需要
	 *//*

	private Integer hgvsFlag;

	*//**
	 * 是否外销快递,0=否，1=是
	 *//*

	private Integer expressFlag;

	*//**
	 * 是否商检,0=否，1=是(暂时保留）
	 *//*
	private Integer inspectionFlag;

	*//**
	 * 特殊检
	 *//*
	private String specialInspection;

	*//**
	 * 装箱方式
	 *//*
	private String packingType;

	*//**
	 * 生产工厂编码
	 *//*
	@NotBlank(message = "生产工厂不能为空")
	@NotNull(message = "生产工厂不能为空")
	private String factoryCode;

	*//**
	 * 生产工厂姓名
	 *//*
	private String factoryName;

	*//**
	 * T模式代码
	 *//*
	private String tmodeCode;

	*//**
	 * T模式返回代码
	 *//*
	private String tmodeReturnCode;

	*//**
	 * T模式代码
	 *//*
	private String tmodeName;

	*//**
	 * 附件UPLOAD_FILE的ID
	 *//*
	private String orderAttachments;

	*//**
	 * PO附件UPLOAD_FILE的ID
	 *//*
	private String poAttachments;

	*//**
	 * 修改次数
	 *//*
	private Integer modificationNum;

	*//**
	 * 备件关联整机订单号
	 *//*
	private String spZor;

	*//**
	 * 备注
	 *//*
	private String mark;

	*//**
	 * 是否有利润 0：无 1：有
	 *//*
	private Integer profitFlag = 1;

	*//**
	 * 释放者
	 *//*
	private String releaseBy;

	*//**
	 * 释放时间
	 *//*
	private LocalDateTime releaseTime;

	*//**
	 * 创建人
	 *//*
	private String createBy;

	*//**
	 * 创建时间
	 *//*
	private LocalDateTime createTime;

	*//**
	 * 更新人
	 *//*
	private String updateBy;

	*//**
	 * 更新时间
	 *//*
	private LocalDateTime updateTime;


	*//**
	 * poSource
	 *//*
	private Integer poSource;

	*//**
	 * 审核标记
	 *//*
	private Integer orderAuditFlag;

	*//**
	 * 议付通过
	 *//*
	private String orderNegoSubject;

	*//**
	 * 是否有效
	 *//*
	private String activeFlag;

	*//**
	 * 货代的发票号
	 *//*
	private String negotionInvoice;

	*//**
	 * 约类型
	 *//*
	private String ifYear;

	*//**
	 * 开发部样机
	 *//*
	private Integer devFlag;

	*//**
	 * 出口国家
	 *//*
	@NotBlank(message = "出口国家不能为空")
	@NotNull(message = "出口国家不能为空")
	private String country;

	*//**
	 * 出口国家名称
	 *//*
	private String countryName;

	*//**
	 * 名称
	 *//*
	private String name;

	*//**
	 * 发票号
	 *//*
	private String invoiceNum;

	*//**
	 * 是否直创
	 *//*
	private Integer directFlag;

	*//**
	 * 是否出运
	 *//*
	private String isSap;

	*//**
	 * 创建方式0:接口1:手动2:EXCEl
	 *//*
	private Integer createType;

	*//**
	 * 终端客户
	 *//*
	private String customerCode;

	*//**
	 * 版本
	 *//*
	private String version;

	*//**
	 * 调度单ID
	 *//*
	private Long dispatchId;

	*//**
	 * 是否贸易公司
	 *//*
	private String isShop;

	*//**
	 * 是否贸付款保证
	 *//*
	private String isPay;
	*//**
	 * 评审的id
	 *//*
	private Long mainId;

	private String actShipmentFlag;

	private String compreNo;


	private String freight;

	*//**
	 * id的集合
	 *//*

	private String needId;

	*//**
	 * id的集合
	 *//*

	private String ids;

	private String processId;

	private String taskId;

	private Integer ifTodo;

	private Integer orderGroup;

	*//**
	 * 订单删除还是更新 0删除 1更新
	 *//*

	private String mqType;

*/
}
