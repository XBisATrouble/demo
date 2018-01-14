# 接口文档

[TOC]

## 说明

### 1、状态码

>| 状态编码      |     参数类型 |  
>| :-------- | :--------|
>|200|   处理成功| 
>|404|   找不到相关信息| 
>|401|   密码输入错误| 
>|501|   数据库操作出错| 
>|500|   服务器出错| 

### 2、时间格式
>yyyy-MM-dd HH:mm:ss, 如"2017年4月22日11:02:43"

## 监测站模块

### 接口说明 1、获取所有的监测站

- **请求URL**
> [http://111.231.64.125/v1/stations](http://111.231.64.125/v1/stations)


- **请求方式** 
>**GET**

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|

- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "操作成功",
    "data": [
        {
            "id": 1,
            "name": "重庆市监测站",
            "position": "重庆",
            "password": null,
            "created_at": "2018-01-13 23:01:24",
            "started_at": "2018-01-13 23:01:25"
        },
        {
            "id": 2,
            "name": "成都市监测站",
            "position": "成都",
            "password": null,
            "created_at": "2018-01-13 17:36:26",
            "started_at": "2018-01-13 17:36:28"
        },
    ]
}
```


### 接口说明 2、获取单个监测站信息

- **请求URL**
> [http://111.231.64.125 /v1/station/{id}](http://111.231.64.125/v1/stations/{id})


- **请求方式** 
>**GET**

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "操作成功",
    "data": {
        "id": 2,
        "name": "成都市监测站",
        "position": "成都",
        "password": "wreGyPgRvMY=",
        "created_at": "2018-01-13 17:36:26",
        "started_at": "2018-01-13 17:36:28"
    }
}
```

### 接口说明 3、创建一个监测站

- **请求URL**
> [http://111.231.64.125/v1/stations/{id}](http://111.231.64.125/v1/stations/{id})


- **请求方式** 
>**POST**

- **请求参数**
> | 请求参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| name |String|姓名|
>|position|String|位置|
>|password|String|密码|
> |created_at|String|创建时间|
> |started_at|String|启用时间|

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "插入成功",
    "data": {
        "id": 0,
        "name": "tesest",
        "position": "123",
        "password": "wreGyPgRvMY=",
        "created_at": null,
        "started_at": null
    }
}
```

### 接口说明 4、删除一个监测站

- **请求URL**
> [http://111.231.64.125/v1/stations/{id}](http://111.231.64.125/v1/stations/{id})


- **请求方式** 
>**DELETE**

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "删除成功",
    "data": null
}
```

### 接口说明 5、更新一个监测站内容

- **请求URL**
> [http://111.231.64.125/v1/stations/{id}](http://111.231.64.125/v1/stations/{id})


- **请求方式** 
>**PUT**

- **请求参数**
> | 请求参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| name |String|姓名|
>|position|String|位置|
>|password|String|密码|

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "更新成功",
    "data": {
        "id": 8,
        "name": "tesest",
        "position": "1233",
        "password": "123123",
        "created_at": null,
        "started_at": null
    }
}
```

### 接口说明 6、监测站用户登陆

- **请求URL**
> [http://111.231.64.125/v1/auth](http://111.231.64.125/v1/auth)


- **请求方式** 
>**POST**

- **请求参数**
> | 请求参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| id|String|id:10000|
>|password|String|密码:123123|

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "登陆成功",
    "data": {
        "id": 8,
        "name": "tesest",
        "position": "1233",
        "password": "wreGyPgRvMY=",
        "created_at": "2018-01-14 00:37:19",
        "started_at": "2018-01-14 00:45:15"
    }
}
//错误
{
    "rspCode": "401",
    "rspMsg": "密码输入错误",
    "data": null
}
```

### 接口说明 7、监测站用户更改密码

- **请求URL**
> [http://111.231.64.125/v1/auth](http://111.231.64.125/v1/auth)


- **请求方式** 
>**PUT**

- **请求参数**
> | 请求参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| name |String|姓名|
>|position|String|位置|
>|password|String|密码|

- **返回**
> | 返回参数      |     参数类型 |   参数说明   |
>| :-------- | :--------| :------ |
>| rspCode| String | 执行结果code|
>| rspMsg | String | 信息|
>| data | Object | 监测站实例|


- **返回示例**
>    
```json
{
    "rspCode": "200",
    "rspMsg": "密码更新成功",
    "data": {
        "id": 8,
        "name": "tesest",
        "position": "1233",
        "password": "yeVfgkr1nb4=",
        "created_at": "2018-01-14 00:37:19",
        "started_at": "2018-01-14 00:45:15"
    }
}
```