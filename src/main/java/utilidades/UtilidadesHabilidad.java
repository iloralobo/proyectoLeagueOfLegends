package utilidades;

import modelos.Habilidad;
import modelos.Item;
import modelos.Personaje;

public class UtilidadesHabilidad {

    public void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor) {

        UtilidadesPersonaje.levelTo(emisor, 18);
        UtilidadesPersonaje.levelTo(receptor, 18);

        for (Item objeto : emisor.getEquipamiento()){
            UtilidadesItem.equiparItem(emisor, objeto);
        }
        for (Item objeto : receptor.getEquipamiento()){
            UtilidadesItem.equiparItem(receptor, objeto);
        }

        Double potenciaAtaque = habilidadEmisor.getDanyoBase() + (0.2 * emisor.getAtaque()) - (0.1 * receptor.getDefensa());

        emisor.setMana(emisor.getMana()-habilidadEmisor.getCosteMana());
        receptor.setVida(receptor.getVida()-potenciaAtaque);
    }
}
