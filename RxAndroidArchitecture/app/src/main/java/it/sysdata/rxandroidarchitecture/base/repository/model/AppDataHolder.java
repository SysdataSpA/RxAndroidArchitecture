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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public class AppDataHolder extends BaseDataHolder implements Parcelable {

    private String mWelcomeMessage;

    public AppDataHolder() {
        // empty constructor
    }

    public String getWelcomeMessage() {
        return mWelcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        mWelcomeMessage = welcomeMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mWelcomeMessage);
    }

    protected AppDataHolder(Parcel in) {
        this.mWelcomeMessage = in.readString();
    }

    public static final Creator<AppDataHolder> CREATOR = new Creator<AppDataHolder>() {
        @Override
        public AppDataHolder createFromParcel(Parcel source) {
            return new AppDataHolder(source);
        }

        @Override
        public AppDataHolder[] newArray(int size) {
            return new AppDataHolder[size];
        }
    };
}
