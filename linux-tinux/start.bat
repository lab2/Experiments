@echo off
PATH=%PATH%;E:\bin\qemu-0.13.0-windows
qemu -cdrom ./tinux_boot.iso -m 128 -boot d