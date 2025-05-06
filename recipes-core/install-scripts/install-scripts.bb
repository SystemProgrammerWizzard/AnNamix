SUMMARY = "Simple OS installer script"
LICENSE = "MIT"
PN = "install-scripts"

SRC_URI = "file://install.sh \
           file://install-launch.service"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

inherit systemd

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/install.sh ${D}${bindir}/install-os

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/install-launch.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE:${PN} = "install-launch.service"
RDEPENDS:${PN} += "bash"
