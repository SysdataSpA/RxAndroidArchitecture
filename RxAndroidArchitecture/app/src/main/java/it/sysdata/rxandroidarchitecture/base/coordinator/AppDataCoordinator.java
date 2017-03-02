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

package it.sysdata.rxandroidarchitecture.base.coordinator;

import com.baseandroid.coordinatoradapter.BaseCoordinator;
import com.baseandroid.core.subscriber.BaseSubscriber;
import com.baseandroid.events.EventDispatcher;
import com.baseandroid.events.rx.annotations.RxSubscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import it.sysdata.rxandroidarchitecture.base.dagger.components.DaggerAppDataComponent;
import it.sysdata.rxandroidarchitecture.base.events.BaseResponseEvent;
import it.sysdata.rxandroidarchitecture.base.events.data.DataRetrieveWelcomeMessageRequestEvent;
import it.sysdata.rxandroidarchitecture.base.events.data.DataRetrieveWelcomeMessageResponseEvent;
import it.sysdata.rxandroidarchitecture.base.usecase.RetrieveWelcomeMessageUC;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public class AppDataCoordinator extends BaseCoordinator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppDataCoordinator.class);

    @Inject
    RetrieveWelcomeMessageUC mRetrieveWelcomeMessageUC;

    public AppDataCoordinator() {
        super();
        DaggerAppDataComponent.create().inject(this);
    }

    @Override
    protected void startup() {
        // emptry constructor
    }

    @Override
    public void shutdown() {
        super.shutdown();
        mRetrieveWelcomeMessageUC.unsubscribe();
    }

    /**
     * Receives an event requesting the AppData.
     * To satisfy this request it'll use a {@link RetrieveWelcomeMessageUC} and will emit a {@link DataRetrieveWelcomeMessageResponseEvent}.
     *
     * @param request the request event
     */
    @RxSubscribe
    public void onConsumeDataRetrieveWelcomeMessageRequestEvent(final DataRetrieveWelcomeMessageRequestEvent request) {
        LOGGER.debug("received DataRetrieveWelcomeMessageRequestEvent");
        mRetrieveWelcomeMessageUC.execute(new BaseSubscriber<DataRetrieveWelcomeMessageResponseEvent>() {
            @Override
            public void onNext(DataRetrieveWelcomeMessageResponseEvent responseEvent) {
                super.onNext(responseEvent);
                // forward request owner through response
                BaseResponseEvent.copyOwner(request, responseEvent);
                EventDispatcher.post(responseEvent);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                BaseResponseEvent errorEvent = BaseResponseEvent.makeFailResponse(DataRetrieveWelcomeMessageResponseEvent.class);
                BaseResponseEvent.copyOwner(request, errorEvent);
                EventDispatcher.post(errorEvent);
            }
        });
    }
}