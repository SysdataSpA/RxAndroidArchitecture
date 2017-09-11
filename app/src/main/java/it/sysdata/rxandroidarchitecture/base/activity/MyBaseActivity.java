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

package it.sysdata.rxandroidarchitecture.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.baseandroid.core.activity.BaseActivity;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public class MyBaseActivity extends BaseActivity {

    /**
     * This method use {@link ActivityCompat#startActivity(Context, Intent, Bundle)} to launch activity.
     *
     * @param fromActivity    the activity
     * @param toActivityClass the class of target activity
     */
    public static void launch(FragmentActivity fromActivity, Class toActivityClass) {
        Intent intent = new Intent(fromActivity, toActivityClass);
        ActivityCompat.startActivity(fromActivity, intent, null);
    }

    @Override
    public void attach() {
        // empty implementation
    }

    @Override
    public void detach() {
        // empty implementation
    }

    @Override
    public void init() {
        // empty implementation
    }
}
