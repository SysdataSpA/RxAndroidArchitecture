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

package it.sysdata.rxandroidarchitecture.base.usecase;

import com.baseandroid.core.subscriber.BaseSubscriber;
import com.baseandroid.repositoryadapter.BaseObservableRepository;
import com.baseandroid.usecaseadapter.BaseUseCase;

import org.slf4j.Logger;

import it.sysdata.rxandroidarchitecture.base.repository.RepositoryType;
import it.sysdata.rxandroidarchitecture.base.repository.model.AppDataHolder;
import rx.Scheduler;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public abstract class AppBaseUseCase<T> extends BaseUseCase<T> {

    /**
     * LogCat logger
     */
    protected Logger mLogger;

    /**
     * Reference to Data holder
     */
    protected BaseObservableRepository<AppDataHolder> mAppRepo;

    /**
     * Subscriber to the AppDataRepository used to know when the underlying data changes.
     */
    private BaseSubscriber<AppDataHolder> mDefaultAppRepoSubscriber;

    public AppBaseUseCase(Scheduler threadExecutor, Scheduler postExecutionThread, Logger logger) {
        super(threadExecutor, postExecutionThread);
        this.mLogger = logger;
    }

    @Override
    protected void initSubscribers() {
        super.initSubscribers();
        mDefaultAppRepoSubscriber = onInitAppBaseRepository();
    }

    protected final BaseSubscriber onInitAppBaseRepository() {
        return new BaseSubscriber<AppDataHolder>() {
            @Override
            public void onNext(AppDataHolder appData) {

            }
        };
    }

    @Override
    protected void initRepositories() {
        super.initRepositories();
        mAppRepo = requestRepository(RepositoryType.APP);
        if (mAppRepo != null) {
            mAppRepo.addSubscriber(mDefaultAppRepoSubscriber);
        }
    }

    @Override
    public void unsubscribe() {
        super.unsubscribe();
        mAppRepo.removeSubscriber(mDefaultAppRepoSubscriber);
        releaseRepository(RepositoryType.APP);
    }
}