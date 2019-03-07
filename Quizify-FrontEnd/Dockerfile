FROM node:latest
RUN mkdir -p /quizify
WORKDIR /quizify
COPY package.json /quizify/
RUN npm install --force
RUN npm cache verify
COPY . /quizify
EXPOSE 4200/tcp
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--poll", "2000"]
