
package odev3;

class Yigit {
   
    int top,N;
    char []a;

    boolean isEmpty() {
        return top ==-1;
    }
    boolean full(){
        return top==N-1;
    }
    Yigit(int N) {
        top = -1;
         a = new char[N]; // Maximum size of Stack
        this.N=N;
    }

    void push(char x) {
        if (!full()) {
            top++;
            a[top] = x;            
        }
    }

    char pop() {
        if (!isEmpty()) {
            top=top-1;            
            char x = a[top+1];
            return x;
        }
        return ' ';
    }
    char peek(){
        return a[top];
        
    }
}