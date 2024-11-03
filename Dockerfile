# 1. Mavenの公式イメージをビルドステージとして使用
FROM maven:3.8.6-eclipse-temurin-17 AS build

# 2. 作業ディレクトリを設定
WORKDIR /Amerinflower

# 3. pom.xmlを先にコピーして依存関係をキャッシュする
COPY pom.xml ./

# 4. ソースコードをコピー
COPY src ./src

# mvnwを使ってビルド
RUN mvn clean package -DskipTests



