package pe.edu.upc.ticketrestkotlin.models;

import android.os.Bundle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

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