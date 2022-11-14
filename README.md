# Build
```sh
./gradlew assemble -Pstatic=true
```
## amd64
```sh
docker build --platform linux/amd64 -t kotlin-native-amd64 --build-arg nativeFolder=linuxX64 .
```

## arm64
```sh
docker build --platform linux/arm64 -t kotlin-native-arm64 --build-arg nativeFolder=linuxArm64 .
```
