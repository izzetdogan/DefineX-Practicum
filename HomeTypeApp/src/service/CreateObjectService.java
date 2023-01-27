package service;

import model.BaseHome;
import model.House;
import model.SummerHouse;
import model.Villa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CreateObjectService {

    public List<House> getAllHouse(){
        House house1 = new House(UUID.randomUUID().toString() ,"address",3,1,30000.54,150);
        House house2 = new House(UUID.randomUUID().toString() ,"address",4,1,50000.54,200);
        House house3 = new House(UUID.randomUUID().toString() ,"address",2,1,25000.54,100);
        House house4 = new House(UUID.randomUUID().toString() ,"address",1,1,20000.54,80);
        return Arrays.asList(house1,house2,house3,house4);
    }


    public List<SummerHouse> getAllSummerHouse(){
        SummerHouse summerHouse1 = new SummerHouse(UUID.randomUUID().toString() ,"address",8,3,80000.54,400);
        SummerHouse summerHouse2 = new SummerHouse(UUID.randomUUID().toString() ,"address",5,1,50000.54,250);
        SummerHouse summerHouse3 = new SummerHouse(UUID.randomUUID().toString() ,"address",6,2,60000.54,300);
        SummerHouse summerHouse4 = new SummerHouse(UUID.randomUUID().toString() ,"address",7,2,70000.54,350);

        return Arrays.asList(summerHouse1,summerHouse2,summerHouse3,summerHouse4);
    }

    public List<Villa> getAllVilla(){
        Villa villa = new Villa(UUID.randomUUID().toString() ,"address",6,1,30000.54,300);
        Villa villa2 = new Villa(UUID.randomUUID().toString() ,"address",6,2,40000.54,350);
        Villa villa3 = new Villa(UUID.randomUUID().toString() ,"address",7,2,550000.54,400);
        Villa villa4 = new Villa(UUID.randomUUID().toString() ,"address",8,2,70000.54,600);

        return Arrays.asList(villa,villa2,villa3,villa4);
    }


}
