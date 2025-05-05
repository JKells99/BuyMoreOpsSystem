package unittesting.buymoreidea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
    private Department department;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int itemQuantity;

}
