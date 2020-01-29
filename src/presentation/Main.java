package presentation;

import sn.isi.controller.IInscription;
import sn.isi.controller.InscriptionImpl;
import sn.isi.entities.Inscription;

public class Main {
    public static void main(String[]args){
        IInscription i = new InscriptionImpl();
        IInscription inscription = new InscriptionImpl();

        i.fichier(inscription.liste());
       // i.dbjdbc(inscription.liste());

    }
}
