# Development Guide


**1. To modify version open `imagekit-sdk/build.gradle` and change value of `version`.**

**2. Run test cases**
```shell
./gradlew imagekit-sdk:test
```

**3. Clean cache of SDK**
```shell
./gradlew imagekit-sdk:clean
```

**4. Build SDK jar**
```shell script
./gradlew imagekit-sdk:build
```
Then you will find `jar` inside `imagekit-sdk/build/libs/` with specific version name. Then you can share `jar` or upload `jar` to any java dependency repository.
 
