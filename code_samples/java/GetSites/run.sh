#!/bin/bash
# 8 for 1.8.0_nn, 9 for 9-ea etc, and "no_java" for undetected
jdk_version() {
  local result
  local java_cmd
  if [[ -n $(type -p java) ]]
  then
    java_cmd=java
  elif [[ (-n "$JAVA_HOME") && (-x "$JAVA_HOME/bin/java") ]]
  then
    java_cmd="$JAVA_HOME/bin/java"
  fi
  local IFS=$'\n'
  # remove \r for Cygwin
  local lines=$("$java_cmd" -Xms32M -Xmx32M -version 2>&1 | tr '\r' '\n')
  if [[ -z $java_cmd ]]
  then
    result=no_java
  else
    for line in $lines; do
      if [[ (-z $result) && ($line = *"version \""*) ]]
      then
        local ver=$(echo $line | sed -e 's/.*version "\(.*\)"\(.*\)/\1/; 1q')
        # on macOS, sed doesn't support '?'
        if [[ $ver = "1."* ]]
        then
          result=$(echo $ver | sed -e 's/1\.\([0-9]*\)\(.*\)/\1/; 1q')
        else
          result=$(echo $ver | sed -e 's/\([0-9]*\)\(.*\)/\1/; 1q')
        fi
      fi
    done
  fi
  echo "$result"
}

v="$(jdk_version)"
echo 'java is present'
if [[  $# -lt 3 ]] ; then
    echo 'Supply the name of one of the classes as an argument, token and baseUrl.'
    exit 1
fi
export CLASSPATH=target/energy-sustanibility-score-1.0.0.jar
export className=$1
if [[ $className != "GetSites" ]] ; then
     echo $className 'Not found.'
    exit 1
fi
export token=$2
export baseUrl=$3
echo "## Running $className..."
shift
echo "## arguments passed."
mvn exec:java -Dexec.mainClass="com.se.ods.apigee.sdk.ods.$className" -Dexec.args="$token $baseUrl" -Dexec.cleanupDaemonThreads=false