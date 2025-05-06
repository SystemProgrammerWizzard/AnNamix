SUMMARY = "Vietnamese font package"
DESCRIPTION = "Custom Vietnamese fonts for Anamix Linux"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://OFL.txt;md5=09ed978d55339d326caa5e1495a6feb2"
SRC_URI = " \
    file://Inter-Italic-VariableFont_opsz,wght.ttf \
    file://Inter-VariableFont_opsz,wght.ttf \
    file://static/ \
    file://OFL.txt \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/vietnamese

    # Install main variable fonts
    install -m 0644 ${WORKDIR}/Inter-*.ttf ${D}${datadir}/fonts/truetype/vietnamese/

    # Install static fonts
    cp -r ${WORKDIR}/static/* ${D}${datadir}/fonts/truetype/vietnamese/
}
FILES:${PN} += "${datadir}/fonts"