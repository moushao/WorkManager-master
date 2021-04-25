package com.moushao.workmanager.lib.work;

import com.moushao.workmanager.lib.ReportRepository;
import com.moushao.workmanager.lib.WorkResult;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public Single<Integer> report() {
        // todo report device permission info
        return  Single.just(1).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer) throws Exception {
                return WorkResult.SUCCESS;
            }
        });
    }
}

