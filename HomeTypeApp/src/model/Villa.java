package model;

public class Villa extends BaseHome {

    public Villa(String id, String address, int room, int hall, double price, int squareMeter) {
        super(id, address, room, hall, price, squareMeter);
    }

    @Override
    public String toString() {
        return "Villa: " + super.toString();
    }
}
