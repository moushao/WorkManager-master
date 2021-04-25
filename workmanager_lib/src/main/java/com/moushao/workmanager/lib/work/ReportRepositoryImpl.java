package com.moushao.workmanager.lib.work;

import com.moushao.workmanager.lib.ReportRepository;
import com.moushao.workmanager.lib.WorkResult;

import io.reactivex.Single;

public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public Single<WorkResult> report() {
        // todo report device permission info
        return null;
    }
}

