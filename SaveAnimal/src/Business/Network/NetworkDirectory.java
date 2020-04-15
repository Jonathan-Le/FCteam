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
    
    public Network findNetWork(String name ) {
        
        for (Network network1 : networkdirectory) {
            if (network1.getName().equals(name)) {
                return network1;
            }
        }
        return null;
    }

    public Network CreaNetwork(String name){
       Network network =  new Network(name);
       networkdirectory.add(network);
       return  network;
    }
    public ArrayList<Network> getNetworkdirectory() {
        return networkdirectory;
    }

    public void setNetworkdirectory(ArrayList<Network> networkdirectory) {
        this.networkdirectory = networkdirectory;
    }
    
    
    
}
