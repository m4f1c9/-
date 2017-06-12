package alcometer_server.statistics;

import java.util.Objects;

public class Drink {

    private String type;

    private int volume;

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


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.type);
        hash = 23 * hash + this.volume;
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
        final Drink other = (Drink) obj;
        if (this.volume != other.volume) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

}
