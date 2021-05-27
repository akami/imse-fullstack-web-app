FROM node:13.12.0-alpine

WORKDIR /usr/src/myapp

ENV PATH /myapp/node_modules/.bin:$PATH

COPY . .

RUN npm install

CMD ["npm", "start"]
