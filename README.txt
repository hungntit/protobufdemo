protoc -I ./conf --ruby_out ./ruby conf/person.proto
protoc -I=conf/ --java_out=java conf/person.proto
protoc -I=conf/ --cpp_out=cplus conf/person.proto
protoc -I=conf/ --swift_out=swiftprotoc/swiftprotoc conf/person.proto
protoc -I=conf/  conf/person.proto -o nodejs/person.desc




g++ cplus/*.cc -lprotobuf -o cplus/bin/TestProtoc
./cplus/bin/TestProtoc


javac -d java/bin -cp java/libs/protobuf-java-2.6.1.jar  java/*.java
java  -classpath java/libs/protobuf-java-2.6.1.jar:java/bin TestProtoc


javac -d java/bin -cp java/libs/gson-2.6.2.jar:java/libs/protobuf-java-2.6.1.jar  java/*.java
java  -classpath java/libs/gson-2.6.2.jar:java/libs/protobuf-java-2.6.1.jar:java/bin TestProtoc
java  -classpath java/libs/gson-2.6.2.jar:java/libs/protobuf-java-2.6.1.jar:java/bin TestJson
