/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import com.google.gson.Gson;
import informacion.Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Archivo {
    public void agregaUsuario (Datos datos){
        String cadena = convertirJson(datos);
        try{
            FileWriter archivo = new FileWriter("datos.txt", true);
            BufferedWriter bw = new BufferedWriter(archivo);
            bw.write(cadena + "\n");
            bw.close();
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
    }
    
    public List<Datos> leerUsuarios(){
        List<Datos> listdatos = new ArrayList<>();
        String cadena;
        try{
            FileReader archivo = new FileReader("datos.txt");
            BufferedReader br = new BufferedReader(archivo);
            while((cadena = br.readLine()) !=null){
              listdatos.add(convEstructura(cadena));  
            }return listdatos;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private String convertirJson(Datos datos){
        Gson gson = new Gson();
        String cadena;
        cadena = gson.toJson(datos);
        return cadena;
        
    }
    private Datos convEstructura(String cadena ){
        Gson gson = new Gson();
        Datos datos = new Datos();
        datos = gson.fromJson(cadena, Datos.class);
        return datos;
        
        
    }
}
