FROM openjdk:17
EXPOSE 8000
WORKDIR /src
ARG host=github.com
ARG start=1
ARG end=100
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build
CMD ./gradlew run --args=" --host github.com --start 1 --end 2 "
