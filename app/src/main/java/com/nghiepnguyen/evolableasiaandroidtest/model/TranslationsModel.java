package com.nghiepnguyen.evolableasiaandroidtest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by W10-PRO on 30-Sep-17.
 */

public class TranslationsModel implements Parcelable {
    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String br;
    private String pt;
    private String nl;
    private String hr;

    protected TranslationsModel(Parcel in) {
        de = in.readString();
        es = in.readString();
        fr = in.readString();
        ja = in.readString();
        it = in.readString();
        br = in.readString();
        pt = in.readString();
        nl = in.readString();
        hr = in.readString();
    }

    public static final Creator<TranslationsModel> CREATOR = new Creator<TranslationsModel>() {
        @Override
        public TranslationsModel createFromParcel(Parcel in) {
            return new TranslationsModel(in);
        }

        @Override
        public TranslationsModel[] newArray(int size) {
            return new TranslationsModel[size];
        }
    };

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(de);
        parcel.writeString(es);
        parcel.writeString(fr);
        parcel.writeString(ja);
        parcel.writeString(it);
        parcel.writeString(br);
        parcel.writeString(pt);
        parcel.writeString(nl);
        parcel.writeString(hr);
    }

    @Override
    public String toString() {
        return
                "de='" + de +
                        ",\nes='" + es +
                        ",\nfr='" + fr +
                        ",\nja='" + ja +
                        ",\nit='" + it +
                        ",\nbr='" + br +
                        ",\npt='" + pt +
                        ",\nnl='" + nl +
                        ",\nhr='" + hr;
    }
}
