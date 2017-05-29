renren-security项目结构的说明
├─doc  项目SQL语句
├─renren-common 公共模块
│  ├─annotation 公共注解
│  ├─oss 云存储服务
│  ├─validator 后台校验
│  └─db.properties 数据库配置文件
│
├─renren-api API模块（接口开发）
│
├─renren-gen 代码生成器模块
│  ├─template 代码生成器模板（可增加或修改相应模板）
│  └─generator.properties 配置文件（配置包名、类型转换等）
│
├─renren-schedule 定时任务模块
│
├─renren-shiro 权限模块
│
├─renren-shiro-dept 部门权限模块（待开发）
│
├──renren-web 管理后台模块
│  ├─js 系统业务js代码
│  ├─statics 第三方库、插件等静态资源
│  ├─index.html AdminLTE主题风格（默认主题）
│  └─index1.html Layui主题风格
