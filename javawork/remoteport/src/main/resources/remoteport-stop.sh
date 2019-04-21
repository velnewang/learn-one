#!/bin/sh

PID=$(cat /var/run/javaweb-remoteport.pid)
kill -9 $PID
