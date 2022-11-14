FROM alpine
ARG TARGETARCH
RUN apk add gcompat
COPY build/bin/docker-${TARGETARCH}/releaseExecutable/kotlin-native.kexe .
CMD ["./kotlin-native.kexe"]
