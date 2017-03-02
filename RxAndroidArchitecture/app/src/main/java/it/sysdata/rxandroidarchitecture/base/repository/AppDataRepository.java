/*
 * Copyright (C) 2017 Sysdata S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.sysdata.rxandroidarchitecture.base.repository;

import android.os.Bundle;

import com.baseandroid.repositoryadapter.BaseObservableRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sysdata.rxandroidarchitecture.base.repository.model.AppDataHolder;
import it.sysdata.rxandroidarchitecture.extra.MockDataProvider;
import rx.Observable;
import rx.Subscriber;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public class AppDataRepository extends BaseObservableRepository<AppDataHolder> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppDataRepository.class);

    private static AppDataHolder mAppData;

    public static final Observable.OnSubscribe<AppDataHolder> ONSUBSCRIBE = new Observable.OnSubscribe<AppDataHolder>() {
        @Override
        public void call(Subscriber<? super AppDataHolder> subscriber) {
            if (!subscriber.isUnsubscribed()) {
                subscriber.onNext(mAppData);
                subscriber.onCompleted();
            }
        }
    };

    public AppDataRepository(Observable.OnSubscribe<AppDataHolder> f) {
        super(f);
    }

    @Override
    public void save(AppDataHolder appData) {
        if (appData == null) {
            throw new RuntimeException("Why you're nullifying AppData? If you want to clear AppDataRepository you should use #clear method!");
        }

        // refresh current static instance
        mAppData = appData;

        notifyObservers();
    }

    @Override
    public AppDataHolder retrieve(Bundle filters) {
        if (mAppData == null) {
            mAppData = new AppDataHolder();
            mAppData.setWelcomeMessage(MockDataProvider.getMockWelcomeMessage());
        }

        return mAppData;
    }

    @Override
    public void transform(Bundle transformationProperties) {
        // empty implementation
    }

    @Override
    public boolean clear(Bundle clearProperties) {
        mAppData = null;
        return true;
    }
}
