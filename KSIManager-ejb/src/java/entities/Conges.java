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
@Table(name = "conges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conges.findAll", query = "SELECT c FROM Conges c")
    , @NamedQuery(name = "Conges.findByIdconges", query = "SELECT c FROM Conges c WHERE c.idconges = :idconges")
    , @NamedQuery(name = "Conges.findByDatedebut", query = "SELECT c FROM Conges c WHERE c.datedebut = :datedebut")
    , @NamedQuery(name = "Conges.findByDatefin", query = "SELECT c FROM Conges c WHERE c.datefin = :datefin")
    , @NamedQuery(name = "Conges.findByTypeconge", query = "SELECT c FROM Conges c WHERE c.typeconge = :typeconge")
    , @NamedQuery(name = "Conges.findByMotif", query = "SELECT c FROM Conges c WHERE c.motif = :motif")
    , @NamedQuery(name = "Conges.findByNbreconge", query = "SELECT c FROM Conges c WHERE c.nbreconge = :nbreconge")
    , @NamedQuery(name = "Conges.findByStatut", query = "SELECT c FROM Conges c WHERE c.statut = :statut")})
public class Conges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconges")
    private Integer idconges;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Size(max = 30)
    @Column(name = "typeconge")
    private String typeconge;
    @Size(max = 254)
    @Column(name = "motif")
    private String motif;
    @Column(name = "nbreconge")
    private Integer nbreconge;
    @Size(max = 10)
    @Column(name = "statut")
    private String statut;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Conges() {
    }

    public Conges(Integer idconges) {
        this.idconges = idconges;
    }

    public Integer getIdconges() {
        return idconges;
    }

    public void setIdconges(Integer idconges) {
        this.idconges = idconges;
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

    public String getTypeconge() {
        return typeconge;
    }

    public void setTypeconge(String typeconge) {
        this.typeconge = typeconge;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getNbreconge() {
        return nbreconge;
    }

    public void setNbreconge(Integer nbreconge) {
        this.nbreconge = nbreconge;
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
        hash += (idconges != null ? idconges.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conges)) {
            return false;
        }
        Conges other = (Conges) object;
        if ((this.idconges == null && other.idconges != null) || (this.idconges != null && !this.idconges.equals(other.idconges))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Conges[ idconges=" + idconges + " ]";
    }
    
}
