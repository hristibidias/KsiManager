/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import static net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfStream;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.component.commandbutton.CommandButton;  
import org.primefaces.context.RequestContext;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Hristi
 */
public class UtilisateurController implements Serializable{

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    private List<Utilisateur> listUtilisateur = new ArrayList<>();
    private Utilisateur utilisateur = new Utilisateur();
    private String operation;
    private String msg;

    /**
     * Creates a new instance of UtilisateurController
     */
    public UtilisateurController() {
    }

    @PostConstruct
    public void init() {
        listUtilisateur.clear();
        listUtilisateur.addAll(utilisateurFacade.findAll());
    }

    public void action(ActionEvent e) {
        CommandButton btn = (CommandButton) e.getSource();
        System.out.println("Ok : " + utilisateur.getNom());
        operation = btn.getWidgetVar();
        msg = "";
    }

    public void prepareCreate(ActionEvent e) {
        utilisateur = new Utilisateur();
        msg = "";
        System.out.println("Ok1");
        action(e);
    }

    public void saveAccount() {
        try {
                utilisateur.setIdutilisateur(utilisateurFacade.nextId()); 
                utilisateurFacade.create(utilisateur);
                msg = "Opération effectuée avec succès!";
                RequestContext.getCurrentInstance().execute("PF('wv_utilisateur').hide()"); 
        } catch (Exception e) {
            e.printStackTrace();
            RequestContext.getCurrentInstance().execute("PF('wv_utilisateur').hide()");
            msg = "Echec de l'opération!";
        } finally {
            init();
        }
    }

    public void savePersonnel() {
        try {
            if (utilisateurFacade.findByLogin(utilisateur.getLogin()).isEmpty()) {
                utilisateur.setIdutilisateur(utilisateurFacade.nextId());
                utilisateurFacade.create(utilisateur);
                msg = "Opération effectuée avec succès!";
                RequestContext.getCurrentInstance().execute("PF('wv_utilisateur').hide()");
            } else {
                msg = "Ce login est déjà utilisé!";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            init();
        }
    }

    public void modifyAccount() {
        try {
            if (utilisateurFacade.findByLogin(utilisateur.getLogin()).isEmpty()) {
                utilisateur.setMpd(((Integer) utilisateur.getMpd().hashCode()).toString());
                utilisateurFacade.edit(utilisateur);
                msg = "Opération effectuée avec succès!";
                RequestContext.getCurrentInstance().execute("PF('wv_utilisateur').hide()");
            } else {
                msg = "Ce login est déjà utilisé!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            init();
        }
    }

    public void deleteAccount() {
        try {
            utilisateurFacade.remove(utilisateur);
            msg = "Opération effectuée avec succès!!";
            RequestContext.getCurrentInstance().execute("PF('wv_utilisateur').hide()");
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            init();
        }
    }

    public void persist() {
        switch (operation) {
            case "add":
                saveAccount();
                break;
            case "modify":
                modifyAccount();
                break;
            case "modifyPersonnel":
                modifyAccount();
                break;
            case "delete":
                deleteAccount();
                break;
            case "savePersonnel":
                savePersonnel();
                break;
        }
    }
 
    public String imprimer() {
        try {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listUtilisateur);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/etats/listUtilisateur.jasper");
            Map parameters = new HashMap();
            //parameters.put("USER", connectedUser);
            parameters.put("REPORT_LOCALE", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            JasperPrint jasperPrint = fillReport(reportPath, parameters, beanCollectionDataSource);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=listUtilisateur.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
            //----------------------------------------------
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
