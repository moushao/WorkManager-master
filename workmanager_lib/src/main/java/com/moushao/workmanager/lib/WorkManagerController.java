package com.moushao.workmanager.lib;

import android.content.Context;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.moushao.workmanager.lib.work.ReportWork;

import java.util.concurrent.TimeUnit;

public class WorkManagerController {
    public static void initWork(Context context) {
        // add multi work
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("report", ExistingPeriodicWorkPolicy.KEEP, initWorkRequest());
    }

    private static PeriodicWorkRequest initWorkRequest() {
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build();
        PeriodicWorkRequest reportWorkRequest = new PeriodicWorkRequest.Builder(ReportWork.class, 1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .setBackoffCriteria(BackoffPolicy.LINEAR, // EXPONENTIAL 为指数增长
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS)
                .build();
        return reportWorkRequest;
    }
}
