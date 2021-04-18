package invoice.management.utility;

import invoice.management.dto.Merchant;
import invoice.management.model.MerchantModel;

public class ModelConverter {
    public static Merchant convertMerchantModelToMerchantEntity(MerchantModel merchantObject) {
        Merchant merchant = new Merchant();
        merchant.setFirstName(merchantObject.getFirstName());
        merchant.setLastName(merchantObject.getLastName());
        return merchant;
    }

    public static MerchantModel convertMerchantEntityToMerchantModel(Merchant merchant) {
        MerchantModel merchantModel = new MerchantModel();
        merchantModel.setId(merchant.getId());
        merchantModel.setFirstName(merchant.getFirstName());
        merchantModel.setLastName(merchant.getLastName());
        return merchantModel;
    }
}
