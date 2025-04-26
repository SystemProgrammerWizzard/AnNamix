SUMMARY = "Installer image to support Vietnamese Linux community"
DESCRIPTION = "Yocto-based live installer with GUI and basic disk utilities"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image


# Optional GUI and debug tools
IMAGE_FEATURES += " \
    allow-empty-password \
    allow-root-login \
    bash-completion-pkgs \
    dbg-pkgs \
    debug-tweaks \
    dev-pkgs \
    doc \
    doc-pkgs \
    eclipse-debug \
    empty-root-password \
    hwcodecs \
    lic-pkgs \
    nfs-client \
    nfs-server \
    package-management \
    post-install-logging \
    ptest-pkgs \
    read-only-rootfs \
    read-only-rootfs-delayed-postinsts \
    splash \
    src-pkgs \
    ssh-server-dropbear \
    ssh-server-openssh \
    stateless-rootfs \
    staticdev-pkgs \
    tools-debug \
    tools-profile \
    tools-sdk \
    tools-testapps \
    weston \
    x11 \
    x11-base \
    x11-sato \
"


# Enable USB and gadget features
DISTRO_FEATURES:append = " usbgadget"
MACHINE_FEATURES:append = " usbgadget usbhost"

# Base and installer-related packages
IMAGE_INSTALL += " \
    usbutils \
    usbinit \
    bash \
    parted \
    util-linux \
    grub \
    dosfstools \
    e2fsprogs \
    install-assets \
    install-scripts \
    python3 \
"

