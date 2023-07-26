# port-scanner.cli.java

🫣🫣🫣 Javaでポートスキャナーを作成する！  

## 実行方法

```shell
docker build -t port-scanner-cli-java . --build-arg host=github.com --build-arg start=1 --build-arg end=100
docker run --rm --name port-scanner-cli-java port-scanner-cli-java
```
