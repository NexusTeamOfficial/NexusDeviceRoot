# Keep all classes in the NexusDeviceRoot package
-keep class com.nexusteam.nexusdeviceroot.** { *; }

# Keep methods that are called by reflection
-keepclassmembers class com.nexusteam.nexusdeviceroot.** {
    public *;
}

# Keep any annotations
-keepattributes *Annotation*
