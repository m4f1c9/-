package alcometer_server.recommendation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dishes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishes_id")
    private int ID;
    
    @Column(name = "first_dish")
    private String firstDish;
    
    @Column(name = "second_dish")
    private String secondDish;
    
    @Column(name = "third_dish")
    private String thirdDish;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "drinks_dishes", joinColumns = @JoinColumn(name = "dishes_id"), 
            inverseJoinColumns = @JoinColumn(name = "drinks_id"))
    private Set<DrinkInfo> drinks = new HashSet<>();
    
    
    public int getDishesID() {
        return ID;
    }

    public String getFirstDish() {
        return firstDish;
    }

    public String getSecondDish() {
        return secondDish;
    }

    public String getThirdDish() {
        return thirdDish;
    }

    public void setDishesID(int dishesID) {
        this.ID = dishesID;
    }

    public void setFirstDish(String firstDish) {
        this.firstDish = firstDish;
    }

    public void setSecondDish(String secondDish) {
        this.secondDish = secondDish;
    }

    public void setThirdDish(String thirdDish) {
        this.thirdDish = thirdDish;
    }

    public Set<DrinkInfo> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<DrinkInfo> drinks) {
        this.drinks = drinks;
    }

    
}
