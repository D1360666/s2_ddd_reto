package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {
    private final String value;

    public Description(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("The Name can't be empty"));
        }
        if(this.value.length()>100){
            throw new IllegalArgumentException(("The Name can't be longer than 50 characters"));
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
