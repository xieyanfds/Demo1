## API接口设计

### 目录
[交互数据结构](#交互数据结构)

[系统设置相关接口](#系统设置相关接口)

[&emsp;&emsp;登录日志](#登录日志)

[&emsp;&emsp;查询日志](#查询日志)

[&emsp;&emsp;账单信息](#账单信息)

[&emsp;&emsp;&emsp;&emsp;1.企业账单](#1-企业账单)

[&emsp;&emsp;&emsp;&emsp;1.1tenancyDetail接口](#11-tenancydetail接口)

[&emsp;&emsp;&emsp;&emsp;2.机构账单](#2-机构账单)

[&emsp;&emsp;&emsp;&emsp;2.1departmentDetail接口](#21-departmentdetail接口)

[&emsp;&emsp;&emsp;&emsp;3.部门账单](#3-部门账单)

[&emsp;&emsp;记录管理](#记录管理)

[&emsp;&emsp;&emsp;&emsp;1.来电通话记录](#1-来电通话记录)

[&emsp;&emsp;&emsp;&emsp;1.1answerTypes接口说明](#11-answertypes接口说明)

[&emsp;&emsp;&emsp;&emsp;1.2省接口说明](#12-省接口说明)

[&emsp;&emsp;&emsp;&emsp;1.3市接口说明](#13-市接口说明)

[&emsp;&emsp;&emsp;&emsp;1.4showFileds接口说明](#14-showfileds接口说明)

[&emsp;&emsp;&emsp;&emsp;1.5来电通话详情接口](#15-来电通话详情接口)

[&emsp;&emsp;&emsp;&emsp;1.6IVR详情接口](#16-ivr详情接口)

### 交互数据结构

数据为json格式

正确结果

```
{
    "status":0,
    "msg":"成功",
    "result": object/array
}
```

错误结果

```
{
    "status":-1,
    "msg":"失败",
    "error": "error message"
}
```

### 系统设置相关接口

#### 登录日志

* URL:/api/loginLogs

* Method:GET

* Content type: application/json

* 输入参数：

  |    参数     |  要求  |   类型   |        描述         |
  | :-------: | :--: | :----: | :---------------: |
  | startDate | 非必选  | string |    开始日期，默认当日零点    |
  |  endDate  | 非必选  | string | 截止日期，默认当日23:59:59 |
  |   start   | 非必选  | string |    当前页码，默认第一页     |
  |   limit   | 非必选  | string |    每页记录数，默认10条    |
  | loginType | 非必选  |  int   | 登录类型，0 全部，1登入，2登出 |

* 返回结果：

  |   参数   |   类型   |      描述       |
  | :----: | :----: | :-----------: |
  | status |  int   | 状态码, 0成功，-1失败 |
  |  msg   | string |   状态说明，例如成功   |
  | result | array  |   登录日志数据列表    |

* 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": [
          {
   	  	   "loginName":"admin",
              "loginIp":"127.0.0.1",
              "loginTypeDesc":"登入",
              "userTypeDesc":"系统用户",
              "loginTime":"2017-12-27 16:33:03", 
              "resultDesc": "成功"
           }   
      ],
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

* 返回对象字段说明：

  ​

  |      参数       |   类型   |             描述             |
  | :-----------: | :----: | :------------------------: |
  |   loginName   | string |            用户名             |
  |    loginIp    | string |            登录ip            |
  | loginTypeDesc | string |            登录类型            |
  | userTypeDesc  | string |            用户类型            |
  |   loginTime   | string | 操作时间,格式yyyy-MM-dd HH:mm:ss |
  |  resultDesc   | string |            登录结果            |

#### 查询日志

- URL:/api/queryLogs

- Method:GET

- Content type: application/json

- 输入参数：

  |    参数     |  要求  |   类型   |        描述         |
  | :-------: | :--: | :----: | :---------------: |
  | operator  | 非必选  | String |      查询的用户名       |
  | startDate | 非必选  | String |    开始日期，默认当日零点    |
  |  endDate  | 非必选  | String | 截止日期，默认当日23:59:59 |
  |   start   | 非必选  | String |    当前页码，默认第一页     |
  |   limit   | 非必选  | String |   每页记录数，默认值10条    |

- 返回结果：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  int   |    状态码    |
  |  msg   | string | 状态说明，例如成功 |
  | result | array  | 查询日志数据列表  |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": [
          {
   	  	   "operator":"admin",
              "queryModule":"质检管理 > 案例组管理",
              "queryTime":"2017-12-27 16:36:09",
              "comment":"质检管理 "
           }   
      ],
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

  ​

- 返回对象字段说明：

  |     参数      |   类型   |             描述             |
  | :---------: | :----: | :------------------------: |
  |  operator   | string |            查询用户            |
  | queryModule | string |            查询菜单            |
  |  queryTime  | string | 查询时间，格式yyyy-MM-dd HH:mm:ss |
  |   comment   | string |       所属模块，字符长度50以内        |

#### 账单信息

##### 1. 企业账单

- URL:/api/bill/tenancy

- Method:GET

- Content type: application/json

- 输入参数：

  |     参数     |  要求  |   类型   |       描述        |
  | :--------: | :--: | :----: | :-------------: |
  | tenancyId  |  必选  | String | 所属企业id，查询所有企业获取 |
  |  billDate  | 非必选  | String |   开始账期，默认前一个月   |
  | billDateTo | 非必选  | String |   结束账期，默认前一个月   |
  |   start    | 非必选  | String |   当前页码,默认第一页    |
  |   limit    | 非必选  | String |  每页记录数，默认每页十条   |

- 返回结果：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  Int   |    状态码    |
  |  msg   | String | 状态说明，例如成功 |
  | result | array  |  企业账单列表   |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": [
          {
   	  	   "billDate":"2017-09",
              "accountName":"中华保险",
              "fullName":"厉炉钢",
              "cost":"11685.0",
              "discount":"0.0", 
              "realCost": "11685.0",
              "statusStr":"已销账"
           }   
      ],
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

- 返回对象字段说明：

  |     参数      |   类型   |           描述            |
  | :---------: | :----: | :---------------------: |
  |  billDate   | String |           账期            |
  | accountName | String |          账户名称           |
  |  fullName   | String |          直销经理           |
  |    cost     | Float  |          标准费用           |
  |  discount   | Float  |          减免金额           |
  |  realCost   | Float  |          实际收费           |
  |  statusStr  | String |           状态            |
  |     操作      |   按钮   | 调用tenancyDetail接口查看账单详情 |

##### 1.1 tenancyDetail接口

  - URL:/api/bill/tenancyDetail

  - Method:GET

  - Content type: application/json

    输入参数：

|     参数      |   类型   |               描述               |
| :---------: | :----: | :----------------------------: |
|  tenancyId  | String |              企业id              |
| accountName | String |              账户名称              |
|  billDate   | String |               账期               |
|  statusStr  | String |               状态               |
|   export    |  int   | 100：导出本页，200：导出全部，若导出返回导出文件url |

- tenancyDetail接口返回：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  Int   |    状态码    |
  |  msg   | String | 状态说明，例如成功 |
  | result | array  | 企业账单详情列表  |

- 返回示例：

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": {
      	[
          {
          	"accountBillFee":{
                  "cost":"11.0",
                  "discount":"0.0",
                  "lowestCost":"1.9",
                  "billCost":"2.1",
                  "realCost":"15.0"
          	},
          	"rateFee":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"rateFee1010":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"rateFee400":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"numberFee":{
                "cost":"10.0",
                "count":"2"
          	},
          	"clientFee":{
                "mode":"0",
                "fee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
                 "dayRatio":"1"
          	},
          	"lowestCostFee":{
                "cost":"10.0"
          	},
          	"smsFee":{
                "amount":"1",
                "price":"10.0",
                "feeType":"按小时收费",
                "cost":"10.0
          	},
   	  	   "email":"123@qq.com",
           }   
      	],
      	"billDate":"2017-09",
          "accountName":"中华保险",
          "tenancyId":"123",
          "statusStr":"已销账"
      	},
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

  ​

- 返回对象字段说明：

  |     参数      |   类型   |  描述  |
  | :---------: | :----: | :--: |
  | accountName | String | 账户名称 |
  |  billDate   | String |  账期  |
  |  statusStr  | String | 账单状态 |
  |  tenancyId  | Float  | 企业id |

accountBillFee（账户对象）对象字段说明：

|     参数     |  类型   |  描述  |
| :--------: | :---: | :--: |
|    cost    | float | 标准费用 |
|  discount  | float | 减免金额 |
| lowestCost | float | 最低消费 |
|  billCost  | float | 账单费用 |
|  realCost  | float | 实际收费 |

rateFee,rateFee1010,rateFee400对象说明：

|      参数       |   类型    |                  描述                   |
| :-----------: | :-----: | :-----------------------------------: |
|     mode      |   int   |         通话计费方式，0：按分钟计，1：按6秒计          |
|    modeStr    | String  |                 计费描述                  |
|   ibLeftFee   |  Fee对象  |                 客户侧呼入                 |
|  ibRightFee   |  Fee对象  |             座席侧呼入(呼转座席侧)              |
| ibRightIadFee |  Fee对象  |               呼转座席(iad)               |
|   obLeftFee   |  Fee对象  |                 外呼客户侧                 |
|  obRightFee   |  Fee对象  |                 外呼座席侧                 |
| obRightIadFee |  Fee对象  |              外呼转座席(iad)               |
|   phoneType   | String  | "": DID号码、"400": 400号码、"1010": 1010号码 |
|   haveCombo   | boolean |     是否有套餐，true：有；false：无，默认为false     |

Fee对象说明：

|   参数    |   类型   |    描述     |
| :-----: | :----: | :-------: |
| amount  |  int   | 呼入流量，单位分钟 |
|  price  | float  |    价格     |
| feeType | String |   收费类型    |
|  cost   | float  |    费用     |

numberFee（号码对象）对象说明：

|  参数   |  类型   |  描述  |
| :---: | :---: | :--: |
| cost  | float | 消费金额 |
| count |  int  |  数量  |

clientFee（坐席对象）对象说明：

|    参数    |  类型   |                    描述                    |
| :------: | :---: | :--------------------------------------: |
|   mode   |  int  | 计算计费座席数的方式，0：付费电脑座席数，1：用户登录活跃座席数，2：用户使用活跃座席数(有流量) |
|   fee    | Fee对象 |                   座席费用                   |
| dayRatio | float |           当月有效天数与当月总天数的比率，默认为1           |

lowestCostFee（最低消费对象）对象说明：

|  参数  |  类型   |  描述  |
| :--: | :---: | :--: |
| cost | float | 消费金额 |

smsFee（短信对象）对象也是Fee对象。



参考：



|       参数       |   类型   |                    描述                    |
| :------------: | :----: | :--------------------------------------: |
|  accountName   | String |                   账户名称                   |
|    billDate    | String |                    账期                    |
|   statusStr    | String |                   账单状态                   |
|   lowestCost   | Float  |            结余小计,最低消费对象的cost字段            |
|  numberCount   |  Int   |           收费号码个数，号码对象的count字段            |
|   numberCost   | Float  |            功能费合计，号码对象的cost字段             |
|  400ILFPrice   | Float  | 400号码客户呼入单价，400号码通信对象ibLeftfee字段对象price字段 |
|   400ModeStr   | String |  400号码通话计费描述，每分钟或每六秒，400号码通信对象modeStr字段  |
|  400ILFAmount  |  Int   | 400号码客户呼入流量，单位分钟，400号码通信对象ibLeftFee字段对象amount字段 |
|   400ILFCost   | Float  | 400号码客户呼入费用，400号码通信对象ibLeftFee字段对象cost字段 |
|  400IRFPrice   | Float  | 400号码呼转座席单价，400号码通信对象ibRightFee字段对象price字段 |
|  400IRFAmount  |  Int   | 400号码呼转座席流量，单位分钟，400号码通信对象ibRightFee字段对象amount字段 |
|   400IRFCost   | Float  | 400号码呼转座席费用，400号码通信对象ibRightFee字段对象cost字段 |
|  400IRIFPrice  | Float  | 400号码呼转座席-IAD单价，400号码通信对象ibRightIadFee字段对象price字段 |
| 400IRIFAmount  |  Int   | 400号码呼转座席-IAD流量，单位分钟，400号码通信对象ibRightIadFee字段对象amount字段 |
|  400IRIFCost   | Float  | 400号码呼转座席-IAD费用，400号码通信对象ibRightIadFee字段对象cost字段 |
|  400OLFPrice   | Float  | 400号码外呼呼转客户单价，400号码通信对象obLeftFee字段对象price字段 |
|  400OLFAmount  |  Int   | 400号码外呼呼转客户流量，单位分钟，400号码通信对象obLeftFee字段对象amount字段 |
|   400OLFCost   | Float  | 400号码外呼呼转客户费用，400号码通信对象obLeftFee字段对象cost字段 |
|  400ORFPrice   | Float  | 400号码外呼呼转坐席单价，400号码通信对象obRightFee字段对象price字段 |
|  400ORFAmount  |  Int   | 400号码外呼呼转坐席流量，单位分钟，400号码通信对象obRightFee字段对象amount字段 |
|   400ORFCost   | Float  | 400号码外呼呼转坐席费用，400号码通信对象obRightFee字段对象cost字段 |
|  400ORIFPrice  | Float  | 400号码外呼呼转坐席-IAD单价，400号码通信对象obRightIadFee字段对象price字段 |
| 400ORIFAmount  |  Int   | 400号码外呼呼转坐席-IAD流量，单位分钟，400号码通信对象obRightIadFee字段对象amount字段 |
|  400ORIFCost   | Float  | 400号码外呼呼转坐席-IAD费用，400号码通信对象obRightIadFee字段对象cost字段 |
|  1010ILFPrice  | Float  | 1010号码客户呼入单价，1010号码通信对象ibLeftfee字段对象price字段 |
|  1010ModeStr   | String | 1010号码通话计费描述，每分钟或每六秒，1010号码通信对象modeStr字段 |
| 1010ILFAmount  |  Int   | 1010号码客户呼入流量，单位分钟，1010号码通信对象ibLeftFee字段对象amount字段 |
|  1010ILFCost   | Float  | 1010号码客户呼入费用，1010号码通信对象ibLeftFee字段对象cost字段 |
|  1010IRFPrice  | Float  | 1010号码呼转座席单价，1010号码通信对象ibRightFee字段对象price字段 |
| 1010IRFAmount  |  Int   | 1010号码呼转座席流量，单位分钟，1010号码通信对象ibRightFee字段对象amount字段 |
|  1010IRFCost   | Float  | 1010号码呼转座席费用，1010号码通信对象ibRightFee字段对象cost字段 |
| 1010IRIFPrice  | Float  | 1010号码呼转座席-IAD单价，1010号码通信对象ibRightIadFee字段对象price字段 |
| 1010IRIFAmount |  Int   | 1010号码呼转座席-IAD流量，单位分钟，1010号码通信对象ibRightIadFee字段对象amount字段 |
|  1010IRIFCost  | Float  | 1010号码呼转座席-IAD费用，1010号码通信对象ibRightIadFee字段对象cost字段 |
|  1010OLFPrice  | Float  | 1010号码外呼呼转客户单价，1010号码通信对象obLeftFee字段对象price字段 |
| 1010OLFAmount  |  Int   | 1010号码外呼呼转客户流量，单位分钟，1010号码通信对象obLeftFee字段对象amount字段 |
|  1010OLFCost   | Float  | 1010号码外呼呼转客户费用，1010号码通信对象obLeftFee字段对象cost字段 |
|  1010ORFPrice  | Float  | 1010号码外呼呼转坐席单价，1010号码通信对象obRightFee字段对象price字段 |
| 1010ORFAmount  |  Int   | 1010号码外呼呼转坐席流量，单位分钟，1010号码通信对象obRightFee字段对象amount字段 |
|  1010ORFCost   | Float  | 1010号码外呼呼转坐席费用，1010号码通信对象obRightFee字段对象cost字段 |
| 1010ORIFPrice  | Float  | 1010号码外呼呼转坐席-IAD单价，1010号码通信对象obRightIadFee字段对象price字段 |
| 1010ORIFAmount |  Int   | 1010号码外呼呼转坐席-IAD流量，单位分钟，1010号码通信对象obRightIadFee字段对象amount字段 |
|  1010ORIFCost  | Float  | 1010号码外呼呼转坐席-IAD费用，1010号码通信对象obRightIadFee字段对象cost字段 |
|  DIDILFPrice   | Float  | DID号码客户呼入单价，DID号码通信对象ibLeftfee字段对象price字段 |
|   DIDModeStr   | String |  DID号码通话计费描述，每分钟或每六秒，DID号码通信对象modeStr字段  |
|  DIDILFAmount  |  Int   | DID号码客户呼入流量，单位分钟，DID号码通信对象ibLeftFee字段对象amount字段 |
|   DIDILFCost   | Float  | DID号码客户呼入费用，DID号码通信对象ibLeftFee字段对象cost字段 |
|  DIDIRFPrice   | Float  | DID号码呼转座席单价，DID号码通信对象ibRightFee字段对象price字段 |
|  DIDIRFAmount  |  Int   | DID号码呼转座席流量，单位分钟，DID号码通信对象ibRightFee字段对象amount字段 |
|   DIDIRFCost   | Float  | DID号码呼转座席费用，DID号码通信对象ibRightFee字段对象cost字段 |
|  DIDIRIFPrice  | Float  | DID号码呼转座席-IAD单价，DID号码通信对象ibRightIadFee字段对象price字段 |
| DIDIRIFAmount  |  Int   | DID号码呼转座席-IAD流量，单位分钟，DID号码通信对象ibRightIadFee字段对象amount字段 |
|  DIDIRIFCost   | Float  | DID号码呼转座席-IAD费用，DID号码通信对象ibRightIadFee字段对象cost字段 |
|  DIDOLFPrice   | Float  | DID号码外呼呼转客户单价，DID号码通信对象obLeftFee字段对象price字段 |
|  DIDOLFAmount  |  Int   | DID号码外呼呼转客户流量，单位分钟，DID号码通信对象obLeftFee字段对象amount字段 |
|   DIDOLFCost   | Float  | DID号码外呼呼转客户费用，DID号码通信对象obLeftFee字段对象cost字段 |
|  DIDORFPrice   | Float  | DID号码外呼呼转坐席单价，DID号码通信对象obRightFee字段对象price字段 |
|  DIDORFAmount  |  Int   | DID号码外呼呼转坐席流量，单位分钟，DID号码通信对象obRightFee字段对象amount字段 |
|   DIDORFCost   | Float  | DID号码外呼呼转坐席费用，DID号码通信对象obRightFee字段对象cost字段 |
|  DIDORIFPrice  | Float  | DID号码外呼呼转坐席-IAD单价，DID号码通信对象obRightIadFee字段对象price字段 |
| DIDORIFAmount  |  Int   | DID号码外呼呼转坐席-IAD流量，单位分钟，DID号码通信对象obRightIadFee字段对象amount字段 |
|  DIDORIFCost   | Float  | DID号码外呼呼转坐席-IAD费用，DID号码通信对象obRightIadFee字段对象cost字段 |
|    SFPrice     | Float  |            短信单价，短信对象的price字段             |
|    SFAmount    |  Int   |            短信条数，短信对象的amount字段            |
|     SFCost     | Float  |             短信费用，短信对象的cost字段             |
|    CFFPrice    | Float  |        坐席月租，坐席对象的fee字段对象的price字段         |
|   CFFAmount    |  Int   |       计费坐席数，坐席对象的fee字段对象的amount字段        |
|     CFCost     | Float  |             坐席费用，坐席对象的cost字段             |
|   ACCBFCost    | Float  |            账户合计费用，账户对象的cost字段            |
|  ACCBFLowCost  | Float  |          账户低消，账户对象的lowestCost字段          |
| ACCBFBillCost  | Float  |           账单费用，账户对象的billCost段            |
| ACCBFDiscount  | Float  |           减免金额，账户对象的discount字段           |
| ACCBFRealCost  | Float  |           结算费用，账户对象的realCost字段           |

##### 2 机构账单

- URL:/api/bill/organization

- Method:GET

- Content type: application/json

- 输入参数：

  |       参数       |  要求  |   类型   |               描述               |
  | :------------: | :--: | :----: | :----------------------------: |
  |   tenancyId    |  必选  | String |        所属企业id，查询所有企业获取         |
  | organizationId |  必选  | String |        所属机构id，查询所有机构获取         |
  |    billDate    | 非必选  | String |           账期，默认前一个月            |
  | tenancyTableId | 非必选  | String |        tenancyId  1,2,3        |
  |     start      | 非必选  | String |           当前页码,默认第一页           |
  |     limit      | 非必选  | String |          每页记录数，默认每页十条          |
  |     export     | 非必选  |  int   | 100：导出本页，200：导出全部，若导出返回导出文件url |

- 返回结果：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  Int   |    状态码    |
  |  msg   | String | 状态说明，例如成功 |
  | result | array  |  机构账单列表   |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": [
          {
   	  	   "orgName":"研发测试机构",
              "orgCost":"19000.0",
              "departmentName":"AWS-6研发测试",
              "deptCost":"19000.0"
           }   
      ],
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

- 返回对象字段说明：

  |       参数       |   类型   |             描述             |
  | :------------: | :----: | :------------------------: |
  |    orgName     | String |            机构名称            |
  |    orgCost     | Float  |          机构费用（元）           |
  | departmentName | String |            部门名称            |
  |    deptCost    | Float  |          部门费用（元）           |
  |       操作       |   无    | 调用departmentDetail接口查看账单详情 |

##### 2.1 departmentDetail接口

  - URL:/api/bill/organizationDetail

  - Method:GET

  - Content type: application/json

  - 输入参数：

    |       参数       |   类型   |               描述               |
    | :------------: | :----: | :----------------------------: |
    |   tenancyId    | String |              企业id              |
    | organizationId | String |             所属机构id             |
    |  departmentId  | String |              部门id              |
    | departmentName | String |              部门名称              |
    |    billDate    | String |               账期               |
    |     export     |  Int   | 100：导出本页，200：导出全部，若导出返回导出文件url |

  - 返回结果：

    |   参数   |   类型   |    描述     |
    | :----: | :----: | :-------: |
    | status |  int   |    状态码    |
    |  msg   | String | 状态说明，例如成功 |
    | result | array  | 机构账单详情列表  |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": {
      	[
          {
          	"accountBillFee":{
                  "cost":"11.0",
                  "discount":"0.0",
                  "lowestCost":"1.9",
                  "billCost":"2.1",
                  "realCost":"15.0"
          	},
          	"rateFee":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"rateFee1010":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"rateFee400":{
               	 "mode":"0",
               	 "modeStr":"",
               	 "ibLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "ibRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obLeftFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "obRightIadFee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
               	 "phoneType":"400",
               	 "haveCombo":"false"
          	},
          	"numberFee":{
                "cost":"10.0",
                "count":"2"
          	},
          	"clientFee":{
                "mode":"0",
                "fee":{
                    		"amount":"1",
                    		"price":"10.0",
                    		"feeType":"按小时收费",
                    		"cost":"10.0
               	 },
                 "dayRatio":"1"
          	},
          	"lowestCostFee":{
                	"cost":"10.0"
          	},
          	"smsFee":{
                  "amount":"1",
                  "price":"10.0",
                  "feeType":"按小时收费",
                  "cost":"10.0
          	},
          	"deductionFee":{
                	"mode":"0",
                	"cost":"0",
                	"preFeeType":"all_call",
                	"threshold":"12.9",
                	"deductFeeType":"client"
          	},
          	"comboFee":{
                  "cost":"花费",
                  "resultList":[{
                      "cno":"10001",
                      "amount":"61",
                      "cost":""12.9,
                      "comboCopysCount":"4",
                      "itemList":[{
                          "minThreshold":"2",
                          "maxThreshold":"12",
                          "mode":"0",
                          "price":"0.5",
                          "amount":"13",
                          "cost":"21.3",
                      }]
                  }],
                  "clientCount":"12",
                  "comboRule":{
                        "clientMode":"1"
                  },
                  "comboCopysCount":"12"
          	},
              "masterHotline":"86445293",
   	  	    "email":"123@qq.com",
           }   
      	],
      	"tenancyId":"123",
          "organizationId":"234",
          "departmentId":"456",
          "departmentName":"部门567",
          "billDate":"2017-12",
          "statusStr":"已销账",
          "obAmount":"23",
          "masterHotline":"86445293"
      	},
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

  ​

- 返回对象字段说明：

  accountBillFee，rateFee，rateFee1010，rateFee400，numberFee，clientFee，lowestCostFee，smsFee等对象说明同上。

  ​

  deductionFee（减免对象）对象说明：

  |      参数       |   类型   |                    描述                    |
  | :-----------: | :----: | :--------------------------------------: |
  |     mode      |  int   |           减免模式：0-不允许减免，1-允许减免            |
  |     cost      | float  |                <=0，小于或等于0                |
  |  preFeeType   | String | 减免条件对象类型，FEE_TYPE_ALL_CALL，all_call，所有呼叫费用(不含短信)，ib_left+ib_right+ib_right_iad+ob_left+ob_right+ob_right_iad |
  |   threshold   | float  |                减免生效阈值(金额)                |
  | deductFeeType | String |     减免对象，FEE_TYPE_CLIENT，client，座席费      |

  ​

  comboFee（套餐对象）对象说明：

  |       参数        |     类型      |                    描述                    |
  | :-------------: | :---------: | :--------------------------------------: |
  |      cost       |    float    |                    花费                    |
  |   resultList    |    array    |              ComboResult结果集              |
  |   clientCount   |     int     |                  计费座席数                   |
  |    comboRule    | ComboRule对象 |                  套餐规则对象                  |
  | comboCopysCount |     int     | 套餐份数，套餐按计算时采用的座席个数，独享模式下为1，共享模式下是有效计费座席数 |

  ComboResult对象说明：

  |       参数        |   类型   |                    描述                    |
  | :-------------: | :----: | :--------------------------------------: |
  |       cno       | String | 座席号，如果是座席共享模式则座席号为Const.CLIENT_DEFAULT_CNO |
  |     amount      |  int   |                总的数量(分钟数)                 |
  |      cost       | float  |                  套餐实际扣费                  |
  | comboCopysCount |  int   |                   套餐规则                   |
  |    itemList     | array  |            ComboItemResult结果集            |

  ComboItemResult对象说明：

  |      参数      |  类型   |                  描述                  |
  | :----------: | :---: | :----------------------------------: |
  | minThreshold |  int  |        最小阈值，单位(分钟)，即每座席的最小分钟数        |
  | maxThreshold |  int  | 最大阈值，单位(分钟)，即每座席的最大分钟数； <= 999999999 |
  |     mode     |  int  |      计费方式，0：费率（元/分钟），1：费用（元/座席）      |
  |    price     | float |       价格：费率(mode=0)/费用(mode=1)       |
  |    amount    |  int  |               数量(分钟数)                |
  |     cost     | float |                  花费                  |

  ComboRule（套餐规则）对象说明：

  |     参数     |  类型  |             描述             |
  | :--------: | :--: | :------------------------: |
  | clientMode | int  | 座席模式，0：所有座席共享套餐，1：每个座席独享套餐 |


参考：



|       参数       |   类型   |                    描述                    |
| :------------: | :----: | :--------------------------------------: |
| departmentName | String |                   部门名称                   |
|    billDate    | Stirng |                    账期                    |
|   statusStr    | String |                   账单状态                   |
| masterHotline  | Stirng |                  主热线号码                   |
|   lowestCost   |  Int   |            结余小计，最低消费对象的cost字段            |
|  numFeeCount   |  Int   |           收费号码个数，号码对象的count字段            |
|  numFeeCount   | Float  |            功能费合计，号码对象的cost字段             |
|  400ILFPrice   | Float  | 400号码客户呼入单价，400号码通信对象ibLeftfee字段对象price字段 |
|   400ModeStr   | String |  400号码通话计费描述，每分钟或每六秒，400号码通信对象modeStr字段  |
|  400ILFAmount  |  Int   | 400号码客户呼入流量，单位分钟，400号码通信对象ibLeftFee字段对象amount字段 |
|   400ILFCost   | Float  | 400号码客户呼入费用，400号码通信对象ibLeftFee字段对象cost字段 |
|  400IRFPrice   | Float  | 400号码呼转座席单价，400号码通信对象ibRightFee字段对象price字段 |
|  400IRFAmount  |  Int   | 400号码呼转座席流量，单位分钟，400号码通信对象ibRightFee字段对象amount字段 |
|   400IRFCost   | Float  | 400号码呼转座席费用，400号码通信对象ibRightFee字段对象cost字段 |
|  400IRIFPrice  | Float  | 400号码呼转座席-IAD单价，400号码通信对象ibRightIadFee字段对象price字段 |
| 400IRIFAmount  |  Int   | 400号码呼转座席-IAD流量，单位分钟，400号码通信对象ibRightIadFee字段对象amount字段 |
|  400IRIFCost   | Float  | 400号码呼转座席-IAD费用，400号码通信对象ibRightIadFee字段对象cost字段 |
|  400OLFPrice   | Float  | 400号码外呼呼转客户单价，400号码通信对象obLeftFee字段对象price字段 |
|  400OLFAmount  |  Int   | 400号码外呼呼转客户流量，单位分钟，400号码通信对象obLeftFee字段对象amount字段 |
|   400OLFCost   | Float  | 400号码外呼呼转客户费用，400号码通信对象obLeftFee字段对象cost字段 |
|  400ORFPrice   | Float  | 400号码外呼呼转坐席单价，400号码通信对象obRightFee字段对象price字段 |
|  400ORFAmount  |  Int   | 400号码外呼呼转坐席流量，单位分钟，400号码通信对象obRightFee字段对象amount字段 |
|   400ORFCost   | Float  | 400号码外呼呼转坐席费用，400号码通信对象obRightFee字段对象cost字段 |
|  400ORIFPrice  | Float  | 400号码外呼呼转坐席-IAD单价，400号码通信对象obRightIadFee字段对象price字段 |
| 400ORIFAmount  |  Int   | 400号码外呼呼转坐席-IAD流量，单位分钟，400号码通信对象obRightIadFee字段对象amount字段 |
|  400ORIFCost   | Float  | 400号码外呼呼转坐席-IAD费用，400号码通信对象obRightIadFee字段对象cost字段 |
|  1010ILFPrice  | Float  | 1010号码客户呼入单价，1010号码通信对象ibLeftfee字段对象price字段 |
|  1010ModeStr   | String | 1010号码通话计费描述，每分钟或每六秒，1010号码通信对象modeStr字段 |
| 1010ILFAmount  |  Int   | 1010号码客户呼入流量，单位分钟，1010号码通信对象ibLeftFee字段对象amount字段 |
|  1010ILFCost   | Float  | 1010号码客户呼入费用，1010号码通信对象ibLeftFee字段对象cost字段 |
|  1010IRFPrice  | Float  | 1010号码呼转座席单价，1010号码通信对象ibRightFee字段对象price字段 |
| 1010IRFAmount  |  Int   | 1010号码呼转座席流量，单位分钟，1010号码通信对象ibRightFee字段对象amount字段 |
|  1010IRFCost   | Float  | 1010号码呼转座席费用，1010号码通信对象ibRightFee字段对象cost字段 |
| 1010IRIFPrice  | Float  | 1010号码呼转座席-IAD单价，1010号码通信对象ibRightIadFee字段对象price字段 |
| 1010IRIFAmount |  Int   | 1010号码呼转座席-IAD流量，单位分钟，1010号码通信对象ibRightIadFee字段对象amount字段 |
|  1010IRIFCost  | Float  | 1010号码呼转座席-IAD费用，1010号码通信对象ibRightIadFee字段对象cost字段 |
|  1010OLFPrice  | Float  | 1010号码外呼呼转客户单价，1010号码通信对象obLeftFee字段对象price字段 |
| 1010OLFAmount  |  Int   | 1010号码外呼呼转客户流量，单位分钟，1010号码通信对象obLeftFee字段对象amount字段 |
|  1010OLFCost   | Float  | 1010号码外呼呼转客户费用，1010号码通信对象obLeftFee字段对象cost字段 |
|  1010ORFPrice  | Float  | 1010号码外呼呼转坐席单价，1010号码通信对象obRightFee字段对象price字段 |
| 1010ORFAmount  |  Int   | 1010号码外呼呼转坐席流量，单位分钟，1010号码通信对象obRightFee字段对象amount字段 |
|  1010ORFCost   | Float  | 1010号码外呼呼转坐席费用，1010号码通信对象obRightFee字段对象cost字段 |
| 1010ORIFPrice  | Float  | 1010号码外呼呼转坐席-IAD单价，1010号码通信对象obRightIadFee字段对象price字段 |
| 1010ORIFAmount |  Int   | 1010号码外呼呼转坐席-IAD流量，单位分钟，1010号码通信对象obRightIadFee字段对象amount字段 |
|  1010ORIFCost  | Float  | 1010号码外呼呼转坐席-IAD费用，1010号码通信对象obRightIadFee字段对象cost字段 |
|  DIDILFPrice   | Float  | DID号码客户呼入单价，DID号码通信对象ibLeftfee字段对象price字段 |
|   DIDModeStr   | String |  DID号码通话计费描述，每分钟或每六秒，DID号码通信对象modeStr字段  |
|  DIDILFAmount  |  Int   | DID号码客户呼入流量，单位分钟，DID号码通信对象ibLeftFee字段对象amount字段 |
|   DIDILFCost   | Float  | DID号码客户呼入费用，DID号码通信对象ibLeftFee字段对象cost字段 |
|  DIDIRFPrice   | Float  | DID号码呼转座席单价，DID号码通信对象ibRightFee字段对象price字段 |
|  DIDIRFAmount  |  Int   | DID号码呼转座席流量，单位分钟，DID号码通信对象ibRightFee字段对象amount字段 |
|   DIDIRFCost   | Float  | DID号码呼转座席费用，DID号码通信对象ibRightFee字段对象cost字段 |
|  DIDIRIFPrice  | Float  | DID号码呼转座席-IAD单价，DID号码通信对象ibRightIadFee字段对象price字段 |
| DIDIRIFAmount  |  Int   | DID号码呼转座席-IAD流量，单位分钟，DID号码通信对象ibRightIadFee字段对象amount字段 |
|  DIDIRIFCost   | Float  | DID号码呼转座席-IAD费用，DID号码通信对象ibRightIadFee字段对象cost字段 |
|  DIDOLFPrice   | Float  | DID号码外呼呼转客户单价，DID号码通信对象obLeftFee字段对象price字段 |
|  DIDOLFAmount  |  Int   | DID号码外呼呼转客户流量，单位分钟，DID号码通信对象obLeftFee字段对象amount字段 |
|   DIDOLFCost   | Float  | DID号码外呼呼转客户费用，DID号码通信对象obLeftFee字段对象cost字段 |
|  DIDORFPrice   | Float  | DID号码外呼呼转坐席单价，DID号码通信对象obRightFee字段对象price字段 |
|  DIDORFAmount  |  Int   | DID号码外呼呼转坐席流量，单位分钟，DID号码通信对象obRightFee字段对象amount字段 |
|   DIDORFCost   | Float  | DID号码外呼呼转坐席费用，DID号码通信对象obRightFee字段对象cost字段 |
|  DIDORIFPrice  | Float  | DID号码外呼呼转坐席-IAD单价，DID号码通信对象obRightIadFee字段对象price字段 |
| DIDORIFAmount  |  Int   | DID号码外呼呼转坐席-IAD流量，单位分钟，DID号码通信对象obRightIadFee字段对象amount字段 |
|  DIDORIFCost   | Float  | DID号码外呼呼转坐席-IAD费用，DID号码通信对象obRightIadFee字段对象cost字段 |
|    SFPrice     | Float  |            短信单价，短信对象的price字段             |
|    SFAmount    |  Int   |            短信条数，短信对象的amount字段            |
|     SFCost     | Float  |             短信费用，短信对象的cost字段             |
|    CFFPrice    | Float  |        坐席月租，坐席对象的fee字段对象的price字段         |
|   CFFAmount    |  Int   |       计费坐席数，坐席对象的fee字段对象的amount字段        |
|     CFCost     | Float  |             坐席费用，坐席对象的cost字段             |
|  ComboFRCMode  |  Int   | 坐席模式，0：所有座席共享套餐，1：每个座席独享套餐；套餐对象的套餐规则对象的clientMode字段 |
|  ComboFCCount  |  Int   |       套餐计费坐席总数,套餐对象的clientCount字段        |
|    obAmount    |  Int   |                   外呼流量                   |
|   ComboCost    | Float  |             套餐费用,套餐对象的cost字段             |
|   ACCBFCost    | Float  |            账户合计费用，账户对象的cost字段            |
|  ACCBFLowCost  | Float  |          账户低消，账户对象的lowestCost字段          |
| ACCBFBillCost  | Float  |           账单费用，账户对象的billCost段            |
| ACCBFDiscount  | Float  |           减免金额，账户对象的discount字段           |
| ACCBFRealCost  | Float  |           结算费用，账户对象的realCost字段           |


##### 3. 部门账单

- URL:/api/bill/department

- Method:GET

- Content type: application/json

- 输入参数：

  |       参数       |  要求  |   类型   |      描述      |
  | :------------: | :--: | :----: | :----------: |
  |   tenancyId    |  必选  | String |    所属企业id    |
  | organizationId |  必选  | String |    所属机构id    |
  |  departmentId  |  必选  | String |    所属部门id    |
  |    billDate    | 非必选  | String |  账期，默认前一个月   |
  |   billDateTo   | 非必选  | String |  账期，默认前一个月   |
  |     start      | 非必选  | String |  当前页码,默认第一页  |
  |     limit      | 非必选  | String | 每页记录数，默认每页十条 |

- 返回结果：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  int   |    状态码    |
  |  msg   | String | 状态说明，例如成功 |
  | result | array  |  部门账单列表   |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": [
          {
   	  	   "id":"1",
              "billDate":"2017-12",
              "hotline":"86445293",
              "departmentName":"AWS-2测试账户7000002",
              "fullName":"罗尧", 
              "cost": "2001818.0",
              "discount":"2001818.0",
              "realCost":"0.0",
              "statusStr":"已出账，核账中"
           }   
      ],
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

- 返回对象字段说明：

  |       参数       |   类型   |             描述             |
  | :------------: | :----: | :------------------------: |
  |    billDate    | String |             账期             |
  |    hotline     | String |           主热线号码            |
  | departmentName | String |            部门名称            |
  |    fullName    | String |            直销经理            |
  |      cost      | Float  |            标准费用            |
  |    discount    | Float  |            减免金额            |
  |    realCost    | Float  |            实际收费            |
  |   statusStr    | String |             状态             |
  |       操作       |   按钮   | 调用departmentDetail接口查看账单详情 |

#### 记录管理

##### 1. 来电通话记录

- URL:/api/record/ib

- Method:GET

- Content type: application/json

- 输入参数：

  |       参数       |  要求  |   类型   |                    描述                    |
  | :------------: | :--: | :----: | :--------------------------------------: |
  |   tenancyId    |  必选  | String |                  所属企业id                  |
  | organizationId |  必选  | String |                  所属机构id                  |
  |  departmentId  |  必选  | String |                  所属部门id                  |
  |   answerType   | 非必选  |  Int   | 接听状态，调用answerTypes接口获取数据，调用接口传递参数  0：默认全部，1：人工接听，2：人工未接听，3：系统应答，4：系统未应答 |
  | answerTypeFlag | 非必选  | String |        接听状态类型，根据answerType变化联动变化         |
  |  vadRateBegin  | 非必选  | Float  |                 通话占比起始值                  |
  |   vadRateEnd   | 非必选  | Float  |                 通话占比终止值                  |
  | vadCountBegin  | 非必选  | Float  |                 通话质量起始值                  |
  |  vadCountEnd   | 非必选  | Float  |                 通话质量终止值                  |
  |    province    | 非必选  | String |                 调用获取省接口                  |
  |      city      | 非必选  | string |                 调用获取地区接口                 |
  |    vadBegin    | 非必选  | Float  |                 通话占比起始值                  |
  |     vadEnd     | 非必选  | Float  |                 通话占比终止值                  |
  |   showFileds   | 非必选  | string |           调用showFileds接口获取显示字段           |
  |   startDate    |  必选  | string |                   开始时间                   |
  |    endDate     |  必选  | string |                   结束时间                   |
  |     start      | 非必选  | String |                当前页码,默认第一页                |
  |     limit      | 非必选  | String |               每页记录数，默认每页十条               |
  |   searchDate   | 非必选  | String |          查询日期，0：今天，-1：昨天，-29：一月          |
  |     export     | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |

- 返回结果：

  |   参数   |   类型   |    描述     |
  | :----: | :----: | :-------: |
  | status |  int   |    状态码    |
  |  msg   | String | 状态说明，例如成功 |
  | result | array  | 来电通话记录列表  |

- 返回示例

  ```
  {
      "status": 0,
      "msg": "成功",
      "result": {
          [
              {
                  "id":"1",
                  "uniqueId":"1",
                  "hotline":"89193631",
                  "numberTrunk":"1",
                  "customerNumber":"01089170766",
                  "customerNumberType":"1",
                  "customerAreaCode":"101",
                  "customerProvince":"北京",
                  "customerCity":"北京",
                  "customerVip":"1",
                  "calleeNumber":"123",
                  "agentAreaCode":"101",
                  "agentName":"小小",
                  "agentCrmId":"145",
                  "calleeCno":"123",
                  "calleeExten":"321",
                  "startTime":"2017-10-20 09:20:12",
                  "answerTime"":"2017-10-20 09:20:12",
                  "joinQueueTime":2017-10-20 09:20:12"",
                  "bridgeTime":"2017-10-20 09:20:12",
                  "endTime":"2017-10-20 09:20:12",
                  "bridgeDuration":"1",
                  "bridgeDurationInt":"1"
                  "totalDuration":"1",
                  "ivrId":"1",
                  "ivrName":"2",
                  "ivrFlow":"product",
                  "qno":"1", 
                  "queueName": "12",
                  "recordFile":[
                  	{
                          "file":"file-in",
                          "title":"客户侧",
                          "recordFormat":"1",
                  	}
                  ],
                  "voiceCount":"",
                  "callType":"",
                  "callTypeInt":"",
                  "status":"",
                  "statusTitle":"",
                  "endReason":"",
                  "gwIp":"",
                  "consult":"",
                  "transfer":"",
                  "threeway":"",
                  "interact":"",
                  "voicemailId":"",
                  "ivrRouterId":"",
                  "obRemember":"",
                  "investigation":"",
                  "userField":"",
                  "callId":"",
                  "createTime":"",
                  "uniqueIdTime":"",
                  "comment":"",
                  "voicemailName":"",
                  "vadIn":"",
                  "vadOut":"",
                  "vadCount":""
               }   
          ],
          "province":"湖南",
          "city":"长沙",
          "searchDate":"0",
          "startDate":"2017-10-12 00:00:00",
          "endDateStr":"2017-11-12 23:59:59",
          "answerType":"0",
          "answerTypeFlag":"0",
          "showFileds":""
      },
      "currentPageNo":1,
      "pageSize" : 1,
      "totalCount" : 1
  }
  ```

- 返回对象字段说明：

  |       参数       |   类型   |                    描述                    |
  | :------------: | :----: | :--------------------------------------: |
  | customerNumber | String |                   客户号码                   |
  |    hotline     | String |                   热线号码                   |
  |    callType    | Stirng |               呼入类型，1：普通呼入                |
  |    ivrName     | String |                   IVR                    |
  |      qno       | String |                   队列号                    |
  |   queueName    | String |                   队列名称                   |
  |   calleeCno    | String |                   座席工号                   |
  |   agentName    | String |                   座席姓名                   |
  |  calleeNumber  | String |                   座席电话                   |
  |   startTime    | String |       进入系统时间，格式yyyy-MM-dd hh:mm:ss       |
  |   answerTime   | String |        接听时间，格式yyyy-MM-dd hh:mm:ss        |
  | bridgeDuration | String |             通话时长，格式hh:mm:ss              |
  |     status     | String | 接听状态,状态有座席接听，座席未接听，系统接听，系统未接听-IVR配置错误，系统未接听-停机，系统未接听-欠费，系统未接听-黑名单，系统未接听-未注册，系统未接听-彩铃，系统未接听-超限，系统未接听-应答前挂机，其他错误 |
  |   endReason    | String |                   客户挂机                   |
  | totalDuration  | String |              总时长，格式hh:mm:ss              |
  |     index      | String |                   通话占比                   |
  |    vadCount    | String |                   通话质量                   |
  |      file      | String |        文件名，recordFile字段对象的file字段         |
  |  recordFormat  |  Int   |    录音格式，recordFile字段对象的recordFormat字段    |
  |     title      | String |       录音标题，recordFile字段对象的title字段        |
  |    comment     | String |                    备注                    |
  |   userField    | String |                  自定义字段                   |
  |     callId     | String |                  CALLID                  |

##### 1.1 answerTypes接口说明

- URL:/api/record/answerTypes
- Method:GET
- Content type: application/json
- 输入参数：

|  参数   |       要求        |   类型   | 描述                                       |
| :---: | :-------------: | :----: | ---------------------------------------- |
| 人工接听  | answerType为1时必选 | String | 咨询，转移，三方，ivr交互，直接电话，默认全部                 |
| 人工未接听 | answerType为2时必选 | String | 全部                                       |
| 系统应答  | answerType为3时必选 | String | 未进ivr，ivr中放弃，已进入留言，默认全部                  |
| 系统未应答 | answerType为4时必选 |  Int   | 欠费，彩铃，未注册，停机，黑名单，ivr配置错误，超限，应答前挂机，其他，默认全部 |

##### 1.2 省接口说明

- URL:/api/record/province
- Method:GET
- Content type: application/json
- 输入参数：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |    省列表    |

省接口返回字段说明：

|      参数       |   类型   |  描述  |
| :-----------: | :----: | :--: |
| provinceValue |  Int   | 省代号  |
| provinceDesc  | String | 省名称  |

##### 1.3 市接口说明

- URL:/api/record/city
- Method:GET
- Content type: application/json
- 输入参数：

|  参数   |   类型   |  描述  |
| :---: | :----: | :--: |
| value | String | 省代号  |

市接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |    市列表    |

##### 1.4 showFileds接口说明

- URL:/api/record/showFileds
- Method:GET
- Content type: application/json
- 输入参数：

|   参数   |   类型   |      描述      |
| :----: | :----: | :----------: |
| status |  int   |     状态码      |
|  msg   | String |  状态说明，例如成功   |
| result | array  | 来电记录显示字段实体数组 |

字段说明：

|     参数      |   类型   |   描述   |
| :---------: | :----: | :----: |
| filedsIndex |  Int   | 字段下标索引 |
| filedsDesc  | String |  字段描述  |

##### 1.5 来电通话详情接口

- URL:/api/record/ib/ibDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 来电通话记录唯一id |
|  startDate   | String |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |     描述     |
| :----: | :----: | :--------: |
| status |  int   |    状态码     |
|  msg   | String | 状态说明，例如成功  |
| result | array  | 来电通话记录详情列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"id":"1",
        	"uniqueId":"1",
 	  	   "agentName":""
            "answerTime":""
            "callId":""
            "callType":""
            "calleeNumber":""
            "class":""
            "clid":""
            "cno":""
            "createTime":""
            "endReason":""
            "endTime":""
            "exten":""
            "gwIp":""
            "ibRemember":""
            "ivrFlow":""
            "ivrId":""
            "ivrName":""
            "mainCallType":""
            "mainUniqueId":""
            "mainUniqueIdTime":""
            "recordFile":""
            "sipCause":""
            "startTime":""
            "status":""
            "totalDuration":""
            "tsiFile":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

详情对象字段说明：

|      参数      |   类型   |              描述              |
| :----------: | :----: | :--------------------------: |
| calleeNumber | String |             座席电话             |
|  agentName   | Stirng |             座席名称             |
|     cno      | String |             座席工号             |
|  startTime   | String | 开始呼叫时间，格式yyyy-MM-dd hh:mm:ss |
|  answerTime  | String |  接听时间，格式yyyy-MM-dd hh:mm:ss  |
|   endTime    | String |  结束时间，格式yyyy-MM-dd hh:mm:ss  |
|   callType   | String |   呼叫类型,0：全部，1：预览外呼，2：主叫外呼    |
|    status    | String |             呼叫结果             |
|   sipCause   | String |             呼叫情况             |
|  ibRemember  | String |             主叫记忆             |
|    callId    | String |            CALLID            |

##### 1.6 IVR详情接口

- URL:/api/record/ib/ivrDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 来电通话记录唯一id |
|  startDate   |   必选   |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  ivr对象列表  |