# 豆瓣电影
豆瓣电影客户端，目前只提供当前热映电影列表和相应详情页，采用MD。

## 架构相关
- 依赖注入使用[Dagger2, a fast dependency injector for Android and Java.](http://google.github.io/dagger/)
- 网联模块使用square全家桶，即[okhttp](http://square.github.io/okhttp/)+[retrofit](http://square.github.io/retrofit/)，使用gson序列化
- 采用[facebook flux](https://facebook.github.io/flux/)架构组织代码，具体见`feature/flux`分支
- 采用mvp(model + view + presention)组织代码，具体见`feature/mvp`分支

## 预览
![](screenshots/Screenshot_20160501-010803.png) ![](screenshots/Screenshot_20160501-010820.png)
![](screenshots/Screenshot_20160501-010858.png)
