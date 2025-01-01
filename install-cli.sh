#!/bin/bash
curl -L -o cli-app-0.0.1-SNAPSHOT.jar https://raw.githubusercontent.com/aryak0512/my-custom-cli/master/executables/cli-app-0.0.1-SNAPSHOT.jar
chmod +x cli-app-0.0.1-SNAPSHOT.jar
version=$(java -version 2>&1 | head -n 1 | cut -d '"' -f2)

# Check if the version starts with "21."
if [[ $version == 21.* ]]; then
    java -jar cli-app-0.0.1-SNAPSHOT.jar
else
    echo "The required Java version (21) does not exist on your system. Please run the CLI after installing Java 21"
    exit
fi

