package com.interstellar.android.httpapp;

/**
 * Created by Administrator on 2018-02-25.
 */

public class ExampleItem {
    private String mImageUrl;
    private String mTitle;
    private int mPrice;
    private String mAuthor;
    private String mBarcode;
    private String mCategory;
    private String mCover_l_url;
    private String mCover_s_url;
    private String mDescription;
    private String mEbook_barcode;
    private String mEtc_author;
    private String mIsbn;
    private String mIsbn13;
    private String mList_price;
    private String mPub_date;
    private String mPub_nm;
    private String mSale_price;
    private String mSale_yn;
    private String mStatus_des;
    private String mTranslator;


    public ExampleItem(String imageUrl, String title, int price, String author, String barcode,
                       String category, String cover_l_url, String cover_s_url, String description,
                       String ebook_barcode, String etc_author, String isbn, String isbn13,
                       String list_price, String pub_date, String pub_nm, String sale_price,
                       String sale_yn, String status_des, String translator) {

        mImageUrl = imageUrl;
        mTitle = title;
        mPrice = price;
        mAuthor = author;
        mBarcode = barcode;
        mCategory = category;
        mCover_l_url = cover_l_url;
        mCover_s_url = cover_s_url;
        mDescription = description;
        mEbook_barcode = ebook_barcode;
        mEtc_author = etc_author;
        mIsbn = isbn;
        mIsbn13 = isbn13;
        mList_price = list_price;
        mPub_date = pub_date;
        mPub_nm = pub_nm;
        mSale_price = sale_price;
        mSale_yn = sale_yn;
        mStatus_des = status_des;
        mTranslator = translator;
    }

    public ExampleItem(String imageUrl, String title, int price) {
        mImageUrl = imageUrl;
        mTitle = title;
        mPrice = price;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getPrice() {
        return mPrice;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getBarcode() {
        return mBarcode;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getCover_l_url() {
        return mCover_l_url;
    }

    public String getCover_s_url() {
        return mCover_s_url;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getEbook_barcode() {
        return mEbook_barcode;
    }

    public String getEtc_author() {
        return mEtc_author;
    }

    public String getIsbn() {
        return mIsbn;
    }

    public String getIsbn13() {
        return mIsbn13;
    }

    public String getList_price() {
        return mList_price;
    }

    public String getPub_date() {
        return mPub_date;
    }

    public String getPub_nm() {
        return mPub_nm;
    }

    public String getSale_price() {
        return mSale_price;
    }

    public String getSale_yn() {
        return mSale_yn;
    }

    public String getStatus_des() {
        return mStatus_des;
    }

    public String getTranslator() {
        return mTranslator;
    }
}
