cd ..
ant jar
rmdir build
echo **********************************************
echo *                      Done                  *
echo *                                                                     *
echo **********************************************
pause
echo Your build jar is in dist directory
echo Use java -jar $name_of_jar.jar to run
pause