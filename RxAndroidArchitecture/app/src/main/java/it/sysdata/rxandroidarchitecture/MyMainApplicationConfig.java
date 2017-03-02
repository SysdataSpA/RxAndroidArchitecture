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

package it.sysdata.rxandroidarchitecture;

import com.baseandroid.coordinatoradapter.CoordinatorManager;
import com.baseandroid.events.EventDispatcher;
import com.baseandroid.events.rx.RxEventProcessor;
import com.baseandroid.repositoryadapter.RepositoryManager;
import com.baseandroid.rxcoordinator.RxCoordinatorProcessor;
import com.baseandroid.rxrepository.RxRepositoryProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sysdata.rxandroidarchitecture.base.coordinator.CoordinatorType;
import it.sysdata.rxandroidarchitecture.base.repository.RepositoryType;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public class MyMainApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMainApplicationConfig.class);

    private static final MyMainApplicationConfig sInstance = new MyMainApplicationConfig();

    public static synchronized MyMainApplicationConfig getInstance() {
        return sInstance;
    }

    public synchronized void onCreate() {
        //initContextManager(); TODO insert ContextManager into basecore lib
        initEventBus();
        initCoordinatorManager();
        initRepositoryManager();
    }

    private void initEventBus() {
        EventDispatcher.useEventProcessor(RxEventProcessor.newInstance());
    }

    private void initCoordinatorManager() {
        CoordinatorManager.useCoordinatorProcessor(RxCoordinatorProcessor.newInstance(new CoordinatorType.CoordinatorProvider()));
    }

    private void initRepositoryManager() {
        RepositoryManager.useRepositoryProcessor(RxRepositoryProcessor.newInstance(new RepositoryType.RepositoryProvider()));
    }

    //private void initContextManager() {
    //    ContextManager.initBuilder(new ContextManager.ContextProvider(MainApplication.getInstance().getApplicationContext()));
    //}
}
