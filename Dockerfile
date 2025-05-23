# Stage 1: Build với Maven và Amazon Corretto 21 (Java 17 LTS)
FROM maven:3.9.9-amazoncorretto-24 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Sử dụng package thay vì war nếu ứng dụng của bạn là Spring Boot executable jar
RUN mvn clean package -DskipTests

# Stage 2: Runtime với Amazon Corretto 21 Alpine
FROM amazoncorretto:24-alpine3.20
WORKDIR /app

# Thiết lập non-root user
RUN addgroup -S appgroup && \
    adduser -S appuser -G appgroup && \
    chown appuser:appgroup /app

# Copy đúng file jar từ build stage
COPY --from=build --chown=appuser:appgroup /app/target/shoplaptop.jar ./app.jar

# Chuyển sang user không có quyền root
USER appuser

# Thiết lập timezone
ENV TZ=Asia/Ho_Chi_Minh
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Port ứng dụng
EXPOSE 8080

# Lệnh khởi chạy với các tham số tối ưu cho container
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]