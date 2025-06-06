# Build stage
FROM ghcr.io/graalvm/native-image:21 AS build
WORKDIR /workspace
COPY spring-backend/pom.xml spring-backend/
COPY spring-backend/src spring-backend/src
WORKDIR /workspace/spring-backend
RUN mvn -Pnative -DskipTests package

# Runtime stage
FROM alpine:3.19
WORKDIR /app
COPY --from=build /workspace/spring-backend/target/nav-backend /app/nav-backend
EXPOSE 8080
CMD ["./nav-backend"]
