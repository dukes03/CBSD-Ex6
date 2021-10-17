

package studentjpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ID;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "student.findAll", query = "SELECT e FROM student e"),
    @NamedQuery(name = "student.findByID", query = "SELECT e FROM student e WHERE e.ID = :ID"),
    @NamedQuery(name = "student.findByName", query = "SELECT e FROM student e WHERE e.name = :name"),
    @NamedQuery(name = "student.findByGPA", query = "SELECT e FROM student e WHERE e.GPA = :GPA")})
public class student implements Serializable {
    private static final long serialVersionUID = 1L;
    @ID
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consIDer using these annotations to enforce field valIDation
    @Column(name = "GPA")
    private Double GPA;

    public student() {
    }

    public student(Integer ID) {
        this.ID = ID;
    }

    public student(Integer ID, String name, Double GPA) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

    public Integer getID() {
        return ID;
    }

    public voID setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public voID setName(String name) {
        this.name = name;
    }

    public Double getGPA() {
        return GPA;
    }

    public voID setGPA(Double GPA) {
        this.GPA = GPA;
    }

    @OverrIDe
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @OverrIDe
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ID fields are not set
        if (!(object instanceof student)) {
            return false;
        }
        student other = (student) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @OverrIDe
    public String toString() {
        return "studentdatabasejpa.student[ ID=" + ID + " ]";
    }
    
}