#!/bin/bash

mvn -f .. clean install
cp ../target/*.jar .
docker-compose up --build
rm *.jar