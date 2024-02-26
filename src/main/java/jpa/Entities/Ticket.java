package jpa.Entities;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jpa.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private Long id;
    private String status;
    private String title;
    private String description;
    private String creationDate;
    private String closingDate;
    private User creator;
    private String date;
    private List<User> affectUser;
    private List<Message> conversation;
    private List<Tags> tags;

    public static String getCurrentDate() {
        // Obtenir la date et l'heure actuelles
        Date date = new Date();

        // Formatter la date en utilisant SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Renvoyer la date formatée
        return dateFormat.format(date);
    }
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }

    @ManyToMany
    public List<User> getAffectedSupportMembers() {
        return affectUser;
    }
    public void setAffectedSupportMembers(List<User> affectedSupportMembers) { this.affectUser = affectedSupportMembers; }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getClosingDate() {
        return closingDate;
    }
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    @OneToMany
    public List<Message> getConversation() {
        return conversation;
    }
    public void setConversation(List<Message> conversation) {
        this.conversation = conversation;
    }

    @ManyToMany
    @JoinTable(name="Tickets_Tags")
    public List<Tags> getTags() {
        return tags;
    }
    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void addTag(Tags tag){
        this.tags.add(tag);
        tag.getTickets().add(this);
    }

    public void removeTag(Tags tag){
        this.tags.remove(tag);
        tag.getTickets().remove(this);
    }


}
