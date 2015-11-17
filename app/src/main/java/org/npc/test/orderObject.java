package org.npc.test;

/**
 * Created by Caleb on 11/17/15.
 */
public class orderObject {

    private int quant;
    private String desc;
    private String name;
    private double price;

    int getQuant(){return quant;}
    String getDesc(){return desc;}
    String getName(){return name;}
    double getPrice(){return price;}

    void setQuant(int input)
    {this.quant = input;}

    void setDesc(String input)
    {this.desc = input;}

    void setName(String input)
    {this.name = input;}

    void setPrice(double input)
    {this.price = input;}

    public orderObject()
    {
        this.quant = 0;
        this.desc = null;
        this.name = null;
        this.price = 0.0;
    }


    public orderObject(int quant, String desc, String name, double price)
    {
        this.quant = quant;
        this.desc = desc;
        this.name = name;
        this.price = price;
    }
}

