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
import com.baseandroid.rxcoordinator.RxCoordinatorBuilder;

/**
 * Defines the list of all possible types of Coordinator used in the Application.
 *
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public final class CoordinatorType {

    /**
     * Indicates a Coordinator for the generic access to data available throughout the whole application.
     */
    public static final int APPDATA = 1;

    public static class CoordinatorProvider implements RxCoordinatorBuilder {

        @Override
        public BaseCoordinator getCoordinator(int coordinatorType) {
            BaseCoordinator bp;
            switch (coordinatorType) {
                case APPDATA:
                    bp = new AppDataCoordinator();
                    break;
                default:
                    bp = null;
                    break;
            }
            return bp;
        }

        @Override
        public String getTypeName(int typeCode) {
            switch (typeCode) {
                case APPDATA:
                    return "APPDATA";
                default:
                    return "*** UNKNOWN ***";
            }
        }
    }
}