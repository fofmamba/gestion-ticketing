package jpa.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {
    private String name;
    private List<Ticket> tickets;

    public Tags(){
        this.tickets = new ArrayList<Ticket>();
    }

    public Tags(String name){
        this.name = name;
        this.tickets = new ArrayList<Ticket>();
    }

    public String nom(){
        return "le nom : " + this.name;
    }

    @Id
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="tags")
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


}
