package pe.edu.upc.ticketrestkotlin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("ticketId")
    @Expose
    private String ticketId;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("festival")
    @Expose
    private Festival festival;
    @SerializedName("sold")
    @Expose
    private Boolean sold;
    @SerializedName("redeemed")
    @Expose
    private Boolean redeemed;
    @SerializedName("shop")
    @Expose
    private String shop;

    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Boolean getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        this.redeemed = redeemed;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

}