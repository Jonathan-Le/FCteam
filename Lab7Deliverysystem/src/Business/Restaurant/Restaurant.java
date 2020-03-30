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
public class Restaurant {
    private String name;
    private String location;
    private String phone ;
    private ArrayList<String> menuelist;

    public Restaurant(String name, String location,String phone ) {
        this.location=location;
        this.name=name;
        this.phone =phone;

    }
    public void getInstance(){
         menuelist= new ArrayList();
         menuelist.add("orange chicken");
        menuelist.add("rice");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String addMenue(String dish){
        menuelist.add(name);
        return dish;
    }
    
    public void deleMenue(String dish){
        for (String d : menuelist) {
            if (d.equals(dish)) {
                menuelist.remove(d);
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getMenuelist() {
        return menuelist;
    }

    public void setMenuelist(ArrayList<String> menuelist) {
        this.menuelist = menuelist;
    }
    
    
}
