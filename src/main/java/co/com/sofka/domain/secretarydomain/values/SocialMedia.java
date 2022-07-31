package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SocialMedia implements ValueObject<String> {
    private final String value;

    public SocialMedia(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException(("SocialMedia can't be empty"));
        }
        if(this.value.length()>100){
            throw new IllegalArgumentException(("SocialMedia can't be longer than 30 characters"));
        }
    }

    public String value(){
        return value;
    }


}
