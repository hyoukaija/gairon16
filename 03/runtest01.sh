#!/bin/sh

PATH=~aotani/local/sbt/bin:$PATH

TESTEE="src/main/scala/testee01.scala"
TESTER="src/test/resources/add_test.scala"
SRC="src/main/resources/add.scala"

mkdir -p src/main/scala
mkdir -p src/test/scala
rm -f $TESTEE >& /dev/null
rm -rf src/test/scala/*
rm -rf src/main/scala/*
cp $TESTER src/test/scala/
echo "package gairon.k06.k01" >> $TESTEE
echo "object Main{" >> $TESTEE
cat $SRC >> $TESTEE
echo "}" >> $TESTEE
sbt test
