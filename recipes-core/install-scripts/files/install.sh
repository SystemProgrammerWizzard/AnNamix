# Writing OS image and installing GRUB with progress
(
    echo "10"
    echo "# Writing OS image to $disk..."
    dd if=/usr/share/installer/core-image-sato-genericx86-64.wic of=$disk bs=4M status=progress conv=fsync
    sync
    echo "70"
    echo "# Installing GRUB bootloader..."
    mount ${disk}1 /mnt || {
        zenity --error --title="Mount Failed" --text="Failed to mount ${disk}1. Installation aborted."
        exit 1
    }
    cp -v /usr/share/grub/grub.cfg /mnt/boot/grub/grub.cfg
    grub-install --boot-directory=/mnt/boot $disk || {
        zenity --error --title="GRUB Install Failed" --text="GRUB installation failed."
        umount /mnt
        exit 1
    }
    umount /mnt
    echo "100"
    echo "# Installation finished successfully."
) | zenity --progress --title="Installing OS" --text="Starting installation..." --percentage=0 --auto-close --width=500