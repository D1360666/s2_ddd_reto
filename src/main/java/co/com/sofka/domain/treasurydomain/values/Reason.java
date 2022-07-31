package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Reason implements ValueObject<String> {
    private final String value;

    public Reason(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("Reason can't be empty"));
        }
        if(this.value.length()>100){
            throw new IllegalArgumentException(("Reason can't be longer than 50 characters"));
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reason)) return false;
        Reason reason = (Reason) o;
        return Objects.equals(value, reason.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
