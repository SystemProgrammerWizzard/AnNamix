SUMMARY = "Custom GRUB configuration for Anamix Linux Installer"
LICENSE = "MIT"
SRC_URI = "file://grub.cfg"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/boot/grub
    install -m 0644 ${WORKDIR}/grub.cfg ${D}/boot/grub/grub.cfg
}

FILES:${PN} += "/boot/grub/grub.cfg"
