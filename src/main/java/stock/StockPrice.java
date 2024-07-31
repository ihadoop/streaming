package stock;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class StockPrice {

    private String code;
    private Long price;
    private Long number;
    private Long time;


    public StockPrice(){


    }
    public static StockPrice gen(){
        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(System.currentTimeMillis());
        stockPrice.setTime(System.currentTimeMillis());
        stockPrice.setCode("A");
        stockPrice.setNumber(System.currentTimeMillis());
        return stockPrice;
    }
}
