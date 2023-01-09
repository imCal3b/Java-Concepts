package InheritanceExample;

public class FrozenTreats extends Dessert {
    private String flavour;

    public FrozenTreats(String flavour) {
        this.flavour = flavour;
    }

    public FrozenTreats(String flavour, String name) {
        super(name);
        this.flavour = flavour;
    }    
}
