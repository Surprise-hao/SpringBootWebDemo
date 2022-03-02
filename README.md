# 使用spring boot开发的web样例
###从零摸索搭建，代码中包含注释说明
#### 使用组件的版本
```text
SpringBoot: 2.5.3
数据库等其他: 写明于src/main/resources/init/docker/启动外部组件.sh
```
#### 此样例整合了如下内容
```text
01. mybatis-plus 操作数据库、生成实体类
02. 配置文件读取（com.example.springbootwebdemo.property中测试了@Value、Environment、@ConfigurationProperties方式，最后选用@ConfigurationProperties方式）
03. baomidou动态多数据源+druid连接池
04. spring cache + redis 缓存
05. spring security + jwt 鉴权
06. spring schedule 定时任务
07. spring jms + activemq5 异步消息
08. maven + spring profile 联动多环境配置文件
09. 全局controller异常捕获
10. 切面日志记录
11. 登录邮件提醒
12. 配置文件加密
13. 缓存中转，批量存库
14. 控制台彩色日志和sql打印，日志文件按级别分类并按大小触发打包，按时间删除
15. knife4j + swagger 文档
16. 携带token验证的websocket样例
17. hl7拼装工具
```
#### 初始化说明
```text
位于src/main/resources/init文件夹下，包含docker和sql脚本
```
#### 使用整合后的框架
| 业务类         | 需实现的接口           |
    | --------- |      -----------     |
   | 日志实体   | GlobalLog            |
  | 日志服务    | GlobalLogService     |
 | 登录实体    | MyLoginAccount       |
| 登录服务     | MyLoginAccountService|
```text
访问knife4j的路径：/doc.html
mybatisplus根据数据库生成实体：com.example.springbootwebdemo.core.utils.GenerateJavaFromDb
根据mybatisplus注解的实体生成批量新增xml映射代码：com.example.springbootwebdemo.core.utils.GenerateMybatisXmlBatchInsertUtil
token和登录实体的使用样例：com.example.springbootwebdemo.demo.controller.TokenController
无需token验证的路径：追加于配置文件的app.token.ignore-path项
非@AuthenticationPrincipal方式获取登录实体样例：com.example.springbootwebdemo.demo.service.impl.IGlobalLogServiceImpl::setRequestInfo
jms-activemq5发送样例：com.example.springbootwebdemo.demo.service.impl.LoginAccountServiceImpl::remindLogin
jms-activemq5接收样例：com.example.springbootwebdemo.demo.jms.MyJmsOrderReceiver、com.example.springbootwebdemo.core.jms.JmsOrderReceiver
读取配置文件样例：com.example.springbootwebdemo.demo.controller.PropertyController、com.example.springbootwebdemo.demo.property.PropertyDemo
携带token验证的websocket样例：com.example.springbootwebdemo.demo.websocket、src/main/resources/static/websocket/
spring-cache缓存的使用样例：com.example.springbootwebdemo.demo.controller.TokenController::testUseful
redis的使用、缓存中转，批量存库样例：com.example.springbootwebdemo.demo.service.impl.IGlobalLogServiceImpl::saveLog、com.example.springbootwebdemo.demo.task.BatchSaveDbTask::log
mybaitsplus分页查询样例：com.example.springbootwebdemo.demo.controller.TokenController.getLoginNames、com.example.springbootwebdemo.demo.service.impl.LoginAccountServiceImpl::getAllLoginName
hl7拼装工具示例：com.example.springbootwebdemo.demo.task.SelfHl7UtilDemo
```
