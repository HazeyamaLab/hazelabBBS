# hazelabBBS

動的Webプロジェクトのサンプルです．  

## Requirement

- `java 1.8+`
- `Apach Tomcat 8.0+`

## Installation

1. clone this project

```
$ git clone https://github.com/HazeyamaLab/hazelabBBS.git
```

2. import project to Eclipse

  「メニュー」 -> 「インポート」 -> 「Gitからプロジェクト」 -> 「既存ローカルリポジトリ」  
  `hazelabBBS` -> 「新規プロジェクト・ウィザードを使用してインポート」 -> 「Web」 -> 「動的webプロジェクト」  
  「ターゲットランタイム」 -> `Apach Tomcat 8.0+`


3. bulid and run

  「実行」 -> 「サーバーで実行」


## dockerの使い方
### dockerfileの場合
以下で，`Dockerfile`から`image`をつくる．
```
$ docker image build -t deploy:latest .
```
作った`image`を実行
```
docker run -it --privileged -d -p 8080:8080 --name bbs deploy:latest /sbin/init
```

### Docker-composeの場合
```
docker-compose up -d
```

## CD
やって見る
