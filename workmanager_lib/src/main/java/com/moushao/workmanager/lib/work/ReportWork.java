package com.moushao.workmanager.lib.work;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;

import com.moushao.workmanager.lib.ReportRepository;
import com.moushao.workmanager.lib.injection.Injection;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ReportWork extends RxWorker {
    ReportRepository reportRepository;
    private static String TAG = "ReportWork";
    /**
     * @param appContext   The application {@link Context}
     * @param workerParams Parameters to setup the internal state of this worker
     */
    public ReportWork(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
        reportRepository = Injection.getReportRepository();
    }

    @NonNull
    @Override
    public Single<Result> createWork() {
        Log.e(TAG, "start");
        return reportRepository.report().map(workResult -> Result.success());
    }

    @NonNull
    @Override
    protected Scheduler getBackgroundScheduler() {
        return Schedulers.io();
    }
}
