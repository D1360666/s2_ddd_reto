package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.TutorID;

import java.util.Objects;

public class Tutor extends Entity<TutorID> {
    private TutorID tutorID;
    private Name name;
    private Ci ci;

    public Tutor(TutorID tutorID, Name name, Ci ci){
        super(tutorID);
        this.name=name;
        this.ci=ci;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }

    public Name name(){
        return name;
    }

    public Ci ci(){
        return ci;
    }
}
