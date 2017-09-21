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
@Table(name = "permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p")
    , @NamedQuery(name = "Permissions.findByIdpermissions", query = "SELECT p FROM Permissions p WHERE p.idpermissions = :idpermissions")
    , @NamedQuery(name = "Permissions.findByDatedebut", query = "SELECT p FROM Permissions p WHERE p.datedebut = :datedebut")
    , @NamedQuery(name = "Permissions.findByDatefin", query = "SELECT p FROM Permissions p WHERE p.datefin = :datefin")
    , @NamedQuery(name = "Permissions.findByMotif", query = "SELECT p FROM Permissions p WHERE p.motif = :motif")
    , @NamedQuery(name = "Permissions.findByNbrepermission", query = "SELECT p FROM Permissions p WHERE p.nbrepermission = :nbrepermission")
    , @NamedQuery(name = "Permissions.findByStatut", query = "SELECT p FROM Permissions p WHERE p.statut = :statut")})
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermissions")
    private Integer idpermissions;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Size(max = 254)
    @Column(name = "motif")
    private String motif;
    @Column(name = "nbrepermission")
    private Integer nbrepermission;
    @Size(max = 10)
    @Column(name = "statut")
    private String statut;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Permissions() {
    }

    public Permissions(Integer idpermissions) {
        this.idpermissions = idpermissions;
    }

    public Integer getIdpermissions() {
        return idpermissions;
    }

    public void setIdpermissions(Integer idpermissions) {
        this.idpermissions = idpermissions;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getNbrepermission() {
        return nbrepermission;
    }

    public void setNbrepermission(Integer nbrepermission) {
        this.nbrepermission = nbrepermission;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
        hash += (idpermissions != null ? idpermissions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissions)) {
            return false;
        }
        Permissions other = (Permissions) object;
        if ((this.idpermissions == null && other.idpermissions != null) || (this.idpermissions != null && !this.idpermissions.equals(other.idpermissions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Permissions[ idpermissions=" + idpermissions + " ]";
    }
    
}
