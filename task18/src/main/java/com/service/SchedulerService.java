package com.service;

import com.Backupable;
import com.Dog;
import com.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SchedulerService implements SchedulerServiceMBean {
    private final UserService userService;
    private final DogService dogService;

    @Autowired
    public SchedulerService(UserService userService, DogService dogService) {
        this.userService = userService;
        this.dogService = dogService;
    }

    @Scheduled(fixedRate = 1800000L)
    //@Scheduled(fixedRate = 60000L)
    public void backupDB() throws IOException {
        clearOldDirectories();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d MMM uuuu H-m");
        String dirName = LocalDateTime.now().format(dateFormat);
        String backupDir = "task18/backup/" + dirName;
        if (new File(backupDir).mkdirs()) {
            File usersBackupFile = new File(backupDir + "/users");
            File dogsBackupFile = new File(backupDir + "/dogs");
            List<User> users = userService.readAll();
            List<Dog> dogs = dogService.readAll();
            writeBackup(users, usersBackupFile);
            writeBackup(dogs, dogsBackupFile);
        }
    }

    public void writeBackup(List<? extends Backupable> backups, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        for (Backupable backup : backups) {
            printWriter.println(backup.toString());
        }
        printWriter.close();
    }

    public void clearOldDirectories() {
        File file = new File("task18/backup/");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                boolean deleted = FileSystemUtils.deleteRecursively(f);
                if (deleted) {
                    System.out.println(f.getName() + " is deleted");
                } else {
                    System.err.println(f.getName() + " is not deleted");
                }
            }
        }
    }
}
