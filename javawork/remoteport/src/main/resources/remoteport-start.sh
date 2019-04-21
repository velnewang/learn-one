#!/bin/sh

java -jar /root/javaweb/remoteport/remoteport.jar -Djava.net.preferIPv4Stack=true -Xms128M -Xmx128M > /root/javaweb/remoteport/remoteport.log &
echo $! > /var/run/javaweb-remoteport.pid
