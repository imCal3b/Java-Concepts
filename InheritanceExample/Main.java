package InheritanceExample;

public class Main {

    public static void main(String[] args) {
        Dessert[] goods = new Dessert[6];

        Dessert pie = new Dessert("pie");
        Dessert popsicle = new FrozenTreats("orange", "popsicle");
        Dessert iceCream = new FrozenTreats("strawberry", "ice-cream");
        Dessert cookie = new BakedGood("Oreo", "cookie");
        Dessert fudge = new Dessert("fudge");
        Dessert cake = new BakedGood("chocolate", "cake");

        goods[0] = pie;
        goods[1] = popsicle;
        goods[2] = iceCream;
        goods[3] = cookie;
        goods[4] = fudge;
        goods[5] = cake;

        for (int i=0; i<goods.length ; i++) {
            System.out.println(goods[i]);
        }
    }
    
}
