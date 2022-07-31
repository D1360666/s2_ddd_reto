package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ci implements ValueObject<Long> {
    private final Long value;

    public Ci(Long value){
        this.value = Objects.requireNonNull(value);
        String valueAux = value.toString();
        if(this.value==0){
            throw new IllegalArgumentException("Incorrect ID");
        }
        if(valueAux.length()>8){
            throw new IllegalArgumentException("Long value must be 8 digits");
        }
        if(valueAux.length()<8){
            throw new IllegalArgumentException("Long value must be 8 digits");
        }
    }

    public Long value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ci)) return false;
        Ci ci = (Ci) o;
        return Objects.equals(value, ci.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
