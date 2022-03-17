import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ERP_System{

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        String path = "Desktop\\Exercicios Java\\Estrutura de dados\\Products.csv";
        String linea = "";
        Map<String, ArrayList> map = new HashMap<String, ArrayList>();
        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> nome = new ArrayList<String>();
        ArrayList<String> preco = new ArrayList<String>();

        try {
            BufferedReader p = new BufferedReader(new FileReader(path));
            while((linea = p.readLine()) != null){
                String[] values = linea.split(",");
                id.add(values[0]);
                nome.add(values[20]);
                preco.add(values[1]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } 
        map.put("ID", id);
        map.put("Nome", nome);
        map.put("Precio", preco);
        System.out.println(map);

            //Id,prices.amountMax,prices.amountMin,prices.availability,prices.condition,prices.currency,prices.dateSeen,prices.isSale,prices.merchant,prices.shipping,prices.sourceURLs,asins,brand,categories,dateAdded,dateUpdated,ean,imageURLs,keys,manufacturer,manufacturerNumber,name,primaryCategories,sourceURLs,upc,weight,Column1,_1,_2,_3,_4
            //Nome de cada coluna
        int res = menu();
        while(res!=3){
             res = menu();
             switch(res){
                 case 1:
                    System.out.println("Insira o codigo: ");
                    String codigo = ler.nextLine();
                    // busca(values, codigo, 0);// codigo = valor de id,  0 = coluna ID
                     break;
                 case 2:
                     //busca_nome(sc);
                     break;
             }
         }
     }
      

    
public static int menu(){
    Scanner ler = new Scanner(System.in);
    System.out.println("1 - Buscar por codigo");
    System.out.println("2 - Buscar por nome");
    System.out.println("3 - sair");
    int res = ler.nextInt();
     return res;
    }

// public static String busca(String[] l, String a, int item){
//     for(int i=0; i< a.length();i++){
//         if (l[item][i].equals(a)){
//             String[] v= l[][i];
//         } 
//     }
// return Array;
// }

}  