package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Address implements ValueObject<String> {
    private final String value;

    public Address(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("Address can't be empty"));
        }
        if(this.value.length()>50){
            throw new IllegalArgumentException(("Address can't be longer than 50 characters"));
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(value, address.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
