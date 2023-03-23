#!/bin/sh

for yamlfile in *.yamlp
do
  echo "Filename: " + $yamlfile
  yamlFileWithoutExtension=$(echo $yamlfile | cut -f 1 -d '.')
  echo "Filename_without: " + $yamlFileWithoutExtension
  ag -o $yamlFileWithoutExtension $yamlfile -p listenerPollTimeout=5000 -p javaPackage=nl.ind.gebeurtenissturingpoc.$yamlFileWithoutExtension ~/java-spring-template/ --force-write
done
