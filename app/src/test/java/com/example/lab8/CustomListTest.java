package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        boolean test = list.hasCity(city);
        assertEquals(true, test);

        City city2 = new City("Edmonton", "Alberta");
        boolean test2 = list.hasCity(city2);
        assertEquals(false, test2);
    }

    @Test
    void testDelete(){
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertEquals(0, list.getCount());
        assertTrue(list.hasCity(city) == false);
    }

    @Test
    void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.getCount());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.getCount());

        City city2 = new City("Edmonton", "Alberta");
        list.addCity(city2);
        assertEquals(2, list.getCount());

        City city3 = new City("Vancouver", "British Columbia");
        list.addCity(city3);
        assertEquals(3, list.getCount());
    }
}
