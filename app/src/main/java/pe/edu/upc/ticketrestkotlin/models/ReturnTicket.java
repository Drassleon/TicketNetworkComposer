package pe.edu.upc.ticketrestkotlin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ReturnTicket {
    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("ticket")
    @Expose
    private Ticket ticket;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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
