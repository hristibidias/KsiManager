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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "prestataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestataire.findAll", query = "SELECT p FROM Prestataire p")
    , @NamedQuery(name = "Prestataire.findByIdprestataire", query = "SELECT p FROM Prestataire p WHERE p.idprestataire = :idprestataire")
    , @NamedQuery(name = "Prestataire.findByNom", query = "SELECT p FROM Prestataire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Prestataire.findByPrenom", query = "SELECT p FROM Prestataire p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Prestataire.findByDatenaiss", query = "SELECT p FROM Prestataire p WHERE p.datenaiss = :datenaiss")
    , @NamedQuery(name = "Prestataire.findByLieunaiss", query = "SELECT p FROM Prestataire p WHERE p.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Prestataire.findByCni", query = "SELECT p FROM Prestataire p WHERE p.cni = :cni")
    , @NamedQuery(name = "Prestataire.findBySexe", query = "SELECT p FROM Prestataire p WHERE p.sexe = :sexe")
    , @NamedQuery(name = "Prestataire.findByMatricule", query = "SELECT p FROM Prestataire p WHERE p.matricule = :matricule")
    , @NamedQuery(name = "Prestataire.findByPhoto", query = "SELECT p FROM Prestataire p WHERE p.photo = :photo")
    , @NamedQuery(name = "Prestataire.findByDateembauche", query = "SELECT p FROM Prestataire p WHERE p.dateembauche = :dateembauche")
    , @NamedQuery(name = "Prestataire.findByPays", query = "SELECT p FROM Prestataire p WHERE p.pays = :pays")
    , @NamedQuery(name = "Prestataire.findByRegion", query = "SELECT p FROM Prestataire p WHERE p.region = :region")
    , @NamedQuery(name = "Prestataire.findByVille", query = "SELECT p FROM Prestataire p WHERE p.ville = :ville")
    , @NamedQuery(name = "Prestataire.findByAdresse", query = "SELECT p FROM Prestataire p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Prestataire.findBySpecialite", query = "SELECT p FROM Prestataire p WHERE p.specialite = :specialite")})
public class Prestataire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprestataire")
    private Integer idprestataire;
    @Size(max = 35)
    @Column(name = "nom")
    private String nom;
    @Size(max = 35)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Size(max = 60)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Size(max = 15)
    @Column(name = "cni")
    private String cni;
    @Size(max = 10)
    @Column(name = "sexe")
    private String sexe;
    @Size(max = 12)
    @Column(name = "matricule")
    private String matricule;
    @Size(max = 254)
    @Column(name = "photo")
    private String photo;
    @Column(name = "dateembauche")
    @Temporal(TemporalType.DATE)
    private Date dateembauche;
    @Size(max = 60)
    @Column(name = "pays")
    private String pays;
    @Size(max = 60)
    @Column(name = "region")
    private String region;
    @Size(max = 60)
    @Column(name = "ville")
    private String ville;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 60)
    @Column(name = "specialite")
    private String specialite;
    @ManyToMany(mappedBy = "prestataireCollection")
    private Collection<Missions> missionsCollection;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Prestataire() {
    }

    public Prestataire(Integer idprestataire) {
        this.idprestataire = idprestataire;
    }

    public Integer getIdprestataire() {
        return idprestataire;
    }

    public void setIdprestataire(Integer idprestataire) {
        this.idprestataire = idprestataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateembauche() {
        return dateembauche;
    }

    public void setDateembauche(Date dateembauche) {
        this.dateembauche = dateembauche;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @XmlTransient
    public Collection<Missions> getMissionsCollection() {
        return missionsCollection;
    }

    public void setMissionsCollection(Collection<Missions> missionsCollection) {
        this.missionsCollection = missionsCollection;
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
        hash += (idprestataire != null ? idprestataire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestataire)) {
            return false;
        }
        Prestataire other = (Prestataire) object;
        if ((this.idprestataire == null && other.idprestataire != null) || (this.idprestataire != null && !this.idprestataire.equals(other.idprestataire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Prestataire[ idprestataire=" + idprestataire + " ]";
    }
    
}
