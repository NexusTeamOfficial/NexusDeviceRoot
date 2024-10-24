package com.nexusteam.nexusdeviceroot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class NexusDeviceRoot {

    // A. Check if the device is rooted
    public static boolean checkDeviceRoot() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    // B. Attempt to set root access
    public static boolean setRootDevice() {
        // This will only check if root access can be executed.
        String command = "su";  // Check if the 'su' command is available
        return executeRootCommand(command);
    }

    // C. Check the system for root files/binaries
    public static boolean checkDeviceSystemForRoot() {
        String[] rootFiles = {
                "/system/app/Superuser.apk",
                "/system/bin/su",
                "/system/xbin/su",
                "/sbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su",
                "/data/local/bin/su",
                "/data/local/xbin/su"
        };

        for (String path : rootFiles) {
            if (new File(path).exists()) {
                return true;
            }
        }
        return false;
    }

    // D. Check if the device is rootable
    public static boolean checkDeviceForRootable() {
        return checkDeviceSystemForRoot() || checkBuildTagsForRootable();
    }

    // E. Remount the system as read/write
    public static boolean remountSystemRW() {
        String command = "mount -o remount,rw /system";
        return executeRootCommand(command);
    }

    // F. Modify a system file
    public static boolean modifySystemFile(String filePath, String content) {
        String command = "echo '" + content + "' > " + filePath;
        return executeRootCommand(command);
    }

    // Helper method to check for test-keys in the build tags
    private static boolean checkBuildTagsForRootable() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    // Execute a command with root access
    public static boolean executeRootCommand(String command) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(command + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
            return process.exitValue() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }

    // Method 1: Check for common root binaries on the device
    private static boolean checkRootMethod1() {
        String[] rootPaths = {
                "/system/app/Superuser.apk",
                "/sbin/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su"
        };
        for (String path : rootPaths) {
            if (new File(path).exists()) {
                return true;
            }
        }
        return false;
    }

    // Method 2: Check if the 'su' command is available
    private static boolean checkRootMethod2() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return in.readLine() != null;
        } catch (Exception e) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }

    // Method 3: Check for test-keys in the build tags
    private static boolean checkRootMethod3() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }
             }
      
