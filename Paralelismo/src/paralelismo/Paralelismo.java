package paralelismo;

import java.util.concurrent.ForkJoinPool;

public class Paralelismo {
    public static void main(String[] args) {
        long total; 
        int x, y;
        
        x = 17;
        y = 17;

        long start = System.currentTimeMillis(); 

        total = Recursão.cont(x, y); 

        long end = System.currentTimeMillis() - start; 
        
        System.out.println("Usando Recursão ");
        System.out.println("Resultado: " + total); 
        System.out.println("Tempo: " + end + " ms");
        System.out.println();

        long rutimeStart = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();

        total = pool.invoke(new Robo(x, y, false)); 

        pool.shutdown();

        long runtimeEnd = System.currentTimeMillis() - rutimeStart; 

        System.out.println("Usando fork/join");
        System.out.println("Resultado:" + total); 
        System.out.println("Tempo: " + runtimeEnd + " ms");
    }   
}
