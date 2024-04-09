package com.example.lab_04;

import android.graphics.Bitmap;

public class Person {

    public Bitmap img;     // Изображение
    public String title;         // Заголовок
    public String ref;           // Справка
    public Person( String t, String r, Bitmap img) // Конструктор
    {
        this.img=img;
        this.title=t;
        this.ref=r;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String t) {
        this.title = t;
    }
    public Bitmap getImg() {
        return this.img;
    }

    public void setImg(Bitmap i) {
        this.img = i;
    }
    public String getRef() {
        return this.ref;
    }
    public void setRef(String r) {
        this.ref = r;
    }
}