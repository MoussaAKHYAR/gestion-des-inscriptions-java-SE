package sn.isi.entities;

import java.util.Date;

public class Academique extends Inscription {

    private String anneEtude;

    public Academique() {
        super();
    }

    public Academique(int id, int annee, Date date, double montant, Etudiant etudiant, String anneEtude) {
        super(id, annee, date, montant, etudiant);
        this.anneEtude = anneEtude;
    }

    public String getAnneEtude() {
        return anneEtude;
    }

    public void setAnneEtude(String anneEtude) {
        this.anneEtude = anneEtude;
    }
}
