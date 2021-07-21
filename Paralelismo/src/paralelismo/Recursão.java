package paralelismo;

public class Recursão {
 
    public static long cont(int x, int y) {
        if (x!=0 && y!=0) {
        } else { 
            return 1;
        }
        return (cont(x-1,y) + cont(x,y-1)); 
    }
}