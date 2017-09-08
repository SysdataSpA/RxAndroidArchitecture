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

import com.baseandroid.repositoryadapter.BaseObservableRepository;
import com.baseandroid.rxrepository.RxRepositoryBuilder;

/**
 * Defines the list of all possible types of Repository used in the Application.
 *
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public final class RepositoryType {

    /**
     * Indicates a Repository containing data available throughout the whole application.
     */
    public static final int APP = 0;

    public static class RepositoryProvider implements RxRepositoryBuilder {

        @Override
        public BaseObservableRepository getRepository(int repositoryType) {
            BaseObservableRepository br;
            switch (repositoryType) {
                case APP:
                    br = new AppDataRepository(AppDataRepository.ONSUBSCRIBE);
                    break;
                default:
                    br = null;
                    break;
            }
            return br;
        }

        @Override
        public String getTypeName(int typeCode) {
            switch (typeCode) {
                case APP:
                    return "APP";
                default:
                    return "*** UNKNOWN ***";
            }
        }
    }
}