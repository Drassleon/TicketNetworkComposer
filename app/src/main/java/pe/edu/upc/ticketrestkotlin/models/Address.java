package pe.edu.upc.ticketrestkotlin.models;

import android.os.Bundle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable{

    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("id")
    @Expose
    private String id;

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("$class",$class);
        bundle.putString("street",street);
        bundle.putString("city",city);
        bundle.putString("country",country);
        bundle.putString("id",id);
        return bundle;
    }

    public Address fromBundle(Bundle bundle){
        Address aBundle = new Address();
        aBundle.$class = bundle.getString("$class");
        aBundle.street = bundle.getString("street");
        aBundle.city = bundle.getString("city");
        aBundle.country = bundle.getString("country");
        aBundle.id = bundle.getString("id");
        return aBundle;
    }
    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}