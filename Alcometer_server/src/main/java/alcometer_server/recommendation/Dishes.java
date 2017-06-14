package alcometer_server.recommendation;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dishes implements Serializable {

    @Id
    @Column(name = "dishes_id")
    @JSONField(serialize = false)
    private int ID;

    @Column(name = "first_dish")
    @JSONField(serialize = false)
    private String firstDish;

    @Column(name = "second_dish")
    @JSONField(serialize = false)
    private String secondDish;

    @Column(name = "third_dish")
    @JSONField(serialize = false)
    private String thirdDish;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "drinks_dishes", joinColumns = @JoinColumn(name = "dishes_id"),
            inverseJoinColumns = @JoinColumn(name = "drinks_id"))
    private Set<Drinks> drinks = new HashSet<>();

    @JSONField(serialize = false)
    public int getDishesID() {
        return ID;
    }
    
    @JSONField(serialize = false)
    public String getFirstDish() {
        return firstDish;
    }
    
    @JSONField(serialize = false)
    public String getSecondDish() {
        return secondDish;
    }
    
    @JSONField(serialize = false)
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
 
    public Set<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drinks> drinks) {
        this.drinks = drinks;
    }

}
