package co.com.sofka.domain.teamdomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Phone implements ValueObject<String> {
    private final String value;

    public Phone(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("The phone can't be empty"));
        }
        if(this.value.length()>20){
            throw new IllegalArgumentException(("The phone can't be longer than 20 characters"));
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(value, phone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
