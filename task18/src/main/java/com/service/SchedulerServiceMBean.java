package com.service;

import com.Backupable;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SchedulerServiceMBean {
    void backupDB() throws IOException;

    void writeBackup(List<? extends Backupable> backups, File file) throws IOException;

    void clearOldDirectories();
}
