#!/usr/bin/bash

declare name_of_the_app

# Find the compiled jar file
name_of_the_app=$(find "${PWD}" -type f -name "*\.jar" -print | awk 'NR==1')

# Execute JAR as main application;
java -jar "${name_of_the_app}" 2> /dev/null

# Sleep 1 second before clearing the screen;
sleep 0.5

# Clear the screen after quiting;
clear

