package InheritanceExample;

public class BakedGood extends Dessert {
    private String type;

    public BakedGood(String type) {
        this.type = type;
    }

    public BakedGood(String type, String name) {
        super(name);
        this.type = type;
    }

    public String toString() {
        return "Yummy - " + type + this.getName();
    }
    
}
