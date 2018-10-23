package odev3;
public class odev3_2 {
    static int oncelik(char ch) 
    { 
        switch (ch)         { 
        case '+': 
        case '-': 
            return 1; 
        case '*': 
        case '/': 
            return 2;        
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
    static String terscevir(String exp){
        String S="";
        for (int i = exp.length()-1; i >=0; i--) {
            switch (exp.charAt(i)) {
                case '(':
                    S=S+")";
                    break;
                case ')':
                    S=S+"(";
                    break;
                default:
                    S=S+exp.charAt(i);
                    break;
            }
        }
        return S;
    }
    static String infixToPrefix(String exp){
        String S=terscevir(exp);
        String donustur=infixToPostfix(S);
        S=terscevir(donustur);
        return S;
    }
    static String infixToPostfix(String exp) 
    {  
        String result = new String("");  
        Yigit stack= new Yigit(100);     
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
            else if (c == '(') 
                stack.push(c); 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && oncelik(c) <= oncelik(stack.peek())) 
                    result += stack.pop(); 
                stack.push(c); 
            } 
       
        } 
        while (!stack.isEmpty()) 
            result += stack.pop();        
        return result; 
    }
    static int evaluatePostfix(String exp) 
    { 
        YigitI stack=new YigitI(100); 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
            if(Character.isDigit(c)) 
                stack.push(c -'0'); 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop();                   
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break;                       
                    case '-': 
                    stack.push(val2- val1); 
                    break;                       
                    case '/': 
                    stack.push(val2/val1); 
                    break;                       
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 
    static int evaluateprefix(String exp){  
        YigitI stack=new YigitI(100); 
        for(int i=exp.length()-1;i>=0;i--) 
        { 
            char c=exp.charAt(i); 
            if(Character.isDigit(c)) 
                stack.push(c -'0'); 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop();                   
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break;                       
                    case '-': 
                    stack.push(val1- val2); 
                    break;                       
                    case '/': 
                    stack.push(val1/val2); 
                    break;                       
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();
    }
    public static void main(String[] args)  
    { 
        String exp = "(3+8)*5-7/2"; 
        String prefix=infixToPrefix(exp);
        String postfix=infixToPostfix(exp);
        System.out.println(exp+" ifadesinin prefixi:"+prefix);
        System.out.println(exp+" ifadesinin postfixi:"+postfix); 
        System.out.println(evaluatePostfix(postfix));
        System.out.println(evaluateprefix(prefix));
    } 
    
}
