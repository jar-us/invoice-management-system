package invoice.management.services;

import invoice.management.dto.Merchant;
import invoice.management.model.MerchantModel;
import invoice.management.repo.MerchantRepo;
import org.springframework.stereotype.Service;

import static invoice.management.utility.ModelConverter.convertMerchantEntityToMerchantModel;
import static invoice.management.utility.ModelConverter.convertMerchantModelToMerchantEntity;

@Service
public class MerchantService {

    private MerchantRepo merchantRepo;

    public MerchantService(MerchantRepo merchantRepo) {
        this.merchantRepo = merchantRepo;
    }

    public MerchantModel saveMerchant(MerchantModel merchantObject) {
        Merchant merchant = convertMerchantModelToMerchantEntity(merchantObject);
        Merchant savedMerchant = merchantRepo.save(merchant);
        MerchantModel merchantModel = convertMerchantEntityToMerchantModel(savedMerchant);
        return merchantModel;
    }
}
