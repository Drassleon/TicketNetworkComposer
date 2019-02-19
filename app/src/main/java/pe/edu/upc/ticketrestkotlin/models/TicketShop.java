package pe.edu.upc.ticketrestkotlin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketShop {

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
    private List<Ticket> soldTickets = null;

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

    public List<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(List<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
    }

}