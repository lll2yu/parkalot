cls
@ECHO OFF
title connection config
color 1f
cd..
ECHO. This will help you configure your source with your sql connection
ECHO. 
ECHO. ****************************************
ECHO. *     Connection Configuration          *
ECHO. *                                       *
ECHO. *                        	         *
ECHO. ****************************************
ECHO enter your JDBC driver name like e.g. org.mariadb.jdbc.Driver,etc
SET /P conDriver="Enter response : "
ECHO. Your entered driver name = %conDriver%
pause
ECHO. replacing the code......
path=%cd%
sed -i -- "s|add your jdbc Driver|%conDriver%|g" *.java
ECHO Done.....
ECHO.
ECHO. enter your connection info 
ECHO. ##refer to your JDBC driver documentation for information on setting up connections
rem  refer to your JDBC driver documentation for information on setting up connections	
SET /P conInfo="Enter response: "
ECHO. Your entered connection info = %conInfo%
pause
ECHO. replacing the code......
sed -i -- "s|add your connectin info|%conInfo%|g" *.java
ECHO. "**********************************************"
ECHO. "*                      Done                  *"
ECHO. "*                                            *"
ECHO. "**********************************************"
pause
exit 0