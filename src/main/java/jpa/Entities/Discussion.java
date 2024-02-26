package jpa.Entities;
import jakarta.persistence.*;

import java.util.List;

@Entity @Table(

)
public class Discussion {
    private int iddiscussion;
    private String Libellediscussion;


    //constructeur sans parametre
    public Discussion(){ }

    //constructeur avec parametre
    public Discussion (String libelle){
        this.Libellediscussion=libelle;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return iddiscussion;
    }

    public String getName(){
        return Libellediscussion;
    }

    public void setName(String libelle){this.Libellediscussion=libelle;}

    public void setId(int id){this.iddiscussion=id;}
}
