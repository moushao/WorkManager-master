package com.moushao.workmanager.lib.injection;

import com.moushao.workmanager.lib.ReportRepository;
import com.moushao.workmanager.lib.work.ReportRepositoryImpl;

public class Injection {
    public static ReportRepository getReportRepository() {
        return new ReportRepositoryImpl();
    }
}
