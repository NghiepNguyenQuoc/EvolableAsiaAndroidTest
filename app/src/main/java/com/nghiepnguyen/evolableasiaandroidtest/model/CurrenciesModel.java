package com.nghiepnguyen.evolableasiaandroidtest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by W10-PRO on 30-Sep-17.
 */

public class CurrenciesModel implements Parcelable {
    private String code;
    private String name;
    private String symbol;

    protected CurrenciesModel(Parcel in) {
        code = in.readString();
        name = in.readString();
        symbol = in.readString();
    }

    public static final Creator<CurrenciesModel> CREATOR = new Creator<CurrenciesModel>() {
        @Override
        public CurrenciesModel createFromParcel(Parcel in) {
            return new CurrenciesModel(in);
        }

        @Override
        public CurrenciesModel[] newArray(int size) {
            return new CurrenciesModel[size];
        }
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(name);
        parcel.writeString(symbol);
    }

    @Override
    public String toString() {
        return
                "code='" + code +
                        ",\nname='" + name +
                        ",\nsymbol='" + symbol;
    }
}
