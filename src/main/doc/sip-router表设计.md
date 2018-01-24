## sip-router表设计

### sip-router-conf-db库

#### 1.product

产品线表，设计容量10

| 字段名         | 字段类型      | 主外键  | 说明    |
| ----------- | --------- | ---- | ----- |
| id          | int       | 主键   |       |
| name        | varchar   |      | 产品线名称 |
| description | varchar   |      | 产品线描述 |
| create_time | timestamp |      | 创建时间  |
|             |           |      |       |

#### 2.product_setting

产品线配置表，设计容量1000

| 字段名         | 字段类型      | 主外键  | 说明         |
| ----------- | --------- | ---- | ---------- |
| id          | int       | 主键   |            |
| product_id  | int       | 外键   | product.id |
| name        | varchar   |      | 设置名称       |
| value       | varchar   |      | 设置值        |
| property    | varchar   |      | 设置属性       |
| description | varchar   |      | 设置描述，用于显示  |
| create_time | timestamp |      | 创建时间       |
|             |           |      |            |

#### 3.domain

平台表，设计容量100

| 字段名          | 字段类型      | 主外键  | 说明         |
| ------------ | --------- | ---- | ---------- |
| id           | int       | 主键   |            |
| name         | varchar   |      | 平台名称       |
| callback_url | varchar   |      | 回调URL      |
| product_id   | int       | 外键   | product.id |
| description  | varchar   |      | 设置描述，用于显示  |
| create_time  | timestamp |      | 创建时间       |
|              |           |      |            |

#### 4.service

业务表，设计容量1000

| 字段名         | 字段类型      | 主外键  | 说明                            |
| ----------- | --------- | ---- | ----------------------------- |
| id          | int       | 主键   |                               |
| name        | varchar   |      | 业务名称                          |
| prefix      | varchar   |      | 前缀，无需支持正则表达式；3位数字100-999，不能重复 |
| domain_id   | int       | 外键   | domain.id                     |
| description | varchar   |      | 设置描述，用于显示                     |
| active      | int       |      | 是否激活                          |
| create_time | timestamp |      | 创建时间                          |
|             |           |      |                               |

#### 5.router

路由表，设计容量10000

| 字段名            | 字段类型      | 主外键  | 说明                         |
| -------------- | --------- | ---- | -------------------------- |
| id             | int       | 主键   |                            |
| service_id     | int       | 外键   | service.id                 |
| priority       | int       |      | 优先级 从小到大排序优先               |
| tel_regex      | varchar   |      | 被叫号码，支持正则表达式，为空表示不限制，带区号格式 |
| clid_regex     | varchar   |      | 主叫号码，支持正则表达式，为空表示不限制       |
| time_regex     | varchar   |      | 时间条件，支持正则表达式，为空表示不限制       |
| trunk_group_id | int       | 外键   | gateway_group.id           |
| description    | varchar   |      | 设置描述，用于显示                  |
| active         | int       |      | 是否激活                       |
| tags           | varchar   |      | json格式存储kv对，用于过滤和统计        |
| create_time    | timestamp |      | 创建时间                       |
|                |           |      |                            |



字段内容格式定义：

| 字段名        | 格式         | 说明                                       | 示例                                       |
| ---------- | ---------- | ---------------------------------------- | ---------------------------------------- |
| tel_regex  | string     | 正则表达式                                    | ^010                                     |
| clid_regex | string     | 正则表达式                                    | ^8917                                    |
| time_regex | json array | [{"dayOfWeek":"1,2,3,4,5,6,7", "timeStart": "09:00", "timeEnd": "23:00"}] 星期1-7表示周日-周六 | {"dayOfWeek":"1,2,3,4,5", "timeStart": "09:00", "timeEnd": "23:00"} |



#### 6.action

路由操作表，设计容量50000

| 字段名         | 字段类型      | 主外键  | 说明                                       |
| ----------- | --------- | ---- | ---------------------------------------- |
| id          | int       | 主键   |                                          |
| router_id   | int       | 外键   | router.id                                |
| priority    | int       |      | 优先级 从小到大执行                               |
| type        | int       |      | action类型：noop/set_var/add_prefix/remove_prefix/remove_codec/add_header/remove_header/set_next_route/add_cdr_tag/set_clid/set_dlg |
| property    | varchar   |      | json格式需要操作的数据，可以常量值也可以是变量名               |
| description | varchar   |      | 设置描述，用于显示                                |
| create_time | timestamp |      | 创建时间                                     |
|             |           |      |                                          |



