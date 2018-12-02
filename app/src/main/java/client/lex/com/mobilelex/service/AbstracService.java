package client.lex.com.mobilelex.service;

import android.os.StrictMode;

import com.sun.jersey.api.client.Client;

public class AbstracService {
    public  static StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    public  static Client client = Client.create();
    public AbstracService(){
        this.policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        this.client = Client.create();
    }
}
