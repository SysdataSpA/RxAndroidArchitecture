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

package it.sysdata.rxandroidarchitecture.base.events;

import android.os.Parcel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public abstract class BaseResponseEvent extends BaseOwnerEvent {

    public static final String BASE_STATUS_OK = "base.status.ok";
    public static final String BASE_STATUS_FAIL = "base.status.fail";
    public static final String BASE_STATUS_EMPTY = "base.status.empty";

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseResponseEvent.class);

    private String mEventStatus = BASE_STATUS_EMPTY;

    public BaseResponseEvent() {
        // empty constructor
    }

    /**
     * This method copies the given {@code BaseRequestEvent}'s owner to the given {@code BaseResponseEvent}.
     *
     * @param from The {@link BaseRequestEvent} object used as source of the owner copy process.
     * @param to   The {@link BaseResponseEvent} object used as destination of the owner copy process.
     */
    public static void copyOwner(BaseRequestEvent from, BaseResponseEvent to) {
        BaseOwnerEvent.copyOwner(from, to);
    }

    /**
     * This method will make the event based on class passed by parameter with status {@link BaseResponseEvent#BASE_STATUS_OK}
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends BaseResponseEvent> T makeOkResponse(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            t.setEventStatus(BASE_STATUS_OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return t;
    }

    /**
     * This method will make the event based on class passed by parameter with status {@link BaseResponseEvent#BASE_STATUS_FAIL}
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends BaseResponseEvent> T makeFailResponse(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            t.setEventStatus(BASE_STATUS_FAIL);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return t;
    }

    /**
     * This method will make the event based on class passed by parameter with status {@link BaseResponseEvent#BASE_STATUS_EMPTY}
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends BaseResponseEvent> T makeEmptyResponse(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            t.setEventStatus(BASE_STATUS_EMPTY);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return t;
    }

    public String getEventStatus() {
        return mEventStatus;
    }

    public void setEventStatus(String status) {
        this.mEventStatus = status;
    }

    public boolean isValidResponse() {
        return mEventStatus != null && mEventStatus.equals(BASE_STATUS_OK);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mEventStatus);
    }

    protected BaseResponseEvent(Parcel in) {
        super(in);
        this.mEventStatus = in.readString();
    }
}