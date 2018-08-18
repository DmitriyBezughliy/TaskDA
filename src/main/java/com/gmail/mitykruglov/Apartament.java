package com.gmail.mitykruglov;

public class Apartament  {
    private int Id;
    private String district;
    private String adrress;
    private double m2;
    private int numberOfRooms;
    private double price;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "Id=" + Id +
                ", district='" + district + '\'' +
                ", adrress='" + adrress + '\'' +
                ", m2=" + m2 +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                '}';
    }
}
