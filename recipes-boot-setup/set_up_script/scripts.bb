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
          "
do_install() {
        install -m 0755 -d ${D}${sysconfdir}/rcS.d/
        install -m 0755 ${S}/S39wifi_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39bt_set_up.sh ${D}${sysconfdir}/rcS.d/
	install -m 0755 ${S}/S39audio_set_up.sh ${D}${sysconfdir}/rcS.d/

	install -d ${D}${bindir}
    	install -m 0755 fan.sh ${D}${bindir}
}