不同action type的property定义：

| action | 类型             | property格式                               | 示例                                       |
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

#### 7.trunk_group

中继群组表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明        |
| ----------- | --------- | ---- | --------- |
| id          | int       | 主键   |           |
| name        | varchar   |      | 网关组名      |
| location    | varchar   |      | 物理位置，机房信息 |
| description | varchar   |      | 设置描述，用于显示 |
| active      | int       |      | 是否激活      |
| max_calls   | int       |      | 最大并发数     |
| create_time | timestamp |      | 创建时间      |
|             |           |      |           |



#### 8.gateway

对接网关表，设计容量200

| 字段名         | 字段类型      | 主外键  | 说明        |
| ----------- | --------- | ---- | --------- |
| id          | int       | 主键   |           |
| name        | varchar   |      | 网关名       |
| ip          | varchar   |      | ip地址      |
| port        | varchar   |      | sip端口号    |
| areacode    | varchar   |      | 所在地区号     |
| max_cps     | int       |      | 容忍的cps    |
| max_calls   | int       |      | 容忍的calls  |
| active      | int       |      | 是否激活      |
| status      | int       |      | 状态监测状态    |
| description | varchar   |      | 设置描述，用于显示 |
| create_time | timestamp |      | 创建时间      |
|             |           |      |           |

#### 9.trunk_group_gateway

中继群组和gateway关系表，设计容量100

| 字段名            | 字段类型 | 主外键  | 说明                        |
| -------------- | ---- | ---- | ------------------------- |
| id             | int  | 主键   |                           |
| trunk_group_id | int  | 外键   | trunk_group.id            |
| gateway_id     | int  | 外键   | gateway.id                |
| weight         | int  |      | 权重，在一个gateway_group中按权重分发 |

#### 10.number

号码表，设计容量100000

| 字段名            | 字段类型      | 主外键  | 说明            |
| -------------- | --------- | ---- | ------------- |
| id             | int       | 主键   |               |
| number         | varchar   |      | 号码            |
| areacode       | varchar   |      | 区号            |
| trunk_group_id | int       |      | 所属trunk_group |
| active         | int       |      | 是否激活          |
| enterpriseId   | int       |      | 所属企业id        |
| update_time    | timestamp |      | 更新时间          |
| create_time    | timestamp |      | 创建时间          |

#### 

#### 10.system_setting

系统设置表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明                      |
| ----------- | --------- | ---- | ----------------------- |
| id          | int       | 主键   |                         |
| name        | varchar   |      | 设置名                     |
| value       | varchar   |      | 设置的value，具体格式与name关联    |
| property    | varchar   |      | 设置的property，具体格式与name关联 |
| description | varchar   |      | 设置描述，用于显示               |
| create_time | timestamp |      | 创建时间                    |

#### 11.user

用户表，设计容量10

| 字段名         | 字段类型      | 主外键  | 说明                 |
| ----------- | --------- | ---- | ------------------ |
| id          | int       | 主键   |                    |
| username    | varchar   |      | 用户名，admin是默认用户不能删除 |
| password    | varchar   |      | 密码，md5后存储          |
| mobile      | varchar   |      | 手机号码               |
| email       | varchar   |      | 邮件地址               |
| role_id     | Int       | 外键   | role.id            |
| create_time | timestamp |      | 创建时间               |

#### 12.role

角色表，设计容量10

| 字段名         | 字段类型      | 主外键  | 说明                        |
| ----------- | --------- | ---- | ------------------------- |
| id          | int       | 主键   |                           |
| name        | varchar   |      | 角色名，admin/report是默认用户不能删除 |
| description | varchar   |      | 描述                        |
| create_time | timestamp |      | 创建时间                      |

#### 13.module

模块表，设计容量20

| 字段名         | 字段类型      | 主外键  | 说明                        |
| ----------- | --------- | ---- | ------------------------- |
| id          | int       | 主键   |                           |
| name        | varchar   |      | 角色名，admin/report是默认用户不能删除 |
| description | varchar   |      | 描述                        |
| prefix      | varchar   |      | 模块页面路径前缀                  |
| create_time | timestamp |      | 创建时间                      |

