# NexusDeviceRoot

## Overview
NexusDeviceRoot is an Android library that simplifies rooting and managing device permissions. It provides a straightforward API for developers to interact with root functionalities on Android devices.

## Features
- **Easy Root Management**: Simplifies the process of checking and managing root access.
- **Permission Handling**: Easily manage permissions for rooted applications.
- **Device Compatibility**: Works across various Android devices with rooting capabilities.
### repository 
- allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

## Installation

### Gradle Dependency
To include NexusDeviceRoot in your project, add the following dependency to your `build.gradle` file:

```groovy
implementation 'com.nexusteam:nexusdeviceroot:0.1'
