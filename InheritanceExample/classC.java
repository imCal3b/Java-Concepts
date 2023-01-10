package InheritanceExample;

public class classC {
    int x;

    public classC() {
        System.out.println("C constructor 1");
        x = 0;
    }

    public classC(int x) {
        this.x = x;
        System.out.println("C constructor 2");
    }

    public void foo() {
        System.out.println("C foo: "+x);
    }
    
}
