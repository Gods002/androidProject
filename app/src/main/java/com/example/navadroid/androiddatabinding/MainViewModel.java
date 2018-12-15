package com.example.navadroid.androiddatabinding;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class MainViewModel extends ViewModel {

    private String string;
    private String name;

    public MainViewModel(){
        this.string = "0";
        this.name="NULL";
    }

    public String getString() {
        return string;
    }
    public String getName(){return name;}

    public void setString(String string) {
        this.string = string;
    }
    public void setName(String name){this.name = name;}


}
