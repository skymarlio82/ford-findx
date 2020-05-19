# ford-findx for Ford Auto China

## API URL explain
- http://localhost:8080/ford-findx/ (登录的形式化主页面，点击按钮后会跳到github后台做用户名密码校验)
- http://localhost:8080/ford-findx/authorization/callback (github的OAuth2回调路径，主要做提取token，拿用户的信息，同样也包括站点产生的二次token)
- http://localhost:8080/ford-findx/system/dashboard?token= (将成功提取的github用户信息打印在页面上)
- http://localhost:8080/ford-findx/api/map/search?lat=39.915&lng=116.404 (去连百度地图的API(ak已经绑定我的手机话)然后基于逻辑提取在一个坐标点为圆心，5公里为半径的中石化加油站和福特4S店的地标点)
- http://localhost:8080/ford-findx/api/map/tops (统计经最高频被搜索的加油站和4S店)
- H2 作为临时内存数据库
- 利用GitHub来做OAuth2身份认证 (已经连入我本人的clientId和secret)，并且在这基础上加上了Shiro作为分角色授权的管理体系
- 做了3个H5页面
- 使用spring-boot-2.1.4完成所有功能
- 代码已经提交进入github仓库当中

## screenshots
- GitHub的OAuth2配置(clientId + secret)
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic01.png)
- 本地应用登录Guthub认证中心的效果
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic02.png)
- 从Guthub提取真实用户信息
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic03.png)
- API:用户输入任意重要地标查询半径5公里范围内最近的中石化加油站和福特4S店，将结果记录。
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic04.png)
- API:查询系统中每个用户查询最频繁的加油站和4S店
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic05.png)
- shiro按照角色赋予权限
![image](https://github.com/skymarlio82/ford-findx/blob/master/screens/pic06.png)