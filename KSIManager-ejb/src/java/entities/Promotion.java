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
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findByIdpromotion", query = "SELECT p FROM Promotion p WHERE p.idpromotion = :idpromotion")
    , @NamedQuery(name = "Promotion.findByMatriculepers", query = "SELECT p FROM Promotion p WHERE p.matriculepers = :matriculepers")
    , @NamedQuery(name = "Promotion.findByNompers", query = "SELECT p FROM Promotion p WHERE p.nompers = :nompers")
    , @NamedQuery(name = "Promotion.findByPrenompers", query = "SELECT p FROM Promotion p WHERE p.prenompers = :prenompers")
    , @NamedQuery(name = "Promotion.findByDateprom", query = "SELECT p FROM Promotion p WHERE p.dateprom = :dateprom")
    , @NamedQuery(name = "Promotion.findByAncienposte", query = "SELECT p FROM Promotion p WHERE p.ancienposte = :ancienposte")
    , @NamedQuery(name = "Promotion.findByNouveauposte", query = "SELECT p FROM Promotion p WHERE p.nouveauposte = :nouveauposte")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromotion")
    private Integer idpromotion;
    @Size(max = 254)
    @Column(name = "matriculepers")
    private String matriculepers;
    @Size(max = 254)
    @Column(name = "nompers")
    private String nompers;
    @Size(max = 254)
    @Column(name = "prenompers")
    private String prenompers;
    @Column(name = "dateprom")
    @Temporal(TemporalType.DATE)
    private Date dateprom;
    @Size(max = 254)
    @Column(name = "ancienposte")
    private String ancienposte;
    @Size(max = 254)
    @Column(name = "nouveauposte")
    private String nouveauposte;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Promotion() {
    }

    public Promotion(Integer idpromotion) {
        this.idpromotion = idpromotion;
    }

    public Integer getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(Integer idpromotion) {
        this.idpromotion = idpromotion;
    }

    public String getMatriculepers() {
        return matriculepers;
    }

    public void setMatriculepers(String matriculepers) {
        this.matriculepers = matriculepers;
    }

    public String getNompers() {
        return nompers;
    }

    public void setNompers(String nompers) {
        this.nompers = nompers;
    }

    public String getPrenompers() {
        return prenompers;
    }

    public void setPrenompers(String prenompers) {
        this.prenompers = prenompers;
    }

    public Date getDateprom() {
        return dateprom;
    }

    public void setDateprom(Date dateprom) {
        this.dateprom = dateprom;
    }

    public String getAncienposte() {
        return ancienposte;
    }

    public void setAncienposte(String ancienposte) {
        this.ancienposte = ancienposte;
    }

    public String getNouveauposte() {
        return nouveauposte;
    }

    public void setNouveauposte(String nouveauposte) {
        this.nouveauposte = nouveauposte;
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
        hash += (idpromotion != null ? idpromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idpromotion == null && other.idpromotion != null) || (this.idpromotion != null && !this.idpromotion.equals(other.idpromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promotion[ idpromotion=" + idpromotion + " ]";
    }
    
}
