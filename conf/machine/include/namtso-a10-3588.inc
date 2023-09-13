# Copyright (c) 2023, Wesion Technology Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY ?= "rk3588"
PREFERRED_VERSION_linux-rockchip ?= "5.10%"
LINUXLIBCVERSION ?= "5.10-custom%"

require conf/machine/include/rockchip-arm64-common.inc

KBUILD_DEFCONFIG = "namtso_a10_rk3588_defconfig"

MALI_GPU := "valhall-g610"
MALI_VERSION ?= "g6p0"

RK_ISP_VERSION := "3.0"
