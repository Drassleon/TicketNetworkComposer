package pe.edu.upc.ticketrestkotlin.models;

import android.os.Bundle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Client {

    @SerializedName("$class")
    @Expose
    private String $class;
    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("docType")
    @Expose
    private String docType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("birthdate")
    @Expose
    private Date birthdate;
    @SerializedName("ticketBought")
    @Expose
    private List<Ticket> ticketBought = null;

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("$class",$class);
        bundle.putString("clientId",clientId);
        bundle.putString("firstName",firstName);
        bundle.putString("lastName",lastName);
        bundle.putBundle("address",address.toBundle());
        bundle.putString("docType",docType);
        bundle.putString("id",id);
        bundle.putString("birthDate",birthdate.toString());
        return bundle;
    }

    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Ticket> getTicketBought() {
        return ticketBought;
    }

    public void setTicketBought(List<Ticket> ticketBought) {
        this.ticketBought = ticketBought;
    }

}