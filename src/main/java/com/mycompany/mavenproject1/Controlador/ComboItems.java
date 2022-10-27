/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.autolog.util;

/**
 *
 * @author macpro2
 */
public class ComboItems {
    
    private String key = "";
    private String value = "";
    private String alt_key = "";
    private String alt_value = "";
    private String alt_key2 = "";
    
    public ComboItems(String key, String value){
        this.key = key;
        this.value = value;
    }
    
    public ComboItems(String _key, String _value,String _alt_key, String _alt_value){
        this.key = _key;
        this.value = _value;
        this.alt_key = _alt_key;
        this.alt_value = _alt_value;
    }
    
    public ComboItems(String _key, String _value,String _alt_key, String _alt_value, String _alt_key2){
        this.key = _key;
        this.value = _value;
        this.alt_key = _alt_key;
        this.alt_value = _alt_value;
        this.alt_key2 = _alt_key2;
    }
    
    public String toString(){
        String sCadena = "";
        
        if (this.value!=null)
            sCadena = this.value;
        
        return sCadena;
    }
    
    public String getKey(){
        return key;
    }
    
    public String getValue(){
        return value;
    }
    
    public String getAltKey(){
        return alt_key;
    }

    public String getAltKey2(){
        return alt_key2;
    }
    
    public String getAltValue(){
        return alt_value;
    }    
    
}
