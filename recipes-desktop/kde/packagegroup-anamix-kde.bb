SUMMARY = "Anamix KDE Desktop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DESCRIPTION = "Anamix KDE Desktop Environment"
inherit packagegroup

RDEPENDS:${PN} += " \
    sddm \
    kde-cli-tools \
    konsole \
    xinit \
    xserver-xorg \
    xauth \
    xf86-video-vesa \
"