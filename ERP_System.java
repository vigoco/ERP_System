package main;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import main.java.ProductoDto;
import main.java.buscador_simple;
import main.java.Menu;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

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
        ArrayList<String> data_add = new ArrayList<String>();
        ArrayList<String> cantidad = new ArrayList<String>();

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
                    nome.add(values[3]);
                    preco.add(values[1]);
                    data_add.add(values[2]);
                    cantidad.add(values[4]);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put("ID", id);
            map.put("Nome", nome);
            map.put("Precio", preco);

            //Agregar productos aleatorios
            escribirEstoque(id,productoDtoList);

            //System.out.println(map);

            //Id,prices.amountMax,prices.amountMin,prices.availability,prices.condition,prices.currency,prices.dateSeen,prices.isSale,prices.merchant,prices.shipping,prices.sourceURLs,asins,brand,categories,dateAdded,dateUpdated,ean,imageURLs,keys,manufacturer,manufacturerNumber,name,primaryCategories,sourceURLs,upc,weight,Column1,_1,_2,_3,_4
            //Nome de cada coluna
             //int res = Menu();
            int res = -1;
             while (res != 0) {
              res = Menu.inimenu();
                switch (res) {
                    case 1:
                        System.out.println("Insira o codigoaaaaaa: ");
                        String codigo = ler.nextLine();

                        buscador_simple code = new buscador_simple(id, codigo);
                        //retorno = busca(id, codigo);// codigo = valor de id,  0 = coluna ID
                        retorno = code.search();// codigo = valor de id,  0 = coluna ID
                        if(retorno>0){ System.out.println("Codigo: " + id.get(retorno) + "|| Nome: " + nome.get(retorno) + "|| Preço: " + preco.get(retorno)+ "|| data de adição: " + data_add.get(retorno)+ "|| cantidad: " + cantidad.get(retorno));
                        }else{ System.out.println("Producto no encontrado ");
                        }
                       // ler.nextLine();
                        break;
                    case 2:
                        System.out.println("Insira o Nomeaaaaaaaaa: ");
                        String nom = ler.nextLine();

                        buscador_simple nomes = new buscador_simple(nome, nom);
                        retorno =  nomes.search();// codigo = valor de id,  0 = coluna ID
                        if(retorno>0){
                            if(!id.get(retorno).equals("Id")) {
                                System.out.println("Codigo: " + id.get(retorno) + "|| Nome: " + nome.get(retorno) + "|| Preço: " + preco.get(retorno)+ "|| data de adição: " + data_add.get(retorno)+ "|| cantidad: " + cantidad.get(retorno));
                            }else{
                                System.out.println("produto não foi encontrado");
                            }
                        }
                        ler.nextLine();
                        break;
                    case 3:
                        System.out.println("Insira o numero do produto ");
                        String codigo_busca = ler.nextLine();

                        buscador_simple line = new buscador_simple(id, codigo_busca);
                        retorno = line.search();
                        System.out.println("Insira a quantidade a retirar: ");
                        Integer retira = ler.nextInt();
                        if(parseInt(cantidad.get(retorno))>=retira){
                            cantidad.set(parseInt(String.valueOf(retorno)), Integer.toString(parseInt(cantidad.get(retorno))-retira));
                        }else if(parseInt(cantidad.get(retorno))<retira){
                            System.out.println("Quantidade insuficiente! Retirar quantidade disponivel?[sim/nao]: ");
                            String ans = ler.nextLine();
                            if(ans.equals("sim")){
                                System.out.println("Retirado: "+ cantidad.get(retorno)+" unidades do produto: "+ nome.get(retorno));
                                cantidad.set(parseInt(String.valueOf(retorno)), "0");
                            }
                        } else{System.out.println("Produto inexistente");}
                        ler.nextLine();
                        break;
                    case 4:
                        System.out.println("Insira o codigo: ");
                        String c = ler.nextLine();

                        buscador_simple ce = new buscador_simple(id, c);
                        //retorno = busca(id, codigo);// codigo = valor de id,  0 = coluna ID
                        retorno = ce.busca_binaria();// codigo = valor de id,  0 = coluna ID
                        if(retorno>0){ System.out.println("Codigo: " + id.get(retorno) + "|| Nome: " + nome.get(retorno) + "|| Preço: " + preco.get(retorno)+ "|| data de adição: " + data_add.get(retorno)+ "|| cantidad: " + cantidad.get(retorno));
                        }else{ System.out.println("Producto no encontrado ");
                        }
                        // ler.nextLine();
                        break;
                }
            }
             //ArrayList<String> prod = Menu.adciona_fifo();
            FileWriter csvWriter = new FileWriter("C:\\Users\\valen\\Downloads\\Products\\Products.csv");
           /* csvWriter.append("Id");
            csvWriter.append(",");
            csvWriter.append("preco");
            csvWriter.append(",");
            csvWriter.append("dateAdded");
            csvWriter.append(",");
            csvWriter.append("name");
            csvWriter.append(",");
            csvWriter.append("cantidad");
            csvWriter.append("\n");*/
             for (int aux = 0; aux<id.size();aux++){
                String row = id.get(aux) +","+ preco.get(aux) +","+ data_add.get(aux) +","+ nome.get(aux) +","+ cantidad.get(aux) ;
                csvWriter.append(row);
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
            System.out.println("cabo");
             break;
        }
    }

    private static void escribirEstoque(ArrayList<String> id, List<main.java.ProductoDto> productoDtoList) {
        File file = new File("C:\\Users\\valen\\Downloads\\Products\\Estoque.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { "Id", "Cantidad", "Fecha" };
            writer.writeNext(header);

            // add data to csv
            int aux = productoDtoList.size();
            for (ProductoDto producto : productoDtoList) {
              //  for (int aux = 0; aux<;aux++){
                    double cant = Math.random() * 20;
                    aux--;
                    String[] data1 = {id.get(aux), String.valueOf(cant), String.valueOf(LocalDate.now())};
                    writer.writeNext(data1);
                   // writer.writeNext("\n");
            //    }

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    /*public static int Menu() {
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
    }*/
    /*public static int menu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("1 - Buscar por codigo");
        System.out.println("2 - Buscar por nome");
        System.out.println("3 - sair");
        int res = ler.nextInt();
        return res;
    }*/
    /*public static Integer busca(ArrayList<String> l, String a){
        Integer r=0;
        for(int i=0; i<l.size(); i++){
            if(l.get(i).equals(a)){
                r = i;
            }
        }*/

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
    //    return r;
   // }




