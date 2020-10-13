package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Item> item = getItem(barcodes);
        Receipt receipt = getTotalCost(item);
        return getReceipt(receipt);
    }

    private String getReceipt(Receipt receipt) {
        String output = "***<store earning no money>Receipt***\n";
        List<Item> itemList = receipt.getItem();
        for(Item currItemList: itemList){
            output += "Name: " + currItemList.getName() + ", Quantity: " + currItemList.getQuantity() + ", Unit price: " + currItemList.getUnitPrice() + " (yuan), Subtotal: " + currItemList.getSubtotal() + " (yuan)\n";
        }
        output += "----------------------\n";
        output += "Total: " + receipt.getTotal() + " (yuan)\n";
        output += "**********************";
        return output;
    }

    private Receipt getTotalCost(List<Item> item) {
        int total = 0;
        for(Item currItem: item){
            total += currItem.getSubtotal();
        }
        return new Receipt(item, total);
    }

    private List<Item> getItem(List<String> barcodes) {
        List<ItemInfo> itemInfo = ItemDataLoader.loadAllItemInfos();
        List<Item> item = setItemInfo(barcodes, itemInfo);
        return item;
    }

    private List<Item> setItemInfo(List<String> barcodes, List<ItemInfo> itemInfo) {
        List<Item> itemList = new ArrayList<>();
        List<String> barcodeNames = barcodes.stream().distinct().collect(Collectors.toList());
        for(ItemInfo currItemInfo: itemInfo){
            for(String currBarcodeName: barcodeNames){
                if(currItemInfo.getBarcode().equals(currBarcodeName)){
                    Item item = new Item(currItemInfo.getName(), Collections.frequency(barcodes, currBarcodeName),currItemInfo.getPrice(),Collections.frequency(barcodes, currBarcodeName)*currItemInfo.getPrice());
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }

}
