package com.swaglabs.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils() {
        super();
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtil.warn("No files found in directory: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogsUtil.warn("Directory does not exist: " + dirPath);
            return;
        }

        File[] filesList = dirPath.listFiles();
        if (filesList == null) {
            LogsUtil.warn("Failed to list files in: " + dirPath);
            return;
        }

        for (File file : filesList) {

            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }
            }
        }
    }


    public static void cleanDirectory(File file) {
        try {
            FileUtils.deleteQuietly(file);
        } catch (Exception exception) {
            LogsUtil.error(exception.getMessage());

        }
    }

    public static void renameFile(File oldName, File newName) {
        try {
            File targetFile = oldName.getParentFile().getAbsoluteFile();
            String targetDirectory = targetFile + File.separator + newName;
            FileUtils.copyFile(oldName, new File(targetDirectory));
            FileUtils.deleteQuietly(oldName);
            LogsUtil.info("Target File Path: \"" + oldName.getPath() + "\", file was renamed to \"" + newName.getName() + "\".");
        } catch (Exception e) {
            LogsUtil.error("Failed to rename file: " + e.getMessage());
        }
    }

    public static void createDirectory(File path) {
        if (!path.exists()) {
            try {
                Files.createDirectories(path.toPath());
                LogsUtil.info("Directory created: " + path);
            } catch (IOException e) {
                LogsUtil.error("Failed to create directory: " + e.getMessage());
            }
        } else {
            LogsUtil.info("Directory already exists: " + path);
        }
    }
}