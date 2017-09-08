import java.util.InputMismatchException;
import java.util.Scanner;
public class DFS_uygulama
{
    private Stack stack; 
    public DFS_uygulama(int N) 
    {
        stack = new Stack();
    }
     public int found(int u, int[][]d,int visited[]){
         for (int i = u; i < d.length; i++) {
             for (int j = 0; j < d[i].length; j++) {
                 if(d[i][j]==1 && visited[j]==0)
                     return j;
             }
         }
         return -1;
     }
     public void dfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length; 
        int visited[] = new int[number_of_nodes];		
        int v= source,u;				
        System.out.print(v + "\t");		
        visited[v] = 1;	
        stack.push(v);
        u=v;
        int w=found(u,adjacency_matrix,visited);    
        while (w!=-1 || !stack.isEmpty())
        {            
     	        if (w!=-1 && visited[w]==0)
	        {
                    stack.push(w);
                    visited[w] = 1;
                    u = w;                   
                    System.out.print(w + "\t");	         
                }
                else
                    u=stack.pop();           
                w=found(u,adjacency_matrix,visited);
        }	
    } 
    public static void main(String...arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
 	try
        {
	    System.out.println("Düğüm Sayısı gir:");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
 
	    int adjacency_matrix[][] = new int[number_of_nodes][number_of_nodes];
	    System.out.println("Komşuluk matrisi gir:");
	    for (int i = 0; i <number_of_nodes; i++)
	        for (int j = 0; j <number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt(); 
	    System.out.println("Başlangıç düğümü");
            source = scanner.nextInt();  
            System.out.println("Sonuç:");
            DFS_uygulama dfs = new DFS_uygulama(source);
            dfs.dfs(adjacency_matrix, source);					
        }catch(InputMismatchException inputMismatch)
        {
            System.out.println("Yanlış giriş formatı");
        }	
        scanner.close();	
    }	
}
