# Filename: Dickerfile
FROM node:16.14.2-alpine3.15
LS
WORKDIR /apiapp
COPY * /apiapp
RUN npm ci
RUN yarn build
EXPOSE 9999/tcp
CMD ["yarn", "start"]