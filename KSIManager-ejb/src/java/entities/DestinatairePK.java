/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hristi
 */
@Embeddable
public class DestinatairePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmessage")
    private int idmessage;

    public DestinatairePK() {
    }

    public DestinatairePK(int idutilisateur, int idmessage) {
        this.idutilisateur = idutilisateur;
        this.idmessage = idmessage;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idmessage;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinatairePK)) {
            return false;
        }
        DestinatairePK other = (DestinatairePK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idmessage != other.idmessage) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DestinatairePK[ idutilisateur=" + idutilisateur + ", idmessage=" + idmessage + " ]";
    }
    
}
