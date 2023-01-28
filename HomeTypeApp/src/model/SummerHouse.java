package model;

public class SummerHouse extends BaseHome {
    public SummerHouse(String id, String address, int room, int hall, double price, int squareMeter) {
        super(id, address, room, hall, price, squareMeter);
    }

    @Override
    public String toString() {
        return "SummerHouse: " + super.toString();
    }
}
