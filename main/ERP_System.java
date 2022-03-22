package main;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import main.java.ProductoDto;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ERP_System{

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        String path = "C:\\Users\\valen\\Downloads\\Products\\Products.csv";
        String linea = "";
        int retorno= 0;
        Map<String, ArrayList> map = new HashMap<String, ArrayList>();
        ArrayList<String> id = new ArrayList<String>();
        ArrayList<String> nome = new ArrayList<String>();
        ArrayList<String> preco = new ArrayList<String>();

        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> productos = csvReader.readAll();
        List<ProductoDto> productoDtoList = new ArrayList<>();
        for (String[] product : productos)
        {
            ProductoDto productoDto = new ProductoDto(product);
            productoDtoList.add(productoDto);
        }

        for (ProductoDto producto : productoDtoList) {

            try {
                BufferedReader p = new BufferedReader(new FileReader(path));
                while ((linea = p.readLine()) != null) {
                    String[] values = linea.split(",");
                    id.add(values[0]);
                    nome.add(values[20]);
                    preco.add(values[1]);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put("ID", id);
            map.put("Nome", nome);
            map.put("Precio", preco);
            //System.out.println(map);

            //Id,prices.amountMax,prices.amountMin,prices.availability,prices.condition,prices.currency,prices.dateSeen,prices.isSale,prices.merchant,prices.shipping,prices.sourceURLs,asins,brand,categories,dateAdded,dateUpdated,ean,imageURLs,keys,manufacturer,manufacturerNumber,name,primaryCategories,sourceURLs,upc,weight,Column1,_1,_2,_3,_4
            //Nome de cada coluna
             int res = Menu();
             while (res != 3) {
            //  res = Menu();
                switch (res) {
                    case 1:
                        System.out.println("Insira o codigo: ");
                        String codigo = ler.nextLine();
                        retorno = busca(id, codigo);// codigo = valor de id,  0 = coluna ID
                        System.out.println("Codigo: " + id.get(retorno) + " Nome: " + nome.get(retorno) + " Preço: " + preco.get(retorno));
                        break;
                    case 2:
                        System.out.println("Insira o Nome: ");
                        String nom = ler.nextLine();
                        retorno = busca(id, nom);// codigo = valor de id,  0 = coluna ID
                        System.out.println("Codigo: " + id.get(retorno) + " Nome: " + nome.get(retorno) + " Preço: " + preco.get(retorno));
                        break;
                }
            }
            System.out.println("cabo");
             break;
        }
    }

    public static int Menu() {
        Integer res = 0;
        boolean avanzar = false;

        Scanner in = new Scanner(System.in);

        while(avanzar == false)
        {
            System.out.println("1 - Buscar por codigo");
            System.out.println("2 - Buscar por nome");
            System.out.println("3 - sair");
            try
            {
                res = in.nextInt();
                avanzar = true;
            }
            catch(InputMismatchException err)
            {
                System.err.println("Valor inválido, intente nuevamente ingresando una de las ocpciones listadas.");
                //	in.next();
            }
        }

        return res;
    }
    /*public static int menu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("1 - Buscar por codigo");
        System.out.println("2 - Buscar por nome");
        System.out.println("3 - sair");
        int res = ler.nextInt();
        return res;
    }*/



    public static Integer busca(ArrayList<String> l, String a){
        Integer r=0;
        for(int i=0; i<l.size(); i++){
            if(l.get(i).equals(a)){
                r = i;
            }
        }

        // for (Map.Entry<String, ArrayList> set : l.entrySet()) {
        //   //  if (set.getKey().equals(item) && set.getValue().equals(a)){
        //     if(set.getKey().equals(item)){
        //         for(Object[] y : set.getValue().toArray()){
        //             System.out.println(y);
        //         }
        //     }
        //             //String[] y = set.getValue().toString();
        //            // System.out.println(set.getKey() + " = " + set.getValue());
        //     //}
        // }

        // for(int i=0; i< a.length();i++){
        //      if (l[item][i].equals(a)){
        //          String[] v= l[][i];
        //      }
        //  }
        return r;
    }
}


