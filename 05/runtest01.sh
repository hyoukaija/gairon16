#!/bin/sh

PATH=~aotani/local/sbt/bin:$PATH
TESTEE="src/main/scala/testee03.scala"
TESTER="src/test/resources/flatten_test.scala"
SRC="src/main/resources/flatten.scala"

mkdir -p src/main/scala
mkdir -p src/test/scala
rm -f $TESTEE >& /dev/null
rm -rf src/test/scala/*
rm -rf src/main/scala/*
cp $TESTER src/test/scala/
echo "package gairon.k09.k01" >> $TESTEE
echo "object Main{" >> $TESTEE
sed -e 's!^:paste!!g' $SRC >> $TESTEE
echo "}" >> $TESTEE
sbt test
