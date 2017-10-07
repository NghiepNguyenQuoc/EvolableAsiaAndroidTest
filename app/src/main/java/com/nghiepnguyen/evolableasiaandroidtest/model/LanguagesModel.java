package com.nghiepnguyen.evolableasiaandroidtest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by W10-PRO on 30-Sep-17.
 */

public class LanguagesModel implements Parcelable {
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;

    protected LanguagesModel(Parcel in) {
        iso639_1 = in.readString();
        iso639_2 = in.readString();
        name = in.readString();
        nativeName = in.readString();
    }

    public static final Creator<LanguagesModel> CREATOR = new Creator<LanguagesModel>() {
        @Override
        public LanguagesModel createFromParcel(Parcel in) {
            return new LanguagesModel(in);
        }

        @Override
        public LanguagesModel[] newArray(int size) {
            return new LanguagesModel[size];
        }
    };

    public String getIso639_1() {
        return iso639_1;
    }

    public void setIso639_1(String iso639_1) {
        this.iso639_1 = iso639_1;
    }

    public String getIso639_2() {
        return iso639_2;
    }

    public void setIso639_2(String iso639_2) {
        this.iso639_2 = iso639_2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iso639_1);
        parcel.writeString(iso639_2);
        parcel.writeString(name);
        parcel.writeString(nativeName);
    }

    @Override
    public String toString() {
        return
                "iso639_1='" + iso639_1 +
                        ",\niso639_2='" + iso639_2 +
                        "\nname='" + name +
                        ",\nnativeName='" + nativeName;
    }
}
