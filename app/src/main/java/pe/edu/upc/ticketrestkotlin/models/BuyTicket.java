package pe.edu.upc.ticketrestkotlin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class BuyTicket implements Serializable{

    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("ticketShop")
    @Expose
    private TicketShop ticketShop;
    @SerializedName("soldTicket")
    @Expose
    private Ticket soldTicket;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("timestamp")
    @Expose
    private Date timestamp;

    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public TicketShop getTicketShop() {
        return ticketShop;
    }

    public void setTicketShop(TicketShop ticketShop) {
        this.ticketShop = ticketShop;
    }

    public Ticket getSoldTicket() {
        return soldTicket;
    }

    public void setSoldTicket(Ticket soldTicket) {
        this.soldTicket = soldTicket;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
