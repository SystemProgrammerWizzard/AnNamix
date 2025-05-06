SUMMARY = "IBus-Unikey input method for Vietnamese"
DESCRIPTION = "Vietnamese input method engine for IBus"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "http://sourceforge.net/projects/unikey/files/ibus-unikey/ibus-unikey-0.6.1/ibus-unikey-0.6.1.tar.gz"

S = "${WORKDIR}/ibus-unikey-0.6.1"

inherit autotools pkgconfig

DEPENDS = "ibus"

do_install() {
    install -d ${D}${datadir}/ibus/component
    install -m 0644 ${S}/src/engine/unikey.xml ${D}${datadir}/ibus/component/
}