
import java.util.Random;

class Eleman{
    int icerik;
    Eleman ileri;
    public Eleman(int icerik){
        this.icerik=icerik;
        this.ileri=null;
    }
}
class Kuyruk {
    Eleman bas;
    Eleman son;
    String S;
    public Kuyruk(){
        bas=null;
        son=null;
        S="";
    }
    boolean bosmu(){
        return bas==null;
    }
    void Ekle(Eleman yeni){
        if(!bosmu())
            son.ileri=yeni;
        else
            bas=yeni;       
        S=S+yeni.icerik+"-";
        son=yeni;
        
    }
    Eleman sil(){
        Eleman sonuc;
        sonuc=bas;
        if(!bosmu()){            
            bas=bas.ileri;
            if(bas==null)
                son=null;
        }
        S=S.substring(S.indexOf("-")+1,S.length());
        return sonuc;
    }
    void roundrobinsil(int quantum){
      while(!bosmu()){
          Eleman e=sil();
          if(e.icerik>quantum)
              Ekle(new Eleman(e.icerik-quantum));
          System.out.println(S);              
      }        
    }
    
}
public class odev4 {
    
    public static void main(String[] args) {
        Kuyruk k=new Kuyruk();
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            Eleman e=new Eleman(r.nextInt(30)+5);
            k.Ekle(e);
            System.out.println(k.S);
        }
        System.out.println("");
        k.roundrobinsil(15);
        
        
    }
}
