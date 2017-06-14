package alcometer_server.statistics;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "volume")
    private int volume;
    
    @Column(name = "user_id")
    private String userID;
    
    @Column(name = "date")
    private Date date;

    public History(String type, int volume) {
        this.type = type;
        this.volume = volume;
    }

    public History() {
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public Date getDate() {
        return date;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.type);
        hash = 71 * hash + this.volume;
        hash = 71 * hash + Objects.hashCode(this.userID);
        hash = 71 * hash + Objects.hashCode(this.date);
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
        final History other = (History) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.volume != other.volume) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    
    
    
}
