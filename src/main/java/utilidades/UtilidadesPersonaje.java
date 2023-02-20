package utilidades;

import modelos.Escalabilidad;
import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPersonaje {

    public Personaje levelUp(Personaje personaje){

        //Creamos el nuevo personaje
        Personaje personajeEvo = new Personaje();
        //Subimos su nivel
        personajeEvo.setNivel(personaje.getNivel()+1);
        //Actualizamos sus estadísticas siguiendo la fórmula "Estadística = EstadísticaBase + EcalabilidadEstadística *
        //nivel (Tras la subida)"
        personajeEvo.setAtaqueBase(personaje.getAtaqueBase()+personaje.getEscalabilidad().getIncrementoDanyoNivel()*personajeEvo.getNivel());
        personajeEvo.setDefensaBase(personaje.getDefensaBase()+personaje.getEscalabilidad().getIncrementoDefensaNivel()*personajeEvo.getNivel());
        personajeEvo.setManaBase(personaje.getManaBase()+personaje.getEscalabilidad().getIncrementoManaNivel()*personajeEvo.getNivel());
        personajeEvo.setVidaBase(personaje.getVidaBase()+personaje.getEscalabilidad().getIncrementoSaludNivel()*personajeEvo.getNivel());

        return personajeEvo;
        }

    public static void levelTo(Personaje personaje, Integer nivelDeseado){

        personaje.setNivel(nivelDeseado);
        personaje.setVida(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() *nivelDeseado);
        personaje.setMana(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * nivelDeseado);
        personaje.setDefensa(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * nivelDeseado);
        personaje.setAtaque(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDanyoNivel() * nivelDeseado);
    }

    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){
        Map<Region, List<Personaje>> personajesPorRegion = new HashMap<>();
        for (Personaje personaje : personajes){
            if (personajesPorRegion.containsKey(personaje.getRegion())){
                personajesPorRegion.get(personaje.getRegion()).add(personaje);
            }else {
                personajesPorRegion.put(personaje.getRegion(),List.of(personaje));
            }
        }
        return personajesPorRegion;
    }

    public Personaje getMasPoderoso(List<Personaje> personaje){
        //Creamos el nuevo personaje mmás poderoso
        Personaje masPoderoso = new Personaje();
        for (Personaje personaje1 : personaje) {

            Personaje personaj = new Personaje();
            Double sumaEstadisticas = 0.0;

            //Subimos su nivel
            personaj.setNivel(personaje1.getNivel() + 18);
            //Actualizamos sus estadísticas siguiendo la fórmula "Estadística = EstadísticaBase + EcalabilidadEstadística *
            //nivel (Tras la subida)"
            personaj.setAtaqueBase(personaje1.getAtaqueBase() + personaje1.getEscalabilidad().getIncrementoDanyoNivel() * personaj.getNivel());
            personaj.setDefensaBase(personaje1.getDefensaBase() + personaje1.getEscalabilidad().getIncrementoDefensaNivel() * personaj.getNivel());
            personaj.setManaBase(personaje1.getManaBase() + personaje1.getEscalabilidad().getIncrementoManaNivel() * personaj.getNivel());
            personaj.setVidaBase(personaje1.getVidaBase() + personaje1.getEscalabilidad().getIncrementoSaludNivel() * personaj.getNivel());

            sumaEstadisticas = personaj.getAtaqueBase() + personaj.getDefensaBase() + personaj.getVidaBase() + personaj.getManaBase();

            if (sumaEstadisticas> (masPoderoso.getAtaqueBase() + masPoderoso.getDefensaBase() + masPoderoso.getVidaBase() + masPoderoso.getManaBase())){
                masPoderoso = personaj;
            }
        }
        return masPoderoso;
    }

//    public Map<Region, List<Personaje>> getMasPoderosoPorRegion(List<Personaje> personajes){
//        Map<Region, List<Personaje>> masPoderosoPorRegion =new HashMap<>();
//
//    }
}

