# Build
```sh
./gradlew assemble
```
## Enable buildx
```sh
docker buildx build use
```
## Build multi arch 
```sh
docker buildx build --platform linux/arm64,linux/amd64 -t kotlin-native .
```
