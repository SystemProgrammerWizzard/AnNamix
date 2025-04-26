#!/bin/bash
echo "Available disks:"
lsblk -d -o NAME,SIZE,MODEL

read -p "Enter the disk (e.g., sda): " disk
disk="/dev/$disk"

echo "Writing OS image to $disk..."
dd if=/usr/share/installer/core-image-sato-genericx86-64.wic of=$disk bs=4M status=progress && sync

echo "Installing GRUB..."
mount ${disk}1 /mnt
grub-install --boot-directory=/mnt/boot $disk
umount /mnt

echo "Installation finished! Reboot now."
