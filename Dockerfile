# Filename: Dickerfile
FROM node:16.14.2-alpine3.15
WORKDIR /apiapp
COPY package*.json ./
RUN npm ci
COPY . .
EXPOSE 9999/tcp
CMD ["yarn", "start"]