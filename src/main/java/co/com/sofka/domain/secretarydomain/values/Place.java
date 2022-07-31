package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Place implements ValueObject<String> {
    private final String value;

    public Place(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("Place can't be empty"));
        }
        if(this.value.length()>30){
            throw new IllegalArgumentException(("Place can't be longer than 30 characters"));
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return Objects.equals(value, place.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
