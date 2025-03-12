# Sử dụng OpenJDK 17 làm môi trường build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng
RUN mvn clean package -DskipTests

# Tạo image chạy ứng dụng
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy file WAR từ giai đoạn build vào
COPY --from=build /app/target/shoplaptop.war shoplaptop.war

# Chạy ứng dụng
CMD ["java", "-jar", "shoplaptop.war"]

# lệnh build bằng Maven Wrapper
#mvnw.cmd clean package -DskipTests
