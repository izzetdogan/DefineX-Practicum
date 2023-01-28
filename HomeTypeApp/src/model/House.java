package model;

public class House extends BaseHome {

    public House(String id, String address, int room, int hall, double price, int squareMeter) {
        super(id, address, room, hall, price, squareMeter);
    }

    @Override
    public String toString() {
        return "House: " + super.toString();
    }
}
