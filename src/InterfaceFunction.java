public class InterfaceFunction {

    public static void main(String[] args) {

        //This is anonymous interface
        Color back = new Color() {
            @Override
            public void showColor(String color) {
                System.out.println(color);
            }
        };
        back.showColor("back");

        System.out.println();

        //This is interface with Lambda
        //Can do like this when interface is FunctionalInterface
        //FunctionalInterface -> interface has only one method
        //We can add Annotation @FunctionalInterface for make sure
        //that interface has only one method, in case it has more than
        //one will compile error
        Color red = color -> {
            System.out.println(color);
        };
        red.showColor("red");

    }
}

@FunctionalInterface
interface Color {
    void showColor(String color);
}

