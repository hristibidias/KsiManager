/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hristi
 */
@Entity
@Table(name = "missions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Missions.findAll", query = "SELECT m FROM Missions m")
    , @NamedQuery(name = "Missions.findByIdmissions", query = "SELECT m FROM Missions m WHERE m.idmissions = :idmissions")
    , @NamedQuery(name = "Missions.findByDatedebut", query = "SELECT m FROM Missions m WHERE m.datedebut = :datedebut")
    , @NamedQuery(name = "Missions.findByDatefin", query = "SELECT m FROM Missions m WHERE m.datefin = :datefin")
    , @NamedQuery(name = "Missions.findByDatefineffec", query = "SELECT m FROM Missions m WHERE m.datefineffec = :datefineffec")
    , @NamedQuery(name = "Missions.findByPays", query = "SELECT m FROM Missions m WHERE m.pays = :pays")
    , @NamedQuery(name = "Missions.findByVille", query = "SELECT m FROM Missions m WHERE m.ville = :ville")
    , @NamedQuery(name = "Missions.findByLieu", query = "SELECT m FROM Missions m WHERE m.lieu = :lieu")
    , @NamedQuery(name = "Missions.findByMotif", query = "SELECT m FROM Missions m WHERE m.motif = :motif")
    , @NamedQuery(name = "Missions.findByStatut", query = "SELECT m FROM Missions m WHERE m.statut = :statut")})
public class Missions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmissions")
    private Integer idmissions;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Column(name = "datefineffec")
    @Temporal(TemporalType.DATE)
    private Date datefineffec;
    @Size(max = 60)
    @Column(name = "pays")
    private String pays;
    @Size(max = 60)
    @Column(name = "ville")
    private String ville;
    @Size(max = 254)
    @Column(name = "lieu")
    private String lieu;
    @Size(max = 254)
    @Column(name = "motif")
    private String motif;
    @Size(max = 15)
    @Column(name = "statut")
    private String statut;
    @JoinTable(name = "participantprestataire", joinColumns = {
        @JoinColumn(name = "idmissions", referencedColumnName = "idmissions")}, inverseJoinColumns = {
        @JoinColumn(name = "idprestataire", referencedColumnName = "idprestataire")})
    @ManyToMany
    private Collection<Prestataire> prestataireCollection;
    @JoinTable(name = "participantpersonnel", joinColumns = {
        @JoinColumn(name = "idmissions", referencedColumnName = "idmissions")}, inverseJoinColumns = {
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;

    public Missions() {
    }

    public Missions(Integer idmissions) {
        this.idmissions = idmissions;
    }

    public Integer getIdmissions() {
        return idmissions;
    }

    public void setIdmissions(Integer idmissions) {
        this.idmissions = idmissions;
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

    public Date getDatefineffec() {
        return datefineffec;
    }

    public void setDatefineffec(Date datefineffec) {
        this.datefineffec = datefineffec;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public Collection<Prestataire> getPrestataireCollection() {
        return prestataireCollection;
    }

    public void setPrestataireCollection(Collection<Prestataire> prestataireCollection) {
        this.prestataireCollection = prestataireCollection;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmissions != null ? idmissions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Missions)) {
            return false;
        }
        Missions other = (Missions) object;
        if ((this.idmissions == null && other.idmissions != null) || (this.idmissions != null && !this.idmissions.equals(other.idmissions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Missions[ idmissions=" + idmissions + " ]";
    }
    
}
