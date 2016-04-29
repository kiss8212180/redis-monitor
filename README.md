# redis-monitor
Redis 监控 
clone for https://github.com/litiebiao2012/redis-monitor
## install

### ubuntu 下运行
sudo apt-get install maven
mvn tomcat7:run
### war  
mvn war

打开浏览器 : http://127.0.0.1:8888/

登录验证说明:
1 本机不管输入什么都通过
2 远程访问时,用户名为admin,密码在第一次登录时后台自动生成(启动后查看控制台输出)