FROM node:20.16-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:stable-alpine
COPY --from=build /app/dist/docker-angular/browser /usr/share/nginx/html
EXPOSE 80
