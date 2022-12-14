package co.com.sofka.domain.treasurydomain.values;

import java.util.Objects;

public class Money {
    private final Double value;

    public Money (Double value){
        this.value = Objects.requireNonNull(value);

        if(this.value==0){
            throw new IllegalArgumentException("Error!,  Value can't be cero");
        }

    }

    public Double value(){
        return value;
    }
}
