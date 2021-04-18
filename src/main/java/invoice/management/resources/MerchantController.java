package invoice.management.resources;

import invoice.management.model.MerchantModel;
import invoice.management.model.RegisterMerchantRequest;
import invoice.management.model.RegisterMerchantResponse;
import invoice.management.services.MerchantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static invoice.management.utility.JsonToModelConverter.getMerchantObject;


@Log4j2
@RestController
@RequestMapping("/register")
public class MerchantController {

    private MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant")
    public ResponseEntity<RegisterMerchantResponse> createInvoice(@RequestBody RegisterMerchantRequest request) {
        log.info("register merchant request received:" + request);

        MerchantModel merchantObject = getMerchantObject(request);

        MerchantModel merchantModel = merchantService.saveMerchant(merchantObject);
        RegisterMerchantResponse registerMerchantResponse = new RegisterMerchantResponse();
        registerMerchantResponse.setMerchantModel(merchantModel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(registerMerchantResponse);
    }


}
