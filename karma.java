import java.util.Scanner;
class dugum
{
    dugum next;
    int data;
    public dugum(int x){
        data = x;
        next = null;}
}
class karmaList
{
    public dugum[] table;
    private int size ;
    public karmaList(int tableSize)
    {
        table = new dugum[ nextPrime(tableSize) ];
        size = 0;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void makeEmpty()
    {
        int l = table.length;
        table = new dugum[l];
        size = 0;
    }
    public int getSize()
    {
        return size;
    }
    public void insert(int val)
    {
        size++;
        int pos = myhash(val);        
        dugum nptr = new dugum(val);                
        if (table[pos] == null)
            table[pos] = nptr;            
        else
        {
            nptr.next = table[pos];
            table[pos] = nptr;
        }    
    }
    public void remove(int val)
    {
        int pos = myhash(val);    
        dugum start = table[pos];
        dugum end = start;
        if (start.data == val)
        {
            size--;
            table[pos] = start.next;
            return;
        }
        while (end.next != null && end.next.data != val)
            end = end.next;
        if (end.next == null)        {
            System.out.println("\nEleman bulunamadı\n");
            return;        }
        size--;
        if (end.next.next == null)
        {
            end.next = null;
            return;
        }
        end.next = end.next.next;
        table[pos] = start;
    }
    public int myhash(Integer x )
    {
        int hashVal = x.hashCode( );
        hashVal %= table.length;
        if (hashVal < 0)
            hashVal += table.length;
        return hashVal;
    }
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for ( ;!isPrime( n ); n += 2);
 
        return n;
    }
    private static boolean isPrime( int n )
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    public void printHashTable ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Bucket " + i + ":  ");             
            dugum start = table[i];
            while(start != null)
            {
                System.out.print(start.data +" ");
                start = start.next;
            }
            System.out.println();
        }
    }   
}

public class karma
{ 
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Tablo boyutu gir:"); 
        karmaList htcsll = new karmaList(scan.nextInt() ); 
        //htcsll.insert(5);
        int [] dizi1={1,3,5,7,10};
        int []dizi2={3,5,7};
        for (int i = 0; i < dizi1.length; i++) {
            htcsll.insert(dizi1[i]);
        }    
        boolean bulundu=false;
        for (int i = 0; i < dizi2.length; i++) {
           int indis=htcsll.myhash(dizi2[i]);
           dugum d1=htcsll.table[indis];
           if(d1==null) {bulundu=false;break;}
           while(d1!=null){
               if(d1.data==dizi2[i]){                       
                   bulundu=true;
                   break;
               }
               else {d1=d1.next;
           bulundu=false;}            
        }
        }
        
                
        if(bulundu==false) System.out.println("Alt kümesi değil");
        else System.out.println("Alt kümesi");
        htcsll.printHashTable();  
       int aranan=htcsll.myhash(0);
       dugum d=htcsll.table[aranan];
       int top=0;
       while(d!=null){
           top=top+d.data;
           d=d.next;
       }
        System.out.println("Toplam:"+top);
    }
}