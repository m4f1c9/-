package alcometer_server.statistics;

import java.util.Objects;
import java.util.Set;

public class Statistic {

    private Set<Drink> drinks;

    public Statistic() {
    }

    public Statistic(Set<Drink> Drinks) {
        this.drinks = Drinks;
    }

    public Set<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.drinks);
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
        if (!Objects.equals(this.drinks, other.drinks)) {
            return false;
        }
        return true;
    }

}
