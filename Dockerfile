FROM openjdk:14.0.2-slim

ENV SPRING_BOOT_HOME=/opt/spring-boot \
    LANG=ja_JP.UTF-8

RUN rm -f /etc/localtime && \
    mkdir -p /opt/spring-boot && chmod 755 /opt/spring-boot && \
    apt-get update && apt-get install -y curl

WORKDIR /opt/spring-boot
ADD ./target/spring-boot-batch-demo-0.0.1-SNAPSHOT.jar /opt/spring-boot/

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/spring-boot/spring-boot-batch-demo-0.0.1-SNAPSHOT.jar"]
