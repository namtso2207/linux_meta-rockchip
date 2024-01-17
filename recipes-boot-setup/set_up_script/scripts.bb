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
		file://test_overlay_dt.dtbo \
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

	install -d ${D}${bootdir}
	install -m 0755 ${S}/uEnv.txt ${D}${bootdir}
	mkdir -p ${D}${bootdir}/overlays
	install -m 0755 ${S}/test_overlay_dt.dtbo ${D}${bootdir}/overlays/
}


