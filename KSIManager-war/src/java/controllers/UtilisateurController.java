/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Hristi
 */
public class UtilisateurController {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    private List<Utilisateur> listUtilisateur = new ArrayList<>();
    private Utilisateur utilisateur = new Utilisateur();
    /**
     * Creates a new instance of UtilisateurController
     */
    public UtilisateurController() {
    }
    
    @PostConstruct
    public void init()
    {
        listUtilisateur.clear();
        listUtilisateur.addAll(utilisateurFacade.findAll());
    }

    public UtilisateurFacadeLocal getUtilisateurFacade() {
        return utilisateurFacade;
    }

    public void setUtilisateurFacade(UtilisateurFacadeLocal utilisateurFacade) {
        this.utilisateurFacade = utilisateurFacade;
    }

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
}
