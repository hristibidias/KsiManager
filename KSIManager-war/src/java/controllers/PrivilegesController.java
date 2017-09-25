/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Menu;
import entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import sessions.MenuFacadeLocal;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Hristi
 */
public class PrivilegesController implements Serializable, Converter{

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    private List<Utilisateur> listUtilisateur = new ArrayList<>();
    private Utilisateur utilisateur = new Utilisateur();
    private Integer idUtilisateur;
    @EJB
    private MenuFacadeLocal menuFacade;
    private DualListModel<Menu> privileges = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
    private String msg;
	
    /**
     * Creates a new instance of PrivilegesController
     */
    public PrivilegesController() {
    }
    
    @PostConstruct
    public void init() {
        chargeListMenu();
        chargeListUtilisateur();
    }

    public void chargeListMenu() {
        privileges.getSource().clear();
        privileges.getSource().addAll(menuFacade.findAll());
    }

    public void chargeListUtilisateur() {
        listUtilisateur.clear();
        listUtilisateur.addAll(utilisateurFacade.findAll());
    }

    public void selectUtilisateur() {
        utilisateur = utilisateurFacade.find(idUtilisateur);
        chargeListMenu();
        privileges.getTarget().clear();
        privileges.getTarget().addAll(utilisateur.getMenuCollection());
        privileges.getSource().removeAll(privileges.getTarget());
    }

    public void savePrivileges() {
        try {
            utilisateur.setMenuCollection(privileges.getTarget());
            utilisateurFacade.edit(utilisateur);
            msg = "Opération effectuée avec succès!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return menuFacade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Menu) value).getIdmenu().toString();
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

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public MenuFacadeLocal getMenuFacade() {
        return menuFacade;
    }

    public void setMenuFacade(MenuFacadeLocal menuFacade) {
        this.menuFacade = menuFacade;
    }

    public DualListModel<Menu> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(DualListModel<Menu> privileges) {
        this.privileges = privileges;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
