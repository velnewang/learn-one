#!/bin/sh

java -jar /root/javaweb/shorturl/shorturl.jar -Djava.net.preferIPv4Stack=true -Xms128M -Xmx128M > /root/javaweb/shorturl/shorturl.log &
echo $! > /var/run/javaweb-shorturl.pid
