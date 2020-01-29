package sn.isi.entities;

public class Etudiant {

    public String mat;
    public String nom;
    public String prenom;

    public Etudiant() {
    }

    public Etudiant(String mat, String nom, String prenom) {
        this.mat = mat;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
