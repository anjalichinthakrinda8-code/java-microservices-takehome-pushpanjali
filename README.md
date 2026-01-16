Steps to do to run

Install kafka
Set kafka / java env variable

Start zookeeper
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

start kafka server
bin\windows\kafka-server-start.bat config\server.properties

list topics
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

Start all three services and hit postman collection in order which provided.

open offset Explorer to observe events.

Refer the document provided

