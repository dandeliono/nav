# znav
基于 Spring Boot 和 PostgreSQL 的导航网站后端，使用 GraalVM native image 构建精简运行环境。
## Docker部署
```shell
### 1.拉取项目
mkdir /data && cd /data
git clone https://github.com/zhanghao123321/nav.git
cd nav
### 2.按需修改docker-compose.image.yml文件

### 3.运行打包镜像
docker-compose -f docker-compose.image.yml up -d

### 4.重新构建镜像
docker-compose -f docker-compose.build.yml up --build -d

后端构建使用 GraalVM 生成原生镜像，数据库默认使用 PostgreSQL。

### web访问：
http://你的IP
admin
admin

```
前台：
![image](https://github.com/zhanghao123321/nav/blob/main/foreground.png)

后台：
![image](https://github.com/zhanghao123321/nav/blob/main/background.png)

## K8S部署
```shell
### 1.构建服务
mkdir /data && cd /data
git clone https://github.com/zhanghao123321/nav.git
cd nav
kubectl apply -f postgres-pv.yaml
kubectl apply -f postgres-deployment.yaml
kubectl apply -f backend-deployment.yaml
kubectl apply -f frontend-deployment.yaml
kubectl apply -f znav-ingress.yaml

### 2.查看服务
kubectl get pod,svc,ingress  -n production
```

主要接口：
```
POST /api/login        登录获取 JWT
GET  /api/applications 获取应用列表
GET  /api/menus        获取菜单列表
```
