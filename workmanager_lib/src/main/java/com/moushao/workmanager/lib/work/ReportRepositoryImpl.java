package com.moushao.workmanager.lib.work;

import android.util.Log;

import com.moushao.workmanager.lib.ReportRepository;
import com.moushao.workmanager.lib.WorkResult;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public Single<Integer> report() {
        // todo report device permission info
        return  Single.just(1).delay(10, TimeUnit.SECONDS).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer) throws Exception {
                Log.e("ReportWork", "apply");
                return WorkResult.SUCCESS;
            }
        });
    }
}

