package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.Identity;

public class CalendarID extends Identity {
    public CalendarID() {

    }

    private CalendarID(String id){
        super(id);
    }
    public static CalendarID of(String id){
        return new CalendarID(id);
    }
}
