package com.example.citates;

public class Person {

    public int img;     // Изображение
    public String title;         // Заголовок
    public String ref;

    public Person(int img, String title, String ref) {
        this.img = img;
        this.title = title;
        this.ref = ref;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

}
