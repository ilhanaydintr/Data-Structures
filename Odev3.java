package odev3;
class ikiYigit 
{ 
    int size; 
    int top1, top2; 
    int arr[];  
    ikiYigit(int n) 
    { 
        arr = new int[n]; 
        size = n; 
        top1 = -1; 
        top2 = size; 
    } 
    void push1(int x) 
    { 
        if (top1 < top2 - 1) 
        { 
            top1++; 
            arr[top1] = x; 
        } 
        else
        { 
            System.out.println("Yigit tasti"); 
            System.exit(1); 
        } 
    } 
    void push2(int x) 
    { 
        if (top1 < top2 -1) 
        { 
            top2--; 
            arr[top2] = x; 
        } 
        else
        { 
            System.out.println("Yigit doldu"); 
            System.exit(1); 
        } 
    } 
    int pop1() 
    { 
        if (top1 >= 0) 
        { 
            int x = arr[top1]; 
            top1--; 
            return x; 
        } 
        else
        { 
            System.out.println("Yigit bos"); 
            System.exit(1); 
        } 
        return 0; 
    } 
    int pop2() 
    { 
        if(top2 < size) 
        { 
            int x =arr[top2]; 
            top2++; 
            return x; 
        } 
        else
        { 
            System.out.println("Yigit bos"); 
            System.exit(1); 
  
        } 
        return 0; 
    }    
} 
public class Odev3 {
   
    public static void main(String args[]) 
    { 
        ikiYigit ts = new ikiYigit(5); 
        ts.push1(5); 
        ts.push2(10); 
        ts.push2(15); 
        ts.push1(11); 
        ts.push2(7); 
        System.out.println("Yigit 1 den çikarilan eleman " + ts.pop1()); 
        ts.push2(40); 
        System.out.println("Yigit 2'den çıkarılan eleman " + ts.pop2()); 
    } 
    
}
