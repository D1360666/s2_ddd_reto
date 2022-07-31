package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateOfIssue implements ValueObject<String> {
    private final LocalDate date;
    private final String format;

    public DateOfIssue(int day, int month, int year){
        try{
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("Invalid date of Issue");
            }
        }catch(DateTimeException e){
            throw new IllegalArgumentException("Invalid date of Issue");
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
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DateOfIssue that = (DateOfIssue) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode(){
        return Objects.hash(format);
    }
}
