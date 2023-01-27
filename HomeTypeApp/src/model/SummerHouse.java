package model;

public class SummerHouse extends BaseHome {

    public SummerHouse(String id, String address, int room, int hall, double price, int squareMeter) {
        super(id, address, room, hall, price, squareMeter, HomeType.SUMMERHOUSE);
    }

    @Override
    public void setHouseType(HomeType houseType) {
        super.setHouseType(HomeType.SUMMERHOUSE);
    }

    @Override
    public String toString() {
        return "SummerHouse: " + super.toString();
    }
}
