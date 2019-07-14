SHELL:=/bin/bash
JAVA_HOME:=/usr/lib/jvm/jdk1.8.0_131
JAVAC_CMD=/usr/lib/jvm/jdk1.8.0_131/bin/javac
JAR_CMD=/usr/lib/jvm/jdk1.8.0_131/bin/jar

.PHONY:all
all:
  export JAVA_HOME=$(JAVA_HOME)
  ./gradlew build
#  ./gradlew clean

.PHONY: maven
maven:
  mvn install:install-file -Dfile=yarn\-19w12bj.jar -DgroupId=net.fabricmc -DartifactId=yarn -Dversion=19w12bj -Dpackaging=jar