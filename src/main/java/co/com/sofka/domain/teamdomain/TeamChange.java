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
            team.playerList= new HashSet<>();
            team.tutorList=new HashSet<>();
            team.trainer=event.getTrainer();

        });

        /***
         * Eventos capturados generados en el Agregado Root
         */

        apply((TrainerAdded event)->{
            Trainer trainer=new Trainer(event.getTrainerID(), event.getName(),event.getAddress(), event.getPhone(),event.getCi());
            team.addTrainer(trainer.identity(), trainer.name(), trainer.address(),trainer.phone(), trainer.ci());
        });

        apply((TrainerUpdated event)->{
            Trainer trainer=new Trainer(event.getTrainerID(), event.getName(),event.getAddress(), event.getPhone(),event.getCi());
            team.addTrainer(trainer.identity(), trainer.name(), trainer.address(),trainer.phone(), trainer.ci());
        });

        apply((PlayerAdded event)-> {
            Player player = new Player(event.getPlayerID(), event.getName(),event.getCi(), event.getTutor());
            team.addPlayer(player.identity(), player.name(), player.ci(), player.tutor());
        });

        apply((PlayerUpdated event)-> {
            Player player = new Player(event.getPlayerID(), event.getName(),event.getCi(), event.getTutor());
            team.addPlayer(player.identity(), player.name(), player.ci(), player.tutor());
        });

        apply((PlayerRemoved event)->{

            team.playerList.removeIf(player -> player.identity().equals(event.getPlayerID()));
        });

    }
}
