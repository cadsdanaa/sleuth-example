#!/bin/bash

mvn -f .. clean install -DskipTests
cp ../target/*.jar .
docker-compose up --build
rm *.jar