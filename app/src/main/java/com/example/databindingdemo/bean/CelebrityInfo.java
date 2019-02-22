package com.example.databindingdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.databindingdemo.BR;


/**
 * @author yanglijun
 * @date 19-2-22
 */
public class CelebrityInfo extends BaseObservable {
    private String name;
    private int weight;
    private int photo;
    private boolean isRetire;
    private double income;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }

    @Bindable
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
        notifyPropertyChanged(BR.photo);
    }

    @Bindable
    public boolean isRetire() {
        return isRetire;
    }

    public void setRetire(boolean retire) {
        isRetire = retire;
        notifyPropertyChanged(BR.retire);
    }

    @Bindable
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
        notifyPropertyChanged(BR.income);
    }
}
