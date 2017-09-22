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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.nextId", query = "SELECT MAX(u.idutilisateur) FROM Utilisateur u")
    ,@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByDatenaiss", query = "SELECT u FROM Utilisateur u WHERE u.datenaiss = :datenaiss")
    , @NamedQuery(name = "Utilisateur.findByLieunaiss", query = "SELECT u FROM Utilisateur u WHERE u.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Utilisateur.findByCni", query = "SELECT u FROM Utilisateur u WHERE u.cni = :cni")
    , @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe")
    , @NamedQuery(name = "Utilisateur.findByMatricule", query = "SELECT u FROM Utilisateur u WHERE u.matricule = :matricule")
    , @NamedQuery(name = "Utilisateur.findByPhoto", query = "SELECT u FROM Utilisateur u WHERE u.photo = :photo")
    , @NamedQuery(name = "Utilisateur.findByDateembauche", query = "SELECT u FROM Utilisateur u WHERE u.dateembauche = :dateembauche")
    , @NamedQuery(name = "Utilisateur.findByPays", query = "SELECT u FROM Utilisateur u WHERE u.pays = :pays")
    , @NamedQuery(name = "Utilisateur.findByRegion", query = "SELECT u FROM Utilisateur u WHERE u.region = :region")
    , @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville")
    , @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "Utilisateur.findByPoste", query = "SELECT u FROM Utilisateur u WHERE u.poste = :poste")
    , @NamedQuery(name = "Utilisateur.findByLoginMpd", query = "SELECT u FROM Utilisateur u WHERE u.login = :login AND u.mpd=:mpd")
    , @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login")
    , @NamedQuery(name = "Utilisateur.findByMpd", query = "SELECT u FROM Utilisateur u WHERE u.mpd = :mpd")
    , @NamedQuery(name = "Utilisateur.findByDerniereconnection", query = "SELECT u FROM Utilisateur u WHERE u.derniereconnection = :derniereconnection")
    , @NamedQuery(name = "Utilisateur.findByDernieredeconnection", query = "SELECT u FROM Utilisateur u WHERE u.dernieredeconnection = :dernieredeconnection")
    , @NamedQuery(name = "Utilisateur.findByNbreconnection", query = "SELECT u FROM Utilisateur u WHERE u.nbreconnection = :nbreconnection")
    , @NamedQuery(name = "Utilisateur.findByEtatconnection", query = "SELECT u FROM Utilisateur u WHERE u.etatconnection = :etatconnection")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;
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
    @Column(name = "poste")
    private String poste;
    @Size(max = 30)
    @Column(name = "login")
    private String login;
    @Size(max = 30)
    @Column(name = "mpd")
    private String mpd;
    @Column(name = "derniereconnection")
    @Temporal(TemporalType.TIMESTAMP)
    private Date derniereconnection;
    @Column(name = "dernieredeconnection")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dernieredeconnection;
    @Column(name = "nbreconnection")
    private Integer nbreconnection;
    @Column(name = "etatconnection")
    private Integer etatconnection;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Menu> menuCollection;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Missions> missionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Prestataire> prestataireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Journalisation> journalisationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Permissions> permissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Destinataire> destinataireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Conges> congesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idutilisateur")
    private Collection<Promotion> promotionCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMpd() {
        return mpd;
    }

    public void setMpd(String mpd) {
        this.mpd = mpd;
    }

    public Date getDerniereconnection() {
        return derniereconnection;
    }

    public void setDerniereconnection(Date derniereconnection) {
        this.derniereconnection = derniereconnection;
    }

    public Date getDernieredeconnection() {
        return dernieredeconnection;
    }

    public void setDernieredeconnection(Date dernieredeconnection) {
        this.dernieredeconnection = dernieredeconnection;
    }

    public Integer getNbreconnection() {
        return nbreconnection;
    }

    public void setNbreconnection(Integer nbreconnection) {
        this.nbreconnection = nbreconnection;
    }

    public Integer getEtatconnection() {
        return etatconnection;
    }

    public void setEtatconnection(Integer etatconnection) {
        this.etatconnection = etatconnection;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @XmlTransient
    public Collection<Missions> getMissionsCollection() {
        return missionsCollection;
    }

    public void setMissionsCollection(Collection<Missions> missionsCollection) {
        this.missionsCollection = missionsCollection;
    }

    @XmlTransient
    public Collection<Prestataire> getPrestataireCollection() {
        return prestataireCollection;
    }

    public void setPrestataireCollection(Collection<Prestataire> prestataireCollection) {
        this.prestataireCollection = prestataireCollection;
    }

    @XmlTransient
    public Collection<Journalisation> getJournalisationCollection() {
        return journalisationCollection;
    }

    public void setJournalisationCollection(Collection<Journalisation> journalisationCollection) {
        this.journalisationCollection = journalisationCollection;
    }

    @XmlTransient
    public Collection<Permissions> getPermissionsCollection() {
        return permissionsCollection;
    }

    public void setPermissionsCollection(Collection<Permissions> permissionsCollection) {
        this.permissionsCollection = permissionsCollection;
    }

    @XmlTransient
    public Collection<Destinataire> getDestinataireCollection() {
        return destinataireCollection;
    }

    public void setDestinataireCollection(Collection<Destinataire> destinataireCollection) {
        this.destinataireCollection = destinataireCollection;
    }

    @XmlTransient
    public Collection<Conges> getCongesCollection() {
        return congesCollection;
    }

    public void setCongesCollection(Collection<Conges> congesCollection) {
        this.congesCollection = congesCollection;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }


    
    
}
