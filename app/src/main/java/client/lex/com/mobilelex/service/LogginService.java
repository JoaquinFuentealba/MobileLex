package client.lex.com.mobilelex.service;

import android.accounts.Account;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.util.JsonReader;
import android.webkit.WebResourceError;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import client.lex.com.mobilelex.domain.Constante;
import client.lex.com.mobilelex.domain.UserDataLoggin;
import client.lex.com.mobilelex.security.UtilEncrypt;

public class LogginService {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static UserDataLoggin getUsuer(String user, String pass){
        try{
            UserDataLoggin result = new UserDataLoggin();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            final Client client = Client.create();
            final WebResource webResource = client.resource(Constante.SERVICIO_LOGGIIN);
            pass = UtilEncrypt.getEncryptCipher(pass);
            String input = "{\"user\":\""+user +"\",\"pass\":\""+pass+"\"}";

            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, input);



            String respuesta = response.getEntity(String.class);
            //InputStream is = new ByteArrayInputStream(respuesta.getBytes("UTF-8"));
            //BufferedReader reader = new BufferedReader(is.;

            JSONObject json = new JSONObject(respuesta);
            String arrayJSON = json.getString("type");
            result.setCodigo(Integer.parseInt(json.getString("codigo")));
            result.setMensaje(json.getString("mensaje"));
            if(result.getCodigo() == 0){
                result.setIdRol(json.getString("idRol"));
                result.setCorreo(json.getString("correo"));
                result.setNombreRol(json.getString("nombreRol"));
                result.setUser(json.getString("user"));
            }
            return result;
        }
        catch(ClientHandlerException e ){
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
}