#### 14.role_module

模块表，设计容量20

| 字段名         | 字段类型      | 主外键  | 说明        |
| ----------- | --------- | ---- | --------- |
| id          | int       | 主键   |           |
| role_id     | int       | 外键   | role.id   |
| module_id   | int       | 外键   | module.id |
| update      | int       |      | 是否可以修改配置  |
| create_time | timestamp |      | 创建时间      |



#### 15.acl

ip白名单表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明                                      |
| ----------- | --------- | ---- | --------------------------------------- |
| id          | int       | 主键   |                                         |
| ip          | varchar   |      | ip地址支持通配符比如172.16.203.18/32,10.10.0.0/8 |
| domain_id   | int       | 外键   | domain.id                               |
| description | varchar   |      | 描述                                      |
| create_time | timestamp |      | 创建时间                                    |

#### 16.statistic_setting

实时统计设置表，设计容量100

| 字段名                | 字段类型      | 主外键  | 说明                                    |
| ------------------ | --------- | ---- | ------------------------------------- |
| id                 | int       | 主键   |                                       |
| name               | varchar   |      | 统计名：英文，单次和下划线和数字组成                    |
| event_type         | int       |      | 事件类型：根据cdr中的状态处理，统计值从cdr里来。           |
| statistic_group_id | int       | 外键   | statistic_group.id                    |
| display_name       | varchar   |      | 显示名                                   |
| condition          | varchar   |      | 统计值所需条件支持：= 1= > >= < <= in regrex    |
| Increase_type      | int       |      | 增加的数值类型 1数值 2变量                       |
| increase_value     | varchar   |      | n满足条件后统计项增加的值，数字或data中配置的字段（字段值必须是数字） |
| create_time        | timestamp |      | 创建时间                                  |

#### 17.statistic_group

实时统计组表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明     |
| ----------- | --------- | ---- | ------ |
| id          | int       | 主键   |        |
| name        | varchar   |      | 实时统计组名 |
| description | varchar   |      | 描述     |
| create_time | timestamp |      | 创建时间   |



#### 18.alert_setting

告警设置表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明                                       |
| ----------- | --------- | ---- | ---------------------------------------- |
| id          | int       | 主键   |                                          |
| name        | varchar   |      | 实时统计组名                                   |
| description | varchar   |      | 描述                                       |
| condition   | varchar   |      | Condition用于配置告警需要的条件，可以支持使用变量，支持多个条件的与或非逻辑 |
| level       | int       |      | 告警级别 1:警告 2:错误                           |
| type        | int       |      | 告警类别：1:系统、2:业务、3:自定义                     |
| interval    | int       |      | 支持按1分钟、5分钟、10分钟、60分钟4种                   |
| create_time | timestamp |      | 创建时间                                     |

#### 19.opensips

opensips实例表，设计容量100

| 字段名         | 字段类型      | 主外键  | 说明            |
| ----------- | --------- | ---- | ------------- |
| id          | int       | 主键   |               |
| name        | varchar   |      | opensips名     |
| description | varchar   |      | 描述            |
| ip          | varchar   |      | sip-router ip |
| mi_url      | varchar   |      | mi接口地址        |
| active      | int       |      | 是否激活          |
| status      | int       |      | 状态            |
| uptime      | varchar   |      | 启动时间        |
| create_time | timestamp |      | 创建时间          |

#### 20.load_balancer

负载均衡实例表，设计容量100，load_balancer表和gateway 表一一对应，给opensips模块用于做状态测试。

| 字段名         | 字段类型    | 主外键  | 说明    |
| ----------- | ------- | ---- | ----- |
| id          | int     | 主键   |       |
| group_id    | int     |      | 组id   |
| dst_uri     | varchar |      | 目标uri |
| resources   | varchar |      | 资源列表  |
| probe_mode  | int     |      | 探测模式  |
| description | varchar |      | 描述    |
|             |         |      |       |



### sip-router-report-db库

#### 1.report_service_day

日报表表，设计容量2000000

