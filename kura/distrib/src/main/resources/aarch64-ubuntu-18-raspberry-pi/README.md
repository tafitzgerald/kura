# Installation of Eclipse Kura™ on Raspberry Pi 2/3/4 with Ubuntu AArch64

This is a guide about installing Kura on the Raspberry Pi 2/3/4 with Ubuntu 18-04 AArch64.

## Operating system installation

A complete guide on how to install Ubuntu on the Raspberry Pi 2/3/4 with Multiarch can be found [here](https://wiki.ubuntu.com/ARM/RaspberryPi#Ubuntu_arm64.2FAArch64) with additional notes [here](https://www.raspberrypi.org/forums/viewtopic.php?f=56&t=220079).
The main procedure is presented in the following.

### Install Ubuntu on Raspberry Pi 2/3/4 board

- To install the OS, you need a Raspberry Pi 2/3/4 board, an SD card greater than 16GB, a keyboard, a mouse, a screen and an Internet connection.

- Download Ubuntu 18.04.2 image from the Ubuntu download page (works with server edition only) from [here](https://ubuntu.com/download/raspberry-pi).

- Burn the downloaded image on an SD card using [Balena Etcher](https://etcher.io)

- Insert the SD card to the Raspberry Pi SD card slot and proceed with a normal Ubuntu installation from console.

- Follow these steps in order to configure for ARM64:

- Open /boot/firmware/config.txt and set to boot 64-bit kernel
```
arm_64bit=1
```

- Configure Multiarch
```
sudo dpkg --add-architecture arm64
```

- Install 64-bit kernel
```
sudo apt-get install linux-raspi2:arm64
```

- Update the repository list
```
sudo apt-get update
```

- Upgrade packages
```
sudo apt-get upgrade
```

- Install desktop
```
sudo apt-get install xubuntu-desktop
```

- Reboot

- If Wifi will not enable then follow the steps found [here](https://wiki.ubuntu.com/ARM/RaspberryPi#WiFi).

## Install Kura

The following services must be configured before installing Kura:
```
sudo systemctl disable networking
```
The following packages must be installed before installing Kura:
```
sudo apt-get install openssh-server hostapd isc-dhcp-server dos2unix bind9 ethtool bluez-hcidump openjdk-8-jdk  
```
Install Kura:
```
sudo dpkg -i kura_4.2.0_SNAPSHOT_aarch64-ubuntu-18-raspberry-pi_installer.deb
```
After the installation is complete, Kura can be started by rebooting the machine by executing:
```
sudo reboot
```