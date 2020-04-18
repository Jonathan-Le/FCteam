/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import java.util.ArrayList;

/**
 *
 * @author junyaoli
 */
    

public class NetworkDirectory {

    private ArrayList<Network> networkdirectory;
    
    public NetworkDirectory() {
        networkdirectory = new ArrayList();
    }

    public ArrayList<Network> getNetworkdirectory() {
        return networkdirectory;
    }

    public void setNetworkdirectory(ArrayList<Network> networkdirectory) {
        this.networkdirectory = networkdirectory;
    }
    
    
    
}
