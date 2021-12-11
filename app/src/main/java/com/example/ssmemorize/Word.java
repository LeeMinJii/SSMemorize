package com.example.ssmemorize;

public class Word {

    public int _id;
    public String english;
    public String korean;

    // set function
    public void setId(int _id){this._id = _id;}
    public void setEnglish(String english) {this.english = english;}
    public void setKorean(String korean) {this.korean = korean;}

    // get function
    public int getId(){return this._id;}
    public String getEnglish() {return this.english;}
    public String getKorean() {return this.korean;}

}