## API接口设计

### 目录
[交互数据结构](#交互数据结构)

[系统设置](#系统设置)

[&emsp;&emsp;登录日志](#登录日志)

[&emsp;&emsp;查询日志](#查询日志)

[&emsp;&emsp;账单信息](#账单信息)

[&emsp;&emsp;&emsp;&emsp;1.企业账单](#1-企业账单)

[&emsp;&emsp;&emsp;&emsp;1.1tenancyDetail接口](#11-tenancydetail接口)

[&emsp;&emsp;&emsp;&emsp;2.机构账单](#2-机构账单)

[&emsp;&emsp;&emsp;&emsp;2.1departmentDetail接口](#21-departmentdetail接口)

[&emsp;&emsp;&emsp;&emsp;3.部门账单](#3-部门账单)

[<br/>记录管理](#记录管理)

[&emsp;&emsp;来电通话记录](#来电通话记录)

[&emsp;&emsp;&emsp;&emsp;1.answerTypes接口说明](#1-answertypes接口说明)

[&emsp;&emsp;&emsp;&emsp;2.省接口说明](#2-省接口说明)

[&emsp;&emsp;&emsp;&emsp;3.市接口说明](#3-市接口说明)

[&emsp;&emsp;&emsp;&emsp;4.showFileds接口说明](#4-showfileds接口说明)

[&emsp;&emsp;&emsp;&emsp;5.来电通话详情](#5-来电通话详情)

[&emsp;&emsp;&emsp;&emsp;6.来电通话IVR详情](#6-来电通话ivr详情)

[&emsp;&emsp;&emsp;&emsp;7.满意度调查接口](#7-满意度调查接口)

[&emsp;&emsp;&emsp;&emsp;8.ASR详情](#8-asr详情)

[&emsp;&emsp;外呼通话记录](#外呼通话记录)

[&emsp;&emsp;&emsp;&emsp;1.外呼通话详情](#1-外呼通话详情)

[&emsp;&emsp;&emsp;&emsp;2.外呼通话IVR详情](#2-外呼通话ivr详情)

[&emsp;&emsp;WebCall通话记录](#webcall通话记录)

[&emsp;&emsp;&emsp;&emsp;1.WebCall通话详情](#1-webcall通话详情)

[&emsp;&emsp;&emsp;&emsp;2.WebCall IVR详情](#2-webcall-ivr详情)

[&emsp;&emsp;预测外呼通话记录](#预测外呼通话记录)

[&emsp;&emsp;&emsp;&emsp;1.预测外呼通话详情](#1-预测外呼通话详情)

[&emsp;&emsp;&emsp;&emsp;2.预测外呼IVR详情](#2-预测外呼ivr详情)

[&emsp;&emsp;满意度记录](#满意度记录)

[&emsp;&emsp;&emsp;&emsp;1.满意度记录详情](#1-满意度记录详情)

[&emsp;&emsp;推送记录](#推送记录)

[&emsp;&emsp;导出进度](#导出进度)

[&emsp;&emsp;&emsp;&emsp;1.导出进度子任务](#1-导出进度子任务)

[&emsp;&emsp;留言记录](#留言记录)

[<br/>统计报表](#统计报表)

[&emsp;&emsp;坐席报表](#坐席报表)

[&emsp;&emsp;&emsp;&emsp;1.工作量统计](#1-工作量统计)

[&emsp;&emsp;&emsp;&emsp;1.1座席列表接口](#11-座席列表接口)

[&emsp;&emsp;&emsp;&emsp;1.2座席字段接口](#12-座席字段接口)

[&emsp;&emsp;&emsp;&emsp;2.工作日志](#2-工作日志)

[&emsp;&emsp;&emsp;&emsp;3.工作时长](#3-工作时长)

[&emsp;&emsp;队列报表](#队列报表)

[&emsp;&emsp;&emsp;&emsp;1.队列列表接口](#1-队列列表接口)

[&emsp;&emsp;&emsp;&emsp;2.队列字段接口](#2-队列字段接口)

[&emsp;&emsp;中继报表](#中继报表)

[&emsp;&emsp;&emsp;&emsp;1.来电分析](#1-来电分析)

[&emsp;&emsp;&emsp;&emsp;1.1来电热线列表接口](#11-来电热线列表接口)

[&emsp;&emsp;&emsp;&emsp;1.2来电队列字段接口](#12-来电队列字段接口)

[&emsp;&emsp;&emsp;&emsp;2.地区分析](#2-地区分析)

[&emsp;&emsp;&emsp;&emsp;2.1地区队列字段接口](#21-地区队列字段接口)

[&emsp;&emsp;满意度报表](#满意度报表)

[&emsp;&emsp;&emsp;&emsp;1.按坐席统计](#1-按坐席统计)

[&emsp;&emsp;&emsp;&emsp;1.1满意度字段接口](#11-满意度字段接口)

[&emsp;&emsp;&emsp;&emsp;2.按热线号码统计](#2-按热线号码统计)

[&emsp;&emsp;外呼报表](#外呼报表)

[&emsp;&emsp;&emsp;&emsp;1.预览外呼报表](#1-预览外呼报表)

[&emsp;&emsp;&emsp;&emsp;1.1预览外呼字段接口](#11-预览外呼字段接口)

[&emsp;&emsp;&emsp;&emsp;2.WebCall报表](#2-webcall报表)

[&emsp;&emsp;&emsp;&emsp;2.1按坐席统计](#21-webcall字段接口)

[&emsp;&emsp;&emsp;&emsp;3.预测外呼坐席报表](#3-预测外呼座席报表)

[&emsp;&emsp;&emsp;&emsp;3.1预览外呼座席字段接口](#31-预览外呼座席字段接口)

[&emsp;&emsp;&emsp;&emsp;3.2任务列表接口](#32-任务列表接口)

[&emsp;&emsp;&emsp;&emsp;4.预测外呼任务报表](#4-预测外呼任务报表)

[<br/>质检管理](#质检管理)

[&emsp;&emsp;案例组管理](#案例组管理)

[&emsp;&emsp;&emsp;&emsp;1.查看案例组列表](#1-查看案例组列表)

[&emsp;&emsp;&emsp;&emsp;2.新增案例组](#2-新增案例组)

[&emsp;&emsp;&emsp;&emsp;3.修改案例组](#3-修改案例组)

[&emsp;&emsp;&emsp;&emsp;4.删除案例组](#4-删除案例组)

[&emsp;&emsp;录音管理](#录音管理)

[&emsp;&emsp;&emsp;&emsp;1.录音接口试听或下载](#1-录音接口试听或下载)

[&emsp;&emsp;&emsp;&emsp;2.彩铃录音接口试听或下载](#2-彩铃录音接口试听或下载)

[&emsp;&emsp;&emsp;&emsp;3.录音评分](#3-录音评分)

[&emsp;&emsp;&emsp;&emsp;4.添加录音到案例库](#4-添加录音到案例库)

[&emsp;&emsp;案例库管理](#案例库管理)

[&emsp;&emsp;&emsp;&emsp;1.修改案例库](#1-修改案例库)

[&emsp;&emsp;&emsp;&emsp;2.删除案例库](#2-删除案例库)

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

### 系统设置

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

### 记录管理

#### 来电通话记录

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
                          "recordFormat":"1"
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
                  "vadCount":"",
                  "txMos":"",
                  "rxMos":"",
                  "numberTrunkAreaCode":""
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

##### 1. answerTypes接口说明

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

##### 2. 省接口说明

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

##### 3. 市接口说明

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

##### 4. showFileds接口说明

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

##### 5. 来电通话详情

- URL:/api/record/ib/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 来电通话记录唯一id |
|  startDate   | String |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 来电通话详情列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"id":"1",
        	"uniqueId":"1",
 	  	    "agentName":"",
            "answerTime":"",
            "callId":"",
            "callType":"",
            "calleeNumber":"",
            "clid":"",
            "cno":"",
            "createTime":"",
            "endReason":"",
            "endTime":"",
            "exten":"",
            "gwIp":"",
            "ibRemember":"",
            "ivrFlow":"",
            "ivrId":"",
            "ivrName":"",
            "mainCallType":"",
            "mainUniqueId":"",
            "mainUniqueIdTime":"",
            "recordFile":[
                {
                "file":"file-in",
                "title":"客户侧",
                "recordFormat":"1"
                }
            ],
            "sipCause":"",
            "startTime":"",
            "status":"",
            "totalDuration":"",
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

##### 6. 来电通话IVR详情

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

接口返回实例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "ivrName":"123",
            "path":"",
            "pathName":"",
            "action":"播放",
            "startTime":"2017-10-20 08:20:12", 
            "endTime": "2017-10-20 09:20:12",
            "pressKey":"4",
            "pressTime":"2017-10-20 08:00:12"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

ivr对象字段说明：

|    参数     |   类型   |                    描述                    |
| :-------: | :----: | :--------------------------------------: |
|  ivrName  | String |                  语音导航名称                  |
|   path    | String |                    节点                    |
| pathName  | String |                   节点名称                   |
|  action   |  Int   | 节点类型；1：播放，2：选择，3：留言，4：队列，5：时间，6：地区，7：传真，8：设置变量，9：收号节点，10：等待节点，11：判断节点，12：curl，13：直呼节点，14：数据库，15：会议，16：分支节点Switch |
| startTime | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|  endTime  | String |       结束时间，格式为yyyy-MM-dd hh:mm:ss        |
| pressKey  | String |                    按键                    |
| pressTime | String |       按键时间，格式为yyyy-MM-dd hh:mm:ss        |

##### 7. 满意度调查接口

- URL:/api/record/investigationDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 来电通话记录唯一id |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 调查记录对象列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "id":"1",
            "agentCrmId":"26",
            "agentName":"",
            "callType":"预览外呼",
            "cno":"35",
            "comment":"",
            "consult":"咨询:电话-",
            "createTime":"2017-09-12 10:09:09",
            "customerNumber":"8871632",
            "duration":"60",
            "endTime":"2017-09-12 10:10:10",
            "enterpriseId":"123",
            "hotline":"88382828",
            "keys":"",
            "mainUniqueId":"12",
            "queue":"13",
            "queueName":"13",
            "startTime":"2017-09-12 10:09:10",
            "transfer":"转移:电话-"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|       参数       |   类型   |                    描述                    |
| :------------: | :----: | :--------------------------------------: |
|   startTime    | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|    endTime     | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|      cno       | String |                   座席工号                   |
|   agentName    | String |                   座席名称                   |
|      keys      | String |                   评分值                    |
|    callType    | String | 呼叫类型，1：呼入，2：webcall，4：预览外呼，5：预测外呼，6：主叫外呼，9：内部外呼 |
|  enterpriseId  | String |                   企业id                   |
|    hotline     | String |                   热线号码                   |
| customerNumber | String |                   客户号码                   |

##### 8. ASR详情

- URL:/api/record/asrDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 来电通话记录唯一id |
|   callType   | String |    通话类型    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | ASR详情对象列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "cdrCalleeCno":"100001",
            "cdrCustomerNumber":"13572379362",
            "text":"product",
            "customerRobSpeechCount":"10.3.8.211", 
            "customerBlankThresholdCount": "2017-10-20 09:20:12"
            "customerContinuousSpeechCount":"1",
            "seatRobSpeechCount":"1",
            "seatBlankThresholdCount":"1",
            "seatContinuousSpeechCount":"1"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

ASR详情对象字段说明：

|              参数               |   类型   |                    描述                    |
| :---------------------------: | :----: | :--------------------------------------: |
|         cdrCalleeCno          | String |                   座席工号                   |
|       cdrCustomerNumber       | String |                   客户电话                   |
|             text              | String |                   消息文本                   |
|    customerRobSpeechCount     |  Int   | 客户抢话次数，asrAnalysis对象的customerRobSpeechCount字段 |
|  customerBlankThresholdCount  |  Int   | 客户大段留白次数，asrAnalysis对象的customerBlankThresholdCount字段 |
| customerContinuousSpeechCount |  Int   | 客户连续讲话次数，asrAnalysis对象的customerContinuousSpeechCount字段 |
|      seatRobSpeechCount       |  Int   | 座席抢话次数，asrAnalysis对象的seatRobSpeechCount字段 |
|    seatBlankThresholdCount    |  Int   | 座席大段留白次数，asrAnalysis对象的seatBlankThresholdCount字段 |
|   seatContinuousSpeechCount   |  Int   | 座席连续讲话次数，asrAnalysis对象的seatContinuousSpeechCount字段 |

#### 外呼通话记录

- URL:/api/record/ob
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|    callType    | 非必选  |  Int   |       呼叫类型，默认全部，0：全部，1：预览外呼，2：主叫外呼       |
|     status     | 非必选  |  Int   | 接听状态，默认全部 ，0：全部，1：双方接听，2：座席接听，3：座席未接听，4：客户未接听 |
|     title      | 非必选  | String | 查询条件，默认客户电话，customer_number：客户电话，cno：座席工号，agent_name：座席姓名，agent_number：座席电话，clid：客户外显号码 |
|  vadRateBegin  | 非必选  | Float  |                 通话占比起始值                  |
|   vadRateEnd   | 非必选  | Float  |                 通话占比终止值                  |
| vadCountBegin  | 非必选  | Float  |                 通话质量起始值                  |
|  vadCountEnd   | 非必选  | Float  |                 通话质量终止值                  |
|    province    | 非必选  | String |                 调用获取省接口                  |
|      city      | 非必选  | string |                 调用获取地区接口                 |
|   showFileds   |  必选  | string |           调用showFileds接口获取显示字段           |
|   startDate    |  必选  | string |                   开始时间                   |
|    endDate     |  必选  | string |                   结束时间                   |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | String |               每页记录数，默认每页十条               |
|   searchDate   | 非必选  | String |          查询日期，0：今天，-1：昨天，-29：一月          |
|     export     | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 外呼通话记录列表  |

接口返回示例:

```
{
    "status": 0,
    "msg": "成功",
    "result": {
    	[
            {
               "id":"1",
                "agentAreaCode":"101",
                "agentCrmId":"1",
                "agentName":"",
                "agentNumber":"",
                "answerTime":"",
                "bridgeDuration":"",
                "bridgeDurationInt":"",
                "bridgeTime":"",
                "callType":"",
                "callTypeInt":"",
                "callid":"",
                "clid":"",
                "cno":"",
                "comment":"",
                "consult":"",
                "createTime":"",
                "customerAreaCode":"",
                "customerCity":"",
                "customerNumber":"",
                "customerNumberType":"",
                "customerProvince":"",
                "customerVip":"",
                "endReason":"",
                "endTime":"",
                "exten":"",
                "gwIp":"",
                "id":"",
                "investigation":"",
                "joinQueueTime":"",
                "leftClid":"",
                "recordFile":[
                    {
                    "file":"file-in",
                    "title":"客户侧",
                    "recordFormat":"1"
                    }
            	],
                "rxMos":"",
                "sipCause":"",
                "startTime":"",
                "status":"",
                "statusTitle":"",
                "threeway":"",
                "totalDuration":"",
                "transfer":"",
                "tsiFile":"",
                "txMos":"",
                "uniqueId":"",
                "uniqueIdTime":"",
                "userField":"",
                "vadCount":"",
                "vadIn":"",
                "vadOut":"",
                "voiceCount":""
             }   
    	],
    	"callType":"0",
    	"status":"0",
    	"title":"客户电话",
    	"value":"",
    	"totalMap":{
         "total_count":"100"
    	},
    	"startDate":"2017-10-12 00:00:00",
    	"endDate":"2017-10-29 12:23:23",
    	"searchDate":"-1",
    	"showFileds":""
    }
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|        参数        |   类型   |                    描述                    |
| :--------------: | :----: | :--------------------------------------: |
|  customerNumber  | String |                   客户电话                   |
| customerProvince | String |                  客户所在省份                  |
|   customerCity   | String |                  客户所在城市                  |
|       cno        | String |                   座席工号                   |
|    queueName     | Stirng |                   座席姓名                   |
|   agentNumber    | String |                   座席电话                   |
|       clid       | String |                  座席外显号码                  |
|     leftClid     | String |                  客户外显号码                  |
|    startTime     | String |       进入系统时间，格式yyyy-MM-dd hh:mm:ss       |
|    answerTime    | String |        接听时间，格式yyyy-MM-dd hh:mm:ss        |
|      status      | String | 接听状态,状态有座席接听，座席未接听，双方接听，主叫外呼接听，主叫外呼客户未接听，主叫外呼双方接听 |
|  bridgeDuration  | String |             通话时长，格式 hh:mm:ss             |
|  totalDuration   | String |             总时长，格式 hh:mm:ss              |
|      vadOut      | Float  |                  客户通话占比                  |
|      vadIn       | Float  |                  座席通话占比                  |
|     vadCount     | Float  |                   通话质量                   |
|     callType     | String |         呼叫类型,0：全部，1：预览外呼，2：主叫外呼          |
|       file       | String |        文件名，recordFile字段对象的file字段         |
|   recordFormat   |  Int   |    录音格式，recordFile字段对象的recordFormat字段    |
|      title       | String |       录音标题，recordFile字段对象的title字段        |
|    endReason     | String |                   客户挂机                   |
|     sipCause     | String |                   呼叫情况                   |
|     comment      | String |                    备注                    |
|    userField     | String |                  自定义字段                   |
|      callId      | String |                  CALLID                  |
|     uniqueId     | String |                外呼通话记录唯一id                |



##### 1. 外呼通话详情

- URL:/api/record/ob/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 外呼通话记录唯一id |
|  startDate   | String |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 外呼通话详情列表  |

接口返回示例:

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "id":"1",
            "agentAreaCode":"",
            "agentCrmId":"",
            "agentName":"",
            "answerTime":"",
            "callType":"",
            "calleeNumber":"",
            "callid":"",
            "clid":"",
            "cno":"",
            "createTime":"",
            "endReason":"",
            "endTime":"",
            "exten":"",
            "gwIp":"",
            "id":"",
            "interact":"",
            "ivrFlow":"",
            "ivrId":"",
            "ivrName":"",
            "mainCallType":"",
            "mainUniqueId":"",
            "mainUniqueIdTime":"",
            "recordFile":[
                    {
                    "file":"file-in",
                    "title":"客户侧",
                    "recordFormat":"1"
                    }
            ],
            "rxMos":"",
            "sipCause":"",
            "startTime":"",
            "status":"",
            "totalDuration":"",
            "tsiFile":"",
            "txMos":"",
            "uniqueId":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|      参数      |   类型   |                 描述                 |
| :----------: | :----: | :--------------------------------: |
| calleeNumber | String |                客户电话                |
|  agentName   | Stirng |                座席名称                |
|     cno      | String |                座席工号                |
|     clid     | String |                外显号码                |
|  startTime   | String |    呼叫客户时间，格式yyyy-MM-dd hh:mm:ss    |
|  answerTime  | String |    客户接听时间，格式yyyy-MM-dd hh:mm:ss    |
|   endTime    | String |     结束时间，格式yyyy-MM-dd hh:mm:ss     |
|   callType   | String |                呼叫类型                |
|    status    | String |                呼叫结果                |
|   sipCause   | String |                呼叫情况                |
|     file     | String |     文件名，recordFile字段对象的file字段      |
| recordFormat |  Int   | 录音格式，recordFile字段对象的recordFormat字段 |
|    title     | String |    录音标题，recordFile字段对象的title字段     |
|   tsiFile    | String |                彩铃试听                |
|    callId    | String |               CALLID               |

##### 2. 外呼通话IVR详情

- URL:/api/record/ob/ivrDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 外呼通话记录唯一id |
|  startDate   |   必选   |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   对象列表    |

接口返回实例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "ivrName":"123",
            "path":"",
            "pathName":"",
            "action":"播放",
            "startTime":"2017-10-20 08:20:12", 
            "endTime": "2017-10-20 09:20:12",
            "pressKey":"4",
            "pressTime":"2017-10-20 08:00:12"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|    参数     |   类型   |                    描述                    |
| :-------: | :----: | :--------------------------------------: |
|  ivrName  | String |                  语音导航名称                  |
|   path    | String |                    节点                    |
| pathName  | String |                   节点名称                   |
|  action   |  Int   | 节点类型；1：播放，2：选择，3：留言，4：队列，5：时间，6：地区，7：传真，8：设置变量，9：收号节点，10：等待节点，11：判断节点，12：curl，13：直呼节点，14：数据库，15：会议，16：分支节点Switch |
| startTime | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|  endTime  | String |       结束时间，格式为yyyy-MM-dd hh:mm:ss        |
| pressKey  | String |                    按键                    |
| pressTime | String |       按键时间，格式为yyyy-MM-dd hh:mm:ss        |

#### WebCall通话记录

- URL:/api/record/webcall
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|    callType    | 非必选  |  Int   |       呼叫类型，默认全部，0：全部，1：预览外呼，2：主叫外呼       |
|     status     | 非必选  |  Int   | 接听状态，默认全部 ，0：全部，1：双方接听，2：座席接听，3：座席未接听，4：客户未接听 |
|     title      | 非必选  | String | 查询条件，默认客户电话，customer_number：客户电话，cno：座席工号，agent_name：座席姓名，agent_number：座席电话，qno：队列号，clid：客户外显号码 |
|  vadRateBegin  | 非必选  | Float  |                 通话占比起始值                  |
|   vadRateEnd   | 非必选  | Float  |                 通话占比终止值                  |
| vadCountBegin  | 非必选  | Float  |                 通话质量起始值                  |
|  vadCountEnd   | 非必选  | Float  |                 通话质量终止值                  |
|   showFileds   |  必选  | string |           调用showFileds接口获取显示字段           |
|   startDate    |  必选  | string |                   开始时间                   |
|    endDate     |  必选  | string |                   结束时间                   |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | String |               每页记录数，默认每页十条               |
|   searchDate   | 非必选  | String |          查询日期，0：今天，-1：昨天，-29：一月          |
|     export     | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |

接口返回：

|   参数   |   类型   |      描述       |
| :----: | :----: | :-----------: |
| status |  int   |      状态码      |
|  msg   | String |   状态说明，例如成功   |
| result | array  | WebCall通话记录列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": {
    	[
            {
            "id":"1",
            "agentAreaCode":"",
            "agentCrmId":"",
            "agentName":"",
            "amd":"",
            "answerTime":"",
            "bridgeDuration":"",
            "bridgeDurationInt":"",
            "bridgeTime":"",
            "callId":"",
            "callType":"",
            "callTypeInt":"",
            "calleeCno":"",
            "calleeExten":"",
            "calleeNumber":"",
            "clid":"",
            "comment":"",
            "consult":"",
            "createTime":"",
            "customerAreaCode":"",
            "customerCity":"",
            "customerNumber":"",
            "customerNumberType":"",
            "customerProvince":"",
            "customerVip":"",
            "endReason":"",
            "endTime":"",
            "gwIp":"",
            "interact":"",
            "investigation":"",
            "ivrFlow":"",
            "ivrId":"",
            "ivrName":"",
            "ivrRouterId":"",
            "joinQueueTime":"",
            "obRemember":"",
            "qno":"",
            "recordFile":[
                    {
                    "file":"file-in",
                    "title":"客户侧",
                    "recordFormat":"1"
                    }
            ],
            "rxMos":"",
            "sipCause":"",
            "startTime":"",
            "status":"",
            "statusTitle":"",
            "taskName":"",
            "threeway":"",
            "totalDuration":"",
            "transfer":"",
            "txMos":"",
            "uniqueId":"",
            "uniqueIdTime":"",
            "userField":"",
            "vadCount":"",
            "vadIn":"",
            "vadOut":"",
            "voiceCount":"",
            "voicemailId":""
            }   
        ],
        "callType":"0",
    	"status":"0",
    	"title":"客户电话",
    	"value":"",
    	"startDate":"2017-10-12 00:00:00",
    	"endDate":"2017-10-29 12:23:23",
    	"searchDate":"-1",
    	"showFileds":""
    }
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：



|        参数        |   类型   |                    描述                    |
| :--------------: | :----: | :--------------------------------------: |
|  customerNumber  | String |                   客户电话                   |
| customerProvince | String |                 队列号/IVR名                 |
|       cno        | String |                   座席工号                   |
|    queueName     | Stirng |                   座席姓名                   |
|   calleeNumber   | String |                   座席电话                   |
|       clid       | String |                   外显号码                   |
|    startTime     | String |       进入系统时间，格式yyyy-MM-dd hh:mm:ss       |
|    answerTime    | String |        接听时间，格式yyyy-MM-dd hh:mm:ss        |
|      status      |  Int   | 接听状态,20:TTS合成失败，21：客户未接听，22：客户接听，23：已呼叫，24：双方接听，40：客户未接听，41：客户接听，42：已呼叫，43：双方接听 |
|  bridgeDuration  | String |             通话时长，格式 hh:mm:ss             |
|  totalDuration   | String |             总时长，格式 hh:mm:ss              |
|      vadOut      | Float  |                  客户通话占比                  |
|      vadIn       | Float  |                  座席通话占比                  |
|     vadCount     | Float  |                   通话质量                   |
|     callType     |  Int   |          呼叫类型，2：webcall，5：预测外呼           |
|       file       | String |        文件名，recordFile字段对象的file字段         |
|   recordFormat   |  Int   |    录音格式，recordFile字段对象的recordFormat字段    |
|      title       | String |       录音标题，recordFile字段对象的title字段        |
|    endReason     | String |                   客户挂机                   |
|     sipCause     | String |                   呼叫情况                   |
|     comment      | String |                    备注                    |
|    userField     | String |                  自定义字段                   |
|      callId      | String |                  CALLID                  |
|     uniqueId     | String |             WebCall通话记录唯一id              |

##### 1. WebCall通话详情

- URL:/api/record/webcall/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |       描述        |
| :----------: | :----: | :-------------: |
|   uniqueId   | String | WebCall通话记录唯一id |
|  startDate   | String |      开始时间       |
| departmentId | String |     所属部门id      |

接口返回说明：

|   参数   |   类型   |      描述       |
| :----: | :----: | :-----------: |
| status |  int   |      状态码      |
|  msg   | String |   状态说明，例如成功   |
| result | array  | WebCall通话详情列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "id":"1",
            "agentName":"",
            "answerTime":"",
            "callType":"",
            "calleeNumber":"",
            "callid":"",
            "clid":"",
            "cno":"",
            "createTime":"",
            "endReason":"",
            "endTime":"",
            "exten":"",
            "gwIp":"",
            "ibRemember":"",
            "ivrFlow":"",
            "ivrId":"",
            "ivrName":"",
            "mainCallType":"",
            "mainUniqueId":"",
            "mainUniqueIdTime":"",
            "recordFile":[
                    {
                    "file":"file-in",
                    "title":"客户侧",
                    "recordFormat":"1"
                    }
            ],
            "rxMos":"",
            "sipCause":"",
            "startTime":"",
            "status":"",
            "totalDuration":"",
            "tsiFile":"",
            "txMos":"",
            "uniqueId":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

WebCall通话记录详情对象字段说明：

|      参数      |   类型   |                    描述                    |
| :----------: | :----: | :--------------------------------------: |
| calleeNumber | String |                   电话号码                   |
|  agentName   | Stirng |                   座席名称                   |
|     cno      | String |                   座席工号                   |
|     clid     | String |                   外显号码                   |
|  startTime   | String |       座席接听时间，格式yyyy-MM-dd hh:mm:ss       |
|  answerTime  | String |       客户接听时间，格式yyyy-MM-dd hh:mm:ss       |
|   endTime    | String |        结束时间，格式yyyy-MM-dd hh:mm:ss        |
|   callType   |  Int   | 呼叫类型，201：呼转座席，202：转移，203：咨询，104：三方，105：监听，106：耳语，107：强插(拦截)，208：呼转客户，209：呼转电话，210：呼转分机 |
|    status    |  Int   |             呼叫结果，1：呼叫失败，2：接听             |
|   sipCause   | String |                   呼叫情况                   |
|    callId    | String |                  CALLID                  |

##### 2. WebCall IVR详情

- URL:/api/record/webcall/ivrDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 外呼通话记录唯一id |
|  startDate   |   必选   |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   对象列表    |

接口返回实例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "ivrName":"123",
            "path":"",
            "pathName":"",
            "action":"播放",
            "startTime":"2017-10-20 08:20:12", 
            "endTime": "2017-10-20 09:20:12",
            "pressKey":"4",
            "pressTime":"2017-10-20 08:00:12"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|    参数     |   类型   |                    描述                    |
| :-------: | :----: | :--------------------------------------: |
|  ivrName  | String |                  语音导航名称                  |
|   path    | String |                    节点                    |
| pathName  | String |                   节点名称                   |
|  action   |  Int   | 节点类型；1：播放，2：选择，3：留言，4：队列，5：时间，6：地区，7：传真，8：设置变量，9：收号节点，10：等待节点，11：判断节点，12：curl，13：直呼节点，14：数据库，15：会议，16：分支节点Switch |
| startTime | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|  endTime  | String |       结束时间，格式为yyyy-MM-dd hh:mm:ss        |
| pressKey  | String |                    按键                    |
| pressTime | String |       按键时间，格式为yyyy-MM-dd hh:mm:ss        |

#### 预测外呼通话记录

- URL:/api/record/predictive
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|    callTask    | 非必选  |  Int   |                   任务选择                   |
|     status     | 非必选  |  Int   | 接听状态，默认全部 ，0：全部，1：双方接听，2：座席接听，3：座席未接听，4：客户未接听 |
|     title      | 非必选  | String | 查询条件，默认客户电话，customer_number：客户电话，cno：座席工号，agent_name：座席姓名，agent_number：座席电话，clid：客户外显号码 |
|  vadRateBegin  | 非必选  | Float  |                 通话占比起始值                  |
|   vadRateEnd   | 非必选  | Float  |                 通话占比终止值                  |
| vadCountBegin  | 非必选  | Float  |                 通话质量起始值                  |
|  vadCountEnd   | 非必选  | Float  |                 通话质量终止值                  |
|    province    | 非必选  | String |                 调用获取省接口                  |
|      city      | 非必选  | string |                 调用获取地区接口                 |
|   showFileds   |  必选  | string |           调用showFileds接口获取显示字段           |
|   startDate    |  必选  | string |                   开始时间                   |
|    endDate     |  必选  | string |                   结束时间                   |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | String |               每页记录数，默认每页十条               |
|   searchDate   | 非必选  | String |          查询日期，0：今天，-1：昨天，-29：一月          |
|     export     | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |

接口返回：

|   参数   |   类型   |     描述     |
| :----: | :----: | :--------: |
| status |  int   |    状态码     |
|  msg   | String | 状态说明，例如成功  |
| result | array  | 预测外呼通话记录列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": {
    	[
        	{
                "id":"1",
                "agentAreaCode":"",
                "agentCrmId":"",
                "agentName":"",
                "amd":"",
                "answerTime":"",
                "bridgeDuration":"",
                "bridgeDurationInt":"",
                "bridgeTime":"",
                "callId":"",
                "callType":"",
                "callTypeInt":"",
                "calleeCno":"",
                "calleeExten":"",
                "calleeNumber":"",
                "clid":"",
                "comment":"",
                "consult":"",
                "createTime":"",
                "customerAreaCode":"",
                "customerCity":"",
                "customerNumber":"",
                "customerNumberType":"",
                "customerProvince":"",
                "customerVip":"",
                "endReason":"",
                "endTime":"",
                "gwIp":"",
                "id":"",
                "interact":"",
                "investigation":"",
                "ivrFlow":"",
                "ivrId":"",
                "ivrName":"",
                "ivrRouterId":"",
                "joinQueueTime":"",
                "obRemember":"",
                "qno":"",
                "recordFile":[
                    {
                        "file":"file-in",
                        "title":"客户侧",
                        "recordFormat":"1"
                    }
            	],
                "rxMos":"",
                "sipCause":"",
                "startTime":"",
                "status":"",
                "statusTitle":"",
                "taskName":"",
                "threeway":"",
                "totalDuration":"",
                "transfer":"",
                "txMos":"",
                "uniqueId":"",
                "uniqueIdTime":"",
                "userField":"",
                "vadCount":"",
                "vadIn":"",
                "vadOut":"",
                "voiceCount":"",
                "voicemailId":""
           	  }   
   		],
   		"callType":"0",
    	"status":"0",
    	"title":"客户电话",
    	"value":"",
    	"startDate":"2017-10-12 00:00:00",
    	"endDate":"2017-10-29 12:23:23",
    	"searchDate":"-1",
    	"showFileds":""
   	}
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|        参数        |   类型   |                 描述                 |
| :--------------: | :----: | :--------------------------------: |
|  customerNumber  | String |                客户电话                |
| customerProvince | String |              队列号/IVR号              |
|       cno        | String |                座席工号                |
|    queueName     | Stirng |                座席姓名                |
|   agentNumber    | String |                座席电话                |
|       clid       | String |                外显号码                |
|    startTime     | String |    进入系统时间，格式yyyy-MM-dd hh:mm:ss    |
|    answerTime    | String |     接听时间，格式yyyy-MM-dd hh:mm:ss     |
|  bridgeDuration  | String |          通话时长，格式 hh:mm:ss          |
|  totalDuration   | String |          总时长，格式 hh:mm:ss           |
|      vadOut      | Float  |               客户通话占比               |
|      vadIn       | Float  |               座席通话占比               |
|     vadCount     | Float  |                通话质量                |
|     callType     | String |      呼叫类型,0：全部，1：预览外呼，2：主叫外呼       |
|      status      | String |                外呼任务                |
|       file       | String |     文件名，recordFile字段对象的file字段      |
|   recordFormat   |  Int   | 录音格式，recordFile字段对象的recordFormat字段 |
|      title       | String |    录音标题，recordFile字段对象的title字段     |
|    endReason     | String |                客户挂机                |
|     sipCause     | String |                呼叫情况                |
|     comment      | String |                 备注                 |
|    userField     | String |               自定义字段                |
|     uniqueId     | String |            预测外呼通话记录唯一id            |

##### 1. 预测外呼通话详情

- URL:/api/record/predictive/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |       描述        |
| :----------: | :----: | :-------------: |
|   uniqueId   | String | WebCall通话记录唯一id |
|  startDate   | String |      开始时间       |
| departmentId | String |     所属部门id      |

接口返回说明：

|   参数   |   类型   |     描述     |
| :----: | :----: | :--------: |
| status |  int   |    状态码     |
|  msg   | String | 状态说明，例如成功  |
| result | array  | 预测外呼通话详情列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "id":"1",
            "agentName":"",
            "answerTime":"",
            "callType":"",
            "calleeNumber":"",
            "callid":"",
            "clid":"",
            "cno":"",
            "createTime":"",
            "endReason":"",
            "endTime":"",
            "exten":"",
            "gwIp":"",
            "ibRemember":"",
            "ivrFlow":"",
            "ivrId":"",
            "ivrName":"",
            "mainCallType":"",
            "mainUniqueId":"",
            "mainUniqueIdTime":"",
            "recordFile":[
                    {
                    "file":"file-in",
                    "title":"客户侧",
                    "recordFormat":"1"
                    }
            ],
            "rxMos":"",
            "sipCause":"",
            "startTime":"",
            "status":"",
            "totalDuration":"",
            "tsiFile":"",
            "txMos":"",
            "uniqueId":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

预测外呼通话记录详情对象字段说明：

|      参数      |   类型   |                 描述                 |
| :----------: | :----: | :--------------------------------: |
| calleeNumber | String |                客户电话                |
|  agentName   | Stirng |                座席名称                |
|     cno      | String |                座席工号                |
|     clid     | String |                外显号码                |
|  startTime   | String |    座席接听时间，格式yyyy-MM-dd hh:mm:ss    |
|  answerTime  | String |    客户接听时间，格式yyyy-MM-dd hh:mm:ss    |
|   endTime    | String |     结束时间，格式yyyy-MM-dd hh:mm:ss     |
|   callType   | String |                呼叫类型                |
|    status    | String |                呼叫结果                |
|   sipCause   | String |                呼叫情况                |
|     file     | String |     文件名，recordFile字段对象的file字段      |
| recordFormat |  Int   | 录音格式，recordFile字段对象的recordFormat字段 |
|    title     | String |    录音标题，recordFile字段对象的title字段     |

##### 2. 预测外呼IVR详情

- URL:/api/record/predictive/ivrDetail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |     描述     |
| :----------: | :----: | :--------: |
|   uniqueId   | String | 外呼通话记录唯一id |
|  startDate   |   必选   |    开始时间    |
| departmentId | String |   所属部门id   |

接口返回实例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "ivrName":"123",
            "path":"",
            "pathName":"",
            "action":"播放",
            "startTime":"2017-10-20 08:20:12", 
            "endTime": "2017-10-20 09:20:12",
            "pressKey":"4",
            "pressTime":"2017-10-20 08:00:12"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|    参数     |   类型   |                    描述                    |
| :-------: | :----: | :--------------------------------------: |
|  ivrName  | String |                  语音导航名称                  |
|   path    | String |                    节点                    |
| pathName  | String |                   节点名称                   |
|  action   |  Int   | 节点类型；1：播放，2：选择，3：留言，4：队列，5：时间，6：地区，7：传真，8：设置变量，9：收号节点，10：等待节点，11：判断节点，12：curl，13：直呼节点，14：数据库，15：会议，16：分支节点Switch |
| startTime | String |       开始时间，格式为yyyy-MM-dd hh:mm:ss        |
|  endTime  | String |       结束时间，格式为yyyy-MM-dd hh:mm:ss        |
| pressKey  | String |                    按键                    |
| pressTime | String |       按键时间，格式为yyyy-MM-dd hh:mm:ss        |

#### 满意度记录

- URL:/api/record/investigation
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                    |
| :------------: | :--: | :----: | :-------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                  |
| organizationId |  必选  | String |                 所属机构id                  |
|  departmentId  |  必选  | String |                 所属部门id                  |
| customerNumber | 非必选  | String |                  客户电话                   |
|      cno       | 非必选  | String |                  座席工号                   |
|      keys      | 非必选  | String |                   评分值                   |
|     queue      | 非必选  | String |                   队列号                   |
|   queueName    | 非必选  | String |                   队列名                   |
|    callType    | 非必选  |  Int   | 满意度类型，默认全部，0：全部，1：呼入，  2：webcall，4：预览外呼 |
|   startDate    |  必选  | string |                  开始时间                   |
|    endDate     |  必选  | string |                  结束时间                   |
|     start      | 非必选  | String |               当前页码,默认第一页                |
|     limit      | 非必选  | String |              每页记录数，默认每页十条               |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url      |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  满意度记录列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": {
          [
              {
                  "id":"1",
                  "agentCrmId":"",
                  "agentName":"",
                  "callType":"",
                  "cno":"",
                  "comment":"",
                  "consult":"",
                  "createTime":"",
                  "customerNumber":"",
                  "duration":"",
                  "endTime":"",
                  "enterpriseId":"",
                  "hotline":"",
                  "keys":"",
                  "mainUniqueId":"",
                  "queue":"",
                  "queueName":"",
                  "startTime":"",
                  "transfer":""
              }   
          ],
          "startTime":"2017-12-12 00:00:00",
          "endTime":"2017-12-13 23:59:59",
          "queue":"25",
          "queueName":"队列名",
          "cno":"2543",
          "keys":"21",
          "customerNumber":"8336272",
          "callType":"0"
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|       参数       |   类型   |                    描述                    |
| :------------: | :----: | :--------------------------------------: |
|   startTime    | String |        开始时间，格式yyyy-MM-dd hh:mm:ss        |
|    endTime     | String |        结束时间，格式yyyy-MM-dd hh:mm:ss        |
| customerNumber | String |                   客户电话                   |
|      cno       | String |                   座席工号                   |
|   agentName    | Stirng |                   座席姓名                   |
|     queue      | String |                   队列号                    |
|   queueName    | String |                   队列名称                   |
|    callType    | String | 呼叫类型,1：呼入，2：webcall，4：预览外呼，5：预测外呼，6：主叫外呼，9：内部呼叫 |
|      keys      | String |                   评分值                    |
|    comment     | String |                    备注                    |

##### 1. 满意度记录详情

- URL:/api/record/investigation/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |    描述     |
| :----------: | :----: | :-------: |
|      Id      | String | 满意度记录对象id |
|  startTime   | String |   开始时间    |
| departmentId | String |  所属部门id   |

接口返回说明：

|   参数   |   类型   |     描述      |
| :----: | :----: | :---------: |
| status |  int   |     状态码     |
|  msg   | String |  状态说明，例如成功  |
| result | array  | 满意度调查通话详情列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
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
                    "recordFormat":"1"
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
            "vadCount":"",
            "txMos":"",
            "rxMos":"",
            "numberTrunkAreaCode":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|        参数        |   类型   |                 描述                 |
| :--------------: | :----: | :--------------------------------: |
|   calleeNumber   | String |                客户电话                |
| customerProvince | Stirng |               客户所在省份               |
|   customerCity   | String |               客户所在城市               |
|     hotline      | String |                热线号码                |
|    calleeCno     | String |                座席工号                |
|   calleeNumber   | String |                座席号码                |
|      status      | String |                接听状态                |
|    startTime     | String |    进入系统时间，格式yyyy-MM-dd hh:mm:ss    |
|  bridgeDuration  | String |          通话时长，格式 hh:mm:ss          |
|  totalDuration   | String |          总时长，，格式 hh:mm:ss          |
|     callType     | String |                呼叫类型                |
|     comment      | String |                 备注                 |
|       file       | String |     文件名，recordFile字段对象的file字段      |
|   recordFormat   |  Int   | 录音格式，recordFile字段对象的recordFormat字段 |
|      title       | String |    录音标题，recordFile字段对象的title字段     |

#### 推送记录

- URL:/api/record/logCurl
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|      Type      | 非必选  |  Int   | 推送类型，默认全部，0：全部，1：来电推送，2：来电响铃推送，3：外呼响铃推送，4：webcall客户响铃推送，5：来电接通推送，6：外呼接通推送，7：来电挂机推送，8：外呼挂机推送，9：座席状态推送，10：按键推送，11：号码状态识别推送，12：HTTP交互推送，13：网上回呼结果回调推送，14：预测式外呼任务状态推送 |
|     result     | 非必选  |  Int   |        推送结果，默认全部 ，-1：全部，0：失败，1：成功        |
|   startTime    | 非必选  | string |           开始推送时间，默认今天00:00:00            |
|    endTime     | 非必选  | string |           结束推送时间，默认今天23:59:59            |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | String |               每页记录数，默认每页十条               |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  推送记录列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "typeStr":"座席状态推送",
            "url":"http://www.baidu.com",
            "createTime":"",
            "currentMonth":"",
            "startTime":"2017-12-29 11:21:06.216",
            "endTime":"2017-12-29 11:21:06.216",
            "params":"{cno=2011, enterpriseId=6000001, event=status, loginStatus=0, deviceStatus=0}",
            "method":"POST",
            "timeout":"1",
            "retry":"0",
            "requestTime":"2017-12-29 11:21:06.216",
            "enterpriseId":"",
            "method":"POST",
            "position":"0",
            "level":"2",
            "result":"-1",
            "resultText":"推送失败，www.baidu.com:80 failed to respond",
            "statusCode":"-1",
            "type":"",
            "uniqueId":"",
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|     参数      |   类型   |              描述              |
| :---------: | :----: | :--------------------------: |
|   typeStr   | String |             推送类型             |
|     url     | String |            URL地址             |
|  startTime  | String | 请求开始时间，格式yyyy-MM-dd hh:mm:ss |
|   endTime   | Stirng | 请求结束时间，格式yyyy-MM-dd hh:mm:ss |
|   params    | String |             请求参数             |
|   method    | String |        请求方式，get或者post        |
|   timeout   |  Int   |           超时时间（秒）            |
|    retry    |  Int   |             重试次数             |
| requestTime | String | 进入排队时间，格式yyyy-MM-dd hh:mm:ss |
|  position   |  Int   |             排队位置             |
|    level    |  Int   |             优先级              |
| statusCode  |  Int   |           HTTP状态码            |
| resultText  | String |             结果描述             |
|   result    |  Int   |        执行结果，0：失败，1：成功        |

#### 导出进度

- URL:/api/record/export
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|    callType    | 非必选  |  Int   | 呼叫类型，默认全部，0：全部，1：呼入通话，2：外呼通话，3：webcall通话，4：工作量报表，5：预览外呼报表 |
|   startDate    |  必选  | string |                   开始时间                   |
|    endDate     |  必选  | string |                   结束时间                   |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | String |               每页记录数，默认每页十条               |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 导出进度记录列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": {
        [
            {
                "id":1,
                "enterpriseId":132,
                "type":"1",
                "uniqueId":"12",
                "condition":"{"接听状态":"全部","呼叫类型":"全部"} ",
                "status":"1",
                "task": "",
                "createTime":"2017-10-20 09:20:12"
            }   
        ],
        "startDate":"2017-12-12 00:00:00",
        "endDate":"2017-12-19 00:00:00",
        "callType":0,
    }，
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|     参数     |   类型   |                    描述                    |
| :--------: | :----: | :--------------------------------------: |
|    type    |  Int   | 呼叫类型，默认全部，0：全部，1：呼入通话，2：外呼通话，3：webcall通话，4：工作量报表，5：预览外呼报表 |
| condition  | String |                   导出条件                   |
| createTime | String |        导出时间，格式yyyy-MM-dd hh:mm:ss        |
|   status   |  Int   |        进度，0：排队中，1：生成中，2：完成，3：异常任务        |
|     id     |  Int   |                   主键id                   |

##### 1. 导出进度子任务

- URL:/api/record/export/detail
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |   描述   |
| :----------: | :----: | :----: |
|      id      |  Int   |  主键id  |
| departmentId | String | 所属部门id |

接口返回说明：

|   参数   |   类型   |     描述      |
| :----: | :----: | :---------: |
| status |  int   |     状态码     |
|  msg   | String |  状态说明，例如成功  |
| result | array  | 导出进度记录子任务列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":1,
            "enterpriseId":132,
            "type":"1",
            "uniqueId":"12",
            "condition":"{"接听状态":"全部","呼叫类型":"全部"} ",
            "status":"1",
            "task": "",
            "createTime":"2017-10-20 09:20:12"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象就是导出进度对象。



#### 留言记录

- URL:/api/record/message
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                  描述                   |
| :------------: | :--: | :----: | :-----------------------------------: |
|   tenancyId    |  必选  | String |                所属企业id                 |
| organizationId |  必选  | String |                所属机构id                 |
|  departmentId  |  必选  | String |                所属部门id                 |
|   numberType   | 非必选  | String | 号码类型，默认来电号码，customer：来电号码，client：热线号码 |
|      tel       | 非必选  | String |                 电话号码                  |
|   startDate    |  必选  | string |                 开始时间                  |
|    endDate     |  必选  | string |                 结束时间                  |
|     start      | 非必选  | String |              当前页码,默认第一页               |
|     limit      | 非必选  | String |             每页记录数，默认每页十条              |
|     export     | 非必选  |  int   |    100：导出本页，200：导出全部，若导出返回导出文件url     |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  留言记录列表   |

接口返回示例：

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
                        "recordFormat":"1"
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
                "vadCount":"",
                "txMos":"",
                "rxMos":"",
                "numberTrunkAreaCode":""
            }   
        ],
        "startTime":"2017-12-12 00:00:00",
        "endTime":"2017-12-13 23:59:59",
        "numberType":"customer",
        "tel":"13531623113"
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

### 统计报表

#### 坐席报表

##### 1. 工作量统计

- URL:/api/report/agent/statistic
- Method:GET
- Content type: application/json
- 输入参数：

|       参数        |  要求  |   类型   |                    描述                    |
| :-------------: | :--: | :----: | :--------------------------------------: |
|    tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId  |  必选  | String |                  所属机构id                  |
|  departmentId   |  必选  | String |                  所属部门id                  |
|      type       | 非必选  |  Int   |   报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|    startTime    |  必选  | string |                   开始时间                   |
|     endTime     |  必选  | string |                   结束时间                   |
|  splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示     |
|    startHour    | 非必选  | Float  |                 统计时段起始值                  |
|     endHour     | 非必选  | Float  |                 统计时段终止值                  |
| statisticMethod | 非必选  |  int   | 统计方法：0-分时,1-分日,2-汇总,3-fushionChart分时,4-fushionChart分日,5-fushionChart汇总,6-分类,7-fushionChart分类 |
|      cnos       | 非必选  | String |     选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得     |
|     fields      | 非必选  | String |    要输出的字段，传递时使用逗号连接的字段下标索引，通过座席字段接口获得    |
|      start      | 非必选  | String |                当前页码,默认第一页                |
|      limit      | 非必选  | string |               每页记录数，默认10条                |
|     export      | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 座席工作量报表列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "collectType":"",
            "enterType":"",
            "processType":"",
            "callVolumeType":"",
            "durationType":"",
            "agentStatusType":"",
            "percentage":"",
            "ibTotalCount":"",
            "ibUniqueTotalCount":"",
            "ibAnsweredCount":"",
            "ibUnansweredCount":"",
            "ibUniqueAnsweredCount":"",
            "ibUniqueUnansweredCount":"",
            "ibAgentHangupCount":"",
            "ibCustomerHangupCount":"",
            "ibTransferCount":"",
            "ibConsultCount":"",
            "ibAnsweredDurationArray":"",
            "previewObTotalCount":"",
            "previewObAnsweredCount":"",
            "previewObAgentAnsweredCount":"",
            "previewObAnsweredDurationArray":"",
            "predictObTotalCount":"",
            "predictObAnsweredCount":"",
            "predictObAnsweredDurationArray":"",
            "webcallObTotalCount":"",
            "webcallObAnsweredCount":"",
            "webcallObAnsweredDurationArray":"",
            "idleCount":"",
            "pauseCount":"",
            "ibHoldCount":"",
            "obHoldCount":"",
            "previewObTransferCount":"",
            "previewObConsultCount":"",
            "predictObTransferCount":"",
            "predictObConsultCount":"",
            "webcallObTransferCount":"",
            "webcallObConsultCount":"",
            "ibMonitorThreewayCount":"",
            "ibMonitorSpyCount":"",
            "ibMonitorPickupCount":"",
            "ibMonitorDisconnectCount":"",
            "ibMonitorWhisperCount":"",
            "ibMonitorBargeCount":"",
            "previewObMonitorSpyCount":"",
            "previewObMonitorThreewayCount":"",
            "previewObMonitorDisconnectCount":"",
            "previewObMonitorWhisperCount":"",
            "previewObMonitorBargeCount":"",
            "predictObMonitorSpyCount":"",
            "predictObMonitorThreewayCount":"",
            "predictObMonitorDisconnectCount":"",
            "predictObMonitorWhisperCount":"",
            "predictObMonitorBargeCount":"",
            "webcallObMonitorSpyCount":"",
            "webcallObMonitorThreewayCount":"",
            "webcallObMonitorDisconnectCount":"",
            "webcallObMonitorWhisperCount":"",
            "webcallObMonitorBargeCount":"",
            "bridgeDurationCount1":"",
            "bridgeDurationCount2":"",
            "bridgeDurationCount3":"",
            "ibHoldTime":"",
            "ibMinHoldTime":"",
            "ibMaxHoldTime":"",
            "ibAvgHoldTime":"",
            "obHoldTime":"",
            "obMinHoldTime":"",
            "obMaxHoldTime":"",
            "obAvgHoldTime":"",
            "ibTotalAnswerDelayTime":"",
            "ibMinAnswerDelayTime":"",
            "ibMaxAnswerDelayTime":"",
            "ibAvgAnswerDelayTime":"",
            "loginTime":"",
            "restTime":"",
            "minRestTime":"",
            "maxRestTime":"",
            "avgRestTime":"",
            "pauseTime":"",
            "minPauseTime":"",
            "maxPauseTime":"",
            "avgPauseTime":"",
            "idleTime":"",
            "minIdleTime":"",
            "maxIdleTime":"",
            "avgIdleTime":"",
            "ibCallingTime":"",
            "ibMinCallingTime":"",
            "ibMaxCallingTime":"",
            "ibAvgCallingTime":"",
            "obCallingTime":"",
            "obMinCallingTime":"",
            "obMaxCallingTime":"",
            "obAvgCallingTime":"",
            "ibBridgeTime":"",
            "ibTotalTime":"",
            "ibMinBridgeTime":"",
            "ibMaxBridgeTime":"",
            "ibAvgBridgeTime":"",
            "obBridgeTime":"",
            "obRealBridgeTime":"",
            "obMinBridgeTime":"",
            "obMaxBridgeTime":"",
            "obAvgBridgeTime":"",
            "ibWrapupTime":"",
            "ibMinWrapupTime":"",
            "ibMaxWrapupTime":"",
            "ibAvgWrapupTime":"",
            "obWrapupTime":"",
            "obMinWrapupTime":"",
            "obMaxWrapupTime":"",
            "obAvgWrapupTime":"",
            "previewObAgentAnsweredTime":"",
            "previewObCustomerAnsweredTime":"",
            "predictObAgentAnsweredTime":"",
            "webcallObAgentAnsweredTime":"",
            "ibTotalMinute":"",
            "ibBridgeMinute":"",
            "hoursUtilization":"",
            "agentRate":"",
            "agentAnswerRate":"",
            "previewAgentAnswerdRate":"",
            "previewCustomerAnswerdRate":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|               参数                |   类型   |      描述      |
| :-----------------------------: | :----: | :----------: |
|           collectType           | String |      汇总      |
|            enterType            | String |     进入数      |
|           processType           | String |     处理数      |
|         callVolumeType          | String |      其他      |
|          durationType           | String |      时长      |
|         agentStatusType         | String |     座席状态     |
|           percentage            | String |      比率      |
|          ibTotalCount           | String |    总呼入座席数    |
|       ibUniqueTotalCount        | String |    座席来电数     |
|         ibAnsweredCount         | String |   呼入座席接听数    |
|        ibUnansweredCount        | String |   呼入座席未接听数   |
|      ibUniqueAnsweredCount      | String |   座席来电接听数    |
|     ibUniqueUnansweredCount     | Stirng |   座席来电未接听数   |
|       ibAgentHangupCount        | String |    座席挂机数     |
|      ibCustomerHangupCount      | String |    客户挂机数     |
|         ibTransferCount         | String |    呼入转移数     |
|         ibConsultCount          | String |    呼入咨询数     |
|     ibAnsweredDurationArray     | String |   呼入接听量分布    |
|       previewObTotalCount       | String |    总预览外呼数    |
|     previewObAnsweredCount      | String |  预览外呼双方接听数   |
|   previewObAgentAnsweredCount   | String |  预览外呼接听量分布   |
|       predictObTotalCount       | String |    总预测外呼数    |
|     predictObAnsweredCount      | String |  预测外呼双方接听数   |
| predictObAnsweredDurationArray  | String |  预测外呼接听量分布   |
|       webcallObTotalCount       | String |  总webcall数   |
|     webcallObAnsweredCount      | String | webcall双方接听数 |
| webcallObAnsweredDurationArray  | String | webcall接听量分布 |
|            idleCount            | String |    总空闲次数     |
|           pauseCount            | String |    总置忙次数     |
|           ibHoldCount           | String |    呼入保持次数    |
|           obHoldCount           | String |    外呼保持次数    |
|     previewObTransferCount      | String |   预览外呼转移数    |
|      previewObConsultCount      | String |   预览外呼咨询数    |
|     predictObTransferCount      | String |   预测外呼转移数    |
|      predictObConsultCount      | String |   预测外呼咨询数    |
|     webcallObTransferCount      | String |  webcall转移数  |
|      webcallObConsultCount      | String |  webcall咨询数  |
|     ibMonitorThreewayCount      | String |   呼入监控三方数    |
|        ibMonitorSpyCount        | String |   呼入监控监听数    |
|      ibMonitorPickupCount       | String |   呼入监控抢线数    |
|    ibMonitorDisconnectCount     | String |   呼入监控强拆数    |
|      ibMonitorWhisperCount      | String |   呼入监控耳语数    |
|       ibMonitorBargeCount       | String |   呼入监控强插数    |
|    previewObMonitorSpyCount     | String |  预览外呼监控监听数   |
|  previewObMonitorThreewayCount  | String |  预览外呼监控三方数   |
| previewObMonitorDisconnectCount | String |  预览外呼监控强拆数   |
|  previewObMonitorWhisperCount   | String |  预览外呼监控耳语数   |
|   previewObMonitorBargeCount    | String |  预览外呼监控强插数   |
|    predictObMonitorSpyCount     | String |  预测外呼监控监听数   |
|  predictObMonitorThreewayCount  | String |  预测外呼监控三方数   |
| predictObMonitorDisconnectCount | String |  预测外呼监控强拆数   |
|  predictObMonitorWhisperCount   | String |  预测外呼监控耳语数   |
|   predictObMonitorBargeCount    | String |  预测外呼监控强插数   |
|    webcallObMonitorSpyCount     | String | webcall监控监听数 |
|  webcallObMonitorThreewayCount  | String | webcall监控三方数 |
| webcallObMonitorDisconnectCount | String | webcall监控强拆数 |
|  webcallObMonitorWhisperCount   | String | webcall监控耳语数 |
|   webcallObMonitorBargeCount    | String | webcall监控强插数 |
|      bridgeDurationCount1       | String |    30秒通话数    |
|      bridgeDurationCount2       | String | 30秒至180秒通话数  |
|      bridgeDurationCount3       | String |   180秒通话数    |
|           ibHoldTime            | String |   呼入总保持时长    |
|          ibMinHoldTime          | String |   呼入最小保持时长   |
|          ibMaxHoldTime          | String |   呼入最大保持时长   |
|          ibAvgHoldTime          | String |   呼入平均保持时长   |
|           obHoldTime            | String |   外呼总保持时长    |
|          obMinHoldTime          | String |   外呼最小保持时长   |
|          obMaxHoldTime          | String |   外呼最大保持时长   |
|          obAvgHoldTime          | String |   外呼平均保持时长   |
|     ibTotalAnswerDelayTime      | String |  呼入接听总延迟时间   |
|      ibMinAnswerDelayTime       | String |  呼入接听最小延迟时间  |
|      ibMaxAnswerDelayTime       | String |  呼入接听最大延迟时间  |
|      ibAvgAnswerDelayTime       | String |  呼入接听平均延迟时间  |
|            loginTime            | String |    总登录时长     |
|            restTime             | String |    总休息时长     |
|           minRestTime           | String |    最小休息时长    |
|           maxRestTime           | String |    最大休息时长    |
|           avgRestTime           | String |    平均休息时长    |
|            pauseTime            | String |    总置忙时长     |
|          minPauseTime           | String |    最小置忙时长    |
|          maxPauseTime           | String |    最大置忙时长    |
|          avgPauseTime           | String |    平均置忙时长    |
|            idleTime             | String |    总空闲时长     |
|           minIdleTime           | String |    最小空闲时长    |
|           maxIdleTime           | String |    最大空闲时长    |
|           avgIdleTime           | String |    平均空闲时长    |
|          ibCallingTime          | String |   呼入总呼叫时长    |
|        ibMinCallingTime         | String |   呼入最小呼叫时长   |
|        ibMaxCallingTime         | String |   呼入最大呼叫时长   |
|        ibAvgCallingTime         | String |   呼入平均呼叫时长   |
|          obCallingTime          | String |   外呼总呼叫时长    |
|        obMinCallingTime         | String |   外呼最小呼叫时长   |
|        obMaxCallingTime         | String |   外呼最大呼叫时长   |
|        obAvgCallingTime         | String |   外呼平均呼叫时长   |
|          ibBridgeTime           | String |   呼入双方接听时长   |
|           ibTotalTime           | String |   呼入总通话时长    |
|         ibMinBridgeTime         | String |   呼入最小通话时长   |
|         ibMaxBridgeTime         | String |   呼入最大通话时长   |

|      **ibAvgBridgeTime**      | String |    呼入平均通话时长    |
| :---------------------------: | :----: | :------------: |
|         obBridgeTime          | String |    外呼总通话时长     |
|       obRealBridgeTime        | String |    外呼双方接听时长    |
|        obMinBridgeTime        | String |    外呼最小通话时长    |
|        obMaxBridgeTime        | String |    外呼最大通话时长    |
|        obAvgBridgeTime        | String |    外呼平均通话时长    |
|         ibWrapupTime          | String |    呼入总整理时长     |
|        ibMinWrapupTime        | String |    呼入最小整理时长    |
|        ibMaxWrapupTime        | String |    呼入最大整理时长    |
|        ibAvgWrapupTime        | String |    呼入平均整理时长    |
|         obWrapupTime          | String |    外呼总整理时长     |
|        obMinWrapupTime        | String |    外呼最小整理时长    |
|        obMaxWrapupTime        | String |    外呼最大整理时长    |
|        obAvgWrapupTime        | String |    外呼平均整理时长    |
|  previewObAgentAnsweredTime   | String |  预览外呼座席接听分钟数   |
| previewObCustomerAnsweredTime | String |  预览外呼客户接听分钟数   |
|  predictObAgentAnsweredTime   | String |  预测外呼座席接听分钟数   |
|  webcallObAgentAnsweredTime   | String | webcall座席接听分钟数 |
|         ibTotalMinute         | String |     呼入总分钟数     |
|        ibBridgeMinute         | String |    呼入通话分钟数     |
|       hoursUtilization        | String |     工时利用率      |
|           agentRate           | String |    座席呼叫接听率     |
|        agentAnswerRate        | String |    座席来电接听率     |
|    previewAgentAnswerdRate    | String |   预览外呼座席接听率    |
|  previewCustomerAnswerdRate   | String |   预览外呼客户接听率    |

##### 1.1 座席列表接口

- URL:/api/report/agent/agentInfo
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |  描述  |
| :----------: | :--: | :----: | :--: |
| departmentId |  必选  | String | 部门id |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   座席列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "cno":"1",
            "cname":"王伟"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|  参数   |   类型   |  描述  |
| :---: | :----: | :--: |
|  cno  | String | 座席id |
| cname | String | 座席姓名 |

##### 1.2 座席字段接口

- URL:/api/report/agent/fieldInfo
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |  描述  |
| :----------: | :--: | :----: | :--: |
| departmentId |  必选  | String | 部门id |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | String |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "nameForJava":"agentStatusType",
            "nameForDb":"agent_status_type",
            "desc":"座席状态",
            "index":"666",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |

##### 2. 工作日志

- URL:/api/report/agent/log
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|      type      | 非必选  |  Int   |   报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|   startTime    |  必选  | string |                   开始时间                   |
|    endTime     |  必选  | string |                   结束时间                   |
| splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示     |
|   startHour    | 非必选  | Float  |                 统计时段起始值                  |
|    endHour     | 非必选  | Float  |                 统计时段终止值                  |
|      cnos      | 非必选  | String |     选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得     |
|     fields     | 非必选  | String |    要输出的字段，传递时使用逗号连接的字段下标索引，通过座席字段接口获得    |
|     event      | 非必选  | String | 动作，例：login:登录，loginout：退出，pause：置忙，unpause：置闲  ，changeBindTel：修改绑定电话，hold：保持，unhold：保持接回，wrapupStart：整理开始，wrapupEnd：整理结束，mute：结束，refuse：拒接，consult：咨询，consultCancel：咨询取消，consultThreeway：咨询三方，consultTransfer：咨询转移，unconsult：咨询接回，transfer：转移，previewOutcall：预览外呼，previewOutcallCancel：预览外呼取消，interact：交互，investigation：满意度调查，unlink：挂断，disconnect：强拆，spy：监听，unspy：监听接回，threeway：三方，unthreeway：三方接回，whisper：耳语，unwhisper：耳语接回，barge：强拆，pickup：抢线，verifyTel：电话验证 |
|     export     | 非必选  |  int   |      100：导出本页，200：导出全部，若导出返回导出文件url      |
|     start      | 非必选  | String |                当前页码,默认第一页                |
|     limit      | 非必选  | string |               每页记录数，默认10条                |

接口返回：

|   参数   |   类型   |     描述     |
| :----: | :----: | :--------: |
| status |  int   |    状态码     |
|  msg   | String | 状态说明，例如成功  |
| result | array  | 座席工作日志报表列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "cno":"00000",
            "agentName":"fengwei",
            "eventDsc":"退出",
            "data1":"后台",
            "data2":"",
            "data3":"",
            "data4":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|    参数     |   类型   |  描述  |
| :-------: | :----: | :--: |
|    cno    | String | 座席工号 |
| agentName | String | 座席名称 |
| eventDsc  | String |  动作  |
|   data1   | String | 数据1  |
|   data2   | String | 数据2  |
|   data3   | String | 数据3  |
|   data4   | String | 数据4  |

##### 3. 工作时长

- URL:/api/report/agent/duration
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                  描述                  |
| :------------: | :--: | :----: | :----------------------------------: |
|   tenancyId    |  必选  | String |                所属企业id                |
| organizationId |  必选  | String |                所属机构id                |
|  departmentId  |  必选  | String |                所属部门id                |
|      type      | 非必选  |  Int   | 报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段 |
|   startTime    |  必选  | string |                 开始时间                 |
|    endTime     |  必选  | string |                 结束时间                 |
| splitTimeType  | 非必选  |  Int   |  分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示   |
|   startHour    | 非必选  | Float  |               统计时段起始值                |
|    endHour     | 非必选  | Float  |               统计时段终止值                |
|      cnos      | 非必选  | String |   选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得   |
|     fields     | 非必选  | String |  要输出的字段，传递时使用逗号连接的字段下标索引，通过座席字段接口获得  |
|     export     | 非必选  |  int   |    100：导出本页，200：导出全部，若导出返回导出文件url    |
|     start      | 非必选  | String |              当前页码,默认第一页              |
|     limit      | 非必选  | string |             每页记录数，默认10条              |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 座席工作量报表列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "cno":"00000",
            "agentName":"fengwei",
            "eventDsc":"登录",
            "startTime":"2017-12-27 19:44:00",
            "endTime":"2017-12-28 00:00:00",
            "duration":"04:16:00",
            "data1":"普通",
            "data2":"小休"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|    参数     |   类型   |  描述  |
| :-------: | :----: | :--: |
|    cno    | String | 座席工号 |
| agentName | String | 座席名称 |
| eventDsc  | String |  状态  |
| startTime | String | 开始时间 |
|  endTime  | String | 结束时间 |
| duration  | String |  时长  |
|   data1   | String | 数据1  |
|   data2   | String | 数据2  |

####  队列报表

- URL:/api/report/queue
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                  描述                  |
| :------------: | :--: | :----: | :----------------------------------: |
|   tenancyId    |  必选  | String |                所属企业id                |
| organizationId |  必选  | String |                所属机构id                |
|  departmentId  |  必选  | String |                所属部门id                |
|      type      | 非必选  |  Int   | 报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段 |
|   startTime    |  必选  | string |                 开始时间                 |
|    endTime     |  必选  | string |                 结束时间                 |
| splitTimeType  | 非必选  |  Int   |  分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示   |
|   startHour    | 非必选  | Float  |               统计时段起始值                |
|    endHour     | 非必选  | Float  |               统计时段终止值                |
|      qnos      | 非必选  | String |   选择的队列，传递时用逗号连接的队列下标索引，通过队列列表接口获得   |
|     fields     | 非必选  | String |  要输出的字段，传递时使用逗号连接的字段下标索引，通过队列字段接口获得  |
|     start      | 非必选  | String |              当前页码,默认第一页              |
|     limit      | 非必选  | string |             每页记录数，默认10条              |
|     export     | 非必选  |  int   |    100：导出本页，200：导出全部，若导出返回导出文件url    |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  队列报表列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "collectType":"",
            "enterType":"",
            "processType":"",
            "callVolumeType":"",
            "durationType":"",
            "compareType":"",
            "enterCount":"",
            "successCount":"",
            "emptyFailedCount":"",
            "fullFailedCount":"",
            "leaveAbandonedCount":"",
            "leaveTimeoutCount":"",
            "leaveEmptyCount":"",
            "leaveCompleteCount":"",
            "telEnterCount":"",
            "telAnswerCount":"",
            "callCount":"",
            "rnaCount":"",
            "agentHangupCount":"",
            "customerHangupCount":"",
            "answerIntimeCount":"",
            "totalBridgeTime":"",
            "minBridgeTime":"",
            "maxBridgeTime":"",
            "avgBridgeTime":"",
            "totalWrapupTime":"",
            "minWrapupTime":"",
            "maxWrapupTime":"",
            "avgWrapupTime":"",
            "totalWaitTime":"",
            "minWaitTime":"",
            "maxWaitTime":"",
            "avgWaitTime":"",
            "totalAbandonWaitTime":"",
            "minAbandonWaitTime":"",
            "maxAbandonWaitTime":"",
            "avgAbandonWaitTime":"",
            "totalAnswerWaitTime":"",
            "minAnswerWaitTime":"",
            "maxAnswerWaitTime":"",
            "avgAnswerWaitTime":"",
            "enterAnsweredRate":"",
            "answeredRate":"",
            "abandonedRate":"",
            "serviceLevel":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

队列报表对象字段说明：

|          参数          |   类型   |    描述     |
| :------------------: | :----: | :-------: |
|     collectType      | String |    汇总     |
|      enterType       | String |    进入数    |
|     processType      | String |    处理数    |
|    callVolumeType    | String |    其他     |
|     durationType     | String |    时长     |
|     compareType      | String |    比率     |
|      enterCount      | String |  总排队请求数   |
|     successCount     | String |   成功排队数   |
|   emptyFailedCount   | String | 无座席未进入队列数 |
|   fullFailedCount    | String | 队列满未进入队列数 |
| leaveAbandonedCount  | String |  排队中放弃数   |
|  leaveTimeoutCount   | String | 排队中超时溢出数  |
|   leaveEmptyCount    | Stirng | 排队中无座席溢出数 |
|  leaveCompleteCount  | String |  呼转座席接听数  |
|    telEnterCount     | String |  进入队列来电数  |
|    telAnswerCount    | String |  队列来电接听数  |
|      callCount       | String |  呼转座席总数   |
|       rnaCount       | String | 呼转座席未接听数  |
|   agentHangupCount   | String |   座席挂机数   |
| customerHangupCount  | String |   客户挂机数   |
|  answerIntimeCount   | String |   及时应答数   |
|   totalBridgeTime    | String |   总通话时长   |
|    minBridgeTime     | String |  最短通话时长   |
|    maxBridgeTime     | String |  最长通话时长   |
|    avgBridgeTime     | String |  平均通话时长   |
|   totalWrapupTime    | String |   总整理时长   |
|    minWrapupTime     | String |  最小整理时长   |
|    maxWrapupTime     | String |  最大整理时长   |
|    avgWrapupTime     | String |  平均整理时长   |
|    totalWaitTime     | String |   总等待时长   |
|     minWaitTime      | String |  最小等待时长   |
|     maxWaitTime      | String |  最大等待时长   |
|     avgWaitTime      | String |  平均等待时长   |
| totalAbandonWaitTime | String | 放弃中总等待时长  |
|  minAbandonWaitTime  | String | 放弃中最小等待时长 |
|  maxAbandonWaitTime  | String | 放弃中最大等待时长 |
|  avgAbandonWaitTime  | String | 放弃中平均等待时长 |
| totalAnswerWaitTime  | String | 接听中总等待时长  |
|  minAnswerWaitTime   | String | 接听中最小等待时长 |
|  maxAnswerWaitTime   | String | 接听中最大等待时长 |
|  avgAnswerWaitTime   | String | 接听中平均等待时长 |
|  enterAnsweredRate   | String |  队列来电接听率  |
|     answeredRate     | String |  队列呼叫接听率  |
|    abandonedRate     | String |  队列呼叫放弃率  |
|     serviceLevel     | String |   服务水平    |



##### 1. 队列列表接口

- URL:/api/report/queue/queueInfo
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |  描述  |
| :----------: | :--: | :----: | :--: |
| departmentId |  必选  | String | 部门id |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   队列列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "qno":"100001",
            "announcePosition":"",
            "announcePositionFrequency":"",
            "announcePositionParam":"",
            "announcePositionYouarenext":"",
            "announceSound":"",
            "announceSoundFile":"",
            "announceSoundFrequency":"",
            "createTime":"",
            "description":"",
            "enterpriseId":"",
            "joinEmpty":"",
            "maxLen":"",
            "memberTimeout":"",
            "musicClass":"",
            "queueTimeout":"",
            "retry":"",
            "sayAgentno":"",
            "serviceLevel":"",
            "strategy":"",
            "vipSupport":"",
            "weight":"",
            "wrapupTime":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

对象字段说明：

|  参数  |   类型   |  描述  |
| :--: | :----: | :--: |
|  id  |  int   | 队列id |
| qno  | String | 队列号  |

##### 2. 队列字段接口

- URL:/api/report/queue/fieldInfo
- Method:GET
- Content type: application/json
- 输入参数：

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"collectType",
            "nameForDb":"collect_type",
            "desc":"汇总",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"enterCount",
                    "nameForDb":"enter_count",
                    "desc":"总排队请求数",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

#### 中继报表

##### 1. 来电分析

- URL:/api/report/trunk/hour
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                    |
| :------------: | :--: | :----: | :-------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                  |
| organizationId |  必选  | String |                 所属机构id                  |
|  departmentId  |  必选  | String |                 所属部门id                  |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|   startTime    |  必选  | string |                  开始时间                   |
|    endTime     |  必选  | string |                  结束时间                   |
| splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                 统计时段起始值                 |
|    endHour     | 非必选  | Float  |                 统计时段终止值                 |
|    hotlines    | 非必选  | String | 统计的热线号码字符串，传递时用逗号连接的热线号码索引，通过来电热线列表接口获得 |
|     fields     | 非必选  | String |  要输出的字段，传递时使用逗号连接的字段下标索引，通过来电队列字段接口获得   |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url      |
|     start      | 非必选  | String |               当前页码,默认第一页                |
|     limit      | 非必选  | string |               每页记录数，默认10条               |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  来电分析列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "collectType":"",
            "enterType":"",
            "processType":"",
            "callVolumeType":"",
            "durationType":"",
            "ibTotalCount":"",
            "ibTotalTelLandline":"",
            "ibTotalTelMobile":"",
            "ibIvrCount":"",
            "ibDirectTel":"",
            "ibDirectQueue":"",
            "ibDirectCno":"",
            "ibSystemNoAnswer":"",
            "ibTotalVip":"",
            "ibRestrictCount":"",
            "ibQueueCount":"",
            "ibAnsweredCount":"",
            "ibUnansweredCount":"",
            "ibTotalDurationArray":"",
            "ibAnsweredDurationArray":"",
            "totalTime":"",
            "avgTime":"",
            "totalBridgeTime":"",
            "maxBridgeTime":"",
            "minBridgeTime":"",
            "avgBridgeTime":"",
            "ibAgentAnsweredTime":"",
            "ibCustomerAnsweredTime":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|           参数            |   类型   |    描述    |
| :---------------------: | :----: | :------: |
|       collectType       | String |    汇总    |
|        enterType        | String |   进入数    |
|       processType       | String |   处理数    |
|     callVolumeType      | String |   呼叫量    |
|      durationType       | String |    时长    |
|      ibTotalCount       | String |   总来电数   |
|   ibTotalTelLandline    | String |  固话来电数   |
|    ibTotalTelMobile     | String |  手机来电数   |
|       ibIvrCount        | String |  进入IVR数  |
|       ibDirectTel       | String | 直转电话/分机数 |
|      ibDirectQueue      | String |   直转队列   |
|       ibDirectCno       | String |   直转座席   |
|    ibSystemNoAnswer     | String |  系统未接听数  |
|       ibTotalVip        | String |  VIP呼入数  |
|     ibRestrictCount     | String |  黑名单来电数  |
|      ibQueueCount       | String | 进入队列来电数  |
|     ibAnsweredCount     | String |  人工接听数   |
|    ibUnansweredCount    | String |  非人工接听数  |
|  ibTotalDurationArray   | String |  呼入量分布   |
| ibAnsweredDurationArray | String |  接听量分布   |
|        totalTime        | String |   总时长    |
|         avgTime         | String |   平均时长   |
|     totalBridgeTime     | String |  总通话时长   |
|      maxBridgeTime      | String |  最大通话时长  |
|      minBridgeTime      | String |  最小通话时长  |
|      avgBridgeTime      | String |  平均通话时长  |
|   ibAgentAnsweredTime   | String |  座席接听时长  |
| ibCustomerAnsweredTime  | String |  客户接听时长  |

##### 1.1 来电热线列表接口

- URL:/api/report/trunk/hotlineInfo
- Method:GET
- Content type: application/json
- 输入参数：


|      参数      |  要求  |   类型   |  描述  |
| :----------: | :--: | :----: | :--: |
| departmentId |  必选  | String | 部门id |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  热线号码列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "enterpriseId":"100001",
            "hotline":"13891058",
            "isMaster":"",
            "areaCode":"101",
            "numberTrunk":"",
            "type":"",
            "name":"",
            "createTime":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|   参数    |   类型   |  描述  |
| :-----: | :----: | :--: |
|   id    |  int   | 热线id |
| hotline | String | 热线号  |

##### 


##### 1.2 来电队列字段接口

- URL:/api/report/trunk/fieldInfoHour
- Method:GET
- Content type: application/json
- 输入参数：


接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"collectType",
            "nameForDb":"collect_type",
            "desc":"汇总",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"ibTotalCount",
                    "nameForDb":"ib_total_count",
                    "desc":"总来电数",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |


##### 2. 地区分析

- URL:/api/report/trunk/area
- Method:GET
- Content type: application/json
- 输入参数：


|       参数       |  要求  |   类型   |                   描述                    |
| :------------: | :--: | :----: | :-------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                  |
| organizationId |  必选  | String |                 所属机构id                  |
|  departmentId  |  必选  | String |                 所属部门id                  |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|   startTime    |  必选  | string |                  开始时间                   |
|    endTime     |  必选  | string |                  结束时间                   |
| splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                 统计时段起始值                 |
|    endHour     | 非必选  | Float  |                 统计时段终止值                 |
|    hotlines    | 非必选  | String | 统计的热线号码字符串，传递时用逗号连接的热线号码索引，通过来电热线列表接口获得 |
|     fields     | 非必选  | String |  要输出的字段，传递时使用逗号连接的字段下标索引，通过地区队列字段接口获得   |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url      |
|     start      | 非必选  | String |               当前页码,默认第一页                |
|     limit      | 非必选  | string |               每页记录数，默认10条               |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  地区分析列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "all":"",
            "province":"",
            "city":"",
            "ibTotal":"",
            "proporation":""
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|     参数      |   类型   |  描述  |
| :---------: | :----: | :--: |
|     all     | String |  全部  |
|  province   | String |  省份  |
|    city     | String |  城市  |
|   ibTotal   | String | 来电数  |
| proporation | String |  比例  |


##### 2.1 地区队列字段接口

- URL:/api/report/trunk/fieldInfoArea
- Method:GET
- Content type: application/json
- 输入参数：

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"all",
            "nameForDb":"all",
            "desc":"全部",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"province",
                    "nameForDb":"province",
                    "desc":"省份",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

#### 满意度报表

##### 1. 按坐席统计

- URL:/api/report/investigation/agent
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                  描述                  |
| :------------: | :--: | :----: | :----------------------------------: |
|   tenancyId    |  必选  | String |                所属企业id                |
| organizationId |  必选  | String |                所属机构id                |
|  departmentId  |  必选  | String |                所属部门id                |
|      type      | 非必选  |  Int   | 报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段 |
|   startTime    |  必选  | string |                 开始时间                 |
|    endTime     |  必选  | string |                 结束时间                 |
| splitTimeType  | 非必选  |  Int   |  分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示   |
|   startHour    | 非必选  | Float  |               统计时段起始值                |
|    endHour     | 非必选  | Float  |               统计时段终止值                |
|      cnos      | 非必选  | String |   选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得   |
|     fields     | 非必选  | String | 要输出的字段，传递时使用逗号连接的字段下标索引，通过满意度字段接口获得  |
|     export     | 非必选  |  int   |    100：导出本页，200：导出全部，若导出返回导出文件url    |
|     start      | 非必选  | String |              当前页码,默认第一页              |
|     limit      | 非必选  | string |             每页记录数，默认10条              |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   统计列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "callVolumeType":"",
            "durationType":"",
            "callTypeNode":"",
            "totalCount":"",
            "keyCount":"",
            "abandonCount":"",
            "totalInvestigationTime":"",
            "minInvestigationTime":"",
            "maxInvestigationTime":"",
            "avgInvestigationTime":"",
            "totalAbandonTime":"",
            "minAbandonTime":"",
            "maxAbandonTime":"",
            "avgAbandonTime":"",
            "keyValues":"",
            "callType":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

满意度统计对象字段说明：

|           参数           |   类型   |   描述   |
| :--------------------: | :----: | :----: |
|     callVolumeType     | String |  呼叫量   |
|      durationType      | String |   时长   |
|      callTypeNode      | String |  呼叫类型  |
|       totalCount       | String |  调查总数  |
|        keyCount        | String |  按键数   |
|      abandonCount      | String |  放弃数   |
| totalInvestigationTime | String | 总调查时长  |
|  minInvestigationTime  | String | 最小调查时长 |
|  maxInvestigationTime  | String | 最大调查时长 |
|  avgInvestigationTime  | String | 平均调查时长 |
|    totalAbandonTime    | String | 总放弃时长  |
|     minAbandonTime     | String | 最小放弃时长 |
|     maxAbandonTime     | String | 最大放弃时长 |
|     avgAbandonTime     | String | 平均放弃时长 |
|       keyValues        | String |  按键统计  |
|        callType        | String |  呼叫类型  |

##### 1.1 满意度字段接口

- URL:/api/report/investigation/fieldInfo
- Method:GET
- Content type: application/json
- 输入参数：

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"callVolumeType",
            "nameForDb":"call_volume_type",
            "desc":"呼叫量",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"totalCount",
                    "nameForDb":"total_count",
                    "desc":"调查总数",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}


```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

##### 2. 按热线号码统计

- URL:/api/report/investigation/hotline
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                    |
| :------------: | :--: | :----: | :-------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                  |
| organizationId |  必选  | String |                 所属机构id                  |
|  departmentId  |  必选  | String |                 所属部门id                  |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|   startTime    |  必选  | string |                  开始时间                   |
|    endTime     |  必选  | string |                  结束时间                   |
| splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                 统计时段起始值                 |
|    endHour     | 非必选  | Float  |                 统计时段终止值                 |
|    hotlines    | 非必选  | String | 统计的热线号码字符串，传递时用逗号连接的热线号码索引，通过来电热线列表接口获得 |
|     fields     | 非必选  | String |   要输出的字段，传递时使用逗号连接的字段下标索引，通过满意度字段接口获得   |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url      |
|     start      | 非必选  | String |               当前页码,默认第一页                |
|     limit      | 非必选  | string |               每页记录数，默认10条               |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   统计列表    |



#### 外呼报表

##### 1. 预览外呼报表

- URL:/api/report/ob/preview
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                  描述                  |
| :------------: | :--: | :----: | :----------------------------------: |
|   tenancyId    |  必选  | String |                所属企业id                |
| organizationId |  必选  | String |                所属机构id                |
|  departmentId  |  必选  | String |                所属部门id                |
|      type      | 非必选  |  Int   | 报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段 |
|   startTime    |  必选  | string |                 开始时间                 |
|    endTime     |  必选  | string |                 结束时间                 |
| splitTimeType  | 非必选  |  Int   |  分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示   |
|   startHour    | 非必选  | Float  |               统计时段起始值                |
|    endHour     | 非必选  | Float  |               统计时段终止值                |
|      cnos      | 非必选  | String |   选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得   |
|     fields     | 非必选  | String | 要输出的字段，传递时使用逗号连接的字段下标索引，通过预览外呼字段接口获得 |
|     export     | 非必选  |  int   |    100：导出本页，200：导出全部，若导出返回导出文件url    |
|     start      | 非必选  | String |              当前页码,默认第一页              |
|     limit      | 非必选  | string |             每页记录数，默认10条              |

接口返回：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  预测外呼列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "callVolumeType":"",
            "durationType":"",
            "percentage":"",
            "totalCount":"",
            "agentAnsweredCount":"",
            "customerAnsweredCount":"",
            "bothAnsweredCount":"",
            "validCalls":"",
            "totalBridgeTime":"",
            "avgBridgeTime":"",
            "maxBridgeTime":"",
            "minBridgeTime":"",
            "validTotalBridgeTime":"",
            "validAvgBridgeTime":"",
            "vadRate":"",
            "agentRate":"",
            "customerRate":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|          参数           |   类型   |     描述     |
| :-------------------: | :----: | :--------: |
|    callVolumeType     | String |    呼叫量     |
|     durationType      | String |     时长     |
|      percentage       | String |     比率     |
|      totalCount       | String |    外呼总数    |
|  agentAnsweredCount   | String |   座席接听数    |
| customerAnsweredCount | String |   客户接听数    |
|   bothAnsweredCount   | String |   双方接听数    |
|      validCalls       | String |   有效通话次数   |
|    totalBridgeTime    | String |   总通话时长    |
|     avgBridgeTime     | String |   平均通话时长   |
|     maxBridgeTime     | String |   最长通话时长   |
|     minBridgeTime     | String |   最短通话时长   |
| validTotalBridgeTime  | String | 有效通话总通话时长  |
|  validAvgBridgeTime   | String | 有效通话平均通话时长 |
|        vadRate        | String |    通话占比    |
|       agentRate       | String |   座席接听率    |
|     customerRate      | String |   客户接听率    |



##### 1.1 预览外呼字段接口

- URL:/api/report/ob/fieldInfoPreview
- Method:GET
- Content type: application/json
- 输入参数：

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"callVolumeType",
            "nameForDb":"call_volume_type",
            "desc":"呼叫量",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"totalCount",
                    "nameForDb":"total_count",
                    "desc":"外呼总数",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}


```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

##### 2. WebCall报表

- URL:/api/report/ob/webcall
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                    |
| :------------: | :--: | :----: | :-------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                  |
| organizationId |  必选  | String |                 所属机构id                  |
|  departmentId  |  必选  | String |                 所属部门id                  |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段   |
|   startTime    |  必选  | string |                  开始时间                   |
|    endTime     |  必选  | string |                  结束时间                   |
| splitTimeType  | 非必选  |  Int   |    分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                 统计时段起始值                 |
|    endHour     | 非必选  | Float  |                 统计时段终止值                 |
|      cnos      | 非必选  | String |    选择的座席，传递时用逗号连接的座席下标索引，通过座席列表接口获得     |
|     fields     | 非必选  | String | 要输出的字段，传递时使用逗号连接的字段下标索引，通过WebCall字段接口获得 |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url      |
|     start      | 非必选  | String |               当前页码,默认第一页                |
|     limit      | 非必选  | string |               每页记录数，默认10条               |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | webcall列表 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "callVolumeType":"",
            "durationType":"",
            "percentage":"",
            "totalCount":"",
            "answeredCount":"",
            "validCalls":"",
            "totalBridgeTime":"",
            "avgBridgeTime":"",
            "maxBridgeTime":"",
            "minBridgeTime":"",
            "validTotalBridgeTime":"",
            "validAvgBridgeTime":"",
            "agentRate":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|          参数          |   类型   |     描述     |
| :------------------: | :----: | :--------: |
|    callVolumeType    | String |    呼叫量     |
|     durationType     | String |     时长     |
|      percentage      | String |     比率     |
|      totalCount      | String |    呼叫总数    |
|    answeredCount     | String |   座席接听数    |
|      validCalls      | String |   有效通话次数   |
|   totalBridgeTime    | String |   总通话时长    |
|    avgBridgeTime     | String |   平均通话时长   |
|    maxBridgeTime     | String |   最长通话时长   |
|    minBridgeTime     | String |   最短通话时长   |
| validTotalBridgeTime | String | 有效通话总通话时长  |
|  validAvgBridgeTime  | String | 有效通话平均通话时长 |
|      agentRate       | String |   座席接听率    |

##### 2.1 WebCall字段接口

- URL:/api/report/ob/fieldInfoWebcall
- Method:GET
- Content type: application/json
- 输入参数：

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"callVolumeType",
            "nameForDb":"call_volume_type",
            "desc":"呼叫量",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"totalCount",
                    "nameForDb":"total_count",
                    "desc":"呼叫总数",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}


```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

##### 3. 预测外呼座席报表

- URL:/api/report/ob/agent
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                   |
| :------------: | :--: | :----: | :------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                 |
| organizationId |  必选  | String |                 所属机构id                 |
|  departmentId  |  必选  | String |                 所属部门id                 |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段  |
|   startTime    |  必选  | string |                  开始时间                  |
|    endTime     |  必选  | string |                  结束时间                  |
| splitTimeType  | 非必选  |  Int   |   分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                统计时段起始值                 |
|    endHour     | 非必选  | Float  |                统计时段终止值                 |
|      tids      | 非必选  | String | 要统计的预览外呼任务，传递时用逗号连接的任务下标索引，通过任务列表接口获得  |
|     fields     | 非必选  | String | 要输出的字段，传递时使用逗号连接的字段下标索引，通过预览外呼座席字段接口获得 |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url     |
|     start      | 非必选  | String |               当前页码,默认第一页               |
|     limit      | 非必选  | string |              每页记录数，默认10条               |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 预测外呼座席列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "task":"",
            "cno":"",
            "stateIdle":"",
            "statePause":"",
            "stateInuse":"",
            "stateCalling":"",
            "stateWrapup":"",
            "utilization":"",
            "calledCount":"",
            "bridgeCount":"",
            "answeredRate":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|      参数      |   类型   |   描述   |
| :----------: | :----: | :----: |
|   taskName   | String |  任务名称  |
|     cno      | String |  座席工号  |
|  stateIdle   | String | 空闲状态时长 |
|  statePause  | String | 置忙状态时长 |
|  stateInuse  | String | 通话状态时长 |
| stateCalling | String | 呼叫状态时长 |
| stateWrapup  | String | 整理状态时长 |
| utilization  | String | 座席利用率  |
| calledCount  | String |  已呼叫数  |
| bridgeCount  | String |  接通数   |
| answeredRate | String |  接通率   |

##### 3.1 预览外呼座席字段接口

- URL:/api/report/ob/fieldInfoAgent
- Method:GET
- Content type: application/json
- 输入参数：

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   字段列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
        	"nameForJava":"all",
            "nameForDb":"all",
            "desc":"全部",
            "index":"111",
            "parentIndex":"-1",
            "isBaseField":"false",
            "isTotalStatisticsCan":"false",
            "children":[
                {
                    "nameForJava":"task",
                    "nameForDb":"task",
                    "desc":"任务名称",
                    "index":"1",
                    "parentIndex":"111",
                    "isBaseField":"true",
                    "isTotalStatisticsCan":"true"
                }
            ]
        }
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}


```

对象字段说明：

|          参数          |   类型    |           描述           |
| :------------------: | :-----: | :--------------------: |
|     nameForJava      | String  |       字段名字：驼峰命名        |
|      nameForDb       | String  |     字段名字：多个单词用_分隔      |
|         desc         | String  |          字段描述          |
|        index         |   int   |         字段下标索引         |
|     parentIndex      |   int   | 父节点下标索引，-1为没有父节点，默认为-1 |
|     isBaseField      | boolean |    是否是基础字段:默认为true     |
| isTotalStatisticsCan | boolean |        是否能统计合计         |
|       children       |  字段对象   |         子节点对象          |

##### 3.2 任务列表接口

- URL:/api/report/ob/taskList
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |   类型   |   描述   |
| :----------: | :----: | :----: |
| departmentId | String | 所属部门id |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |   任务列表    |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "tid":1,
            "tname":"测试"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|  参数   |   类型   |  描述  |
| :---: | :----: | :--: |
|  tid  | String | 任务id |
| tname | String | 任务名称 |

##### 4. 预测外呼任务报表

- URL:/api/report/ob/task
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                   描述                   |
| :------------: | :--: | :----: | :------------------------------------: |
|   tenancyId    |  必选  | String |                 所属企业id                 |
| organizationId |  必选  | String |                 所属机构id                 |
|  departmentId  |  必选  | String |                 所属部门id                 |
|      type      | 非必选  |  Int   |  报表类型，默认日报表，0：日报表，1：周报表，2：月报表，3：自定义时段  |
|   startTime    |  必选  | string |                  开始时间                  |
|    endTime     |  必选  | string |                  结束时间                  |
| splitTimeType  | 非必选  |  Int   |   分时报表类型，默认各时段累计 ，1：各时段累计，2：各时段连续显示    |
|   startHour    | 非必选  | Float  |                统计时段起始值                 |
|    endHour     | 非必选  | Float  |                统计时段终止值                 |
|      tids      | 非必选  | String | 要统计的预览外呼任务，传递时用逗号连接的任务下标索引，通过任务列表接口获得  |
|     fields     | 非必选  | String | 要输出的字段，传递时使用逗号连接的字段下标索引，通过预览外呼座席字段接口获得 |
|     export     | 非必选  |  int   |     100：导出本页，200：导出全部，若导出返回导出文件url     |
|     start      | 非必选  | String |               当前页码,默认第一页               |
|     limit      | 非必选  | string |              每页记录数，默认10条               |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  | 预测外呼任务列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "task":"",
            "totalCount":"",
            "calledCount":"",
            "answerCount":"",
            "answerDelayTotal":"",
            "bridgeCount":"",
            "harassCount":"",
            "predictAdjust":"",
            "startTime":"",
            "overTime":"",
            "duration":"",
            "agentUtilization":"",
            "warmUp":"",
            "avgAnswerDelay":"",
            "harassRate":"",
            "harassRateRealtime":"",
            "answerRate":"",
            "answerRateRealtime":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|         参数         |   类型   |    描述    |
| :----------------: | :----: | :------: |
|        task        | String |    任务    |
|     totalCount     | String |   号码总数   |
|    calledCount     | String |   呼叫数    |
|    answerCount     | String |   应答数    |
|  answerDelayTotal  | String |  平均延时时间  |
|    bridgeCount     | String |  双方接听数   |
|    harassCount     | String |   骚扰数    |
|   predictAdjust    | String |   超呼系数   |
|     startTime      | String |   开始时间   |
|      overTime      | String |   结束时间   |
|      duration      | String |   持续时间   |
|  agentUtilization  | String |  座席利用率   |
|       warmUp       | String | 是否在预热阶段  |
|   avgAnswerDelay   | String | 平均延迟应答时间 |
|     harassRate     | String |   骚扰率    |
| harassRateRealtime | String |  实际骚扰率   |
|     answerRate     | String |   应答率    |
| answerRateRealtime | String |  实际应答率   |

### 质检管理

#### 案例组管理

##### 1. 查看案例组列表

- URL:/api/quality/group
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |     描述      |
| :------------: | :--: | :----: | :---------: |
|   tenancyId    |  必选  | String |   所属企业id    |
| organizationId |  必选  | String |   所属机构id    |
|  departmentId  |  必选  | String |   所属部门id    |
|     start      | 非必选  | String | 当前页码,默认第一页  |
|     limit      | 非必选  | string | 每页记录数，默认10条 |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  案例组管理列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"",
            "enterpriseId":"",
            "name":"",
            "comment":"",
            "creaTime":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|      参数      |   类型   |  描述  |
| :----------: | :----: | :--: |
|      id      | String | 主键id |
| enterpriseId | String | 企业id |
|     name     | String |  组名  |
|   comment    | String |  描述  |
|   creaTime   | String | 创建时间 |

##### 2. 新增案例组

- URL:/api/quality/group
- Method:POST
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |   描述   |
| :----------: | :--: | :----: | :----: |
|     name     |  必选  | String |   组名   |
|   comment    |  必选  | String |   描述   |
| departmentId |  必选  | String | 所属部门id |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | object |   案例组对象   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "enterpriseId":"10001",
            "name":"测试",
            "comment":"测试",
            "creaTime":"2018-01-02 15:40:00"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

##### 3. 修改案例组

- URL:/api/quality/group
- Method:PUT
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |   描述   |
| :----------: | :--: | :----: | :----: |
|      id      |  必选  | String |  主键id  |
| departmentId |  必选  | String | 所属部门id |
|     name     |  必选  | String |   组名   |
|   comment    |  必选  | String |   描述   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | object |   案例组对象   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "enterpriseId":"10001",
            "name":"测试",
            "comment":"测试",
            "creaTime":"2018-01-02 15:40:00"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

##### 4. 删除案例组

- URL:/api/quality/group
- Method:DELETE
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |   描述   |
| :----------: | :--: | :----: | :----: |
|      id      |  必选  | String |  主键id  |
| departmentId |  必选  | String | 所属部门id |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": []
}
```

#### 录音管理

- URL:/api/quality/record
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |                    描述                    |
| :------------: | :--: | :----: | :--------------------------------------: |
|   tenancyId    |  必选  | String |                  所属企业id                  |
| organizationId |  必选  | String |                  所属机构id                  |
|  departmentId  |  必选  | String |                  所属部门id                  |
|    callType    | 非必选  |  Int   |        默认来电，1：来电，4：外呼，5：webcall外呼        |
| conditionName  | 非必选  | String | 搜索条件，cno：座席工号，agent_number：坐席电话，customer_number：客户电话，queue_no：队列号，queue_name：队列名称 |
| conditionValue | 非必选  | String |                  搜索条件取值                  |
|   startTime    | 非必选  | String |                   起始时间                   |
|    endTime     | 非必选  | String |                   终止时间                   |
| startDuration  | 非必选  | String |                 通话时长起始值                  |
|  endDuration   | 非必选  | String |                 通话时长终止值                  |
|  samplingMode  | 非必选  |  Int   |     抽样方式，-1：不抽样，1：按比例随机抽样，2：按绝对数随机抽样     |
|    percent     | 非必选  | String |                   抽样比例                   |
|   absNumber    | 非必选  |  Int   |                   抽样数目                   |
|     limit      | 非必选  | string |               每页记录数，默认10条                |
|     start      | 非必选  | String |                当前页码,默认第一页                |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  录音管理列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "uniqueId":"123",
            "callType":"",
            "cno":"",
            "agentName":"",
            "agentCrmId":"",
            "agentNumber":"",
            "businessType":"",
            "customerNumber":"",
            "endTime":"",
            "hotline":"",
            "inCaseLib":"",
            "inCaseLibStr":"",
            "numberTrunk":"",
            "qno":"",
            "queueName":"",
            "recordFile":"",
            "recordFileNames":"",
            "score":"",
            "scoreComment":"",
            "startTime":"",
            "taskId":"",
            "taskName":"",
            "totalDuration":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|       参数       |    类型    |                    描述                    |
| :------------: | :------: | :--------------------------------------: |
|       id       |  String  |                 通话记录唯一标识                 |
|      cno       |  String  |                   座席工号                   |
|   agentName    |  String  |                   座席姓名                   |
|  agentNumber   |  String  |                   座席电话                   |
| customerNumber |  String  |                   客户电话                   |
|      qno       |  String  |                   队列号                    |
|   queueName    |  String  |                   队列名称                   |
|    hotline     |  String  |                   热线号码                   |
|    callType    |   Int    | 呼叫类型，1：来电，2 or 5：webcall外呼，4 or 6 or 9：外呼 |
|   startTime    |  String  |                   开始时间                   |
|    endTime     |  String  |                   结束时间                   |
| totalDuration  |  String  |                  通话总时长                   |
| recordFileName | String[] |                  录音文件名称                  |
|    uniqueId    |  String  |                  电话唯一标示                  |
|     score      |   int    |                   录音分数                   |
|  scoreComment  |  String  |                   评分备注                   |
|   inCaseLib    |   int    |                是否在案例库中的代码                |
|  inCaseLibStr  |  String  |               是否在案例库中的中文描述               |

##### 1. 录音接口（试听或下载）

- URL:/api/quality/recordUrl
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |       描述        |
| :----------: | :--: | :----: | :-------------: |
|   fileName   |  必选  | String |      文件名称       |
| recordFormat |  必选  | String |      录音格式       |
|   download   |  必选  | String | 是否下载，下载：1，不下载为空 |
| departmentId | 非必选  |  Int   |      部门id       |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  录音管理列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "url":"http://voice-dev.cticloud.cn/27122017/record/6000001/6000001-20171227181623-01012345678-15810656011--record-sip-1-1514369783.5.mp3",
    "result":"success"
}
```

字段说明：

|   参数   |   类型   |   描述    |
| :----: | :----: | :-----: |
|  url   | String | 访问录音url |
| result | String |  成功标志   |

##### 2. 彩铃录音接口（试听或下载）

- URL:/api/quality/recordRingUrl
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |       描述        |
| :----------: | :--: | :----: | :-------------: |
|   fileName   |  必选  | String |      文件名称       |
| recordFormat |  必选  | String |      录音格式       |
|   download   |  必选  | String | 是否下载，下载：1，不下载为空 |
| departmentId | 非必选  |  Int   |      部门id       |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  录音管理列表   |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "url":"http://voice-dev.cticloud.cn/27122017/record/6000001/6000001-20171227181623-01012345678-15810656011--record-sip-1-1514369783.5.mp3",
    "result":"success"
}
```

字段说明：

|   参数   |   类型   |   描述    |
| :----: | :----: | :-----: |
|  url   | String | 访问录音url |
| result | String |  成功标志   |

##### 3. 录音评分

- URL:/api/quality/recordMarking
- Method:GET
- Content type: application/json
- 输入参数：

|      参数      |  要求  |   类型   |       描述        |
| :----------: | :--: | :----: | :-------------: |
|    score     |  必选  | String |       分数        |
| scoreComment | 非必选  | String |      分数备注       |
|   groupId    |  必选  | String |      案例组id      |
|   uniqueId   |  必选  | String |    通话录音唯一标识     |
|    cdrId     |  必选  | String | cdr_id串，中间用逗号分隔 |
|   callType   |  必选  | String |   呼叫类型，呼入还是外呼   |
| departmentId |  必选  | String |      部门id       |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功"
}
```

字段说明：

|   参数   |   类型   |       描述       |
| :----: | :----: | :------------: |
| status |  int   | 状态码，成功：0，失败：-1 |
|  msg   | String |      标志信息      |

##### 4. 添加录音到案例库

- URL:/api/quality/addRecord
- Method:POST
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |       描述        |
| :------------: | :--: | :----: | :-------------: |
| caseLibGroupId |  必选  | String |      案例组id      |
|    cdrIdStr    |  必选  | String | 语音文件id串，中间用逗号分隔 |
|    callType    |  必选  | String |   呼叫类型，呼入还是外呼   |
|  currentMonth  |  必选  | String |      当前月份       |
|  departmentId  |  必选  | String |      部门id       |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |

接口返回示例：

```
{
    "status": 0,
    "msg": "添加成功"
}
```



#### 案例库管理

- URL:/api/quality/caseLib
- Method:GET
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |     描述      |
| :------------: | :--: | :----: | :---------: |
|   tenancyId    |  必选  | String |   所属企业id    |
| organizationId |  必选  | String |   所属机构id    |
|  departmentId  |  必选  | String |   所属部门id    |
|    groupId     | 非必选  |  Int   |    案例组id    |
|      cno       | 非必选  | String |    座席工号     |
| customerNumber | 非必选  | String |    客户电话     |
|   startScore   | 非必选  | String |   录音分数起始值   |
|    endScore    | 非必选  | String |   录音分数终止值   |
|   startTime    | 非必选  | String |    起始时间     |
|    endTime     | 非必选  | String |    终止时间     |
|     limit      | 非必选  | string | 每页记录数，默认10条 |
|     start      | 非必选  | String | 当前页码,默认第一页  |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |
| result | array  |  案例库管理列表  |

接口返回示例：

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"597",
            "enterpriseId":"",
            "uniqueId":"sip-1-1513770382.884",
            "agentCrmId":"",
            "agentName":"ceshi",
            "businessType":"",
            "caseLibGroup":{
              "id":"9",
              "enterpriseId":"",
              "name":"5556",
              "comment":"",
              "creaTime":"2017-09-12 12:01:00"
            },
            "cno":"",
            "createTime":"",
            "customerNumber":"",
            "deleteTime":"",
            "duration":"",
            "endTime":"",
            "enterpriseId":"",
            "isDelete":"",
            "recordFile":"",
            "recordFileNames":"",
            "score":"",
            "scoreComment":"",
            "startTime":""
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

对象字段说明：

|       参数       |   类型   |          描述          |
| :------------: | :----: | :------------------: |
|       id       |  Int   |       案例库对象id        |
|      name      | String | 所属案例组,案例组对象字段的name字段 |
|      cno       | String |         座席工号         |
|   agentName    | String |         座席姓名         |
| customerNumber | String |         客户电话         |
| recordFileName | String |        录音文件名称        |
|     score      | String |         录音分数         |
|    duration    | String |         通话时长         |
|   startTime    | String |         开始时间         |
|    endTime     | String |         结束时间         |
|   createTime   | String |         加入时间         |
|  caseLibGroup  | object |        案例组对象         |

##### 1. 修改案例库

- URL:/api/quality/caseLib
- Method:PUT
- Content type: application/json
- 输入参数：

|       参数       |  要求  |   类型   |  描述   |
| :------------: | :--: | :----: | :---: |
|       id       |  必选  | String | 案例库id |
| caseLibGroupId |  必选  | String | 案例组id |
|     score      |  必选  | String |  评分   |
|  scoreComment  |  必选  | String | 评分说明  |
|  departmentId  |  必选  | String | 部门id  |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |

接口返回示例：

```
{
    "status": 0,
    "msg": "修改成功",
    "result":[]
}
```

##### 2. 删除案例库

- URL:/api/quality/caseLib
- Method:DELETE
- Content type: application/json
- 输入参数：

|      参数      |  要求  |    类型    |   描述    |
| :----------: | :--: | :------: | :-----: |
|  caseLibIds  |  必选  | String[] | 案例库id数组 |
| departmentId |  必选  |  String  |  部门id   |

接口返回说明：

|   参数   |   类型   |    描述     |
| :----: | :----: | :-------: |
| status |  int   |    状态码    |
|  msg   | String | 状态说明，例如成功 |

接口返回示例：

```
{
    "status": 0,
    "msg": "删除成功",
    "result":[]
}
```

##### 