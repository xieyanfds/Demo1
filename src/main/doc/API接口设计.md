## API接口设计

### 目录
[交互数据结构](#交互数据结构)

[登录相关接口](#登录相关接口)

[&emsp;&emsp;1.系统管理员登录](#1-系统管理员登录)

[&emsp;&emsp;2.登出](#2-登出)

[&emsp;&emsp;3.获取验证码](#3-获取验证码)

[操作日志](#操作日志)

[&emsp;&emsp;获取操作日志列表](#获取操作日志列表)


[告警信息](#告警信息)

[&emsp;&emsp;&emsp;&emsp;1.新增告警信息](#1-新增告警信息)

[&emsp;&emsp;&emsp;&emsp;2.处理告警信息](#2-处理告警信息)

[&emsp;&emsp;&emsp;&emsp;3.显示告警信息](#3-显示告警信息)


[业务管理](#业务管理)

[&emsp;&emsp;&emsp;&emsp;1.新增业务](#1-新增业务)

[&emsp;&emsp;&emsp;&emsp;2.删除业务](#2-删除业务)

[&emsp;&emsp;&emsp;&emsp;3.修改业务](#3-修改业务)

[&emsp;&emsp;&emsp;&emsp;4.获取业务列表](#4-获取业务列表)

[&emsp;&emsp;业务路由](#业务路由)

[&emsp;&emsp;&emsp;&emsp;1.新增路由](#1-新增路由)

[&emsp;&emsp;&emsp;&emsp;2.删除路由](#2-删除路由)

[&emsp;&emsp;&emsp;&emsp;3.修改路由](#3-修改路由)

[&emsp;&emsp;&emsp;&emsp;4.获取路由列表](#4-获取路由列表)

[&emsp;&emsp;&emsp;&emsp;5.更新路由action](#5-更新路由action)

[&emsp;&emsp;&emsp;&emsp;6.获取路由action列表](#6-获取路由action列表)


[系统设置](#系统设置)

[&emsp;&emsp;实例管理](#实例管理)

[&emsp;&emsp;&emsp;&emsp;1.新增实例](#1-新增实例)

[&emsp;&emsp;&emsp;&emsp;2.删除实例](#2-删除实例)

[&emsp;&emsp;&emsp;&emsp;3.修改实例](#3-修改实例)

[&emsp;&emsp;&emsp;&emsp;4.获取实例列表](#4-获取实例列表)


[&emsp;&emsp;产品管理](#产品管理)

[&emsp;&emsp;&emsp;&emsp;1.新增产品线](#1-新增产品线)

[&emsp;&emsp;&emsp;&emsp;2.删除产品线](#2-删除产品线)

[&emsp;&emsp;&emsp;&emsp;3.修改产品线](#3-修改产品线)

[&emsp;&emsp;&emsp;&emsp;4.获取产品线列表](#4-获取产品线列表)

[&emsp;&emsp;&emsp;&emsp;5.修改产品设置](#5-修改产品设置)

[&emsp;&emsp;&emsp;&emsp;6.获取产品设置列表](#6-获取产品设置列表)


[&emsp;&emsp;平台管理](#平台管理)

[&emsp;&emsp;&emsp;&emsp;1.新增平台](#1-新增平台)

[&emsp;&emsp;&emsp;&emsp;2.删除平台](#2-删除平台)

[&emsp;&emsp;&emsp;&emsp;3.修改平台](#3-修改平台)

[&emsp;&emsp;&emsp;&emsp;4.获取平台列表](#4-获取平台列表)


[&emsp;&emsp;参数设置](#参数设置)


[&emsp;&emsp;&emsp;&emsp;1.修改参数设置](#1-修改参数设置)

[&emsp;&emsp;&emsp;&emsp;2.获取参数设置列表](#2-获取参数设置列表)


[&emsp;&emsp;用户管理](#用户管理)

[&emsp;&emsp;&emsp;&emsp;1.新增用户](#1-新增用户)

[&emsp;&emsp;&emsp;&emsp;2.删除用户](#2-删除用户)

[&emsp;&emsp;&emsp;&emsp;3.修改用户](#3-修改用户)

[&emsp;&emsp;&emsp;&emsp;4.获取用户列表](#4-获取用户列表)

[&emsp;&emsp;&emsp;&emsp;5.修改密码](#5-修改密码)

[&emsp;&emsp;角色管理](#角色管理)

[&emsp;&emsp;&emsp;&emsp;1.新增角色](#1-新增角色)

[&emsp;&emsp;&emsp;&emsp;2.删除角色](#2-删除角色)

[&emsp;&emsp;&emsp;&emsp;3.修改角色](#3-修改角色)

[&emsp;&emsp;&emsp;&emsp;4.获取角色列表](#4-获取角色列表)

[&emsp;&emsp;&emsp;&emsp;5.角色管理模块](#5-角色管理模块)


[&emsp;&emsp;模块管理](#模块管理)

[&emsp;&emsp;&emsp;&emsp;1.获取模块列表](#1-获取模块列表)

[&emsp;&emsp;ACL管理](#acl管理)

[&emsp;&emsp;&emsp;&emsp;1.新增白名单](#1-新增白名单)

[&emsp;&emsp;&emsp;&emsp;2.删除白名单](#2-删除白名单)

[&emsp;&emsp;&emsp;&emsp;3.获取白名单列表](#3-获取白名单列表)


[&emsp;&emsp;实时统计管理](#实时统计管理)

[&emsp;&emsp;&emsp;&emsp;1.新增实时统计组](#1-新增实时统计组)

[&emsp;&emsp;&emsp;&emsp;2.删除实时统计组](#2-删除实时统计组)

[&emsp;&emsp;&emsp;&emsp;3.修改实时统计组](#3-修改实时统计组)

[&emsp;&emsp;&emsp;&emsp;4.获取实时统计组列表](#4-获取实时统计组列表)

[&emsp;&emsp;&emsp;&emsp;5.新增实时统计](#5-新增实时统计)

[&emsp;&emsp;&emsp;&emsp;6.删除实时统计](#6-删除实时统计)

[&emsp;&emsp;&emsp;&emsp;7.修改实时统计](#7-修改实时统计)

[&emsp;&emsp;&emsp;&emsp;8.获取实时统计列表](#8-获取实时统计列表)

[&emsp;&emsp;&emsp;&emsp;9.获取固定统计参数](#9-获取固定统计参数)

[&emsp;&emsp;&emsp;&emsp;10.获取产品统计](#10-获取产品统计)

[&emsp;&emsp;&emsp;&emsp;11.获取平台统计](#11-获取平台统计)

[&emsp;&emsp;&emsp;&emsp;12.获取业务统计](#12-获取业务统计)

[&emsp;&emsp;&emsp;&emsp;13.获取中继组统计](#13-获取中继组统计)

[&emsp;&emsp;&emsp;&emsp;14.获取网关统计](#14-获取网关统计)

[&emsp;&emsp;告警管理](#告警管理)

[&emsp;&emsp;&emsp;&emsp;1.新增告警设置](#1-新增告警设置)

[&emsp;&emsp;&emsp;&emsp;2.删除告警设置](#2-删除告警设置)

[&emsp;&emsp;&emsp;&emsp;3.修改告警设置](#3-修改告警设置)

[&emsp;&emsp;&emsp;&emsp;4.获取告警设置列表](#4-获取告警设置列表)

[对接设置](#对接设置)

[&emsp;&emsp;对接中继组](#对接中继组)

[&emsp;&emsp;&emsp;&emsp;1.新增中继组](#1-新增中继组)

[&emsp;&emsp;&emsp;&emsp;2.删除中继组](#2-删除中继组)

[&emsp;&emsp;&emsp;&emsp;3.修改中继组](#3-修改中继组)

[&emsp;&emsp;&emsp;&emsp;4.获取中继组列表](#4-获取中继组列表)

[&emsp;&emsp;&emsp;&emsp;5.中继组新增网关](#5-中继组新增网关)

[&emsp;&emsp;&emsp;&emsp;6.中继组删除网关](#6-中继组删除网关)

[&emsp;&emsp;&emsp;&emsp;7.查询中继组下所有网关](#7-查询中继组下所有网关)

[&emsp;&emsp;对接网关](#对接网关)

[&emsp;&emsp;&emsp;&emsp;1.新增网关](#1-新增网关)

[&emsp;&emsp;&emsp;&emsp;2.删除网关](#2-删除网关)

[&emsp;&emsp;&emsp;&emsp;3.修改网关](#3-修改网关)

[&emsp;&emsp;&emsp;&emsp;4.获取网关列表](#4-获取网关列表)

[工具](#工具)

[&emsp;&emsp;路由分析](#路由分析)

[通话记录](#通话记录)

[&emsp;&emsp;1.话单查询](#1-话单查询)

[报表](#报表)

[&emsp;&emsp;1.业务日报查询](#1-业务日报查询)

[&emsp;&emsp;2.业务月报查询](#2-业务月报查询)

[&emsp;&emsp;3.网关日报查询](#3-网关日报查询)

[&emsp;&emsp;4.网关月报查询](#4-网关月报查询)

[gateway状态更新](#gateway状态更新)

[&emsp;&emsp;1.gateway状态更新](#1-gateway状态更新)

[获取opensips状态](#获取opensips状态)

[&emsp;&emsp;1.获取opensips启动时间](#1-获取opensips启动时间)




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
### 登录相关接口
#### 1. 系统管理员登录
* URL:/api/login
* Method:POST
* Content type: application/json
* 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明       |
| ------------ | ---- | ------ | -------- |
| userName     | 是    | String | 用户名      |
| authCode     | 是    | String | 密码       |
| securityCode | 是    | String | 用户输入的验证码 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

#### 2. 登出
* URL:/api/logout
* Method:POST
* Content type: application/json
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

#### 3. 获取验证码
* URL:/api/loginSecurityCodeImage
* Method:GET 
* 输入参数：无
* 返回结果：验证码图片

### 日志
#### 1. 获取操作日志列表
* URL:/api/logActions
* Method:GET
* 输入参数：

| 参数名           | 是否必填 | 数据类型 | 说明           |
| ------------- | ---- | ---- | ------------ |
| userId        | 否    | int  | user.id      |
| time          | 否    | int  | 操作时间         |
| currentPageNo | 否    | int  | 页码，默认第一页     |
| pageSize      | 否    | int  | 每页数据条数，默认20条 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
 	  	   "id":"1",
            "userId":"1",
            "type":"2",
            "object":"product",
            "ip":"10.3.8.211", 
            "createTime": "2017-10-20 09:20:12"
         }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```
* 返回对象描述

| 字段         | 类型     | 描述                             |
| ---------- | ------ | ------------------------------ |
| id         | int    | log_action.id                  |
| userId     | int    | user.id                        |
| type       | int    | 1:增 2:删 3:改 4:查 5:导出 6:登录 7:退出 |
| object     | String | 操作对象描述                         |
| ip         | String | 请求的ip地址来源                      |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss    |

#### 2. 获取操作路由日志

- URL:/api/logRouters
- Method:GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明      |
| ------ | ---- | ------ | ------- |
| callId | 是    | String | call-id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "callId":"28384jsfjksdlf",
            "routeId":"2",
            "requestTime":"2017-10-20 09:20:12.111",
            "actions":"[\"ACTION_NOOP: param(1)=1 RESULT: 2\",\"ACTION_SET_VAR: param(1)=a param(2)=b param(3)=3 RESULT: name=a value=1\"]", 
            "createTime": "2017-10-20 09:20:12"
       		}   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```

- 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| id         | int    | log_router.id               |
| callId     | int    | call-id                     |
| routeId    | int    | router.id                   |
| actions    | array  | 操作对象描述字符串数组                 |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

### 告警信息

#### 1. 新增告警信息
* URL:/api/alerts
* Method:POST
* Content type: application/json
* 输入参数：json

| 参数名         | 是否必填 | 数据类型   | 说明                   |
| ----------- | ---- | ------ | -------------------- |
| level       | 是    | int    | 告警级别 1:警告 2:错误       |
| type        | 是    | int    | 告警类别：1:系统、2:业务、3:自定义 |
| name        | 是    | String | 名字                   |
| description | 否    | String | 描述                   |
| msg         | 是    | String | 告警消息                 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": 
        {
            "id":"1",
            "level":"1",
            "type":"1",
            "name":"alert1",
            "msg":"连接中断",
            "ack":"0",
            "createTime": "2017-10-20 09:20:12"
        }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| level       | int    | 告警级别 1:警告 2:错误              |
| type        | int    | 告警类别：1:系统、2:业务、3:自定义        |
| name        | String | 名字                          |
| description | String | 描述                          |
| msg         | String | 告警消息                        |
| ack         | int    | 是否已处理 1已处理 0 未处理            |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### 2. 处理告警信息
* URL:/api/alerts/{id}
* Method:PUT
* Content type: application/json

&emsp;&emsp;处理告警信息，ack为1则不用处理，否则将ack设置为1
* 输入参数：

| 参数名  | 是否必填 | 数据类型 | 说明           |
| ---- | ---- | ---- | ------------ |
| id   | 是    |      | log_alert.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": 
        {
            "id":"1",
            "level":"1",
            "type":"1",
            "name":"alert1",
            "msg":"连接中断",
            "ack":"1",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| level       | int    | 告警级别 1:警告 2:错误              |
| type        | int    | 告警类别：1:系统、2:业务、3:自定义        |
| name        | String | 名字                          |
| description | String | 描述                          |
| msg         | String | 告警消息                        |
| ack         | int    | 是否已处理 1已处理 0 未处理            |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |


#### 3. 显示告警信息
* URL:/api/alerts
* Method:GET
* 输入参数：

| 参数名           | 是否必填 | 数据类型   | 说明                   |
| ------------- | ---- | ------ | -------------------- |
| level         | 否    | int    | 告警级别 1:警告 2:错误       |
| type          | 否    | int    | 告警类别：1:系统、2:业务、3:自定义 |
| msg           | 否    | String | 告警消息                 |
| ack           | 否    | int    | 是否已处理 1已处理 0 未处理     |
| currentPageNo | 否    | int    | 页码，默认第一页             |
| pageSize      | 否    | int    | 每页数据条数，默认20条         |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "level":"1",
            "type":"1",
            "name":"alert1",
            "msg":"连接中断",
            "ack":"0",
            "createTime": "2017-10-20 09:20:12"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| level       | int    | 告警级别 1:警告 2:错误              |
| type        | int    | 告警类别：1:系统、2:业务、3:自定义        |
| name        | String | 名字                          |
| description | String | 描述                          |
| msg         | String | 告警消息                        |
| ack         | int    | 是否已处理 1已处理 0 未处理            |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

### 业务管理
#### 业务列表
##### 1. 新增业务
* URL: /api/serviceManage/services
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                            |
| ----------- | ---- | ------ | ----------------------------- |
| name        | 是    | String | 业务名称                          |
| prefix      | 是    | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domainId    | 是    | int    | domain.id                     |
| description | 否    | String | 描述                            |
| active      | 是    | int    | 是否激活 1 激活  0 未激活              |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"预览外呼客户侧天润线路",
        "prefix":"200",
        "domainId":"1",
        "description":"预览外呼客户侧天润线路",
        "active":"1",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                            |
| ----------- | ------ | ----------------------------- |
| id          | int    | service.id                    |
| name        | String | 业务名称                          |
| prefix      | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domainId    | int    | domain.id                     |
| description | String | 描述                            |
| active      | int    | 是否激活 1 激活  0 未激活              |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss   |

##### 2. 删除业务
* URL: /api/serviceManage/services/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改业务
* URL: /api/serviceManage/services
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                            |
| ----------- | ---- | ------ | ----------------------------- |
| id          | 是    | int    | service.id                    |
| name        | 否    | String | 业务名称                          |
| prefix      | 否    | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domainId    | 否    | int    | domain.id                     |
| description | 否    | String | 描述                            |
| active      | 否    | int    | 是否激活 1 激活  0 未激活              |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"预览外呼客户侧天润线路",
        "prefix":"200",
        "domainId":"1",
        "description":"预览外呼客户侧天润线路",
        "active":"1",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                            |
| ----------- | ------ | ----------------------------- |
| id          | int    | service.id                    |
| name        | String | 业务名称                          |
| prefix      | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domainId    | int    | domain.id                     |
| description | String | 描述                            |
| active      | int    | 是否激活 1 激活  0 未激活              |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss   |

##### 4. 获取业务列表
* URL:/api/serviceManage/services
* Method:GET
* 输入参数：

| 参数名           | 是否必填 | 数据类型   | 说明                            |
| ------------- | ---- | ------ | ----------------------------- |
| productId     | 否    | String | product.id                    |
| domainId      | 否    | String | domain.id                     |
| prefix        | 否    | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| description   | 否    | String | 描述                            |
| currentPageNo | 否    | int    | 页码，默认第一页                      |
| pageSize      | 否    | int    | 每页数据条数，默认20条                  |

* 返回结果：

| 字段     | 数据类型   | 说明                              |
| ------ | ------ | ------------------------------- |
| status | int    | 0成功，-1失败                        |
| msg    | String | 状态说明，例如成功                       |
| result | array  | service嵌套domain，domain嵌套product |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"预览外呼客户侧天润线路",
            "prefix":"200",
            "domain":{
                "id": "2001",
                "name":"ali1",
                "callbackUrl":"http://api/......",
                "product":{
                    "id": "1001",
                    "name":"CTIcloud",
                    "description":"CTIcloud产品线",
                    "createTime": "2017-10-20 09:20:12"
                },
                "description":"CTIcloud产品线ali1平台",
                "createTime": "2017-10-20 09:20:12"    
            },
            "description":"预览外呼客户侧天润线路",
            "active":"1",
            "createTime": "2017-10-20 09:20:12"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```
* 返回对象描述

| 字段          | 类型     | 描述                            |
| ----------- | ------ | ----------------------------- |
| id          | int    | service.id                    |
| name        | String | 业务名称                          |
| prefix      | String | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domain      | object | domain对象                      |
| description | String | 描述                            |
| active      | int    | 是否激活 1 激活  0 未激活              |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss   |

#### 业务路由

router字段内容格式定义：

| 字段名       | 格式         | 说明                                       | 示例                                       |
| --------- | ---------- | ---------------------------------------- | ---------------------------------------- |
| telRegex  | string     | 正则表达式                                    | ^010                                     |
| clidRegex | string     | 正则表达式                                    | ^8917                                    |
| timeRegex | json array | [{"dayOfWeek":"1,2,3,4,5,6,7", "timeStart": "09:00", "timeEnd": "23:00"}] 星期1-7表示周日-周六 | {"dayOfWeek":"1,2,3,4,5", "timeStart": "09:00", "timeEnd": "23:00"} |

##### 1. 新增路由
* URL: /api/serviceManage/routers
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明                         |
| ------------ | ---- | ------ | -------------------------- |
| serviceId    | 是    | int    | service.id                 |
| priority     | 是    | int    | 优先级，越大越优先                  |
| telRegex     | 否    | String | 被叫号码，支持正则表达式，为空表示不限制，带区号格式 |
| clidRegex    | 否    | String | 主叫号码，支持正则表达式，为空表示不限制       |
| timeRegex    | 否    | String | 时间条件，支持正则表达式，为空表示不限制       |
| trunkGroupId | 是    | int    | trunk_group.id             |
| description  | 否    | String | 描述                         |
| active       | 是    | int    | 是否激活                       |
| tags         | 否    | String | json格式存储kv对，用于过滤和统计        |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id":"1",
        "serviceId":"1",
        "priority":"6",	
        "telRegex":"",			
        "clidRegex":"",		
        "timeRegex":"[{"dayOfWeek":"2,3,4,5,6", "timeStart": "09:00", "timeEnd": "23:00"}]",	
        "trunkRroupId":"1",	
        "description":"'自有电路工作时间路由",
        "active":"1",	
        "tags:"",	
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段           | 类型     | 描述                          |
| ------------ | ------ | --------------------------- |
| id           | int    | router.id                   |
| serviceId    | int    | service.id                  |
| priority     | int    | 优先级，越大越优先                   |
| telRegex     | String | 被叫号码，支持正则表达式，为空表示不限制，带区号格式  |
| clidRegex    | String | 主叫号码，支持正则表达式，为空表示不限制        |
| timeRegex    | String | 时间条件，支持正则表达式，为空表示不限制        |
| trunkGroupId | int    | trunk_group.id              |
| description  | String | 描述                          |
| active       | int    | 是否激活                        |
| tags         | String | json格式存储kv对，用于过滤和统计         |
| createTime   | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除路由
* URL: /api/serviceManage/routers/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改路由
* URL: /api/serviceManage/routers
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明                         |
| ------------ | ---- | ------ | -------------------------- |
| id           | 是    | int    | router.id                  |
| serviceId    | 否    | int    | service.id                 |
| priority     | 否    | int    | 优先级，越大越优先                  |
| telRegex     | 是    | String | 被叫号码，支持正则表达式，为空表示不限制，带区号格式 |
| clidRegex    | 是    | String | 主叫号码，支持正则表达式，为空表示不限制       |
| timeRegex    | 是    | String | 时间条件，支持正则表达式，为空表示不限制       |
| trunkGroupId | 否    | int    | trunk_group.id             |
| description  | 否    | String | 描述                         |
| active       | 否    | int    | 是否激活                       |
| tags         | 否    | String | json格式存储kv对，用于过滤和统计        |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id":"1",
        "serviceId":"1",
        "priority":"6",	
        "telRegex":"",			
        "clidRegex":"",		
        "timeRegex":"[{"dayOfWeek":"2,3,4,5,6", "timeStart": "09:00", "timeEnd": "23:00"}]",	
        "trunkRroupId":"1",	
        "description":"'自有电路工作时间路由",
        "active":"1",	
        "tags:"",	
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段           | 类型     | 描述                          |
| ------------ | ------ | --------------------------- |
| id           | int    | router.id                   |
| serviceId    | int    | service.id                  |
| priority     | int    | 优先级，越大越优先                   |
| telRegex     | String | 被叫号码，支持正则表达式，为空表示不限制，带区号格式  |
| clidRegex    | String | 主叫号码，支持正则表达式，为空表示不限制        |
| timeRegex    | String | 时间条件，支持正则表达式，为空表示不限制        |
| trunkGroupId | int    | trunk_group.id              |
| description  | String | 描述                          |
| active       | int    | 是否激活                        |
| tags         | String | json格式存储kv对，用于过滤和统计         |
| createTime   | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取路由列表
* URL:/api/serviceManage/routers
* Method:GET
* 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明         |
| --------- | ---- | ---- | ---------- |
| serviceId | 是    | int  | service.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "serviceId":"1",
            "priority":"6",	
            "telRegex":"",			
            "clidRegex":"",		
            "timeRegex":"[{"dayOfWeek":"2,3,4,5,6", "timeStart": "09:00", "timeEnd": "23:00"}]",
            "trunkRroupId":"1",	
            "description":"'自有电路工作时间路由",
            "active":"1",	
            "tags:"",	
            "createTime": "2017-10-20 09:20:12"
        }
    ]
}
```
* 返回对象描述


| 字段           | 类型     | 描述                          |
| ------------ | ------ | --------------------------- |
| id           | int    | router.id                   |
| serviceId    | int    | service.id                  |
| priority     | int    | 优先级，越大越优先                   |
| telRegex     | String | 被叫号码，支持正则表达式，为空表示不限制，带区号格式  |
| clidRegex    | String | 主叫号码，支持正则表达式，为空表示不限制        |
| timeRegex    | String | 时间条件，支持正则表达式，为空表示不限制        |
| trunkGroupId | int    | trunk_group.id              |
| description  | String | 描述                          |
| active       | int    | 是否激活                        |
| tags         | String | json格式存储kv对，用于过滤和统计         |
| createTime   | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |


&emsp;&emsp;不同action type的property定义：

| type | 类型             | property格式                               | 示例                                       |
| ------ | -------------- | ---------------------------------------- | ---------------------------------------- |
| 1      | noop           | [{"nameType":1,"name":"$ci"},{"nameType":2,"name":"a"}] nameType=1是字符串 nameType=2是固定变量 nameType=3是avp变量 nameType=4是hdr变量 | "product_id:$var(product_id)"            |
| 2      | set_var        | {"name":"","value":"",valueType:1} value支持变量，设置到avp中 | {"name":"bt","value":"1"}/{"name":"ct","value":"$var(bt)"} |
| 3      | add_prefix     | {"valueType":1,"value":"$ci"}value支持变量   | 888/$var(bt)                             |
| 4      | remove_prefix  | 字符串：3去除3位前缀，支持1-10位                      | 3                                        |
| 5      | remove_codec   | 字符串：g729                                 | codec_delete("g729")                     |
| 6      | add_header     | {"name":"","value":"",valueType:1}value支持变量 |                                          |
| 7      | remove_header  | name支持变量{"nameType":2,"name":"$ci"}{"nameType":1,"name":"call_type"} | X-Asterisk-call_type                     |
| 8      | set_next_route | sip-route-next                           | 10.10.10.29:5060                         |
| 9      | set_clid       | {"valueType":2,"value":"$ci"}value支持变量   | 89170766/$var(customer_clid)             |
| 10     | set_dlg        | {"name":"all","nameType":1}name支持变量      | {"name":"all","nameType":1}/{"name":"call_type","nameType":2} |
| 11     | set_cdr_tag    | {"name":"","value":"",valueType:1}value支持变量 | {"name":"yewu","value":"a",valueType:2}  |


##### 5. 更新路由action
* URL: /api/serviceManage/actions
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名      | 是否必填 | 数据类型 | 说明         |
| -------- | ---- | ---- | ---------- |
| routerId | 是    | int  | router.id  |
| actions  | 是    | list | action对象数组 |

先删除router下所有action，再插入数组中的action，根据数组顺序确定优先级

action对象中的参数

| 参数名         | 是否必填 | 数据类型   | 说明           |
| ----------- | ---- | ------ | ------------ |
| type      | 是    | int    | 参考property定义 |
| property    | 是    | String | 参考property定义 |
| description | 否    | String | 描述           |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
             "id":"1",
             "routerId":"6",
             "priority":"1", 
             "action":"4",         
             "property":"2",	    
             "description":"remove_prefix",	
             "createTime": "2017-10-20 09:20:12"  
        },
        {
             "id":"2",
             "routerId":"6",
             "priority":"2", 
             "action":"2",         
             "property":"{"name":"a","value":"abc123",valueType:1}",	    
             "description":"set_var",	
             "createTime": "2017-10-20 09:20:12"              
        }
    ]  
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | action.id                   |
| routerId    | int    | router.id                   |
| priority    | int    | 优先级，从小到大执行                  |
| action      | int    | 参考property定义                |
| property    | String | 参考property定义                |
| description | String | 描述                          |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 6. 获取路由action列表
* URL:/api/serviceManage/actions
* Method:GET
* 输入参数：

| 参数名      | 是否必填 | 数据类型 | 说明        |
| -------- | ---- | ---- | --------- |
| routerId | 是    | int  | router.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
             "id":"1",
             "routerId":"6",
             "priority":"4", 
             "action":"4",         
             "property":"2",	    
             "description":"remove_prefix",	
             "createTime": "2017-10-20 09:20:12"  
        }
    ]  
}
```
* 返回对象描述

&emsp;&emsp;router

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | action.id                   |
| routerId    | int    | router.id                   |
| priority    | int    | 优先级，从小到大执行                  |
| action      | int    | 参考property定义                |
| property    | String | 参考property定义                |
| description | String | 描述                          |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

### 系统设置
#### 实例管理
##### 1. 新增实例
* URL: /api/system/instances
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明            |
| ----------- | ---- | ------ | ------------- |
| name        | 是    | String | opensips名称    |
| description | 否    | String | 描述            |
| ip          | 是    | String | sip-router ip |
| miUrl       | 是    | String | mi接口地址        |
| active      | 是    | int    | 是否激活          |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"opensips1",
        "description":"opensip1",
        "ip":"172.16.203.18",
        "miUrl":"http://172.16.203.18:8089/json",
        "active":"1",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | opensips.id                 |
| name        | String | opensips名称                  |
| description | String | 描述                          |
| ip          | String | sip-router ip               |
| miUrl       | String | mi接口地址                      |
| active      | int    | 是否激活                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除实例
* URL: /api/system/instances/{id}
* Method: DELETE
* 输入参数：

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改实例
* URL: /api/system/instances
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明            |
| ----------- | ---- | ------ | ------------- |
| id          | 是    | int    | opensips.id   |
| name        | 否    | String | opensips名称    |
| description | 否    | String | 描述            |
| ip          | 否    | String | sip-router ip |
| miUrl       | 否    | String | mi接口地址        |
| active      | 否    | int    | 是否激活          |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
         "id": "1",
         "name":"opensips1",
         "description":"opensip1",
         "ip":"172.16.203.18",
         "miUrl":"http://172.16.203.18:8089/json",
         "active":"1",
         "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | opensips.id                 |
| name        | String | opensips名称                  |
| description | String | 描述                          |
| ip          | String | sip-router ip               |
| miUrl       | String | mi接口地址                      |
| active      | int    | 是否激活                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取实例列表
* URL:/api/system/instances
* Method:GET
* 输入参数：无
* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"opensips1",
            "description":"opensip1",
            "ip":"172.16.203.18",
            "miUrl":"http://172.16.203.18:8089/json",
            "active":"1",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述


| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | opensips.id                 |
| name        | String | opensips名称                  |
| description | String | 描述                          |
| ip          | String | sip-router ip               |
| miUrl       | String | mi接口地址                      |
| active      | int    | 是否激活                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### 产品管理
##### 1. 新增产品线
* URL: /api/system/products
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明    |
| ----------- | ---- | ------ | ----- |
| name        | 是    | String | 产品线名称 |
| description | 否    | String | 产品线描述 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"CTICloud",
        "description":"CTICloud大型呼叫中心平台",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | product.id                  |
| name        | String | 产品线名称                       |
| description | String | 产品线描述                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除产品线
* URL: /api/system/products/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改产品线
* URL: /api/system/products
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明         |
| ----------- | ---- | ------ | ---------- |
| id          | 是    | int    | product.id |
| name        | 否    | String | 产品线名称      |
| description | 否    | String | 产品线描述      |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"CTICloud",
        "description":"CTICloud大型呼叫中心平台",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | product.id                  |
| name        | String | 产品线名称                       |
| description | String | 产品线描述                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取产品线列表
* URL:/api/system/products
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"CTICloud",
            "description":"CTICloud大型呼叫中心平台",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]  
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | product.id                  |
| name        | String | 产品线名称                       |
| description | String | 产品线描述                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 5. 修改产品设置
* URL:/api/system/product/settings
* Method:POST
* Content type: application/json

&emsp;&emsp;支持修改的设置名：

| 设置名       | 数据类型 | 说明           |
| --------- | ---- | ------------ |
| max_cps   | int  | 产品线最大并发cps   |
| max_calls | int  | 产品线最大并发calls |


* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明         |
| ----------- | ---- | ------ | ---------- |
| name        | 是    | String | 设置名        |
| productId   | 否    | int    | product.id |
| value       | 否    | String | 设置值        |
| property    | 否    | String | 设置属性       |
| description | 否    | String | 设置描述       |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "productId":"1",
        "name":"max_cps",	  
        "value":"500",
        "property":"当前版本",
        "description":"产品最大并发cps",	  
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | product_setting.id          |
| productId   | int    | product.id                  |
| name        | String | 设置名                         |
| value       | String | 设置的值                        |
| property    | String | 设置的属性                       |
| description | String | 设置描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 6. 获取产品设置列表
* URL:/api/system/product/settings
* Method:GET
* 输入参数：

| 参数名       | 是否必填 | 数据类型 | 说明         |
| --------- | ---- | ---- | ---------- |
| productId | 是    | int  | product.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "productId"
            "name":"max_cps",	  
            "value":"500",
            "property":"当前版本",
            "description":"产品最大并发cps",	  
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | product_setting.id          |
| productId   | int    | product.id                  |
| name        | String | 设置名                         |
| value       | String | 设置的值                        |
| property    | String | 设置的属性                       |
| description | String | 设置描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### 平台管理
##### 1. 新增平台
* URL: /api/system/domains
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明         |
| ----------- | ---- | ------ | ---------- |
| name        | 是    | String | 平台名称       |
| callbackUrl | 否    | String | 回调URL      |
| productId   | 是    | int    | product.id |
| description | 否    | String | 描述         |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"AWS2",
        "callbackUrl":"",
        "productId":"1"
        "description":"CTICloud AWS2平台",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | domain.id                   |
| name        | String | 平台名称                        |
| callbackUrl | String | 回调URL                       |
| productId   | int    | product.id                  |
| description | String | 描述                          |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除平台
* URL: /api/system/domains/{id}
* Method: DELETE
* Content type: application/json
* 输入参数：

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改平台
* URL: /api/system/domains
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明         |
| ----------- | ---- | ------ | ---------- |
| id          | 是    | int    | domain.id  |
| name        | 否    | String | 平台名称       |
| callbackUrl | 否    | String | 回调URL      |
| productId   | 否    | int    | product.id |
| description | 否    | String | 描述         |


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"AWS2",
        "callbackUrl":"",
        "productId":"1"
        "description":"CTICloud AWS2平台",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | domain.id                   |
| name        | String | 平台名称                        |
| callbackUrl | String | 回调URL                       |
| productId   | int    | product.id                  |
| description | String | 描述                          |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取平台列表
* URL:/api/system/domains
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"AWS2",
            "callbackUrl":"",
            "product"：{
                "id": "1",
                "name":"CTICloud",
                "description":"CTICloud大型呼叫中心平台",
                "createTime": "2017-10-20 09:20:12"    
            },
            "description":"CTICloud AWS2平台",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                      |
| ----------- | ------ | ----------------------- |
| id          | int    | domain.id               |
| name        | String | 平台名称                    |
| callbackUrl | String | 回调URL                   |
| product     | object | product对象               |
| description | String | 描述                      |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:m |

#### 参数设置

&emsp;&emsp;支持的设置名：version

| 设置名     | 数据类型 | 说明   |
| ------- | ---- | ---- |
| version | int  | 当前版本 |

##### 1. 修改参数设置
* URL: /api/system/settings
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                      |
| ----------- | ---- | ------ | ----------------------- |
| name        | 是    | String | 设置名                     |
| value       | 是    | String | 设置的value，具体格式与name关联    |
| property    | 是    | String | 设置的property，具体格式与name关联 |
| description | 否    | String | 设置描述                    |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"version",	  
        "value":"0.1",
        "property":"当前版本",
        "description":"",	  
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | id                          |
| name        | String | 设置名                         |
| value       | String | 设置的value，具体格式与name关联        |
| property    | String | 设置的property，具体格式与name关联     |
| description | String | 设置描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 获取参数设置列表
* URL:/api/system/systemSettings
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"version",	  
            "value":"0.1",
            "property":"当前版本",
            "description":"",	  
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | id                          |
| name        | String | 设置名                         |
| value       | String | 设置的value，具体格式与name关联        |
| property    | String | 设置的property，具体格式与name关联     |
| description | String | 设置描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### 用户管理
##### 1. 新增用户
* URL: /api/system/users
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名      | 是否必填 | 数据类型   | 说明        |
| -------- | ---- | ------ | --------- |
| username | 是    | String | 用户名       |
| password | 是    | String | 密码，md5后存储 |
| mobile   | 否    | String | 手机号码      |
| email    | 否    | String | 邮件地址      |
| roleId   | 是    | int    | roie.id   |


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "username":"张三",	 
        "mobile":"18811795226",
        "email":"zhangsan@ti-net.com.cn",	 
        "roleId":"1", 	  
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| id         | int    | user.id                     |
| username   | String | 用户名                         |
| mobile     | String | 手机号码                        |
| email      | String | 邮件地址                        |
| roleId     | int    | role.id                     |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除用户
* URL: /api/system/users/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改用户
* URL: /api/system/users
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明      |
| ------ | ---- | ------ | ------- |
| id     | 是    | int    | user.id |
| mobile | 否    | String | 手机号码    |
| email  | 否    | String | 邮件地址    |
| roleId | 否    | int    | 角色id    |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "username":"张三",	 
        "mobile":"18811795226",
        "email":"zhangsan@ti-net.com.cn",	 
        "roleId":"1", 	  
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| id         | int    | user.id                     |
| username   | String | 用户名                         |
| mobile     | String | 手机号码                        |
| email      | String | 邮件地址                        |
| roleId     | int    | role.id                     |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取用户列表
* URL:/api/system/users
* Method:GET
* 输入参数：无
* ​
* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "username":"张三",	  
            "mobile":"18811795226",
            "email":"zhangsan@ti-net.com.cn",	 
            "role":{
                "id": "1",
                "name":"admin",
                "description":"管理员",
                "createTime": "2017-10-20 09:20:12"
            },
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| id         | int    | user.id                     |
| username   | String | 用户名                         |
| mobile     | String | 手机号码                        |
| email      | String | 邮件地址                        |
| role       | object | role对象                      |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 5. 修改密码
* URL:/api/system/user/password
* Method:PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明         |
| ----------- | ---- | ------ | ---------- |
| username    | 是    | String | 用户名        |
| oldPassword | 是    | String | 原密码，md5后存储 |
| newPassword | 是    | String | 新密码，md5后存储 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

#### 角色管理
##### 1. 新增角色
* URL: /api/system/roles
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明   |
| ----------- | ---- | ------ | ---- |
| name        | 是    | String | 角色名称 |
| description | 否    | String | 角色描述 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"admin",
        "description":"管理员",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | role.id                     |
| name        | String | 角色名称                        |
| description | String | 角色描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除角色
* URL: /api/system/roles/{id}
* Method: DELTE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改角色
* URL: /api/system/role
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明      |
| ----------- | ---- | ------ | ------- |
| id          | 是    | int    | role.id |
| description | 否    | String | 角色描述    |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"admin",
        "description":"管理员",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | role.id                     |
| name        | String | 角色名称                        |
| description | String | 角色描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |


##### 4. 获取角色列表
* URL:/api/system/roles
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"admin",
            "description":"管理员",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | role.id                     |
| name        | String | 角色名称                        |
| description | String | 角色描述                        |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 5. 角色管理模块
* URL: /api/system/role/module
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名     | 是否必填 | 数据类型 | 说明              |
| ------- | ---- | ---- | --------------- |
| roleId  | 是    | int  | role.id         |
| modules | 是    | list | role_module对象数组 |

先删除role_module中roleId对应的所有项，再插入数组中的所有项

role_module对象中的参数

| 参数名      | 是否必填 | 数据类型 | 说明        |
| -------- | ---- | ---- | --------- |
| moduleId | 是    | int  | module.id |
| update   | 是    | int  | 是否可以修改配置  |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result":[ 
        {
            "id": "1",
            "roleId":"1",
            "moduleId":"1",
            "update":"1",
            "createTime": "2017-10-20 09:20:12"
        },
        {
            "id": "2",
            "roleId":"1",
            "moduleId":"2",
            "update":"1",
            "createTime": "2017-10-20 09:20:12"    
        }
    ]
}
```
* 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| roleId     | int    | role.id                     |
| moduleId   | int    | module.id                   |
| update     | int    | 是否可以修改配置                    |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 6. 查询角色下所有模块
* URL: /api/system/role/module
* Method: GET
* Content type: application/json
* 输入参数：

| 参数名     | 是否必填 | 数据类型 | 说明              |
| ------- | ---- | ---- | --------------- |
| roleId  | 是    | int  | role.id         |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result":[ 
        {
            "id": "1",
            "roleId":"1",
            "moduleId":"1",
            "update":"1",
            "createTime": "2017-10-20 09:20:12"
        },
        {
            "id": "2",
            "roleId":"1",
            "moduleId":"2",
            "update":"1",
            "createTime": "2017-10-20 09:20:12"    
        }
    ]
}
```
* 返回对象描述

| 字段         | 类型     | 描述                          |
| ---------- | ------ | --------------------------- |
| roleId     | int    | role.id                     |
| moduleId   | int    | module.id                   |
| update     | int    | 是否可以修改配置                    |
| createTime | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### 模块管理
##### 1. 获取模块列表
* URL:/api/system/modules
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"admin",
            "description":"api模块",
            "prefix":"/api",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | module.id                   |
| name        | String | 模块名称, admin/report是默认用户不能删除 |
| description | String | 描述                          |
| prefix      | String | 模块页面路径前缀                    |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

#### ACL管理
##### 1. 新增白名单
* URL: /api/system/acls
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                                      |
| ----------- | ---- | ------ | --------------------------------------- |
| ip          | 是    | String | ip地址支持通配符比如172.16.203.18/32,10.10.0.0/8 |
| domainId    | 是    | int    | domain.id                               |
| description | 否    | String | 描述                                      |


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "ip":"172.16.203.18/32",
        "domainId":"1"
        "description":"ip白名单",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                                      |
| ----------- | ------ | --------------------------------------- |
| id          | int    | acl.id                                  |
| ip          | String | ip地址支持通配符比如172.16.203.18/32,10.10.0.0/8 |
| domainId    | int    | domain.id                               |
| description | String | 描述                                      |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss             |

##### 2. 删除白名单
* URL: /api/system/acls/{id}
* Method: DELTE

* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 3. 获取白名单列表
* URL:/api/system/acls
* Method:GET
* 输入参数：

| 参数名           | 是否必填 | 数据类型 | 说明           |
| ------------- | ---- | ---- | ------------ |
| currentPageNo | 否    | int  | 页码，默认第一页     |
| pageSize      | 否    | int  | 每页数据条数，默认20条 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "ip":"172.16.203.18/32",
            "domain":{
                "id": "1",
                "name":"AWS2",
                "callbackUrl":"",
                "product"：{
                    "id": "1",
                    "name":"CTICloud",
                    "description":"CTICloud大型呼叫中心平台",
                    "createTime": "2017-10-20 09:20:12"    
                },
                "description":"CTICloud AWS2平台",
                "createTime": "2017-10-20 09:20:12"    
            },
            "description":"ip白名单",
            "createTime": "2017-10-20 09:20:12"
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}
```
* 返回对象描述

| 字段          | 类型     | 描述                                      |
| ----------- | ------ | --------------------------------------- |
| id          | int    | acl.id                                  |
| ip          | String | ip地址支持通配符比如172.16.203.18/32,10.10.0.0/8 |
| domain      | object | domain对象                                |
| description | String | 描述                                      |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss             |

#### 实时统计管理
##### 1. 新增实时统计组
* URL: /api/system/statistic/statisticGroups
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明      |
| ----------- | ---- | ------ | ------- |
| name        | 是    | String | 实时统计组名称 |
| description | 否    | String | 实时统计组描述 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"statistic_group_001",
        "description":"实时统计组001",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | statistic_group.id          |
| name        | String | 实时统计组名称                     |
| description | String | 实时统计组描述                     |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除实时统计组
* URL: /api/system/statistic/statisticGroups/{id}
* Method: DELETE
* 输入参数：

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改实时统计组
* URL: /api/system/statistic/statisticGroups
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                 |
| ----------- | ---- | ------ | ------------------ |
| id          | 是    | int    | statistic_group.id |
| name        | 是    | String | 实时统计组名称            |
| description | 否    | String | 实时统计组描述            |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"statistic_group_001",
        "description":"实时统计组001",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | statistic_group.id          |
| name        | String | 实时统计组名称                     |
| description | String | 实时统计组描述                     |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取实时统计组列表
* URL:/api/system/statistic/statisticGroups
* Method: GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"statistic_group_001",
            "description":"实时统计组001",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]  
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | statistic_group.id          |
| name        | String | 实时统计组名称                     |
| description | String | 实时统计组描述                     |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 5. 新增实时统计
* URL: /api/system/statistics
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名              | 是否必填 | 数据类型   | 说明                                       |
| ---------------- | ---- | ------ | ---------------------------------------- |
| name             | 是    | String | 统计名：英文，单次和下划线和数字组成                       |
| eventType        | 是    | int    | 事件类型：1:invite 2:routed 3:fail route 4:response ring 5:response fail 6:answer 7:bye |
| statisticGroupId | 是    | int    | statistic_group.id                       |
| displayName      | 是    | String | 显示名                                      |
| condition        | 是    | String | 统计值所需条件支持：= 1= > >= < <= in regex        |
| IncreaseType     | 是    | int    | 增加的数值类型 1数值 2变量                          |
| increaseValue    | 是    | String | 满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字）     |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id":"1",
        "name":"statistic_001",
        "eventType":"1", 
        "statisticGroupId":"1",
        "displayName":"实时统计001",
        "condition":">=",
        "IncreaseType:"1",
        "increaseValue:"3",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段               | 类型     | 描述                                       |
| ---------------- | ------ | ---------------------------------------- |
| id               | int    | statistic_setting.id                     |
| name             | String | 统计名：英文，单次和下划线和数字组成                       |
| eventType        | int    | 事件类型：1:invite 2:routed 3:fail route 4:response ring 5:response fail 6:answer 7:bye |
| statisticGroupId | int    | statistic_group.id                       |
| displayName      | String | 显示名                                      |
| condition        | String | 统计值所需条件支持：= 1= > >= < <= in regex        |
| IncreaseType     | int    | 增加的数值类型 1数值 2变量                          |
| increaseValue    | String | n满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字）    |
| createTime       | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

##### 6. 删除实时统计
* URL: /api/system/statistics/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 7. 修改实时统计
* URL: /api/system/statistics
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名              | 是否必填 | 数据类型   | 说明                                       |
| ---------------- | ---- | ------ | ---------------------------------------- |
| id               | 是    | int    | statistic_setting.id                     |
| name             | 否    | String | 统计名：英文，单次和下划线和数字组成                       |
| eventType        | 否    | int    | 事件类型：1:invite 2:routed 3:fail route 4:response ring 5:response fail 6:answer 7:bye |
| statisticGroupId | 否    | int    | statistic_group.id                       |
| displayName      | 否    | String | 显示名                                      |
| condition        | 否    | String | 统计值所需条件支持：= 1= > >= < <= in regex        |
| IncreaseType     | 否    | int    | 增加的数值类型 1数值 2变量                          |
| increaseValue    | 否    | String | n满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字）    |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id":"1",
        "name":"statistic_001",
        "eventType":"1", 
        "statisticGroupId":"1",
        "displayName":"实时统计001",
        "condition":">=",
        "IncreaseType:"1",
        "increaseValue:"3",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段               | 类型     | 描述                                       |
| ---------------- | ------ | ---------------------------------------- |
| id               | int    | statistic_setting.id                     |
| name             | String | 统计名：英文，单次和下划线和数字组成                       |
| eventType        | int    | 事件类型：1:invite 2:routed 3:fail route 4:response ring 5:response fail 6:answer 7:bye |
| statisticGroupId | int    | statistic_group.id                       |
| displayName      | String | 显示名                                      |
| condition        | String | 统计值所需条件支持：= 1= > >= < <= in regex        |
| IncreaseType     | int    | 增加的数值类型 1数值 2变量                          |
| increaseValue    | String | n满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字）    |
| createTime       | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

##### 8. 获取实时统计列表
* URL:/api/system/statistics
* Method:GET
* 输入参数：

| 参数名              | 是否必填 | 数据类型 | 说明                 |
| ---------------- | ---- | ---- | ------------------ |
| statisticGroupId | 是    | int  | statistic_group.id |


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "name":"statistic_001",
            "eventType":"1", 
            "statisticGroupId":"1",
            "displayName":"实时统计001",
            "condition":">=",
            "IncreaseType:"1",
            "increaseValue:"3",
            "createTime": "2017-10-20 09:20:12"
    ]
}
```
* 返回对象描述

| 字段               | 类型     | 描述                                       |
| ---------------- | ------ | ---------------------------------------- |
| id               | int    | statistic_setting.id                     |
| name             | String | 统计名：英文，单次和下划线和数字组成                       |
| eventType        | int    | 事件类型：1:invite 2:routed 3:fail route 4:response ring 5:response fail 6:answer 7:bye |
| statisticGroupId | int    | statistic_group.id                       |
| displayName      | String | 显示名                                      |
| condition        | String | 统计值所需条件支持：= 1= > >= < <= in regex        |
| IncreaseType     | int    | 增加的数值类型 1数值 2变量                          |
| increaseValue    | String | n满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字）    |
| createTime       | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

### 9. 获取系统统计

- URL: /api/statistic/system
- Method: GET
- 输入参数：


- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 参数统计集合数据 |

[查看全部系统统计参数](./sip-router表设计.md#系统级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.global",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

### 10. 获取产品统计

- URL: /api/statistic/product
- Method: GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| product_id | 是    | int | 产品id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 产品统计集合数据 |

[查看全部产品统计参数](./sip-router表设计.md#产品级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.product.1",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

### 11. 获取平台统计

- URL: /api/statistic/domain
- Method: GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| domain_id | 是    | int | 平台id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 平台统计集合数据 |

[查看全部平台统计参数](./sip-router表设计.md#平台级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.domain.1",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

### 12. 获取业务统计

- URL: /api/statistic/service
- Method: GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| service_id | 是    | int | 业务id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 业务统计集合数据 |

[查看全部业务统计参数](./sip-router表设计.md#业务级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.service.1",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

### 13. 获取中继组统计

- URL: /api/statistic/trunkgroup
- Method: GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| trunk_group_id | 是    | int | 中继组id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 中继组统计集合数据 |

[查看全部中继组统计参数](./sip-router表设计.md#中继组级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.trunk_group.1",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

### 14. 获取网关统计

- URL: /api/statistic/gateway
- Method: GET
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| gateway_id | 是    | int | 网关id |

- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 网关统计集合数据 |

[查看全部网关统计参数](./sip-router表设计.md#网关级别)

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":[
        {
            "key":"sip-router.dialog.gateway.1",
            "value":23,
            "desc":"并发calls"
        }
    ]
}

```

#### 告警管理
##### 1. 新增告警设置
* URL: /api/system/alertSettings
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                                       |
| ----------- | ---- | ------ | ---------------------------------------- |
| name        | 是    | String | 实时统计组名                                   |
| description | 否    | String | 描述                                       |
| condition   | 是    | String | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | 是    | int    | 告警级别 1:警告 2:错误                           |
| type        | 是    | int    | 告警类别：系统、业务、自定义                           |
| interval    | 是    | int    | 支持按1分钟、5分钟、10分钟、60分钟4种                   |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"statistic_group_001",
        "description":"统计组1告警设置",
        "condition":"sip-router.system.opensips.${opensips_id}.calls>100000",
        "level":"1",
        "type":"1",
        "interval":"5",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                                       |
| ----------- | ------ | ---------------------------------------- |
| id          | int    | alert_setting.id                         |
| name        | String | 实时统计组名                                   |
| description | String | 描述                                       |
| condition   | String | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | int    | 告警级别 1:警告 2:错误                           |
| type        | int    | 告警类别：系统、业务、自定义                           |
| interval    | int    | 支持按1分钟、5分钟、10分钟、60分钟4种                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

##### 2. 删除告警设置
* URL: /api/system/alertSettings/{id}
* Method: DELETE
* 输入参数：

| 参数名  | 是否必填 | 数据类型 | 说明               |
| ---- | ---- | ---- | ---------------- |
| id   | 是    | int  | alert_setting.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改告警设置
* URL: /api/system/alertSettings
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                                       |
| ----------- | ---- | ------ | ---------------------------------------- |
| id          | 是    | int    | alert_setting.id                         |
| name        | 否    | String | 实时统计组名                                   |
| description | 否    | String | 描述                                       |
| condition   | 否    | String | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | 否    | int    | 告警级别 1:警告 2:错误                           |
| type        | 否    | int    | 告警类别：系统、业务、自定义                           |
| interval    | 否    | int    | 支持按1分钟、5分钟、10分钟、60分钟4种                   |



* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"statistic_group_001",
        "description":"统计组1告警设置",
        "condition":"sip-router.system.opensips.${opensips_id}.calls>100000",
        "level":"1",
        "type":"1",
        "interval":"5",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                                       |
| ----------- | ------ | ---------------------------------------- |
| id          | int    | alert_setting.id                         |
| name        | String | 实时统计组名                                   |
| description | String | 描述                                       |
| condition   | String | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | int    | 告警级别 1:警告 2:错误                           |
| type        | int    | 告警类别：系统、业务、自定义                           |
| interval    | int    | 支持按1分钟、5分钟、10分钟、60分钟4种                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

##### 4. 获取告警设置列表
* URL:/api/system/alertSettings
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id": "1",
            "name":"statistic_group_001",
            "description":"统计组1告警设置",
            "condition":"sip-router.system.opensips.${opensips_id}.calls>100000",
            "level":"1",
            "type":"1",
            "interval":"5",
            "createTime": "2017-10-20 09:20:12"
        }   
    ]
}
```
* 返回对象描述

| 字段          | 类型     | 描述                                       |
| ----------- | ------ | ---------------------------------------- |
| id          | int    | alert_setting.id                         |
| name        | String | 实时统计组名                                   |
| description | String | 描述                                       |
| condition   | String | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | int    | 告警级别 1:警告 2:错误                           |
| type        | int    | 告警类别：系统、业务、自定义                           |
| interval    | int    | 支持按1分钟、5分钟、10分钟、60分钟4种                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss              |

### 对接设置
#### 对接中继组
##### 1. 新增中继组
* URL: /api/system/trunkGroups
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明        |
| ----------- | ---- | ------ | --------- |
| name        | 是    | String | 中继组名      |
| location    | 是    | String | 物理位置，机房信息 |
| description | 否    | String | 描述        |
| active      | 是    | int    | 是否激活      |
| maxCalls    | 是    | int    | 最大并发数     |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"北京联通落地组",
        "location":"北京光环新网酒仙桥机房",
        "description":"北京联通线路",
        "active":"1",
        "maxCalls":"1000",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | trunk_group.id              |
| location    | String | 物理位置，机房信息                   |
| description | String | 描述                          |
| active      | int    | 是否激活                        |
| maxCalls    | int    | 最大并发数                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除中继组
* URL: /api/system/trunkGroups/{id}
* Method: DELETE
* 输入参数：


* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改中继组
* URL: /api/system/trunkGroups
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明             |
| ----------- | ---- | ------ | -------------- |
| id          | 是    | int    | trunk_group.id |
| name        | 否    | String | 中继组名           |
| location    | 否    | String | 物理位置，机房信息      |
| description | 否    | String | 描述             |
| active      | 否    | int    | 是否激活           |
| maxCalls    | 否    | int    | 最大并发数          |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |
&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "name":"北京联通落地组",
        "location":"北京光环新网酒仙桥机房",
        "description":"北京联通线路",
        "active":"1",
        "maxCalls":"1000",
        "createTime": "2017-10-20 09:20:12"
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | trunk_group.id              |
| location    | String | 物理位置，机房信息                   |
| description | String | 描述                          |
| active      | int    | 是否激活                        |
| maxCalls    | int    | 最大并发数                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取中继组列表
* URL:/api/system/trunkGroups
* Method:GET
* 输入参数：无

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": 
        {
            "id": "1",
            "name":"北京联通落地组",
            "location":"北京光环新网酒仙桥机房",
            "description":"北京联通线路",
            "active":"1",
            "maxCalls":"1000",
            "createTime": "2017-10-20 09:20:12"
        }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | trunk_group.id              |
| location    | String | 物理位置，机房信息                   |
| description | String | 描述                          |
| active      | int    | 是否激活                        |
| maxCalls    | int    | 最大并发数                       |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 5. 中继组新增网关
* URL: /api/system/trunkGroup/gateways
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名          | 是否必填 | 数据类型 | 说明             |
| ------------ | ---- | ---- | -------------- |
| trunkGroupId | 是    | int  | trunk_group.id |
| gatewayId    | 是    | int  | gateway.id     |
| weight       | 是    | int  | 权重，在一个gateway_group中按权重分发    |   

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result": {
        "id": "1",
        "trunkGroupId":"1", 
        "gatewayId":"1" ,
        "weight":"1"
    }   
}
```
* 返回对象描述

| 字段           | 类型   | 描述                     |
| ------------ | ---- | ---------------------- |
| id           | int  | trunk_group_gateway.id |
| trunkGroupId | int  | trunk_group.id         |
| gatewayId    | int  | gateway.id             |
| weight       | int  | 权重，在一个gateway_group中按权重分发    | 

##### 6. 中继组删除网关
* URL: /api/system/trunkGroup/gateways
* Method: DELETE
* 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明             |
| -----------    | ---- | ------ | -------------- |
| trunkGroupId   | 是    | int    | trunk_group.id |
| gatewayId      | 是    | int    |gateway.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功"
}
```

##### 7. 查询中继组下所有网关
* URL: /api/system/trunkGroup/gateways
* Method: GET
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明             |
| ----------- | ---- | ------ | -------------- |
| id          | 是    | int    | trunk_group.id |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "result": [
        {
            "id": 111,
            "name": "sss555554546565465",
            "ip": "ddd",
            "port": "ddd",
            "areacode": "33",
            "maxCps": 33,
            "maxCalls": 33,
            "active": 1,
            "status": 3,
            "description": "33",
            "createTime": "2017-11-28 14:56:45"
        }
    ],
    "msg": "成功",
    "currentPageNo": 1,
    "pageSize": 20,
    "totalCount": 4
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | gateway.id                  |
| name        | String | 网关名                         |
| ip          | String | ip地址                        |
| port        | String | sip端口号                      |
| areacode    | String | 所在地区号                       |
| maxCps      | int    | 容忍的cps                      |
| maxCalls    | int    | 容忍的calls                    |
| active      | int    | 是否激活                        |
| status      | int    | 状态监测状态                      |
| description | String | 设置描述，用于显示                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |


#### 对接网关
##### 1. 新增网关
* URL: /api/system/gateways
* Method: POST
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                        |
| ----------- | ---- | ------ | ------------------------- |
| name        | 是    | String | 网关名                       |
| ip          | 是    | String | ip地址                      |
| port        | 是    | String | sip端口号                    |
| areacode    | 是    | String | 所在地区号                     |
| maxCps      | 是    | int    | 容忍的cps                    |
| maxCalls    | 是    | int    | 容忍的calls                  |
| active      | 是    | int    | 是否激活                      |
| status      | 是    | int    | 状态， 0：关闭 1：打开                     |
| description | 否    | String | 设置描述，用于显示                 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result":{ 
        "id":"1",
        "name":"g1",	 
        "ip":"172.16.0.156",            
        "port":"5060",           
        "areacode":"010",	   
        "maxCps":"20",     	 
        "maxCalls": "100",      
        "active":"1",	         
        "status":"1",	        
        "description":"test gateway",     
        "createTime": "2017-10-20 09:20:12" 
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | gateway.id                  |
| name        | String | 网关名                         |
| ip          | String | ip地址                        |
| port        | String | sip端口号                      |
| areacode    | String | 所在地区号                       |
| maxCps      | int    | 容忍的cps                      |
| maxCalls    | int    | 容忍的calls                    |
| active      | int    | 是否激活                        |
| status      | int    | 状态监测状态                      |
| description | String | 设置描述，用于显示                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 2. 删除网关
* URL: /api/system/gateways/{id}
* Method: PUT
* 输入参数：

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功"
}
```

##### 3. 修改网关
* URL: /api/system/gateways
* Method: PUT
* Content type: application/json
* 输入参数：

| 参数名         | 是否必填 | 数据类型   | 说明                        |
| ----------- | ---- | ------ | ------------------------- |
| id          | 是    | int    | gateway.id                |
| name        | 否    | String | 网关名                       |
| ip          | 否    | String | ip地址                      |
| port        | 否    | String | sip端口号                    |
| areacode    | 否    | String | 所在地区号                     |
| maxCps      | 否    | int    | 容忍的cps                    |
| maxCalls    | 否    | int    | 容忍的calls                  |
| active      | 否    | int    | 是否激活                      |
| status      | 否    | int    | 状态监测状态                    |
| description | 否    | String | 设置描述，用于显示                 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | object | 结果对象      |

&emsp;&emsp;返回示例
```    
{
    "status": 0,
    "msg": "成功",
    "result":{ 
        "id":"1",
        "name":"g1",	 
        "ip":"172.16.0.156",            
        "port":"5060",                
        "areacode":"010",	   
        "maxCps":"20",     	 
        "maxCalls": "100",      
        "active":"1",	         
        "status":"1",	        
        "description":"test gateway",     
        "createTime": "2017-10-20 09:20:12" 
    }   
}
```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | gateway.id                  |
| name        | String | 网关名                         |
| ip          | String | ip地址                        |
| port        | String | sip端口号                      |
| areacode    | String | 所在地区号                       |
| maxCps      | int    | 容忍的cps                      |
| maxCalls    | int    | 容忍的calls                    |
| active      | int    | 是否激活                        |
| status      | int    | 状态监测状态                      |
| description | String | 设置描述，用于显示                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

##### 4. 获取网关列表
* URL:/api/system/gateways
* Method:GET
* 输入参数：

| 参数名           | 是否必填 | 数据类型 | 说明           |
| ------------- | ---- | ---- | ------------ |
| currentPageNo | 否    | int  | 页码，默认第一页     |
| pageSize      | 否    | int  | 每页数据条数，默认20条 |

* 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | array  | 结果对象      |

&emsp;&emsp;返回示例
```    
  {
    "status": 0,
    "msg": "成功",
    "result": [
        {
            "id":"1",
            "name":"g1",	 
            "ip":"172.16.0.156",            
            "port":"5060",                
            "areacode":"010",	   
            "maxCps":"20",     	 
            "maxCalls": "100",      
            "active":"1",	         
            "status":"1",	        
            "description":"test gateway",     
            "createTime": "2017-10-20 09:20:12" 
        }   
    ],
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```
* 返回对象描述

| 字段          | 类型     | 描述                          |
| ----------- | ------ | --------------------------- |
| id          | int    | gateway.id                  |
| name        | String | 网关名                         |
| ip          | String | ip地址                        |
| port        | String | sip端口号                      |
| areacode    | String | 所在地区号                       |
| maxCps      | int    | 容忍的cps                      |
| maxCalls    | int    | 容忍的calls                    |
| active      | int    | 是否激活                        |
| status      | int    | 状态监测状态                      |
| description | String | 设置描述，用于显示                   |
| createTime  | String | 创建时间,格式:yyyy-MM-dd HH:mm:ss |

### 工具
#### 路由分析

### 通话记录

##### 1. 话单查询

- URL: /api/cdrs
- Method: GET
- 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明          |
| ------------ | ---- | ------ | ----------- |
| callId       | 否    | String | call-id     |
| startTime    | 是    | String | request起始时间 |
| endTime      | 是    | String | request结束时间 |
| tel          | 否    | String | 呼叫号码不带区号    |
| areacode     | 否    | String | 所在地区号       |
| enterpriseId | 否    | int    | 企业id        |
| beforeClid   | 否    | int    | 请求时外显号码     |
| serviceId    | 否    | int    | 业务id        |
| gatewayId    | 否    | int    | 落地网关id      |
| trunkGroupId | 否    | int    | 中继组id       |
| fromIp       | 否    | String | 发起ip        |

- 返回结果：


| 字段     | 数据类型   | 说明           |
| ------ | ------ | ------------ |
| status | int    | 0成功，-1失败     |
| msg    | String | 状态说明，例如成功    |
| result | object | CDR json结果对象 |

- 返回对象描述CDR json对象:

| 字段           | 类型        | 说明                                       |
| ------------ | --------- | ---------------------------------------- |
| callId       | varchar   | 通话唯一表示                                   |
| requestTime  | int       | unix时间戳，请求时间                             |
| routedTime   | int       | unix时间戳，路由出去时间                           |
| gatewayIp    | varchar   | 对接网关ip                                   |
| ringTime     | int       | unix时间戳，返回180、183时间，第一次返回为准              |
| answerTime   | int       | unix时间戳，接通时间                             |
| endTime      | int       | unix时间戳，结束之间                             |
| duration     | int       | 接通分钟数                                    |
| beforeClid   | varchar   | 路由前的外显                                   |
| afterClid    | varchar   | 路由后的外显                                   |
| beforePrefix | varchar   | 路由前prefix                                |
| afterPrefix  | varchar   | 路由后prefix                                |
| tel          | varchar   | 去掉prefix的呼叫号码，不带区号                       |
| areacode     | varchar   | 被叫区号                                     |
| sp           | varchar   | 北京运营商                                    |
| status       | int       | 状态1:路由失败2:路由成功3:接通成功                     |
| sipCode      | int       | 路由成功中没有接通的返回sip_code 4xx/5xx/6xx等        |
| failCode     | int       | 路由失败原因1:acl未通过 2:超全局cps 3:超全局calls 4:没有prefix 5:超产品cps 6:超产品calls，缺少这个字段是值是-1 |
| endReason    | int       | 1:发起者挂断 2:转接者挂断 3:超时挂断 4:MI挂断            |
| createTime   | timestamp | 创建时间                                     |
| serviceId    | int       | 业务id                                     |
| domainId     | int       | 平台id                                     |
| productId    | int       | 产品线id                                    |
| trunkGroupId | int       | 对接中继组id                                  |
| gatewayId    | int       | 对接网关id                                   |
| enterpriseId | varchar   | 企业id                                     |
| callType     | int       | 呼叫类型                                     |
| fromIp       | varchar   | 来源ip                                     |
| createTime   | varchar   | 入库时间                                     |
| ...          | varchar   | 其他打入cdr_tag中的字段，支持0-n个自定义字段              |
| ...          | varchar   | 其他打入cdr_tag中的字段，支持0-n个自定义字段              |



&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":{ 
        "callId":"dkk183848301832-1834",
        "requestTime":"2017-10-20 09:20:12.333",	 
        "routedTime":"2017-10-20 09:20:12.333",            
        "gatewayIp":"10.10.10.10",           
        "ringTime":"2017-10-20 09:20:12.333",        
        "answerTime":"2017-10-20 09:20:12.333",	   
        "endTime":"2017-10-20 09:20:12.333",     	 
        "duration": "100",      
        "beforeClid":"87120766",	         
        "afterClid":"87120766",	        
        "beforePrefix":"112",  
                ...
                ...
        "createTime": "2017-10-20 09:20:12" 
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

### 报表

##### 1. 业务日报查询

- URL: /api/service/day/reports
- Method: GET
- 输入参数：

| 参数名        | 是否必填 | 数据类型   | 说明             |
| ---------- | ---- | ------ | -------------- |
| serviceId  | 否    | String | call-id        |
| day        | 是    | String | 查询天 2017-11-09 |
| productId  | 否    | String | 产品id           |
| domainId   | 否    | String | 平台id           |
| opensipsId | 否    | String | openips id     |

- 返回结果：

| 字段      | 数据类型       | 说明                      |
| ------- | ---------- | ----------------------- |
| status  | int        | 0成功，-1失败                |
| msg     | String     | 状态说明，例如成功               |
| result  | json Array | REPORT_SERVICE json结果对象 |
| summary | object     | 汇总对象（全量数据汇总，非只分页数据）     |

- 返回对象描述REPORT_SERVICE json对象:

| 字段                | 类型      | 说明                          |
| ----------------- | ------- | --------------------------- |
| productId         | varchar | 产品id                        |
| domainId          | int     | 平台id                        |
| serviceId          | int     | 业务id                        |
| opensipsId        | int     | opensips id                 |
| day               | varchar | 天 2017-11-09                |
| totalCount        | int     | 总呼叫次数                          |
| successRouteCount | int     | 成功路由个数                        |
| limitCount     | int     | 被限制数                    |
| aclCount     | varchar | 由于acl被拒绝数                    |
| routeFailCount | varchar | 路由失败个数                      |
| answerCount       | varchar | 应答个数                        |
| answerDuration    | varchar | 通话分钟数                       |
| createTime        | varchar | 创建时间,格式:yyyy-MM-dd HH:mm:ss |



&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":{
        "list":[{ 
                "productId":"1",
                "domainId":"1",	 
                "opensipsId":"1",            
                "serviceId":"1",           
                "day":"2017-10-20",        
                "totalCount":"3333",	   
                "limitCount":"233",     	 
                "successRouteCount": "1",         
                "aclCount":"33",	        
                "routeFailCount":"1",  
                "answerCount":"1"
                "answerDuration":"11"
                "createTime": "2017-10-20 09:20:12" 
                }],
        "summary":{
                "totalCount":"3333",	   
                "successRouteCount":"233",     	 
                "limitCount": "1",      
                "aclCount":"22",	         
                "routeFailCount":"33",	
                "answerCount":"1"
                "answerDuration":"11"
                  }
     },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

##### 2. 业务月报查询

- URL: /api/service/month/reports
- Method: GET
- 输入参数：

| 参数名        | 是否必填 | 数据类型   | 说明          |
| ---------- | ---- | ------ | ----------- |
| serviceId  | 否    | String | call-id     |
| month      | 是    | String | 查询月 2017-11 |
| productId  | 否    | String | 产品id        |
| domainId   | 否    | String | 平台id        |
| opensipsId | 否    | String | openips id  |

- 返回结果：

| 字段      | 数据类型   | 说明                  |
| ------- | ------ | ------------------- |
| status  | int    | 0成功，-1失败            |
| msg     | String | 状态说明，例如成功           |
| result  | object | CDR json结果对象        |
| summary | object | 汇总对象（全量数据汇总，非只分页数据） |

- 返回对象描述REPORT_SERVICE json对象:

| 字段                | 类型      | 说明                          |
| ----------------- | ------- | --------------------------- |
| productId         | varchar | 产品id                        |
| domainId          | int     | 平台id                        |
| serviceId          | int     | 业务id                        |
| opensipsId        | int     | opensips id                 |
| month             | varchar | 月 2017-11                   |
| totalCount        | int     | 总呼叫次数                          |
| successRouteCount | int     | 成功路由个数                        |
| limitCount     | int     | 被限制数                    |
| aclCount     | varchar | 由于acl被拒绝数                    |
| routeFailCount | varchar | 路由失败个数                      |
| answerCount       | varchar | 应答个数                        |
| answerDuration    | varchar | 通话分钟数                       |
| createTime        | varchar | 创建时间,格式:yyyy-MM-dd HH:mm:ss |



&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":{
        "list":[{ 
                "productId":"1",
                "domainId":"1",	 
                "opensipsId":"1",            
                "serviceId":"1",           
                "day":"2017-10-20",        
                "totalCount":"3333",	   
                "limitCount":"233",     	 
                "successRouteCount": "1",         
                "aclCount":"33",	        
                "routeFailCount":"1",
                "answerCount":"1"
                "answerDuration":"11"
                "createTime": "2017-10-20 09:20:12" 
            }],
       "summary":{
               	"totalCount":"3333",	   
                "limitCount":"233",     	 
                "successRouteCount": "1",         
                "aclCount":"33",	        
                "routeFailCount":"1",  
                "answerCount":"1"
                "answerDuration":"11"
                }
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

##### 3. 网关日报查询

- URL: /api/gateway/day/reports
- Method: GET
- 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明             |
| ------------ | ---- | ------ | -------------- |
| gatewayId    | 否    | String | gateway.id     |
| day          | 是    | String | 查询天 2017-11-09 |
| trunkGroupId | 否    | String | 中继组id          |
| opensipsId   | 否    | String | opensips.id    |

- 返回结果：

| 字段      | 数据类型       | 说明                      |
| ------- | ---------- | ----------------------- |
| status  | int        | 0成功，-1失败                |
| msg     | String     | 状态说明，例如成功               |
| result  | json Array | REPORT_GATEWAY json结果对象 |
| summary | object     | 汇总对象（全量数据汇总，非只分页数据）     |

- 返回对象描述REPORT_SERVICE json对象:

| 字段             | 类型      | 说明                          |
| -------------- | ------- | --------------------------- |
| gatewayId      | int     | 网关id                        |
| trunkGroupId   | int     | 平台id                        |
| opensipsId     | int     | opensips id                 |
| day            | varchar | 天 2017-11-09                |
| totalCount     | int     | 总呼叫次数                          |
| answerCount    | varchar | 应答个数                        |
| answerDuration | varchar | 通话分钟数                       |
| createTime     | varchar | 创建时间,格式:yyyy-MM-dd HH:mm:ss |



&emsp;&emsp;返回示例

```

```

```
{
    "status": 0,
    "msg": "成功",
    "result":{
        "list":[{ 
                "gatewayId":"1",
                "trunkGroupId":"1",	 
                "opensipsId":"1",                       
                "day":"2017-10-20",        
                "totalCount":"3333",	   
                "answerCount":"1"
                "answerDuration":"11"
                "createTime": "2017-10-20 09:20:12" 
            }],
        "summary":{
            	"totalCount":"3333",	   
                "answerCount":"1"
                "answerDuration":"11"
                }
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

##### 4. 网关月报查询

- URL: /api/gateway/month/reports
- Method: GET
- 输入参数：

| 参数名          | 是否必填 | 数据类型   | 说明          |
| ------------ | ---- | ------ | ----------- |
| gatewayId    | 否    | String | gateway.id  |
| month        | 是    | String | 查询月 2017-11 |
| trunkGroupId | 否    | String | 中继组id       |
| opensipsId   | 否    | String | opensips.id |

- 返回结果：

| 字段      | 数据类型       | 说明                      |
| ------- | ---------- | ----------------------- |
| status  | int        | 0成功，-1失败                |
| msg     | String     | 状态说明，例如成功               |
| result  | json Array | REPORT_GATEWAY json结果对象 |
| summary | object     | 汇总对象（全量数据汇总，非只分页数据）     |

- 返回对象描述REPORT_SERVICE json对象:

| 字段             | 类型      | 说明                          |
| -------------- | ------- | --------------------------- |
| gatewayId      | int     | 网关id                        |
| trunkGroupId   | int     | 平台id                        |
| opensipsId     | int     | opensips id                 |
| month          | varchar | 月 2017-11                   |
| totalCount     | int     | 总呼叫次数                          |
| answerCount    | varchar | 应答个数                        |
| answerDuration | varchar | 通话分钟数                       |
| createTime     | varchar | 创建时间,格式:yyyy-MM-dd HH:mm:ss |



&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":{
        "list":[{ 
                "gatewayId":"1",
                "trunkGroupId":"1",	 
                "opensipsId":"1",                       
                "month":"2017-10",        
                "totalCount":"3333",	   
                "answerCount":"1"
                "answerDuration":"11"
                "createTime": "2017-10-20 09:20:12" 
            }],
        "summary":{
            	"totalCount":"3333",	   
                "answerCount":"1"
                "answerDuration":"11"
                }
    },
    "currentPageNo":1,
    "pageSize" : 1,
    "totalCount" : 1
}

```

### gateway状态更新

##### 1. gateway状态更新

- URL: /api/gateway/status
- Method: POST
- 输入参数：

| 参数名    | 是否必填 | 数据类型   | 说明           |
| ------ | ---- | ------ | ------------ |
| ip | 是    | String | gateway IP地址 |
| port | 是    | String | gateway 端口 |
| status | 是    | int    | 0:不可用 1:可用   |


- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功"
}

```


### 获取opensips状态

##### 1. 获取opensips启动时间

- URL: /api/opensips/uptime
- Method: GET
- 输入参数：


- 返回结果：

| 字段     | 数据类型   | 说明        |
| ------ | ------ | --------- |
| status | int    | 0成功，-1失败  |
| msg    | String | 状态说明，例如成功 |
| result | JSON   | 启动时间数据 |

&emsp;&emsp;返回示例

```
{
    "status": 0,
    "msg": "成功",
    "result":{"Now": "Fri Dec 15 14:47:02 2017", "Up since": "Fri Dec 15 14:20:06 2017", "Up time": "1616 [sec]"}
}

```

