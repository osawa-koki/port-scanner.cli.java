FROM openjdk:17
EXPOSE 8000
WORKDIR /src
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build

ARG host
ARG start
ARG end

ARG CMD_SCRIPT="./gradlew run --args=' --host ${host} --start ${start} --end ${end}'"
RUN echo ${CMD_SCRIPT} > ./entrypoint.sh && chmod +x ./entrypoint.sh
CMD ./entrypoint.sh
