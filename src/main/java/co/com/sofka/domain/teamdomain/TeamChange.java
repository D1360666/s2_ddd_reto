package co.com.sofka.domain.teamdomain;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.events.*;

import java.util.HashSet;

public class TeamChange extends EventChange {
    /***
     * Cpmstructor que carga todps ñps eventos al crear un nuevo Equipo
     * @param team
     */
    public TeamChange(Team team){
        apply((TeamCreated event)-> {
            team.name = event.getName();
        });

        /***
         * Eventos capturados generados en el Agregado Root
         */

    /*    apply((TrainerCreated event)->{
            Trainer trainer=new Trainer(event.getTrainerID(), event.getName(),event.getAddress(), event.getPhone(),event.getCi());
            team.addTrainer(trainer.identity(), trainer.name(), trainer.address(),trainer.phone(), trainer.ci());
        });

        apply((TrainerUpdated event)->{
            Trainer trainer=new Trainer(event.getTrainerID(), event.getName(),event.getAddress(), event.getPhone(),event.getCi());
            team.addTrainer(trainer.identity(), trainer.name(), trainer.address(),trainer.phone(), trainer.ci());
        });

        apply((PlayerCreated event)-> {
            Player player = new Player(event.getPlayerID(), event.getName(),event.getCi());
            team.createPlayer(player.identity(), player.name(), player.ci());
        });

        apply((PlayerUpdated event)-> {
            Player player = new Player(event.getPlayerID(), event.getName(),event.getCi());
            //team.addPlayer();
            team.updatedPlayer(player.identity(), player.name(), player.ci());
        });

        apply((PlayerRemoved event)->{

            team.playerList.removeIf(player -> player.identity().equals(event.getPlayerID()));
        });
*/

        apply((PlayerCreated event)->{
            Player.playerID = event.getPlayerID();
            Player.name = event.getName();
            Player.ci = event.getCi();
        });

        apply((TrainerCreated event) -> {
            Trainer.trainerID = event.getTrainerID();
            Trainer.name = event.getName();
            Trainer.address = event.getAddress();
            Trainer.phone = event.getPhone();
            Trainer.ci = event.getCi();
        });
    }
}
