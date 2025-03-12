# Sử dụng image Java chính thức
FROM openjdk:17-jdk-slim

# Đặt biến môi trường cho ứng dụng
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Sao chép file WAR vào container
COPY target/shoplaptop.war shoplaptop.war

# Chạy ứng dụng Spring Boot với lệnh java -jar
CMD ["java", "-jar", "shoplaptop.war"]

# lệnh build bằng Maven Wrapper
#mvnw.cmd clean package -DskipTests
