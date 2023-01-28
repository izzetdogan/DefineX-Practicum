package model;

public abstract class BaseHome {
    private String id;
    private String address;
    private int room;
    private int hall;
    private double price;
    private int squareMeter;



    public BaseHome(String id, String address, int room, int hall, double price, int squareMeter) {
        this.id = id;
        this.address = address;
        this.room = room;
        this.hall = hall;
        this.price = price;
        this.squareMeter = squareMeter;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }



    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", room=" + room +
                ", hall=" + hall +
                ", price=" + price +
                ", squareMeter=" + squareMeter;
    }
}
