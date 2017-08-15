#!/bin/bash

cd ..
ant jar
rm -rf build
echo "**********************************************"
echo "*                      Done                  *"
echo "*                                            *"
echo "**********************************************"
echo "Your build jar is in dist directory"
echo "Use java -jar $name_of_jar.jar to run"
read -n 1 -s -r -p "Press any key to continue"