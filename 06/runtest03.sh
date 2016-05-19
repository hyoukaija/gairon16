#!/bin/sh

PATH=~aotani/local/sbt/bin:$PATH
TESTEE="src/main/scala/testee02.scala"
TESTER="src/test/resources/placement_test.scala"
SRC="src/main/resources/placement.scala"

mkdir -p src/main/scala
mkdir -p src/test/scala
rm -f $TESTEE >& /dev/null
rm -rf src/test/scala/*
rm -rf src/main/scala/*
cp $TESTER src/test/scala/
echo "package gairon.k12.k03" >> $TESTEE
echo "object Main{" >> $TESTEE
sed -e 's!^:paste!!g' $SRC >> $TESTEE
echo "}" >> $TESTEE
sbt test
