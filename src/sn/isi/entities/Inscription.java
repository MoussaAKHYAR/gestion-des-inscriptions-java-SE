package sn.isi.entities;

import java.util.Date;

public class Inscription {

    protected int id;
    protected int annee;
    protected Date date;
    protected double montant;
    protected Etudiant etudiant = new Etudiant();

    public Inscription() {
    }

    public Inscription(int id, int annee, Date date, double montant, Etudiant etudiant) {
        this.id = id;
        this.annee = annee;
        this.date = date;
        this.montant = montant;
        this.etudiant = etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