| 字段名                  | 字段类型      | 主外键  | 说明                                       |
| -------------------- | --------- | ---- | ---------------------------------------- |
| id                   | int       | 主键   |                                          |
| product_id           | int       |      | 产品线id                                    |
| domain_id            | int       |      | 平台id                                     |
| opensips_id          | int       |      | opensips的id                              |
| service_id           | int       |      | 业务id                                     |
| day                  | varchar   |      | YYYY-MM-DD格式                             |
| total_count          | int       |      | 总呼叫次数total_count=success_route_count+limit_count+acl_count+route_fail_count |
| success_route_count  | int       |      | 成功路由个数                                   |
| limit_count      | int       |      | 由于cps/calls限制                               |                          |
| acl_count      | int       |      | 由于acl被拒绝数                                  |
| route_fail_count | int       |      | 没有被正确路由的个数       |
| answer_count         | int       |      | 接通个数                                     |
| answer_duration      | int       |      | 接通分钟数                                    |
| create_time          | timestamp |      | 创建时间                                     |

#### 2.report_service_month

日报表表，设计容量100000

| 字段名                  | 字段类型      | 主外键  | 说明                                       |
| -------------------- | --------- | ---- | ---------------------------------------- |
| id                   | int       | 主键   |                                          |
| product_id           | int       |      | 产品线id                                    |
| domain_id            | int       |      | 平台id                                     |
| opensips_id          | int       |      | opensips的id                              |
| service_id           | int       |      | 业务id                                     |
| month                | varchar   |      | YYYY-MM格式                                |
| total_count          | int       |      | 总呼叫次数total_count=success_route_count+limit_count+acl_count+route_fail_count |
| success_route_count  | int       |      | 成功路由个数   路由成功+接通成功                                |
| limit_count      | int       |      | 由于cps/calls限制                               |                          |
| acl_count      | int       |      | 由于acl被拒绝数                                  |
| route_fail_count | int       |      | 没有被正确路由的个数 没有prefix+无路由配置+无可用路由       |
| answer_count         | int       |      | 接通个数                                     |
| answer_duration      | int       |      | 接通分钟数                                    |
| create_time          | timestamp |      | 创建时间                                     |

#### 3.report_gateway_day

日报表表，设计容量1000000

| 字段名              | 字段类型      | 主外键  | 说明                                       |
| ---------------- | --------- | ---- | ---------------------------------------- |
| id               | int       | 主键   |                                          |
| gateway_id       | int       |      | 网关id                                     |
| gateway_group_id | int       |      | 网关组id                                    |
| opensips_id      | int       |      | opensips的id                              |
| day              | varchar   |      | YYYY-MM-DD格式                             |
| total_count      | int       |      | 总呼叫次数，路由成功+接通成功, 失败次数=total_count-success_route_count |
| answer_count     | int       |      | 接通个数                                     |
| answer_duration  | int       |      | 接通分钟数                                    |
| create_time      | timestamp |      | 创建时间                                     |

#### 4.report_gateway_month

日报表表，设计容量100000

| 字段名             | 字段类型      | 主外键  | 说明                                       |
| --------------- | --------- | ---- | ---------------------------------------- |
| id              | int       | 主键   |                                          |
| gateway_id      | int       |      | 网关id                                     |
| trunk_group_id  | int       |      | 网关组id                                    |
| opensips_id     | int       |      | opensips的id                              |
| month           | varchar   |      | YYYY-MM格式                                |
| total_count     | int       |      | 总呼叫次数，失败次数=total_count-success_route_count |
| answer_count    | int       |      | 接通个数                                     |
| answer_duration | int       |      | 接通分钟数                                    |
| create_time     | timestamp |      | 创建时间                                     |



### redis库

自定义实时统计类 

| 序号   | key                                   | value  | expire            | 说明                    |
| ---- | ------------------------------------- | ------ | ----------------- | --------------------- |
| 1    | sip-router.statistic.${name}.20170929 | String | 设置后24小时+（3小时随机事件） | 统计字段用法，每个name、每天一个key |
| 2    |                                       |        |                   |                       |

#### 固定统计参数类

