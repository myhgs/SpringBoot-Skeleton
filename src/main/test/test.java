import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kiseokhong on 2020/03/09.
 */
public class test {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.getAndIncrement());

        System.out.println(atomicInteger.getAndIncrement());


    }
}
