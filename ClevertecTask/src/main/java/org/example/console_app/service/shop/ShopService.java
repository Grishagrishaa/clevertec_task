package org.example.console_app.service.shop;

import org.example.console_app.dto.Receipt;
import org.example.console_app.dto.commodities.SaleCard;
import org.example.console_app.dto.commodities.api.ICommodity;
import org.example.console_app.service.shop.api.IShopService;
import org.example.console_app.service.storage.StorageService;
import org.example.console_app.service.storage.api.IStorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ShopService implements IShopService {
    private final IStorageService storageService;
    private final StringBuilder strBld;

    public ShopService() {
        this.strBld = new StringBuilder();
        this.storageService = new StorageService();
    }

    @Override
    public String getReceipt(Map<Long, Integer> idAndCount) {
        strBld.setLength(0);

        Receipt receipt = createReceipt(idAndCount);

        strBld.append( formCommoditiesList(receipt.getCommodityList()) );
        strBld.append(String.format("Total Sum - %d", receipt.getTotalSum()));

        return strBld.toString();
    }

    @Override
    public String getReceipt(Map<Long, Integer> idAndCount, Long cardNumber) {
        strBld.setLength(0);

        Receipt receipt = createReceipt(idAndCount);
        SaleCard saleCard;
        try{
            saleCard = storageService.getSaleCardByNumber(cardNumber);
        }catch (IllegalArgumentException e){
            System.out.println("SALE_CARD WASN'T FOUND");
            throw e;
        }

        strBld.append( formCommoditiesList(receipt.getCommodityList()) );
        strBld.append(String.format("Total Sum - %f", receipt.getTotalSum() * ((100.0 - saleCard.getSalePercent())/100.0)) );

        return strBld.toString();
    }

    private Receipt createReceipt(Map<Long, Integer> idAndCount){
        ArrayList<ICommodity> commodities = new ArrayList<>();
        Integer totalSum = 0;

        for (Map.Entry<Long, Integer> entry : idAndCount.entrySet()) {

            for (int i = 0; i < entry.getValue(); i++) {
                ICommodity commodity;
                try {
                    commodity = storageService.getCommodityById(entry.getKey());
                }catch (NullPointerException e){
                    System.out.println("PRODUCT WASN'T FOUND");//THERE IS NO SUCH PRODUCT
                    throw e;
                }catch (NoSuchElementException e1){//TO0 MUCH COUNT OF PRODUCTS IN COMMAND
                    System.out.println("PRODUCT IS OUT OF STOCK");
                    throw e1;
                }
                commodities.add(commodity);
                totalSum += commodity.getCost();
            }
        }

        return Receipt.Builder.create()
                .setCommodityList(commodities)
                .setTotalSum(totalSum)
                .build();
    }

    private String formCommoditiesList(List<ICommodity> commodities){
        StringBuilder strBld1 = new StringBuilder();
        int i = 0;
        for (ICommodity iCommodity : commodities) {
            strBld1.append(String.format("%d. %s___%s RUB", ++i, iCommodity.getName(), iCommodity.getCost()));
            strBld1.append('\n');
        }

        strBld1.append("------------------");
        strBld1.append('\n');

        return strBld1.toString();
    }
}
