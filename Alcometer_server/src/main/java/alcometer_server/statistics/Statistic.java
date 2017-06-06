package alcometer_server.statistics;

import java.util.Objects;
import java.util.Set;

public class Statistic {

    private Set<Drink> Drinks;

    public Statistic() {
    }

    public Statistic(Set<Drink> Drinks) {
        this.Drinks = Drinks;
    }

    public Set<Drink> getDrinks() {
        return Drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.Drinks = drinks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Drinks);
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
        final Statistic other = (Statistic) obj;
        if (!Objects.equals(this.Drinks, other.Drinks)) {
            return false;
        }
        return true;
    }
    

}
