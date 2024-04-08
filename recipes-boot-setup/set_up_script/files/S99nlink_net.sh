#!/bin/sh
if [ -d "/sys/class/net/eth1" ]; then
    ifconfig eth1 up
    udhcpc -R -b -p /var/run/udhcpc.eth1.pid -i eth1 &
fi

if [ -d "/sys/class/net/eth2" ]; then
    ifconfig eth2 up              
    udhcpc -R -b -p /var/run/udhcpc.eth2.pid -i eth2 &
fi
