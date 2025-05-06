PN = "anamix-installer-image"
SUMMARY = "Installer image to support Vietnamese Linux community"
DESCRIPTION = "Yocto-based live installer with KDE GUI and basic disk utilities"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image image-live 


IMAGE_FEATURES += " \
    allow-root-login \
    debug-tweaks \
    splash \
    x11 \
    x11-base \
    package-management \
    ssh-server-openssh \
    ssh-server-dropbear \
"

DISTRO_FEATURES:append = " usbgadget"

IMAGE_INSTALL += " \
    packagegroup-anamix-kde \
    packagegroup-anamix-utils \
    packagegroup-anamix-network \
    grub-config \
    install-scripts \
    ibus \
    fonts-vietnamese \
    libjack jack-server jack-utils \
    openssh \
"

IMAGE_FSTYPES = " wic iso"
IMAGE_BASENAME = "anamix"

inherit systemd

SYSTEMD_AUTO_ENABLE += "sddm.service"

SYSTEMD_AUTO_ENABLE += "install-launch.service"
ROOTFS_POSTPROCESS_COMMAND += "anamix_enable_services;"


ROOTFS_POSTPROCESS_COMMAND += "fix_resolv_conf_symlink;"

fix_resolv_conf_symlink () {
    ln -sf /run/NetworkManager/resolv.conf ${IMAGE_ROOTFS}/etc/resolv.conf
}