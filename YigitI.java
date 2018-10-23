/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev3;

class YigitI {
   
    int top,N;
    int []a;

    boolean isEmpty() {
        return top ==-1;
    }
    boolean full(){
        return top==N-1;
    }
    YigitI(int N) {
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
        return ' ';
    }
    int peek(){
        return a[top];
        
    }
}
