package alcometer_server.recommendation;

import java.util.Set;

public class Recommendation {

    private Set<DrinkInfo> drinks;

    public Recommendation() {
    }

    public Recommendation(Set<DrinkInfo> drinks) {
        this.drinks = drinks;
    }

    public Set<DrinkInfo> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<DrinkInfo> drinks) {
        this.drinks = drinks;
    }

    
}
