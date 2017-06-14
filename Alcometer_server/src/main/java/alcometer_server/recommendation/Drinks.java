package alcometer_server.recommendation;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drinks")
public class Drinks implements Serializable {

    @Id
    @Column(name = "drinks_id")
    @JSONField(serialize = false)
    private String ID;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.ID);
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drinks other = (Drinks) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

}
