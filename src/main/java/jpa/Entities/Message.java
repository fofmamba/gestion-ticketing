package jpa.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Message {

    private Long id;
    private User sender;
    private Ticket ticket;
    private String content;
    private String date;

    public static String getCurrentDate() {
        // Obtenir la date et l'heure actuelles
        Date date = new Date();

        // Formatter la date en utilisant SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Renvoyer la date formatée
        return dateFormat.format(date);
    }
    public Message(){
        this.date = getCurrentDate();
    }

    public Message(User sender, Ticket ticket, String content){
        this.sender = sender;
        this.ticket = ticket;
        this.content = content;
        this.date = getCurrentDate();
    }

    public String toString(){
        return "Message : [" + this.id + "] " + date + '\n' + this.sender + this.ticket + "Content : " + '\n' + this.content + '\n';
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }

    @ManyToOne
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
