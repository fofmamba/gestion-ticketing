package jpa.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;

    @OneToMany()
    private List<Ticket> ticketsCrees;

    //un ticket est attribuer par un ou un plusieurs utilisateur
    @ManyToMany()
    private List<Ticket> ticketsAttribues;

    //un ticket est fermé par un et un seul utilisateur
    @OneToMany()
    private List<Ticket> ticketsFermes;

}
