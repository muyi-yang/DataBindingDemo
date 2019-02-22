package com.example.databindingdemo.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @author yanglijun
 * @date 19-2-22
 */
public class CelebrityInfo {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt weight = new ObservableInt();
    public final ObservableInt photo = new ObservableInt();
    public final ObservableBoolean isRetire = new ObservableBoolean();
    public final ObservableDouble income = new ObservableDouble();
}
