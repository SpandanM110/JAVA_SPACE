import java.util.*;

class MyStack{
    Stack<Integer> s;
    Stack<Integer> a;

    public MyStack() {
        s = new Stack<Integer>();
        a = new Stack<Integer>();
    }

    void getMin(){
        if(a.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Minimum element: " + a.peek());
        }
    }

    void peek(){
        if(s.isEmpty()){
            System.out.println("Stack is Empty");
            return;

        }
        Integer t = s.peek();
        System.out.println("Top most element: " + t);

    }

    void pop(){
        if(s.isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        int t = s.pop();
        System.out.println("Removed element: " + t);
        if(!a.isEmpty() && t == a.peek()){
            a.pop();
        }
    }

    void push(int x){
        if(s.isEmpty()){
            s.push(x);
            a.push(x);
            System.out.println("Number inserted: " + x);
            return;
        }
        else{
            s.push(x);
            System.out.println("Number inserted: " + x);
        }
        if(x <= a.peek()){
            a.push(x);
        }
    }




}

public class minstack{
    public static void main(String args[]){
        MyStack s = new MyStack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            s.push(m);
        }
        s.getMin();
        s.peek();
        s.pop();
        s.peek();
        s.getMin();
    }
}


