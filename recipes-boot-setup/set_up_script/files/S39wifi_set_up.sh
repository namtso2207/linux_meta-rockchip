#!/bin/sh
mkdir -p /lib/firmware/brcm
cp /lib/firmware/* /lib/firmware/brcm/
insmod /vendor/lib/modules/bcmdhd_pcie.ko
sleep 1
ifconfig wlan0 up
sleep 1
wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf
