package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPartida {

    private void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles){

        //Inicializa el mapa de elecciones de la partida, asignando a cada
        //jugador un personaje de entre los personajesDisponibles,
        //eligiendo preferentemente uno de entre sus favoritos y si no uno
        //aleatorio de los disponibles.

        Map<Jugador, Personaje> elecciones = new HashMap<>();
        List<Personaje> personajesRestantes = new ArrayList<>(personajesDisponibles);

        for (Jugador jugador : participantes){
            for (Personaje p : personajesDisponibles){
                if (jugador.getPersonajesFavoritos().contains(p)){
                    partida.getElecciones().put(jugador, p);
                    personajesDisponibles.remove(p);
                }else{
                    partida.getElecciones().put(jugador, personajesDisponibles.get(-1));
                    personajesDisponibles.remove(personajesDisponibles.get(-1));
                }
            }
        }
        //Inicializa el mapa de jugadoresPorEquipo, asignando
        //aleatoriamente cada jugador a uno de los equipos, sabiendo que el
        //número de jugadores siempre es par y que siempre hay dos
        //equipos.

        //Establece la fecha de inicio de partida indicando el momento
        //actual como el inicio de la partida.

        partida.setInicioPartida(LocalDateTime.now());

    }

    private void finalizarPartida(Partida partida, Integer equipoVencedor){

        //Establece la fecha fin de partida al momento actual .

        partida.getFinPartida().adjustInto(LocalDate.now());

        //Establece la duración de la partida a la diferencia en segundos
        //entre el inicio de partida y el fin de la misma.

        partida.getDuracionPartida(partida.getInicioPartida()-partida.getFinPartida());

        //Establece el equipo vencedor al que se pasa como parámetro.


        //Para cada jugador que participa en dicha partida y es del equipo
        //vencedor tiene que actualizarle el número de partidas ganadas en
        //su atributo partidas ganadas teniendo en cuenta con el personaje
        //con el que ha ganado la partida.


    }

}
