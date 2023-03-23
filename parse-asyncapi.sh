#!/bin/sh

for arg in "$@"
do
  FILE=$arg.yaml
  echo "Passing Argument: " + $FILE
  node parse-asyncapi.js $FILE
done
