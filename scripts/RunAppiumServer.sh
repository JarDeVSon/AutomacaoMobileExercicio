#!/bin/bash
set -ex
npm install -g appium
appium driver install xcuitest
appium driver install uiautomator2
appium driver install flutter

appium -v
appium --log appium.log &>/dev/null &
