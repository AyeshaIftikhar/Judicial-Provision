package com.ayesha.judicial_provision;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;

public class MyBackupSpace extends BackupAgentHelper {
    static final String File_Name_Of_Prefrences = "myPrefrences";
    static final String PREFS_BACKUP_KEY = "backup";

    @Override
    public void onCreate() {
        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this,
                File_Name_Of_Prefrences);
        addHelper(PREFS_BACKUP_KEY, helper);
    }
}


