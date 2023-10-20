package Stock_Manangement_System.StockSevice;

import Stock_Manangement_System.StockSystem.Products;

import java.util.List;

import static Stock_Manangement_System.Features.Display.display;

public class Previous {
    public static int previous(List<Products> products, int currentPage, int rowsPerPage) {
        if (currentPage > 1) {
            currentPage--;
            display(products, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the first page.");
        }
        return currentPage;
    }
}