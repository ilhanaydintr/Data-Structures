package ikiliagac;

class Kuyruk {

    Dugum bas;
    Dugum son;

    public Kuyruk() {
        bas = null;
        son = null;
    }

    boolean bosmu() {
        return bas == null;
    }

    void Ekle(Dugum yeni) {
        if (!bosmu()) {
            son.ileri = yeni;
        } else {
            bas = yeni;
        }
        son = yeni;
    }

    Dugum sil() {
        Dugum sonuc;
        sonuc = bas;
        if (!bosmu()) {
            bas = bas.ileri;
            if (bas == null) {
                son = null;
            }
        }
        return sonuc;
    }
}

class Dugum {
    int icerik;
    Dugum sol, sag, ileri;

    Dugum(int icerik) {
        this.icerik = icerik;
        sol = null;
        sag = null;
        ileri = null;

    }
}

class Agac {

    Dugum kok;

    Agac() {
        kok = null;
    }

    Dugum agacAra(int eleman) {
        Dugum d;
        d = kok;
        while (d != null) {
            if (d.icerik == eleman) {
                return d;
            } else if (d.icerik > eleman) {
                d = d.sol;
            } else {
                d = d.sag;
            }
        }
        return null;
    }

    Dugum min() {
        Dugum sonuc = kok;
        while (sonuc.sol != null) {
            sonuc = sonuc.sol;
        }
        return sonuc;
    }

    Dugum max() {
        Dugum sonuc = kok;
        while (sonuc.sag != null) {
            sonuc = sonuc.sag;
        }
        return sonuc;
    }

    void ekle(Dugum yeni) {
        Dugum y = null;
        Dugum x = kok;
        while (x != null) {
            y = x;
            if (yeni.icerik < x.icerik) {
                x = x.sol;
            } else {
                x = x.sag;
            }
        }
        if (y == null) {
            kok = yeni;
        } else if (yeni.icerik < y.icerik) {
            y.sol = yeni;
        } else {
            y.sag = yeni;
        }
    }

    void inorder(Dugum node) {
        if (node == null) {
            return;
        }
        inorder(node.sol);
        System.out.print(node.icerik + " ");
        inorder(node.sag);
    }

    void preorder(Dugum node) {
        if (node == null) {
            return;
        }
        System.out.print(node.icerik + " ");
        preorder(node.sol);
        preorder(node.sag);
    }

    void postorder(Dugum node) {
        if (node == null) {
            return;
        }
        postorder(node.sol);
        postorder(node.sag);
        System.out.print(node.icerik + " ");
    }

    public boolean yapraksil(int key) // delete node with given key
    { // (assumes non-empty list)
        Dugum current = kok;
        Dugum parent = kok;
        boolean isLeftChild = true;
        while (current.icerik != key) // search for node
        {
            parent = current;
            if (key < current.icerik) 
            {
                isLeftChild = true;
                current = current.sol;
            } else 
            {
                isLeftChild = false;
                current = current.sag;
            }
            if (current == null) 
            {
                return false; 
            }
        } 
    if(current.sol==null && current.sag==null){
        if (current == kok) // if root,
        {
            kok = null;            
        } else if (isLeftChild) {
            parent.sol = null;            
        } else 
        {
            parent.sag = null;
        }
        return true;
    }
    else return false;
}

void seviye_goster(){
       Kuyruk k = new Kuyruk(); 
       Dugum tmp=kok;
       if(tmp!=null) k.Ekle(tmp);
      // System.out.println(tmp.icerik);
      int i=0,j=0;
       System.out.print("    ");
       int top=0;
       while(!k.bosmu()){
           tmp=k.sil(); 
           top+=tmp.icerik;
           if(tmp.sol!=null)
               k.Ekle(tmp.sol);
           if(tmp.sag!=null)
               k.Ekle(tmp.sag);                     
           System.out.print(tmp.icerik+"\t");
           int us=(int)Math.pow(2, j);       
           i++;
           if(i==us){
               j=j+1;
               i=0;
               System.out.println("");
           }
       }
       System.out.println("Toplam:"+top);
   

}
}
public class IkiliAgac {

    public static void main(String[] args) {
        Agac a = new Agac();
        a.ekle(new Dugum(8));
        a.ekle(new Dugum(4));
        a.ekle(new Dugum(12));
        a.ekle(new Dugum(2));
        a.ekle(new Dugum(5));
        a.ekle(new Dugum(9));
        a.ekle(new Dugum(14));

        a.seviye_goster();
        System.out.println(a.yapraksil(2));
        a.seviye_goster();
        a.inorder(a.kok);
        System.out.println("");
        a.preorder(a.kok);
        System.out.println("");
        a.postorder(a.kok);
    }

}
