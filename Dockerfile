FROM alpine
ARG TARGETARCH
RUN apk add gcompat
COPY build/bin/docker-${TARGETARCH}/releaseExecutable/kotlin-native-docker.kexe .
CMD ["./kotlin-native-docker.kexe"]
