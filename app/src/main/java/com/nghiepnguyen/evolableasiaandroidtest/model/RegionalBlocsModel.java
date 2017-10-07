package com.nghiepnguyen.evolableasiaandroidtest.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by W10-PRO on 30-Sep-17.
 */

public class RegionalBlocsModel implements Parcelable {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;

    protected RegionalBlocsModel(Parcel in) {
        acronym = in.readString();
        name = in.readString();
        otherAcronyms = in.createStringArrayList();
        otherNames = in.createStringArrayList();
    }

    public static final Creator<RegionalBlocsModel> CREATOR = new Creator<RegionalBlocsModel>() {
        @Override
        public RegionalBlocsModel createFromParcel(Parcel in) {
            return new RegionalBlocsModel(in);
        }

        @Override
        public RegionalBlocsModel[] newArray(int size) {
            return new RegionalBlocsModel[size];
        }
    };

    @Override
    public String toString() {
        return
                "acronym='" + acronym +
                        ",\nname='" + name +
                        ",\notherAcronyms=" + otherAcronyms +
                        ",\notherNames=" + otherNames;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(acronym);
        parcel.writeString(name);
        parcel.writeStringList(otherAcronyms);
        parcel.writeStringList(otherNames);
    }
}
