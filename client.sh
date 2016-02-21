#!/bin/bash

echo "compiles client sources ..."
javac -d bin/ -cp /Users/martine/Client-RMI/bin/:libraryMethods.jar src/fr/upem/library/main/*.java

echo "executes the client ..."
java -cp ./bin/:libraryMethods.jar:/Users/martine/Client-RMI/bin/ -Djava.security.policy=/Users/martine/Library-RMI/securityPolicy.policy fr.upem.library.main.LibraryClient
