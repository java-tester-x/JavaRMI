javac -Xlint:unchecked RmiServer.java
java  -Djava.security.policy=server.policy RmiServer
pause