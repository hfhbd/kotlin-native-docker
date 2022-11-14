FROM alpine
RUN apk add gcompat
ARG nativeFolder
COPY build/bin/${nativeFolder}/releaseExecutable/kotlin-native.kexe .
CMD ["./kotlin-native.kexe"]
