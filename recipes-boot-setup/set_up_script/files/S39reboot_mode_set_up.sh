#!/bin/sh
if cat /proc/cmdline | grep -q reboot_test > /dev/null; then
	/usr/bin/reboot-test-handle.sh
fi

