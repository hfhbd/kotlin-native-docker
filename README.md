# Build
```sh
./gradlew assemble -PdockerOnly=true
```
## Enable buildx
```sh
docker buildx build use
```
## Build multi arch 
```sh
docker buildx build --platform linux/arm64,linux/amd64 -t kotlin-native .
```
