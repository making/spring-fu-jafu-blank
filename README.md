# Spring Fu (Jafu) Blank project

Maven archetype to create a pre-configured maven project for [Spring Fu](https://github.com/spring-projects/spring-fu) (Jafu).

## Create a blank project using maven archetype

### How to use

```
mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=spring-fu-jafu-blank-archetype\
 -DarchetypeVersion=0.0.4
```

### Example

```
$ mvn archetype:generate\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=spring-fu-jafu-blank-archetype\
 -DarchetypeVersion=0.0.4\
 -DgroupId=com.example\
 -DartifactId=demo-fu\
 -Dversion=1.0.0-SNAPSHOT\
 -B

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] 
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] Archetype repository not defined. Using the one from [am.ik.archetype:spring-fu-jafu-blank-archetype:0.0.3] found in catalog remote
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/spring-fu-jafu-blank-archetype/0.0.4/spring-fu-jafu-blank-archetype-0.0.4.pom
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/spring-fu-jafu-blank-archetype/0.0.4/spring-fu-jafu-blank-archetype-0.0.4.pom (2.6 kB at 6.8 kB/s)
[INFO] Downloading from central: https://repo.maven.apache.org/maven2/am/ik/archetype/spring-fu-jafu-blank-archetype/0.0.4/spring-fu-jafu-blank-archetype-0.0.4.jar
[INFO] Downloaded from central: https://repo.maven.apache.org/maven2/am/ik/archetype/spring-fu-jafu-blank-archetype/0.0.4/spring-fu-jafu-blank-archetype-0.0.4.jar (5.4 kB at 10 kB/s)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: spring-fu-jafu-blank-archetype:0.0.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: demo-fu
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: packageInPathFormat, Value: com/example
[INFO] Parameter: package, Value: com.example
[INFO] Parameter: groupId, Value: com.example
[INFO] Parameter: artifactId, Value: demo-fu
[INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
[INFO] Project created from Archetype in dir: /private/tmp/demo-fu
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.258 s
[INFO] Finished at: 2018-11-26T01:23:06+09:00
[INFO] Final Memory: 15M/60M
[INFO] ------------------------------------------------------------------------

$ tree demo-fu
demo-fu
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           ├── App.java
    │   │           ├── HelloHandler.java
    │   │           ├── Message.java
    │   │           └── MessageHandler.java
    │   └── resources
    │       └── application.properties
    └── test
        ├── java
        │   └── com
        │       └── example
        │           └── IntegrationTest.java
        └── resources
            └── junit-platform.properties

11 directories, 8 files
```



```
$ cd demo-fu
$ mvn clean package
$ java -jar target/demo-fu-1.0.0-SNAPSHOT.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.0.RELEASE)

2018-11-26 01:24:26.262  INFO 97031 --- [           main] com.example.App                          : Starting App v1.0.0-SNAPSHOT on makinoMacBook-puro.local with PID 97031 (/private/tmp/demo-fu/target/demo-fu-1.0.0-SNAPSHOT.jar started by maki in /private/tmp/demo-fu)
2018-11-26 01:24:26.266  INFO 97031 --- [           main] com.example.App                          : No active profile set, falling back to default profiles: default
2018-11-26 01:24:26.820  WARN 97031 --- [           main] reactor.netty.tcp.TcpResources           : [http] resources will use the default LoopResources: DefaultLoopResources {prefix=reactor-http, daemon=true, selectCount=8, workerCount=8}
2018-11-26 01:24:26.820  WARN 97031 --- [           main] reactor.netty.tcp.TcpResources           : [http] resources will use the default ConnectionProvider: PooledConnectionProvider {name=http, poolFactory=reactor.netty.resources.ConnectionProvider$$Lambda$307/0x0000000800312c40@5efa40fe}
2018-11-26 01:24:26.894  INFO 97031 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
2018-11-26 01:24:26.902  INFO 97031 --- [           main] com.example.App                          : Started App in 1.025 seconds (JVM running for 1.48)
```

```
$ curl localhost:8080
Hello World!
```

Following libraries will be included:

```
$ mvn dependency:list | grep ':compile' | sort
[INFO]    am.ik.yavi:yavi:jar:0.0.18:compile -- module yavi (auto)
[INFO]    ch.qos.logback:logback-classic:jar:1.2.3:compile -- module logback.classic (auto)
[INFO]    ch.qos.logback:logback-core:jar:1.2.3:compile -- module logback.core (auto)
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile -- module jackson.annotations (auto)
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.9.7:compile -- module com.fasterxml.jackson.core [auto]
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.9.7:compile -- module com.fasterxml.jackson.databind [auto]
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.9.7:compile -- module com.fasterxml.jackson.datatype.jdk8 [auto]
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.7:compile -- module com.fasterxml.jackson.datatype.jsr310 [auto]
[INFO]    com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.9.7:compile -- module com.fasterxml.jackson.module.paramnames [auto]
[INFO]    io.netty:netty-buffer:jar:4.1.29.Final:compile -- module io.netty.buffer [auto]
[INFO]    io.netty:netty-codec-http2:jar:4.1.29.Final:compile -- module io.netty.codec.http2 [auto]
[INFO]    io.netty:netty-codec-http:jar:4.1.29.Final:compile -- module io.netty.codec.http [auto]
[INFO]    io.netty:netty-codec-socks:jar:4.1.29.Final:compile -- module io.netty.codec.socks [auto]
[INFO]    io.netty:netty-codec:jar:4.1.29.Final:compile -- module io.netty.codec [auto]
[INFO]    io.netty:netty-common:jar:4.1.29.Final:compile -- module io.netty.common [auto]
[INFO]    io.netty:netty-handler-proxy:jar:4.1.29.Final:compile -- module io.netty.handler.proxy [auto]
[INFO]    io.netty:netty-handler:jar:4.1.29.Final:compile -- module io.netty.handler [auto]
[INFO]    io.netty:netty-resolver:jar:4.1.29.Final:compile -- module io.netty.resolver [auto]
[INFO]    io.netty:netty-transport-native-epoll:jar:linux-x86_64:4.1.29.Final:compile -- module io.netty.transport.epoll [auto]
[INFO]    io.netty:netty-transport-native-unix-common:jar:4.1.29.Final:compile -- module io.netty.transport.unix.common [auto]
[INFO]    io.netty:netty-transport:jar:4.1.29.Final:compile -- module io.netty.transport [auto]
[INFO]    io.projectreactor.netty:reactor-netty:jar:0.8.2.RELEASE:compile -- module reactor.netty (auto)
[INFO]    io.projectreactor:reactor-core:jar:3.2.2.RELEASE:compile -- module reactor.core (auto)
[INFO]    org.apache.logging.log4j:log4j-api:jar:2.11.1:compile -- module org.apache.logging.log4j
[INFO]    org.apache.logging.log4j:log4j-to-slf4j:jar:2.11.1:compile -- module org.apache.logging.slf4j [auto]
[INFO]    org.reactivestreams:reactive-streams:jar:1.0.2:compile -- module org.reactivestreams [auto]
[INFO]    org.slf4j:jul-to-slf4j:jar:1.7.25:compile -- module jul.to.slf4j (auto)
[INFO]    org.slf4j:slf4j-api:jar:1.7.25:compile -- module slf4j.api (auto)
[INFO]    org.springframework.boot:spring-boot-autoconfigure:jar:2.1.0.RELEASE:compile -- module spring.boot.autoconfigure [auto]
[INFO]    org.springframework.boot:spring-boot-starter-json:jar:2.1.0.RELEASE:compile -- module spring.boot.starter.json [auto]
[INFO]    org.springframework.boot:spring-boot-starter-logging:jar:2.1.0.RELEASE:compile -- module spring.boot.starter.logging [auto]
[INFO]    org.springframework.boot:spring-boot-starter-reactor-netty:jar:2.1.0.RELEASE:compile -- module spring.boot.starter.reactor.netty [auto]
[INFO]    org.springframework.boot:spring-boot-starter-webflux:jar:2.1.0.RELEASE:compile -- module spring.boot.starter.webflux [auto]
[INFO]    org.springframework.boot:spring-boot-starter:jar:2.1.0.RELEASE:compile -- module spring.boot.starter [auto]
[INFO]    org.springframework.boot:spring-boot:jar:2.1.0.RELEASE:compile -- module spring.boot [auto]
[INFO]    org.springframework.fu:spring-fu-jafu:jar:0.0.3.BUILD-SNAPSHOT:compile -- module spring.fu.jafu (auto)
[INFO]    org.springframework:spring-aop:jar:5.1.2.RELEASE:compile -- module spring.aop [auto]
[INFO]    org.springframework:spring-beans:jar:5.1.2.RELEASE:compile -- module spring.beans [auto]
[INFO]    org.springframework:spring-context:jar:5.1.2.RELEASE:compile -- module spring.context [auto]
[INFO]    org.springframework:spring-core:jar:5.1.2.RELEASE:compile -- module spring.core [auto]
[INFO]    org.springframework:spring-expression:jar:5.1.2.RELEASE:compile -- module spring.expression [auto]
[INFO]    org.springframework:spring-jcl:jar:5.1.2.RELEASE:compile -- module spring.jcl [auto]
[INFO]    org.springframework:spring-web:jar:5.1.2.RELEASE:compile -- module spring.web [auto]
[INFO]    org.springframework:spring-webflux:jar:5.1.2.RELEASE:compile -- module spring.webflux [auto]
[INFO]    org.synchronoss.cloud:nio-multipart-parser:jar:1.1.0:compile -- module nio.multipart.parser (auto)
[INFO]    org.synchronoss.cloud:nio-stream-storage:jar:1.1.3:compile -- module nio.stream.storage (auto)
```

## License

Licensed under the Apache License, Version 2.0.
