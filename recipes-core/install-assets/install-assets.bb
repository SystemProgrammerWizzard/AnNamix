SUMMARY = "Embedded OS image to be installed"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://core-image-sato-genericx86-64.wic"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${datadir}/installer
    install -m 0644 ${WORKDIR}/core-image-sato-genericx86-64.wic ${D}${datadir}/installer/
}

FILES:${PN} += "${datadir}/installer"

