package InheritanceExample;

public class Dessert {
    private String name;
    
    public Dessert() {
        name = "dessert";
    }
    
    public Dessert(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Mmmmm... " + name;
    }
}
