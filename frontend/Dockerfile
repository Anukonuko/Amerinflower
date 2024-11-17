# ベースとなるNode.jsの公式イメージを使用
FROM node:18.18-alpine

# 作業ディレクトリを設定
WORKDIR /app

# package.jsonとpackage-lock.jsonをコピー
COPY package*.json ./

# 依存関係をインストール
RUN npm upgrade && npm install

# プロジェクトファイルを全てコピー
COPY . .

# ポート3000を外部に公開
EXPOSE 3000

# アプリケーションを起動
CMD ["npm", "run", "dev"]

