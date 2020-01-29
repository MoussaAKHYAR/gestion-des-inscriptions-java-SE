package sn.isi.controller;

import sn.isi.entities.*;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscriptionImpl implements IInscription {
    private DB db = new DB();
    private ResultSet rs;
    private Object Academique;

    @Override
    public Inscription saisie() {
        Scanner scanner = new Scanner(System.in);
        Etudiant etudiant = new Etudiant();
        Inscription inscription = null;

        System.out.println("-------------Menu---------------");
        System.out.println("1.Incription Academique");
        System.out.println("2.Inscription Seminaire");
        System.out.println("faites votre choix");

        int choix =Integer.parseInt(scanner.nextLine());

        switch (choix){
            case 1 :
                inscription = new Academique();

                getInscription(scanner, etudiant, inscription);

                System.out.println("Saisir l'année academique");
                ((Academique) inscription).setAnneEtude(scanner.nextLine());

                         break;
            case 2 :
                inscription = new Seminaire();

                getInscription(scanner, etudiant, inscription);

                System.out.println("Saisir la Module");
                ((Seminaire) inscription).setModule(scanner.nextLine());

                break;

            default:
                break;
        }

                 return inscription;
    }

    private void getInscription(Scanner scanner, Etudiant etudiant, Inscription inscription) {
        System.out.println("Saisir l'id ");
        inscription.setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Saisir l'année ");
        inscription.setAnnee(Integer.parseInt(scanner.nextLine()));

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println("Saisir la date : ");
            inscription.setDate(sdf.parse(scanner.nextLine()));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Saisir le montant ");
        inscription.setMontant(Integer.parseInt(scanner.nextLine()));

        //Information Etudiant
        System.out.println("Saisir les informations de l'etudiant ");

        System.out.println("Saisir le matricule de l'etudiant ");
        etudiant.setMat(scanner.nextLine());

        System.out.println("Saisir le nom de l'etudiant ");
        etudiant.setNom(scanner.nextLine());

        System.out.println("Saisir le prenom de l'etudiant ");
        etudiant.setPrenom(scanner.nextLine());

        inscription.setEtudiant(etudiant);
    }

    @Override
    public List<Inscription> liste() {
        Scanner scanner = new Scanner(System.in);
        List<Inscription> list = new ArrayList<Inscription>();
        boolean rep = true ;
        do {
            list.add(saisie());

            System.out.println("Voulez vous saisir une autre inscription");
            if (scanner.nextLine().equalsIgnoreCase("non")){
                rep = false;
            }
        }while (rep == true);

            return list;
    }

    @Override
    public void fichier(List<Inscription> inscriptions) {
        try {
            FileOutputStream fos = new FileOutputStream("fichier.csv");
            DataOutputStream dos = new DataOutputStream(fos);
            String menu ="ID ; Annee ; date ; montant ; MatEtudiant ; AN ; Module \n ";

            for (Inscription inscription : inscriptions){

                menu = menu + inscription.getId()+ ";" + inscription.getAnnee()+ ";"
                        + inscription.getDate()+ ";" + inscription.getMontant()+";" + inscription.getEtudiant().getMat();
                if (inscription instanceof Academique){
                    menu = menu + ";"+((Academique) inscription).getAnneEtude()+";"+"  " +"\n";
                }else
                    menu = menu + ";"+" "+";"+((Seminaire) inscription).getModule()+"\n";

                dos.writeUTF(menu);
            }
                dos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dbjdbc(List<Inscription> inscriptions) {

        String sql = "INSERT into inscription VALUES (NULL,?,?,?,?,?,?)";

        for (Inscription inscription : inscriptions){

            try {
                db.initPrepar(sql);
                db.getPstm().setInt(1,inscription.getAnnee());
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
                db.getPstm().setString(2,sdf.format(inscription.getDate()));
                db.getPstm().setDouble(3,inscription.getMontant());
                db.getPstm().setString(4,inscription.getEtudiant().getMat());
                if (inscription instanceof Academique) {
                    db.getPstm().setString(5, ((Academique) inscription).getAnneEtude());
                    db.getPstm().setString(6,"null");
                }
                else {
                    db.getPstm().setString(5, "null");
                    db.getPstm().setString(6, ((Seminaire) inscription).getModule());
                }
                db.executeMaj();

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

    }

    @Override
    public List<Inscription> inscriptionJanvier2019(List<Inscription> inscriptions) {
        List<Inscription> list = new ArrayList<Inscription>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        for (Inscription inscription : inscriptions){
            String str = sdf.format(inscription.getDate());
            String str1 ;
            str1 = str.substring(0,7);
            if(str1.equalsIgnoreCase("2019/01")){
                list.add(inscription);
            }
        }
        return list;
    }

}
