package bliste;

class Eleman {

    int icerik;
    Eleman ileri;

    Eleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }
}
public class BListe {

    Eleman bas;
    Eleman son;

    public BListe() {
        bas = null;
        son = null;
    }

    void basaEkle(Eleman yeni) {
        if (son == null) {
            bas = yeni;
            son = yeni;
        } else {
            yeni.ileri = bas;
            bas = yeni;
        }
    }

    void sonaEkle(Eleman yeni) {
        if (bas == null) {
            son = yeni;
            bas = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

    Eleman listeAra(int deger) {
        Eleman tmp;
        tmp = bas;
        while (tmp != null) {
            if (tmp.icerik == deger) {
                return tmp;
            }
            tmp = tmp.ileri;
        }
        return null;
    }

    void listeBasiSil() {
        bas = bas.ileri;
        if (bas == null) {
            son = null;
        }
    }

    void listeSonuSil() {
        Eleman tmp, once;
        tmp = bas;
        once = null;
        while (tmp != son) {
            once = tmp;
            tmp = tmp.ileri;
        }
        if (once == null) {
            bas = null;
        } else {
            once.ileri = null;
        }
        son = once;
    }

    int elemanSayisi() {
        int sayac = 0;
        Eleman tmp;
        tmp = bas;
        while (tmp != null) {
            tmp = tmp.ileri;
            sayac++;
        }
        return sayac;
    }
    String listele(){
        String S="";
        Eleman tmp=bas;
        while(tmp!=null){
            S=S+"-->"+tmp.icerik;
            tmp=tmp.ileri;
        }
        return S;
    }
}
