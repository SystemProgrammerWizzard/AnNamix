SUMMARY = "Simple OS installer script"
LICENSE = "MIT"
SRC_URI = "file://install.sh"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/install.sh ${D}${bindir}/install-os
}

RDEPENDS:${PN} += "bash"
