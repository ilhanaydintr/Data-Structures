
package yiginuyglama;
class Eleman{
    int icerik;
    Eleman ileri;
    public Eleman(int icerik){
        this.icerik=icerik;
        this.ileri=null;
    }    
}
public class yigin {
    Eleman ust;
    public yigin(){
        ust=null;        
    }
    boolean bosmu(){
        if(ust==null) return true;
        else return false;
    }
    void Ekle(Eleman yeni){
        yeni.ileri=ust;
        ust=yeni;
    }
    Eleman sil(){
        Eleman e=ust;
        if(!bosmu())
            ust=ust.ileri;
        return e;       
    }
    int enBuyuk(){
        int buyuk;
        Eleman e;
        yigin y1=new yigin();
        e=sil();
        y1.Ekle(e);
        buyuk=e.icerik;
        while(!bosmu()){
            e=sil();
            y1.Ekle(e);
            if(e.icerik>buyuk)
                buyuk=e.icerik;
        }
        while(!y1.bosmu()){
            e=y1.sil();
            Ekle(e);
        }
        return buyuk;
    }
}
