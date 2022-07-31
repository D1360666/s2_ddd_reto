package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TypeOfMovement implements ValueObject <String>{
    private final String value;

    public TypeOfMovement(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("Type of Movement can't be empty"));
        }
        if(this.value.length()>100){
            throw new IllegalArgumentException(("Type of Movement can't be longer than 50 characters"));
        }
        if(!this.value.equals("Input") || !this.value.equals("Output")){
            throw new IllegalArgumentException(("Error!, you must enter 'Input' or 'Output'"));
        }
    }

    public String value(){
        return value;
    }
}
