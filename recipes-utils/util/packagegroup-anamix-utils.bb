SUMMARY = "Anamix Common Utilities"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DESCRIPTION = "Anamix Common Utilities for Installer"

inherit packagegroup

RDEPENDS:${PN} = " \
    bash \
    nano \
    parted \
    dosfstools \
    e2fsprogs \
    wget \
    curl \
    iputils \
    net-tools \
    python3 \
    python3-pip \
    gcc \
    make \
    git \
    g++ \
    cmake \
"