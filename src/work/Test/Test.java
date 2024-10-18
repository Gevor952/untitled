package work.Test;


public class Test {


    final static String PATH = "C:\\Users\\NITRO\\Desktop\\untitled\\src\\work\\Test\\test.text";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long s = System.currentTimeMillis();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 2_000_000; i++) {
            map.put(i, i);
            if (map.size() % 1000 == 0) {
                System.out.println(map.size() + " " + (System.currentTimeMillis() - s));
                s = System.currentTimeMillis();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}


