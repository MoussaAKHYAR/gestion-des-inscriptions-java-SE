package sn.isi.controller;

import sn.isi.entities.Inscription;

import java.util.List;

public interface IInscription {
    public Inscription saisie();
    public List<Inscription> liste();
    public void fichier(List<Inscription> inscriptions);
    public void dbjdbc(List<Inscription> inscriptions);
    public List<Inscription> inscriptionJanvier2019(List<Inscription> inscriptions);
}
