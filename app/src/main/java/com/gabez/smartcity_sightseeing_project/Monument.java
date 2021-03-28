package com.gabez.smartcity_sightseeing_project;

public class Monument {
    private MonumentType _monumentType;
    private String _name;
    private String _content;
    private Boolean _isFavourite;
    private Boolean _seen;
    private String _imageUrl;
    private String _shortDescription;
    private int _seenBy;
    private int _favouriteCount;

    public Monument(MonumentType monumentType, String name, String content, Boolean isFavourite, Boolean seen, String imageUrl, String shortDescription, int seenBy, int favouriteCount){
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
}
