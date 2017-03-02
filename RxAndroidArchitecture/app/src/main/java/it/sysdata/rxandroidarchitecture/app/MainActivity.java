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

package it.sysdata.rxandroidarchitecture.app;

import android.os.Bundle;
import android.widget.TextView;

import com.baseandroid.events.EventDispatcher;
import com.baseandroid.events.rx.annotations.RxSubscribe;

import it.sysdata.rxandroidarchitecture.R;
import it.sysdata.rxandroidarchitecture.base.activity.MyBaseActivity;
import it.sysdata.rxandroidarchitecture.base.coordinator.CoordinatorType;
import it.sysdata.rxandroidarchitecture.base.events.data.DataRetrieveWelcomeMessageRequestEvent;
import it.sysdata.rxandroidarchitecture.base.events.data.DataRetrieveWelcomeMessageResponseEvent;

public class MainActivity extends MyBaseActivity {

    private TextView mWelcomeMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWelcomeMessageTextView = (TextView) findViewById(R.id.main_welcome_message_tv);
    }

    @Override
    public void attach() {
        super.attach();

        mIsCoordinatorAvailable = requestCoordinator(CoordinatorType.APPDATA);
    }

    @Override
    public void detach() {
        super.detach();

        mIsCoordinatorAvailable = false;
        releaseCoordinator(CoordinatorType.APPDATA);
    }

    @Override
    public void init() {
        super.init();

        EventDispatcher.post(DataRetrieveWelcomeMessageRequestEvent.create(MainActivity.class));
    }

    @RxSubscribe
    public void onConsumeDataRetrieveWelcomeMessageResponseEvent(final DataRetrieveWelcomeMessageResponseEvent event){
        if(event.matchOwner(MainActivity.class)) {
            mWelcomeMessageTextView.setText(event.getWelcomeMessage());
        }
    }
}
