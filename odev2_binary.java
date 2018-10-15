/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yigit;

class Yigit {
   
    int top,N;
    int []a;

    boolean isEmpty() {
        return top ==-1;
    }
    boolean full(){
        return top==N-1;
    }
    Yigit(int N) {
        top = -1;
         a = new int[N]; // Maximum size of Stack
        this.N=N;
    }

    void push(int x) {
        if (!full()) {
            top++;
            a[top] = x;            
        }
    }

    int pop() {
        if (!isEmpty()) {
            top=top-1;            
            int x = a[top+1];
            return x;
        }
        return -1;
    }
    int peek(){
        return a[top];
        
    }
}
public class odev2_binary {
    public static Yigit dectobin(int sayi){
        Yigit Y=new Yigit(100);
        while(sayi!=0){
            Y.push(sayi%2);
            sayi=sayi/2;
        }
        return Y;
    }
    public static String goster(Yigit y){
        String S="";
        while(!y.isEmpty()){
            S=S+" "+y.pop();
        }
        return S;
    }
    public static void main(String[] args) {
        Yigit sonuc=dectobin(12);
        System.out.println(goster(sonuc));
        
    }
}
