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

package it.sysdata.rxandroidarchitecture.base.repository.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public abstract class BaseDataHolder {

    /**
     * Default Action, Nothing to do
     */
    public static final int ACTION_DEFAULT = 0;

    @Action
    private int action = ACTION_DEFAULT;

    @IntDef({ACTION_DEFAULT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Action {
    }

    /**
     * This method is used to retrieve the action bind with this {@code DataHolder}.
     *
     * @see BaseDataHolder#ACTION_DEFAULT
     */
    public
    @Action
    int getAction() {
        return action;
    }

    /**
     * This method is used to setup the action bind with this {@code DataHolder}.
     *
     * @see BaseDataHolder#ACTION_DEFAULT
     */
    public void setAction(@Action int action) {
        this.action = action;
    }
}
