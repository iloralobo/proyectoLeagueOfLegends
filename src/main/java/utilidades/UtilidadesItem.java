package utilidades;

import modelos.Item;
import modelos.Personaje;

import java.util.List;

public class UtilidadesItem {

    public static void equiparItem(Personaje personaje, Item item){

        personaje.getEquipamiento().add(item);

        personaje.setAtaque(personaje.getAtaque()+item.getAumentoDanyo());
        personaje.setDefensa(personaje.getDefensa()+item.getAumentoDefensa());
        personaje.setVida(personaje.getVida()+item.getAumentoSalud());
        personaje.setMana(personaje.getMana()+item.getAumentoMana());

    }
}
