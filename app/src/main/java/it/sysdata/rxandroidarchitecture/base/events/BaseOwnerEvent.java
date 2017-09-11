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
import android.os.Parcelable;

/**
 * Created on 28/02/17.
 *
 * @author Umberto Marini
 */
public abstract class BaseOwnerEvent implements Parcelable {

    private String mOwner;

    /**
     * This method copies the given {@code BaseRequestEvent}'s owner to the given {@code BaseResponseEvent}.
     *
     * @param from The {@link BaseOwnerEvent} object used as source of the owner copy process.
     * @param to The {@link BaseOwnerEvent} object used as destination of the owner copy process.
     */
    public static void copyOwner(BaseOwnerEvent from, BaseOwnerEvent to) {
        if (from != null && to != null) {
            to.setOwner(from.getOwner());
        }
    }

    /**
     * Sets the owner of this {@code BaseRequestEvent}.
     */
    public void setOwner(Class clazz) {
        mOwner = clazz != null ? clazz.getSimpleName() : null;
    }

    /**
     * Sets the owner of this {@code BaseRequestEvent}.
     */
    public void setOwner(String name) {
        mOwner = name != null ? name : null;
    }

    /**
     * The owner of this {@code BaseRequestEvent}.
     */
    public String getOwner() {
        return mOwner;
    }

    /**
     * Check whether the given class is the owner of this {@code BaseRequestEvent}.
     */
    public boolean matchOwner(Class clazz) {
        return mOwner != null && clazz != null && mOwner.equals(clazz.getSimpleName());
    }

    /**
     * Check whether the given string is the name of the owner of this {@code BaseRequestEvent}.
     */
    public boolean matchOwner(String owner) {
        return mOwner != null && owner != null && mOwner.equals(owner);
    }

    public BaseOwnerEvent() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mOwner);
    }

    protected BaseOwnerEvent(Parcel in) {
        this.mOwner = in.readString();
    }

}
