package co.com.sofka.domain.treasurydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.treasurydomain.entity.Treasurer;
import co.com.sofka.domain.treasurydomain.values.TreasuryID;

public class CreateTreasury extends Command {
    private final TreasuryID treasuryID;
    private final Treasurer treasurer;

    public CreateTreasury(TreasuryID treasuryID, Treasurer treasurer) {
        this.treasuryID = treasuryID;
        this.treasurer = treasurer;
    }

    public TreasuryID getTreasuryID() {
        return treasuryID;
    }

    public Treasurer getTreasurer() {
        return treasurer;
    }
}
