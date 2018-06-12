<style>
table  {
    background:red;
    width: 100px;
}
</style>


表情一： :maple_leaf:,表情二： :hatched_chick:

变量type定义，包括nameType和valueType，定义一致：
<table style="background-color:blue;">
  <tr>
    <th width=10% >type</th>
    <th width=30%>说明</th>
    <th >示例</th>
  </tr>
  <tr>
    <td >1 </td>
    <td> 字符串  </td>
    <td> tell  </td>
  </tr>
  <tr>
    <td >2 </td>
    <td> 固定变量 </td>
    <td> ci </td>
  <tr>
    <td >3 </td>
    <td> avp变量 </td>
    <td>  tel_areacode_len </td>
  </tr>
  <tr>
    <td >4 </td>
    <td> 随机字符串 </td>
    <td> json结构的字符串，例如：
    
```

    "[
        {
            "percent": "80",
            "randomstr": [
                "test1,test2,test3"
            ],
            "randomSize": 3
        },
        {
            "percent": "20",
            "randomstr": [
                "test1,test2,test3"
            ],
            "randomSize": 3
        }
    ]"
    
```
（系统会在此数组中根据比例选择对应的`randomstr`字段中的值随机选择一个,此字段最大支持100个
 设置号码段<br/>
 例子:
- 075588646700+3 
  - 075588646700, 075588646701, 075588646702,075588646703
- 075588646801+9 
  - 075588646801, 075588646802, 075588646803, 075588646804, 075588646805, 075588646806,075588646807, 075588646808, 075588646809, 075588646810
- 075588646901 
  - 075588646901
 
    </td>
  </tr>
</table>

| type | 说明               | 示例               |
| ---- | ------------------ | ------------------ |
| 1    | 字符串             | tell               |
| 2    | 固定变量           | ci                 |
| 3    | avp变量            | tel_areacode_len   |
| 4    | hdr SIP Header变量 | callType           |
| 5    | 被叫号码av变量     | status             |
| 6    | 主叫号码av变量     | trunkGroup/carrier |
| 7    | 随机字符串    | <br/>
json结构的字符串，例如：
```json
"[{"percent":"80", "randomstr":["test1,test2,test3"], 
"randomSize":3 },{"percent":"20", "randomstr":["test1,test2,test3"], "randomSize":3}]"
```

（系统会在此数组中根据比例选择对应的`randomstr`字段中的值随机选择一个,此字段最大支持100个 
设置号码段例子:075588646700+3,075588646801+9,075588646901,
代码自动展开结果：075588646700,075588646701,075588646702,075588646703,075588646801,075588646802,075588646803,
075588646804,075588646805,075588646806,075588646807,075588646808,075588646809,075588646810,075588646901|
 
 
 <table style="width:10px;height:20px;">
 	<th>表头</th>
 	<tr>表体</tr>
 </table>
 
 [http://www.baidu.com]
 
 <http://www.baidu.com>
 
 This is [an example](http://example.com/ "Title") inline link.
 
 **加粗**
 
 *加斜*
 
 ~~删除线~~
 >这是引用的内容
 >>这是二次引用的内容
 
 - 1
 - 2
 - 3
    + 1
    + 2
    + 3
    
    
<table>
  <tr>
    <th width=10%, bgcolor=yellow >参数</th>
    <th width=40%, bgcolor=yellow>详细解释</th>
    <th width="50%", bgcolor=yellow>备注</th>
  </tr>
  <tr>
    <td bgcolor='red'> -l </td>
    <td> use a long listing format  </td>
    <td> 以长列表方式显示（显示出文件/文件夹详细信息）  </td>
  </tr>
  <tr>
    <td bgcolor='yellow'>-t </td>
    <td> sort by modification time </td>
    <td> 按照修改时间排序（默认最近被修改的文件/文件夹排在最前面） </td>
  <tr>
    <td bgcolor=rgb(0,10,0)>-r </td>
    <td> reverse order while sorting </td>
    <td>  逆序排列 </td>
  </tr>
</table>


表情一：:+1:,表情二：:o:
