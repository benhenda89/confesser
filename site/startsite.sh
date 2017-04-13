#!/bin/bash

## Startup script variables that you can/should change:
# JREBEL_PATH - local path to your jrebel dylib to be passed as -agentpath
#           example - /Users/you/jrebel/lib/libjrebel64.dylib
# DEBUG_PORT - defaults to 8000
# TOMCAT_MEMORY - Defaults to -Xmx1536

cwd=$(pwd)

# Do an install of the core jar in case anything changed since the last restart and we're not using jrebel
cd ..
mvn -pl site -am clean install

# Go back to where we just were to get ready to run the Tomcat Maven plugin
cd $cwd

# Ensure that the spring-instrument jar gets downloaded and moved into target
mvn dependency:copy@copy-agent

# Figure out a debug port
if [ -z ${DEBUG_PORT+x} ]; then DEBUG_PORT="8000"; fi

if [ -z ${TOMCAT_MEMORY+x} ]; then TOMCAT_MEMORY="-Xmx1024M -XX:MaxPermSize=512M"; fi

export BROADLEAF_OPTS="$TOMCAT_MEMORY -Xdebug -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=n -javaagent:target/agents/spring-instrument.jar $JREBEL_AGENT"

MAVEN_OPTS="$MAVEN_OPTS $BROADLEAF_OPTS" mvn tomcat7:run-war
