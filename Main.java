package Stock_Manangement_System;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String option;
//            System.out.println("""
//                     ███████╗████████╗ ██████╗  ██████╗██╗  ██╗    ███╗   ███╗ ██████╗ ███████╗ \s
//                     ██╔════╝╚══██╔══╝██╔═══██╗██╔════╝██║ ██╔╝    ████╗ ████║██╔════╝ ██╔════╝ \s
//                     ███████╗   ██║   ██║   ██║██║     █████╔╝     ██╔████╔██║██║  ███╗███████╗ \s
//                     ╚════██║   ██║   ██║   ██║██║     ██╔═██╗     ██║╚██╔╝██║██║   ██║╚════██║ \s
//                     ███████║   ██║   ╚██████╔╝╚██████╗██║  ██╗    ██║ ╚═╝ ██║╚██████╔╝███████║ \s
//                     ╚══════╝   ╚═╝    ╚═════╝  ╚═════╝╚═╝  ╚═╝    ╚═╝     ╚═╝ ╚═════╝ ╚══════╝ \s
//                     """);
//    }
//
//}


import Stock_Manangement_System.Features.*;
import Stock_Manangement_System.StockSevice.*;
import Stock_Manangement_System.StockSystem.Products;
import Stock_Manangement_System.StockSystem.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Stock_Manangement_System.Features.Help.help;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentPage = 1;
        int rowsPerPage = 2;

        List<Products> products = new ArrayList<>();
        products.add(new Products(1,"Coca",2000.0,50, LocalDate.now()));
        products.add(new Products(2,"Vigor",2500.0,100, LocalDate.now()));
        products.add(new Products(3,"Sting",2000.0,350, LocalDate.now()));
        products.add(new Products(4,"Pepsi",2000.0,18, LocalDate.now()));
        products.add(new Products(5,"Vital",1000.0,200, LocalDate.now()));
        products.add(new Products(6,"Colgate",7000.0,8, LocalDate.now()));

        do {
            System.out.println("""
                             ███████╗████████╗ ██████╗  ██████╗██╗  ██╗    ███╗   ███╗ ██████╗ ███████╗ \s
                             ██╔════╝╚══██╔══╝██╔═══██╗██╔════╝██║ ██╔╝    ████╗ ████║██╔════╝ ██╔════╝ \s
                             ███████╗   ██║   ██║   ██║██║     █████╔╝     ██╔████╔██║██║  ███╗███████╗ \s
                             ╚════██║   ██║   ██║   ██║██║     ██╔═██╗     ██║╚██╔╝██║██║   ██║╚════██║ \s
                             ███████║   ██║   ╚██████╔╝╚██████╗██║  ██╗    ██║ ╚═╝ ██║╚██████╔╝███████║ \s
                             ╚══════╝   ╚═╝    ╚═════╝  ╚═════╝╚═╝  ╚═╝    ╚═╝     ╚═╝ ╚═════╝ ╚══════╝ \s
                             """);
            System.out.println("STOCK MANAGEMENT SYSTEM");
            Table.table();

            System.out.print("Command ---> ");
            String options = scanner.nextLine();

            switch (options) {
                case "*" -> Display.display(products, currentPage, rowsPerPage);
                case "w", "W" -> Write.write(products);
                case "r", "R" -> Read.read(products);
                case "u", "U" -> Update.update(products);
                case "d", "D" -> Delete.delete(products);
                case "f", "F" -> currentPage = First.first(products, currentPage, rowsPerPage);
                case "n", "N" -> currentPage = Next.next(products, currentPage, rowsPerPage);
                case "p", "P" -> currentPage =  Previous.previous(products, currentPage, rowsPerPage);
                case "l", "L" -> currentPage = Last.last(products, currentPage, rowsPerPage);
                case "g", "G" -> currentPage = Goto.goTo(products, currentPage, rowsPerPage);
                case "s", "S" -> Search.search(products, currentPage, rowsPerPage);
                case "se", "Se" -> rowsPerPage = SetRow.setRow(products, rowsPerPage);
                case "h", "H" -> help();
                case "e", "E" -> {
                    System.out.println("Good bye");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option!");
            }
        } while (true);
    }
}
