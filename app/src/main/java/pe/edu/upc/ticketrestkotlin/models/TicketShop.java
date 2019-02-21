package pe.edu.upc.ticketrestkotlin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TicketShop implements Serializable{

    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("shopId")
    @Expose
    private String shopId;
    @SerializedName("shopAddress")
    @Expose
    private Address shopAddress;
    @SerializedName("soldTickets")
    @Expose
    private List<String> soldTickets = null;

    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<String> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(List<String> soldTickets) {
        this.soldTickets = soldTickets;
    }

}