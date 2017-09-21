/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hristi
 */
@Entity
@Table(name = "destinataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinataire.findAll", query = "SELECT d FROM Destinataire d")
    , @NamedQuery(name = "Destinataire.findByIdutilisateur", query = "SELECT d FROM Destinataire d WHERE d.destinatairePK.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Destinataire.findByIdmessage", query = "SELECT d FROM Destinataire d WHERE d.destinatairePK.idmessage = :idmessage")
    , @NamedQuery(name = "Destinataire.findByHeureenvoi", query = "SELECT d FROM Destinataire d WHERE d.heureenvoi = :heureenvoi")})
public class Destinataire implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DestinatairePK destinatairePK;
    @Column(name = "heureenvoi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureenvoi;
    @JoinColumn(name = "idmessage", referencedColumnName = "idmessage", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Messagerie messagerie;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Destinataire() {
    }

    public Destinataire(DestinatairePK destinatairePK) {
        this.destinatairePK = destinatairePK;
    }

    public Destinataire(int idutilisateur, int idmessage) {
        this.destinatairePK = new DestinatairePK(idutilisateur, idmessage);
    }

    public DestinatairePK getDestinatairePK() {
        return destinatairePK;
    }

    public void setDestinatairePK(DestinatairePK destinatairePK) {
        this.destinatairePK = destinatairePK;
    }

    public Date getHeureenvoi() {
        return heureenvoi;
    }

    public void setHeureenvoi(Date heureenvoi) {
        this.heureenvoi = heureenvoi;
    }

    public Messagerie getMessagerie() {
        return messagerie;
    }

    public void setMessagerie(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (destinatairePK != null ? destinatairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinataire)) {
            return false;
        }
        Destinataire other = (Destinataire) object;
        if ((this.destinatairePK == null && other.destinatairePK != null) || (this.destinatairePK != null && !this.destinatairePK.equals(other.destinatairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Destinataire[ destinatairePK=" + destinatairePK + " ]";
    }
    
}