##### 系统级别
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |
| 1    | sip-router.system.cps.global.${minute}   | String | 24小时过期  | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.dialog.global                 | String |         | 并发calls          | api cdr收集 |
| 3    | sip-router.system.calls.request          | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 4    | sip-router.system.calls.routed           | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 5    | sip-router.system.calls.answered         | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 6    | sip-router.system.calls.duration         | String | 00:00清零 | 已接听分钟数           | api cdr收集 |
| 7    | sip-router.system.calls.limit_acl        | String | 00:00清零 | 因acl失败calls      | api cdr收集 |
| 7    | sip-router.system.calls.limit_global_cps | String | 00:00清零 | 因cps失败calls      | api cdr收集 |
| 8    | sip-router.system.calls.limit_global_calls | String | 00:00清零 | 因calls失败calls    | api cdr收集 |
| 9    | sip-router.system.calls.limit_no_service | String | 00:00清零 | 因无service失败calls | api cdr收集 |
| 10   | sip-router.system.calls.limit_product_caps | String | 00:00清零 | 因calls失败calls    | api cdr收集 |
| 11   | sip-router.system.calls.limit_product_calls | String | 00:00清零 | 因calls失败calls    | api cdr收集 |
| 12    | sip-router.system.calls.limit_no_route   | String | 00:00清零 | 因无路由失败calls      | api cdr收集 |
##### 产品级别         
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |                          
| 1    | sip-router.system.cps.product.${product_id}.${minute} | String | 24小时过期  | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.dialog.product.${product_id}  | String |         | 并发calls          | api cdr收集 |
| 3    | sip-router.system.product.${product_id}.calls.request | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 4    | sip-router.system.product.${product_id}.calls.routed | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 5    | sip-router.system.product.${product_id}.calls.answered | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 6    | sip-router.system.product.${product_id}.calls.duration | String | 00:00清零 | 已接听分钟数           | api cdr收集 |
| 7    | sip-router.system.product.${product_id}.calls.limit_product_cps | String | 00:00清零 | 因cps失败calls      | api cdr收集 |
| 8    | sip-router.system.product.${product_id}.calls.limit_product_calls | String | 00:00清零 | 因calls失败calls    | api cdr收集 |
| 9    | sip-router.system.product.${product_id}.calls.limit_no_route | String | 00:00清零 | 因无路由失败calls      | api cdr收集 |
##### 平台级别 
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |
| 1    | sip-router.system.cps.domain.${domain_id}.${minute} | String | 24小时过期  | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.dialog.domain.${domain_id}    | String |         | 并发calls          | api cdr收集 |
| 3    | sip-router.system.domain.${domain_id}.calls.request | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 4    | sip-router.system.domain.${domain_id}.calls.routed | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 5    | sip-router.system.domain.${domain_id}.calls.answered | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 6    | sip-router.system.domain.${domain_id}.calls.duration | String | 00:00清零 | 已接听分钟数           | api cdr收集 |
| 9    | sip-router.system.domain.${domain_id}.calls.limit_no_route | String | 00:00清零 | 因cps失败calls      | api cdr收集 |
##### 业务级别 
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |
| 1    | sip-router.system.cps.service.${service_id}.${minute} | String | 24小时过期  | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.dialog.service.${service_id}  | String |         | 并发calls          | api cdr收集 |
| 3    | sip-router.system.service.${service}.calls.request | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 4    | sip-router.system.service.${service}.calls.routed | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 5    | sip-router.system.service.${service_id}.calls.answered | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 6    | sip-router.system.service.${service_id}.calls.duration | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 9    | sip-router.system.service.${service_id}.calls.limit_no_route | String | 00:00清零 | 因无路由失败calls      | api cdr收集 |
##### 中级组级别 
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |
| 1    | sip-router.system.cps.trunk_group.${trunk_group_id}.${minute} | String |         | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.system.trunk_group.${trunk_group_id}.calls.request | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 3    | sip-router.system.trunk_group.${trunk_group_id}.calls.routed | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 4    | sip-router.system.trunk_group.${trunk_group_id}.calls.answered | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 5    | sip-router.system.trunk_group.${trunk_group_id}.calls.duration | String | 00:00清零 | 已接分钟数            | api cdr收集 |
##### 网关级别       
| 序号   | key                                      | value  | expire  | 说明               | 数据统计来源    |
| ---- | ---------------------------------------- | ------ | ------- | ---------------- | --------- |
| 1    | sip-router.system.cps.gateway.${gateway_id}.${minute} | String | 24小时过期  | 按分钟cps 统计        | api cdr收集 |
| 2    | sip-router.dialog.gateway.${gateway_id}  | String |         | 并发calls          | api cdr收集 |
| 3    | sip-router.system.gateway.${gateway_id}.calls.request | String | 00:00清零 | 已请求calls         | api cdr收集 |
| 4    | sip-router.system.gateway.${gateway_id}.calls.routed | String | 00:00清零 | 已路由calls         | api cdr收集 |
| 5    | sip-router.system.gateway.${gateway_id}.calls.answered | String | 00:00清零 | 已接听个数            | api cdr收集 |
| 6    | sip-router.system.gateway.${gateway_id}.calls.duration | String | 00:00清零 | 已接分钟数            | api cdr收集 |
|      | 实例级别统计通过MI直接获取                           |        |         |                  |           |
|      |                                          |        |         |                  |           |

