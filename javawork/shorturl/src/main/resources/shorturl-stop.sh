#!/bin/sh

PID=$(cat /var/run/javaweb-shorturl.pid)
kill -9 $PID
