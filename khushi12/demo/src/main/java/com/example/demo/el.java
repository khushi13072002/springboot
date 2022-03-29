package com.example.demo;

public class el{
    String Title;
    String Price;
    String ImageLink;
    String condition;

    public String getTitle(){
        return this.Title;
    }

    public String getPrice(){
        return this.Price;
    }

    public String getImageLink(){
        return this.ImageLink;
    }

    public String getcondition(){
        return this.condition;
    }


    public void setTitle(String Title){
        this.Title = Title;
    }

    public void setPrice(String Price){
        this.Price = Price;
    }

    public void setImageLink(String ImageLink){
        this.ImageLink = ImageLink;
    }

    public void setcondition(String condition){
        this.condition = condition;
    }

}