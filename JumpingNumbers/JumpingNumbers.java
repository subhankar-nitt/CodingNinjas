package JumpingNumbers;

import java.util.*;;
public class JumpingNumbers {
    public static void main(String[] args) {
        long X =10;
        // for(int i=0;i<=9;i++){
        //     dfs(1100, i);
        // }
        Queue<Long> queue=new LinkedList<>();
        for(int i=1;i<=9;i++){
            queue.add(Long.valueOf(i));
            bfs(100, queue);
        }
    }
    public  static  void  dfs(long num, long dup){
        if(dup>num){
            return ;
        }
        System.out.println(dup);

        long lastDig =  dup%10;
        // int factor = dup/10;

        if(lastDig==0)
            dfs(num, 10*dup+lastDig+1);
        else if(lastDig==9)
            dfs(num, 10*dup+lastDig-1);
        else{
            dfs(num, 10*dup+lastDig+1);
            dfs(num, 10*dup+lastDig-1);
        }
    }
    public static void bfs(long nums,Queue<Long> queue){

        while (!queue.isEmpty()) {
            long ele = queue.poll();
            if(ele<=nums){
                System.out.println(ele);
                long lastDig = ele%10;
                if(lastDig==0)
                    queue.add(ele*10 + lastDig+1);
                else if(lastDig==9)
                    queue.add(ele*10+lastDig-1);
                else{
                    queue.add(ele*10+lastDig-1);
                    queue.add(ele*10+lastDig+1);
                }
            }
        }
    }
}    

