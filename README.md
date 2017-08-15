# parkalot
a parking management software
This is a small project that I did for my school submission. 
It is a parking terminal software implemented in java and database is handled by mysql server using java-jdbc library. 

<h1>Dependencies</h1>
<ul>
	<li>Java Runtime Environment  >=1.7 
		(may work on older java versions )</li>
	<li>Any Sql server implementation 
		(most common ones will work others may need extra configuration)</li>
	<li>Appropriate JDBC drivers depending on your Sql server</li>
	<li>Sed should be installed on Linux machine to configure code</li>
	<li>For Windows, sed is already included in the src directory of the project</li>
	<li>Ant or Maven to build the project</li>
</ul>

<h1>Server Configuration</h1>
<a href="https://github.com/LLL2yu/parkalot/blob/master/server%20configuration">For Server configuration read this</a>
<br>
<h1>Build Instructions</h1>
<h2>On Linux</h2>
<p>Run script configure_connection.sh in config_scripts directory to add your connection info to the code</p>
<p>Run build.sh to build project or use ant or maven to manually build</p>
<h2>On Windows</h2>
<p>Run script configure_connection.bat in config_scripts directory to add your connection info to the code</p>
<p>Run build.bat to build project or use ant or maven to manually build</p>
<h1>Downloads</h1>
<a href="https://github.com/LLL2yu/parkalot/releases">Releases can be found here</a>