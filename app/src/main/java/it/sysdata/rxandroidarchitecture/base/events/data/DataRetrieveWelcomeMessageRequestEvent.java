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

package it.sysdata.rxandroidarchitecture.base.events.data;

import android.os.Parcel;

import com.baseandroid.events.Event;

import it.sysdata.rxandroidarchitecture.base.events.BaseRequestEvent;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
@Event(type = Event.Type.DATA)
public class DataRetrieveWelcomeMessageRequestEvent extends BaseRequestEvent {

  public static DataRetrieveWelcomeMessageRequestEvent create(Class owner){
    DataRetrieveWelcomeMessageRequestEvent dataAppDataRequestEvent = new DataRetrieveWelcomeMessageRequestEvent();
    dataAppDataRequestEvent.setOwner(owner);
    return dataAppDataRequestEvent;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
  }

  public DataRetrieveWelcomeMessageRequestEvent() {
    // empty constructor
  }

  protected DataRetrieveWelcomeMessageRequestEvent(Parcel in) {
    super(in);
  }

  public static final Creator<DataRetrieveWelcomeMessageRequestEvent> CREATOR = new Creator<DataRetrieveWelcomeMessageRequestEvent>() {
    @Override
    public DataRetrieveWelcomeMessageRequestEvent createFromParcel(Parcel source) {
      return new DataRetrieveWelcomeMessageRequestEvent(source);
    }

    @Override
    public DataRetrieveWelcomeMessageRequestEvent[] newArray(int size) {
      return new DataRetrieveWelcomeMessageRequestEvent[size];
    }
  };
}