conf-db缓存类

| 序号   | 字段                                       | 类型     | 值          | 说明                                       |
| ---- | ---------------------------------------- | ------ | ---------- | ---------------------------------------- |
| 1    | sip-router.conf.system_setting.name.${name} | String | json       | system_setting缓存                         |
| 2    | sip-router.conf.product.id.${id}         | String | json       | product缓存                                |
| 3    | sip-router.conf.product_setting.product_id.${id}.name.${name} | String | json       | product_setting缓存                        |
| 4    | sip-router.conf.domain.id.${id}          | String | json       | domain按id缓存                              |
| 5    | sip-router.conf.domain                   | String | json array | 所有domain列表                               |
| 6    | sip-router.conf.service.prefix.${prefix} | String | json       | service单条数据缓存，带上domainId+productId       |
| 7    | sip-router.conf.router.service_id.${service_id} | String | json array | router数组缓存，按优先级从小到大排列,去除active为未激活的,去除trunk_group未激活的,增加trunkGroupMaxCalls字段 |
| 8    | sip-router.conf.action.router_id.${router_id} | String | json array | action数组缓存，按优先级从小到大排列                    |
| 9    | sip-router.conf.trunk_group.id.${id}     | String | json array | trunk_group缓存，gateway非激活的去除掉，status=0的也去除掉，同时增加每个gateway的percent属性，所有gateway percent相加必须等于100 |
| 11   | sip-router.conf.acl                      | String | json array | acl全部数据缓存                                |
| 12   | sip-router.conf.statistic_setting.event_type.${event_type} | String | json array | 实时统计用配置，按照event_type分组                   |



消息队列类：

| 序号   | key                 | value | 说明          |
| ---- | ------------------- | ----- | ----------- |
| 1    | sip-route.cdr       | json  | 话单入库消息队列key |
| 2    | sip-route.log_route | json  | 入库路由过程的日志   |
| 3    | sip-route.event     | json  | 请求发起处理结果事件  |



#### CDR设计

字段设计

| 序号   | 字段             | 类型        | 说明                                       |
| ---- | -------------- | --------- | ---------------------------------------- |
| 1    | call_id        | varchar   | 通话唯一表示                                   |
| 2    | request_time   | int       | unix时间戳，请求时间                             |
| 3    | routed_time    | int       | unix时间戳，路由出去时间                           |
| 4    | gateway_ip     | varchar   | 对接网关ip                                   |
| 5    | ring_time      | int       | unix时间戳，返回180、183时间，第一次返回为准              |
| 6    | answer_time    | int       | unix时间戳，接通时间                             |
| 7    | end_time       | int       | unix时间戳，结束之间                             |
| 8    | duration       | int       | 接通分钟数                                    |
| 9    | before_clid    | varchar   | 路由前的外显                                   |
| 10   | after_clid     | varchar   | 路由后的外显                                   |
| 11   | before_prefix  | varchar   | 路由前prefix                                |
| 12   | after_prefix   | varchar   | 路由后prefix                                |
| 13   | tel            | varchar   | 去掉prefix的呼叫号码，不带区号                       |
| 14   | areacode       | varchar   | 被叫区号                                     |
| 15   | sp             | varchar   | 北京运营商                                    |
| 16   | status         | int       | 状态1:路由失败2:路由成功3:接通成功                     |
| 17   | sip_code       | int       | 路由成功中没有接通的返回sip_code 4xx/5xx/6xx等        |
| 18   | fail_code      | int       | 路由失败原因1:acl未通过 2:超全局cps 3:超全局calls 4:没有service 5:超产品cps 6:超产品calls 7:无路由配置 8:无可用路由 |
| 19   | end_reason     | int       | 1:发起者挂断 2:转接者挂断 3:超时挂断 4:MI挂断            |
| 19   | create_time    | timestamp | 创建时间                                     |
| 20   | service_id     | int       | 业务id                                     |
| 21   | domain_id      | int       | 平台id                                     |
| 22   | product_id     | int       | 产品线id                                    |
| 23   | trunk_group_id | int       | 对接网关组id                                  |
| 24   | gateway_id     | int       | 对接网关id                                   |
| 25   | enterprise_id  | varchar   | 企业id                                     |
| 26   | call_type      | int       | 呼叫类型                                     |
| 27   | from_ip        | varchar   | 来源ip                                     |
| 28   | ...            | varchar   | 其他打入cdr_tag中的字段，支持0-n个自定义字段              |
| 29   | ...            | varchar   | 其他打入cdr_tag中的字段，支持0-n个自定义字段              |

