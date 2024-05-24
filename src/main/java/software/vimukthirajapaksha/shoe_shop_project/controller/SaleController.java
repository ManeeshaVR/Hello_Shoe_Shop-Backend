package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.dto.SaleDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.SaleService;

@RestController
@RequestMapping("api/v1/sale")
@RequiredArgsConstructor
public class SaleController {

    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);
    private final SaleService saleService;

    @GetMapping("/check")
    public String checkTest() {
        logger.info("Sale Checked");
        return "Sale Check Test";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveSale(@Validated @RequestBody SaleDTO saleDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        logger.info("Received request for save a sale");
        try {
            saleService.saveSale(saleDTO);
            logger.info("Request processed successfully");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
