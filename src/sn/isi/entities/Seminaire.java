package sn.isi.entities;

import java.util.Date;

public class Seminaire extends Inscription {

    private String module;

    public Seminaire() {
        super();
    }

    public Seminaire(int id, int annee, Date date, double montant, Etudiant etudiant, String module) {
        super(id, annee, date, montant, etudiant);
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
