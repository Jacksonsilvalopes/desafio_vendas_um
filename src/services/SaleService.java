package services;

import entities.Sale;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SaleService {

    private  List<Sale> saleList;
    public SaleService() {
        this.saleList = saleList = new ArrayList<>();
    }
    public  void add(Sale sale) {
        saleList.add(sale);
    }
    public  void summary() {

        System.out.println();
        System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");

        Comparator<Sale> comp = (s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice());
        List<Sale> sales = saleList.stream().filter(s -> s.getYear() == 2016).sorted(comp.reversed()).limit(5).toList();

        sales.forEach(System.out::println);
        System.out.println();
        System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + String.format("%.2f", getValue()));

    }

    private double getValue() {
        return saleList.stream()
                .filter(s -> s.getSeller().equals("Logan"))
                .filter(s -> s.getMonth() == 1 || s.getMonth() == 7)
                .map(s -> s.getTotal())
                .reduce(0.0, (x, y) -> x + y);
    }
}
