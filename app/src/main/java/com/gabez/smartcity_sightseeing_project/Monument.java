package com.gabez.smartcity_sightseeing_project;

import android.os.Parcel;
import android.os.Parcelable;

import com.gabez.smartcity_sightseeing_project.monument_list.MonumentType;

public class Monument implements Parcelable {
    private MonumentType _monumentType;
    private String _name;
    private String _content;
    private Boolean _isFavourite;
    private Boolean _seen;
    private String _imageUrl;
    private String _shortDescription;
    private int _seenBy;
    private int _favouriteCount;

    public Monument(MonumentType monumentType, String name, String content, Boolean isFavourite, Boolean seen, String imageUrl, String shortDescription, int seenBy, int favouriteCount) {
        _monumentType = monumentType;
        _name = name;
        _content = content;
        _isFavourite = isFavourite;
        _seen = seen;
        _imageUrl = imageUrl;
        _shortDescription = shortDescription;
        _seenBy = seenBy;
        _favouriteCount = favouriteCount;
    }

    public MonumentType get_monumentType() {
        return _monumentType;
    }

    public String get_name() {
        return _name;
    }

    public String get_content() {
        return _content;
    }

    public Boolean get_isFavourite() {
        return _isFavourite;
    }

    public void set_isFavourite(Boolean _isFavourite) {
        this._isFavourite = _isFavourite;
    }

    public Boolean get_seen() {
        return _seen;
    }

    public void set_seen(Boolean _seen) {
        this._seen = _seen;
    }

    public String get_imageUrl() {
        return _imageUrl;
    }

    public void set_imageUrl(String _imageUrl) {
        this._imageUrl = _imageUrl;
    }

    public String get_shortDescription() {
        return _shortDescription;
    }

    public int get_seenBy() {
        return _seenBy;
    }

    public void set_seenBy(int _seenBy) {
        this._seenBy = _seenBy;
    }

    public int get_favouriteCount() {
        return _favouriteCount;
    }

    public void set_favouriteCount(int _favouriteCount) {
        this._favouriteCount = _favouriteCount;
    }

    public Monument(Parcel in) {
        String[] data = new String[9];
        in.readStringArray(data);

        this._monumentType = MonumentType.OTHER;

        this._name = data[1];
        this._content = data[2];

        if(data[3].equals("true")) this._isFavourite = true;
        else this._isFavourite = false;

        if(data[4].equals("true")) this._seen = true;
        else this._seen = false;

        this._imageUrl = data[5];
        this._shortDescription = data[6];
        this._seenBy = Integer.parseInt(data[7]);
        this._favouriteCount = Integer.parseInt(data[8]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(
                new String[]{
                        this._monumentType.toString(),
                        this._name,
                        this._content,
                        this._isFavourite.toString(),
                        this._seen.toString(),
                        this._imageUrl,
                        this._shortDescription,
                        String.valueOf(this._seenBy),
                        String.valueOf(this._favouriteCount),
                }
        );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Monument createFromParcel(Parcel in) {
            return new Monument(in);
        }

        public Monument[] newArray(int size) {
            return new Monument[size];
        }
    };
}
