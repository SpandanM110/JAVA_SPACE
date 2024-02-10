import java.util.*;

public class Sliding_window{
    public static int[] maxsliding(int[] in, int w){
        int[] max_left = new int[in.length];
        int[] max_right = new int[in.length];
        max_left[0] = in[0];
        max_right[in.length -1] = in[in.length - 1];
        for(int i = 1; i<in.length; i++){
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i-1], in[i]);
            final int  j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j+1], in[j]);
        }
        final int[] sliding_max = new int[in.length - w + 1];
        for(int i = 0, j = 0; i + w <= in.length; i++){
            sliding_max[j++] = Math.max(max_right[i], max_left[i+w-1]);
        }
        return sliding_max;
    }
    
        public static void main(String[] args){
            int[] in = {1, 3, -1, -3, 5, 3, 6, 7};
            int w = 3;
            int[] res = maxsliding(in, w);
            for(int i = 0; i<res.length; i++){
                System.out.println(res[i]);
            }
        }
    }