/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hristi
 */
@Entity
@Table(name = "journalisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Journalisation.findAll", query = "SELECT j FROM Journalisation j")
    , @NamedQuery(name = "Journalisation.findByIdjournalisations", query = "SELECT j FROM Journalisation j WHERE j.idjournalisations = :idjournalisations")
    , @NamedQuery(name = "Journalisation.findByNom", query = "SELECT j FROM Journalisation j WHERE j.nom = :nom")
    , @NamedQuery(name = "Journalisation.findByCible", query = "SELECT j FROM Journalisation j WHERE j.cible = :cible")
    , @NamedQuery(name = "Journalisation.findByDate", query = "SELECT j FROM Journalisation j WHERE j.date = :date")
    , @NamedQuery(name = "Journalisation.findByHeure", query = "SELECT j FROM Journalisation j WHERE j.heure = :heure")
    , @NamedQuery(name = "Journalisation.findByAdresseip", query = "SELECT j FROM Journalisation j WHERE j.adresseip = :adresseip")})
public class Journalisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjournalisations")
    private Integer idjournalisations;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "cible")
    private String cible;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "heure")
    @Temporal(TemporalType.TIME)
    private Date heure;
    @Size(max = 254)
    @Column(name = "adresseip")
    private String adresseip;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Journalisation() {
    }

    public Journalisation(Integer idjournalisations) {
        this.idjournalisations = idjournalisations;
    }

    public Integer getIdjournalisations() {
        return idjournalisations;
    }

    public void setIdjournalisations(Integer idjournalisations) {
        this.idjournalisations = idjournalisations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getAdresseip() {
        return adresseip;
    }

    public void setAdresseip(String adresseip) {
        this.adresseip = adresseip;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjournalisations != null ? idjournalisations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journalisation)) {
            return false;
        }
        Journalisation other = (Journalisation) object;
        if ((this.idjournalisations == null && other.idjournalisations != null) || (this.idjournalisations != null && !this.idjournalisations.equals(other.idjournalisations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Journalisation[ idjournalisations=" + idjournalisations + " ]";
    }
    
}
