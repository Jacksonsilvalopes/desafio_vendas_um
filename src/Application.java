import entities.Sale;


import services.SaleService;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Entre o caminho do arquivo: ");
        String filePath = sc.nextLine();

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {

            String line = buffer.readLine();
            Sale sale;
            SaleService saleService = new SaleService();

            while (line != null) {

                String[] saleLine = line.split(",");
                sale = new Sale(Integer.parseInt(saleLine[0]), Integer.parseInt(saleLine[1]), saleLine[2], Integer.parseInt(saleLine[3]), Double.parseDouble(saleLine[4]));
                saleService.add(sale);
                line = buffer.readLine();
            }

            saleService.summary();

            sc.close();

        } catch (IOException e) {
          System.out.println("Erro: " + filePath + " (O sistema não pode encontrar o arquivo especificado)");
        }
    }
}