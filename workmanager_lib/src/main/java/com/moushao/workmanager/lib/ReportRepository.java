package com.moushao.workmanager.lib;

import io.reactivex.Single;

public interface ReportRepository {
    Single<WorkResult> report();
}

