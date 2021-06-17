FROM node:13.12.0-alpine

WORKDIR /usr/src/

ENV PATH /usr/src/node_modules/.bin:$PATH

COPY . .

RUN npm install

CMD ["npm", "start"]
