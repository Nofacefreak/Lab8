package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private ArrayList<City> cities;
    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

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

    /**
     * insert a city
     * check if the city exists
     one
     */
    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);

        assertTrue(list.hasCity(city));
    }


    /**
     * insert a city
     * delete the city
     * check if the city is successfully deleted and if the city does not exists in the list
     * throw an exception
     one
     */
    @Test
    void testDeleteCity(){
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        list.deleteCity(city);

        assertFalse(list.hasCity(city));
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(city); });
    }

    @Test
    void testCountCity(){
        list  = MockCityList();
        City city1 = new City("Regina", "Saskatchewan");
        list.addCity(city1);
        City city2 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city2);

        assertEquals(2,list.countCities());
    }
}
