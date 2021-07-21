package paralelismo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Robo extends RecursiveTask<Long> {
    
    long x; 
    long y; 
    boolean div; 

    public Robo(long x, long y, boolean div) { 
        this.x = x;
        this.y = y; 
        this.div = div; 
    }

    @Override
    protected Long compute() {
        if(x<5 && x<5 || div==true) {
            return contarCam(x, y); 
        }else {
            return Robo.invokeAll(createSubtasks(x, y))
                .stream()
                .mapToLong(Robo::join)
                .sum(); 
        }
    }

    private Collection<Robo> createSubtasks(long x,long y) {
        List<Robo> subtasks = new ArrayList<>(); 

        subtasks.add(new Robo(x-1,y,true)); 
        subtasks.add(new Robo(x,y-1,true));

        return subtasks; 
    }

    public long contarCam(long x,long y) {
        if(x==0 || y==0) {
            return 1L; 
        }
        return (contarCam(x-1, y) + contarCam(x, y-1)); 
    }
}