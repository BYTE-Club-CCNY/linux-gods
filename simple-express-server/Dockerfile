FROM node
EXPOSE 5000
WORKDIR /app
COPY package*.json .
RUN npm install
COPY . .
CMD ["node", "app.js"]
