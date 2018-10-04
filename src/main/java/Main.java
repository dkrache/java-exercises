import com.java.example.list.StreamExample;

public class Main {

    public static void main(String[] args) {

        StreamExample example = new StreamExample();

        example.getClosestShootByPlayer().stream().forEach(x->System.out.println(x));
        System.out.println("----------");
        example.getFarthestShootByPlayer().stream().forEach(x->System.out.println(x));
        System.out.println("----------");
        example.getBestPlayerPerMatch();
    }
}
