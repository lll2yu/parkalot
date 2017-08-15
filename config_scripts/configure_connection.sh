#!/bin/bash

cd ..
cd src/parkalot
echo "This will help you configure your source with your sql connection"
echo ""
echo "****************************************"
echo "*     connection configuration          *"
echo "* if this is your first run press 1     *"
echo "*            else press 2	        *"
echo "****************************************"
echo ""
read tin
if [ $tin = "1" ]
	then
	echo "enter your JDBC driver name like(e.g. org.mariadb.jdbc.Driver,etc)"
	read conDriver
	echo "Your entered driver name = $conDriver"
	echo "you want to continue? Y/n"
	read response
		if [ $response = "y" ]
			then
			echo "replacing the code......"
			sed -i -- "s|add your jdbc Driver|$conDriver|g" *.java
		else
		echo "exiting......."
		exit 0
	fi
	
	echo "enter your connection info "
	echo "##refer to your JDBC driver documentation for information on setting up connections"
	#  refer to your JDBC driver documentation for information on setting up connections	
	read conInfo
	echo "Your entered connection info = $conInfo"
	echo "you want to continue? Y/n"
	read response2
		if [ $response2 = "y" ]
			then
			echo "replacing the code......"
			sed -i -- "s|add your connectin info|$conInfo|g" *.java
		else
		echo "exiting......."
		exit 0
	fi
else
	echo "enter your previous JDBC driver name "
	read prevDriver
	echo "enter your new JDBC driver name like(e.g. org.mariadb.jdbc.Driver,etc)"
	read conDriver
	echo "Your entered driver name = $conDriver"
	echo "you want to continue? Y/n"
	read response
		if [ $response = "y" ]
			then
			echo "replacing the code......"
			sed -i -- "s|$prevDriver|$conDriver|g" *.java
		else
		echo "exiting......."
		exit 0
	fi
	
	echo "enter your previous connection info "
	read prevInfo
	echo "enter your new connection info "
	echo "##refer to your JDBC driver documentation for information on setting up connections"
	#  refer to your JDBC driver documentation for information on setting up connections	
	read conInfo
	echo "Your entered connection info = $conInfo"
	echo "you want to continue? Y/n"
	read response2
		if [ $response2 = "y" ]
			then
			echo "replacing the code......"
			sed -i -- "s|$prevInfo|$conInfo|g" *.java
		else
		echo "exiting......."
		exit 0
	fi
fi
echo "**********************************************"
echo "*                      Done                  *"
echo "*                                                                     *"
echo "**********************************************"
rm *.dll
rm *.exe
echo "Now run build.sh or use ant or maven to build. "
exit 0