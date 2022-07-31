package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateOfCommunication implements ValueObject<String> {
    private final LocalDate date;
    private final String format;

    public DateOfCommunication(int day, int month, int year){
        try{
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("No valid the date of birth");
            }
        }catch(DateTimeException e){
            throw new IllegalArgumentException("No valid the date of birth");
        }
        format = generateFormat();
    }

    private String generateFormat(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    @Override
    public String value(){
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateOfCommunication)) return false;
        DateOfCommunication that = (DateOfCommunication) o;
        return Objects.equals(date, that.date) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, format);
    }
}