cdr自定义字段支持在action中设置

`cdr_tag_1_name;cdr_tag_1_value, cdr_tag_2_name;cdr_tag_2_value, ... 除此之外还要设置cdr_tag_count=n,设置自定义tag的个数,变量设置在dlg_val中`

这样的变量值。



#### 日志记录

1. log_action

| 字段名         | 字段类型      | 主外键  | 说明                             |
| ----------- | --------- | ---- | ------------------------------ |
| id          | int       | 主键   |                                |
| user_id     | int       |      | 用户id                           |
| type        | int       |      | 1:增 2:删 3:改 4:查 5:导出 6:登录 7:退出 |
| object      | varchar   |      | 操作对象描述                         |
| ip          | varchar   |      | 请求的ip地址来源                      |
| create_time | timestamp |      | 创建时间                           |

2. log_router

| 字段名          | 字段类型      | 主外键  | 说明                                       |
| ------------ | --------- | ---- | ---------------------------------------- |
| id           | int       | 主键   |                                          |
| call_id      | varchar   |      | call-id                                  |
| router_id    | int       |      | 最后选择的路由id                                |
| request_time | timestamp |      | 请求路由时间                                   |
| actions      | varchar   |      | 路由的动作列表json格式[{"action":"add_prefix","value":"112"},{"action":"set_clid", "value":"01087120766"},{"action":"add_header","value":"call_type=123"}] |
| create_time  | timestamp |      | 创建时间                                     |

3. log_alert

| 字段名         | 字段类型      | 主外键  | 说明                |
| ----------- | --------- | ---- | ----------------- |
| id          | int       | 主键   |                   |
| level       | int       |      | 级别                |
| type        | int       |      | 类型                |
| name        | varchar   |      | 名字                |
| description | varchar   |      | 描述                |
| msg         | varchar   |      | 告警消息              |
| ack         | int       |      | 是否已处理 1是已处理 0是未处理 |
| create_time | timestamp |      | 创建时间              |

#### 

opensips脚本变量定义：

| 变量名               | 类型   | 说明        | 示例                                       |
| ----------------- | ---- | --------- | ---------------------------------------- |
| service_prefix    | avp  | 业务前缀      | 111                                      |
| service_prefix_op | avp  | 发送后的前缀    |                                          |
| clid              | avp  | 外显号码      | 89170766                                 |
| tel_areacode      | avp  |           |                                          |
| tel               | avp  | 被叫号码去掉区号  | 89170766;13900009999;4006869009;95555    |
| original_tel      | avp  | 被叫号码全称    | 01089170877;01013910080008;4006869009;01095555 |
| product_id        | avp  | 产品id      | 1                                        |
| domain_id         | avp  | 平台id      | 1                                        |
| service_id        | avp  | 业务id      | 2                                        |
| enterprise_id     | avp  | 企业id      | 7000001                                  |
| gateway_id        | avp  | 网关id      | 1                                        |
| global_max_calls  | shv  | 全局最大calls | 100000                                   |
| global_max_cps    | shv  | 全局最大cps   | 1000                                     |
| product_max_calls | avp  | 产品最大calls | 2000                                     |
| product_max_cps   | avp  | 产品最大cps   | 100                                      |
| trunk_group_id    | avp  | 中继组id     | 1                                        |
| call_type         | avp  | 呼叫类型      | 4                                        |
| fail_code         | var  | 失败类型      | 3                                        |


### jmx 监控项：

|监控项|说明|计量周期|
|------------|----------|
|avgRouteDuration|ms|分钟|
|maxRouteDuration|ms|分钟|
|||
