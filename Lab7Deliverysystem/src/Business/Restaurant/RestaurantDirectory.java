/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;


import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
    private ArrayList<Restaurant> RestaurantDirectory;

    public RestaurantDirectory() {
        RestaurantDirectory= new ArrayList();
    }
    public Restaurant addRestaurant(Restaurant restaurant) {
        RestaurantDirectory.add(restaurant);
        return restaurant;
    }   
    public ArrayList<Restaurant> getRestaurantDirectory() {
        return RestaurantDirectory;
    }

        public void deleteUserAccount(Restaurant account){
        this.RestaurantDirectory.remove(account);
    }
    public void setRestaurantDirectory(ArrayList<Restaurant> RestaurantDirectory) {
        this.RestaurantDirectory = RestaurantDirectory;
    }

    public Restaurant findRestaurant(String username) {
           
        for (Restaurant res : RestaurantDirectory)
            if (res.getName().equals(username)){
                return res;
            
        }
        return null;
    }
}
