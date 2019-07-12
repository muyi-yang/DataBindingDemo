package com.example.databindingdemo.bean

import android.databinding.BaseObservable
import android.databinding.Bindable

import com.example.databindingdemo.BR


/**
 * @author yanglijun
 * @date 19-2-22
 */
class CelebrityInfo : BaseObservable() {
    internal var name: String? = null
    internal var weight: Int = 0
    internal var photo: Int = 0
    internal var isRetire: Boolean = false
    internal var income: Double = 0.toDouble()

    @Bindable
    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
        notifyPropertyChanged(BR.name)
    }

    @Bindable
    fun getWeight(): Int {
        return weight
    }

    fun setWeight(weight: Int) {
        this.weight = weight
        notifyPropertyChanged(BR.weight)
    }

    @Bindable
    fun getPhoto(): Int {
        return photo
    }

    fun setPhoto(photo: Int) {
        this.photo = photo
        notifyPropertyChanged(BR.photo)
    }

    @Bindable
    fun isRetire(): Boolean {
        return isRetire
    }

    fun setRetire(retire: Boolean) {
        isRetire = retire
        notifyPropertyChanged(BR.retire)
    }

    @Bindable
    fun getIncome(): Double {
        return income
    }

    fun setIncome(income: Double) {
        this.income = income
        notifyPropertyChanged(BR.income)
    }

    fun copyObj(info: CelebrityInfo) {
        this.name = info.getName()
        this.income = info.getIncome()
        this.isRetire = info.isRetire()
        this.photo = info.getPhoto()
        this.weight = info.getWeight()
        notifyPropertyChanged(BR._all)
    }
}
