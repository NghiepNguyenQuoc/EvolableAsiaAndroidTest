package com.nghiepnguyen.evolableasiaandroidtest.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class CountryModel implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    @SerializedName("population")
    private double population;
    @SerializedName("area")
    private double area;
    @SerializedName("flag")
    private String flag;
    @SerializedName("alpha2Code")
    private String alpha2Code;
    @SerializedName("alpha3Code")
    private String alpha3Code;
    @SerializedName("region")
    private String region;
    @SerializedName("subregion")
    private String subregion;
    @SerializedName("demonym")
    private String demonym;
    @SerializedName("nativeName")
    private String nativeName;
    @SerializedName("numericCode")
    private String numericCode;
    @SerializedName("topLevelDomain")
    private List<String> topLevelDomain;
    @SerializedName("callingCodes")
    private List<String> callingCodes;
    @SerializedName("altSpellings")
    private List<String> altSpellings;
    @SerializedName("latlng")
    private List<String> latlng;
    @SerializedName("timezones")
    private List<String> timezones;
    @SerializedName("borders")
    private List<String> borders;
    @SerializedName("currencies")
    private List<CurrenciesModel> currencies;
    @SerializedName("languages")
    private List<LanguagesModel> languages;
    @SerializedName("translations")
    private TranslationsModel translations;
    @SerializedName("regionalBlocs")
    private List<RegionalBlocsModel> regionalBlocs;

    public List<Dummy> toList() {
        List<Dummy> mapList = new ArrayList<>();
        mapList.add(new Dummy("capital", capital));
        mapList.add(new Dummy("population", String.format(Locale.US, "%1$,.0f", population)));
        mapList.add(new Dummy("area", String.format(Locale.US, "%1$,.0f", area)));
        mapList.add(new Dummy("alpha2Code", alpha2Code));
        mapList.add(new Dummy("alpha3Code", alpha3Code));
        mapList.add(new Dummy("region", region));
        mapList.add(new Dummy("demonym", demonym));
        mapList.add(new Dummy("nativeName", nativeName));
        mapList.add(new Dummy("numericCode", numericCode));
        mapList.add(new Dummy("topLevelDomain", TextUtils.join(", ", topLevelDomain)));
        mapList.add(new Dummy("callingCodes", TextUtils.join(", ", callingCodes)));
        mapList.add(new Dummy("altSpellings", TextUtils.join(", ", altSpellings)));
        mapList.add(new Dummy("latlng", TextUtils.join(", ", latlng)));
        mapList.add(new Dummy("timezones", TextUtils.join(", ", timezones)));
        mapList.add(new Dummy("borders", TextUtils.join(", ", borders)));
        mapList.add(new Dummy("currencies", TextUtils.join(", ", currencies)));
        mapList.add(new Dummy("languages", TextUtils.join(", ", languages)));
        mapList.add(new Dummy("translations", translations.toString()));
        mapList.add(new Dummy("regionalBlocs", TextUtils.join(", ", regionalBlocs)));
        return mapList;
    }

    protected CountryModel(Parcel in) {
        name = in.readString();
        capital = in.readString();
        population = in.readDouble();
        area = in.readDouble();
        flag = in.readString();
        alpha2Code = in.readString();
        alpha3Code = in.readString();
        region = in.readString();
        subregion = in.readString();
        demonym = in.readString();
        nativeName = in.readString();
        numericCode = in.readString();
        topLevelDomain = in.createStringArrayList();
        callingCodes = in.createStringArrayList();
        altSpellings = in.createStringArrayList();
        latlng = in.createStringArrayList();
        timezones = in.createStringArrayList();
        borders = in.createStringArrayList();
        currencies = in.createTypedArrayList(CurrenciesModel.CREATOR);
        languages = in.createTypedArrayList(LanguagesModel.CREATOR);
        translations = in.readParcelable(TranslationsModel.class.getClassLoader());
        regionalBlocs = in.createTypedArrayList(RegionalBlocsModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(capital);
        dest.writeDouble(population);
        dest.writeDouble(area);
        dest.writeString(flag);
        dest.writeString(alpha2Code);
        dest.writeString(alpha3Code);
        dest.writeString(region);
        dest.writeString(subregion);
        dest.writeString(demonym);
        dest.writeString(nativeName);
        dest.writeString(numericCode);
        dest.writeStringList(topLevelDomain);
        dest.writeStringList(callingCodes);
        dest.writeStringList(altSpellings);
        dest.writeStringList(latlng);
        dest.writeStringList(timezones);
        dest.writeStringList(borders);
        dest.writeTypedList(currencies);
        dest.writeTypedList(languages);
        dest.writeParcelable(translations, flags);
        dest.writeTypedList(regionalBlocs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountryModel> CREATOR = new Creator<CountryModel>() {
        @Override
        public CountryModel createFromParcel(Parcel in) {
            return new CountryModel(in);
        }

        @Override
        public CountryModel[] newArray(int size) {
            return new CountryModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public List<String> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<String> latlng) {
        this.latlng = latlng;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<CurrenciesModel> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrenciesModel> currencies) {
        this.currencies = currencies;
    }

    public List<LanguagesModel> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguagesModel> languages) {
        this.languages = languages;
    }

    public TranslationsModel getTranslations() {
        return translations;
    }

    public void setTranslations(TranslationsModel translations) {
        this.translations = translations;
    }

    public List<RegionalBlocsModel> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBlocsModel> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }
}
