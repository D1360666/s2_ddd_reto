package co.com.sofka.domain.treasurydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.treasurydomain.values.*;

public class AddTreasurer extends Command {
    private final TreasurerID treasurerID;
    private final Name name;
    private final Address address;
    private final Phone phone;
    private final Ci ci;

    public AddTreasurer(TreasurerID treasurerID, Name name, Address address, Phone phone, Ci ci) {
        this.treasurerID = treasurerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ci = ci;
    }

    public TreasurerID getTreasurerID() {
        return treasurerID;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    public Ci getCi() {
        return ci;
    }
}
