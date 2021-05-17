FROM node:13.12.0-alpine

WORKDIR /usr/src/myapp

ENV PATH /myapp/node_modules/.bin:$PATH

COPY package.json ./
COPY package-lock.json ./
RUN npm install

COPY . ./

CMD ["npm", "start"]
