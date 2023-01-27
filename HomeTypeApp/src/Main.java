import model.BaseHome;
import model.House;
import model.SummerHouse;
import model.Villa;
import service.CreateObjectService;
import service.HomeService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CreateObjectService createObjectService = new CreateObjectService();
        HomeService homeService = new HomeService();


        List<House> getAllHouse = createObjectService.getAllHouse();
        getAllHouse.forEach(System.out::println);
        System.out.println("---------------------------------------------");


        List<Villa> getAllVilla = createObjectService.getAllVilla();
        getAllVilla.forEach(System.out::println);
        System.out.println("---------------------------------------------");

        List<SummerHouse> getAllSummerHouse = createObjectService.getAllSummerHouse();
        getAllSummerHouse.forEach(System.out::println);
        System.out.println("---------------------------------------------");



        System.out.println("Total price Of All House: " +
                homeService.totalPriceOfHouse(getAllHouse));
        System.out.println("Total price Of All SummerHouse: " +
                homeService.totalPriceOfSummerHouse(getAllSummerHouse));
        System.out.println("Total price Of All Villa: "  +
                homeService.totalPriceOfVilla(getAllVilla));
        System.out.println("Total price Of All Types Of Home: " +
                homeService.totalPriceOfAllTypesOfHome(getAllHouse,getAllVilla,getAllSummerHouse));



        System.out.println("Average Square Meter Of All House: " +
                homeService.averageSquareMeterOfHouses(getAllHouse));
        System.out.println("Average Square Meter Of All SummerHouse: " +
                homeService.averageSquareMeterOfSummerHouses(getAllSummerHouse));
        System.out.println("Average Square Meter Of All Villa: " +
                homeService.averageSquareMeterOfVillas(getAllVilla));
        System.out.println("Average Square Meter Of All Types Of Home: " +
                homeService.totalAverageSquareMeterOfAllTypesOfHome(getAllHouse,getAllVilla,getAllSummerHouse));



        List<BaseHome> allTypeOfHome= concatAllHome(getAllHouse,getAllVilla,getAllSummerHouse);
        List<BaseHome> baseHomeList = homeService
                .filterAnyTypeOfHomeByNumberOfRoomAndHall(allTypeOfHome,1,1);

        System.out.println("-----------------Filter All Type Of Home By Number Of Room and Hall---------------");
        baseHomeList.forEach(System.out::println);
    }

    private static  List<BaseHome> concatAllHome(
            List<House> houses,
            List<Villa> villas,
            List<SummerHouse> summerHouses
    ){
        List<BaseHome> list = new ArrayList<>();
        list.addAll(houses);
        list.addAll(villas);
        list.addAll(summerHouses);
        return  list;
    }



}