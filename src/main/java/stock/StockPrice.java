package stock;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StockPrice {

    private String dateId;
    private String code;
    private Double price;
    private int number;
    private Long time;


    public static StockPrice gen(){

        return StockPrice.builder().build();
    }
}
