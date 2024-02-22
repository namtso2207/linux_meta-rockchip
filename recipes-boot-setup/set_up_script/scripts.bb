SUMMARY = "set_script"
SECTION = "set_script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302" 
 
S = "${WORKDIR}"
 
SRC_URI = "\
		file://S39wifi_set_up.sh \
		file://S39bt_set_up.sh \
		file://fan.sh  \
		file://S39audio_set_up.sh \
		file://S39reboot_mode_set_up.sh \
		file://reboot-test-handle.sh \
		file://uEnv.txt \
		file://rk3588-namtso-a10-3588.dtb.overlay.env \
		file://pwm-gpio-overlay.dtbo \
		file://spi-gpio-overlay.dtbo \
		file://accel_gyro_data \
		"

do_install() {
	install -d ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39wifi_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39bt_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39audio_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39reboot_mode_set_up.sh ${D}${sysconfdir}/rcS.d/

	install -d ${D}${bindir}
	install -m 0755 ${S}/fan.sh ${D}${bindir}
	install -m 0755 ${S}/reboot-test-handle.sh ${D}${bindir}
	install -m 0755 ${S}/accel_gyro_data ${D}${bindir}

	install -d ${D}${bootdir}
	install -m 0755 ${S}/uEnv.txt ${D}${bootdir}

	mkdir -p ${D}${bootdir}/dtb/rockchip/rk3588-namtso-a10-3588.dtb.overlays
	install -m 0755 ${S}/pwm-gpio-overlay.dtbo ${D}${bootdir}/dtb/rockchip/rk3588-namtso-a10-3588.dtb.overlays/
	install -m 0755 ${S}/spi-gpio-overlay.dtbo ${D}${bootdir}/dtb/rockchip/rk3588-namtso-a10-3588.dtb.overlays/
	install -m 0755 ${S}/rk3588-namtso-a10-3588.dtb.overlay.env ${D}${bootdir}/dtb/rockchip/

}


