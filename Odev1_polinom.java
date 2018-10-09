class polinom{
    int ksayi,derece;
    polinom ileri;
    public polinom(int ksayi, int derece) {
        this.ksayi = ksayi;
        this.derece = derece;
        ileri = null;
    }

}
public class odev1 {
    polinom bas;
    public odev1(){
        bas=null;
    }
   void siraliekle(polinom yeni)     { 
         if (bas == null || bas.derece <= yeni.derece) 
         { 
            yeni.ileri = bas; 
            bas = yeni; 
         } 
         else {
            polinom tmp = bas;   
            while (tmp.ileri != null && 
                   tmp.ileri.derece > yeni.derece) 
                  tmp = tmp.ileri; 
  
            yeni.ileri = tmp.ileri; 
            tmp.ileri = yeni; 
         } 
     }
   String polinomgoster(){
       polinom p=bas;
       String S="";
       while(p!=null){
           S=S+p.ksayi+"x^"+p.derece+"+";
           p=p.ileri;
       }
       return S;
   }
}
