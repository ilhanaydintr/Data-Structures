package yigit;
class Stack {
   
    int top,N;
    char []a;

    boolean isEmpty() {
        return top ==-1;
    }
    boolean full(){
        return top==N-1;
    }
    Stack(int N) {
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
public class odev2_parantez {

    static boolean eslesme(char c1, char c2) 
    { 
       if (c1 == '(' && c2 == ')') 
         return true; 
       else if (c1 == '{' && c2 == '}') 
         return true; 
       else if (c1 == '[' && c2 == ']') 
         return true; 
       else
         return false; 
    } 
    static boolean dengelimi(String exp) 
    { 
       /* Boş Yıgıt tanımla */
       Stack st=new Stack(100); 
       for(int i=0;i<exp.length();i++) {             
          /*Eğer exp[i] parantez açma ise ekle*/
          if (exp.charAt(i) == '{' || exp.charAt(i)  == '(' || exp.charAt(i)  == '[') 
            st.push(exp.charAt(i)); 
          if (exp.charAt(i)  == '}' || exp.charAt(i)  == ')' || exp.charAt(i)  == ']') 
          { 
             if (st.isEmpty())               
                   return false; 
             else if ( !eslesme(st.pop(), exp.charAt(i)) )               
                   return false; 
                
          } 
            
       }          
        return st.isEmpty();    
    }  
    public static void main(String[] args) {
        String S= "{()}[]"; 
          if (dengelimi(S)) 
            System.out.println("Dengeli parantez "); 
          else
            System.out.println("Parantezler dengeli değil "); 
    }
    
}
