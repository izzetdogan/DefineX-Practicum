package service;

import model.BaseHome;
import model.House;
import model.SummerHouse;
import model.Villa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeService {


    //TotalPrice Part
    public double totalPriceOfHouse(List<House> home){
        return totalPriceOfAnyHome(new ArrayList<>(home));
    }
    public double totalPriceOfVilla(List<Villa> villas){
        return totalPriceOfAnyHome(new ArrayList<>(villas));
    }
    public double totalPriceOfSummerHouse(List<SummerHouse> summerHouse){
        return totalPriceOfAnyHome(new ArrayList<>(summerHouse));
    }

    private double totalPriceOfAnyHome (List<BaseHome> home) {
        return  home.stream()
                .mapToDouble(BaseHome::getPrice)
                .sum();
    }

    public double totalPriceOfAllTypesOfHome(
            List<House> houses,
            List<Villa> villas,
            List<SummerHouse> summerHouses
    ){
        return totalPriceOfHouse(houses) +
                totalPriceOfVilla(villas) +
                totalPriceOfSummerHouse(summerHouses);
    }

    // Average Part

    public double averageSquareMeterOfHouses(List<House> houses){
        return averageSquareMeterOfAnyHomeType(new ArrayList<>(houses));
    }
    public double averageSquareMeterOfVillas(List<Villa> villas){
        return averageSquareMeterOfAnyHomeType(new ArrayList<>(villas));
    }
    public double averageSquareMeterOfSummerHouses(List<SummerHouse> summerHouses){
        return averageSquareMeterOfAnyHomeType(new ArrayList<>(summerHouses));
    }

    private double averageSquareMeterOfAnyHomeType(List<BaseHome> homeList){
        return homeList.stream()
                .mapToDouble(BaseHome::getSquareMeter)
                .average().orElse(0);
    }

    public double totalAverageSquareMeterOfAllTypesOfHome(
            List<House> houses,
            List<Villa> villas,
            List<SummerHouse> summerHouses
    ){
        return (averageSquareMeterOfHouses(houses) +
                averageSquareMeterOfVillas(villas) +
                averageSquareMeterOfSummerHouses(summerHouses))/3;
    }

    // Room and Hall
    public List<BaseHome> filterAnyTypeOfHomeByNumberOfRoomAndHall(List<BaseHome> homeList, int room, int hall){
        return homeList.stream()
                .filter(house -> house.getHall()==hall && house.getRoom()==room)
                .collect(Collectors.toList());
    }


}
