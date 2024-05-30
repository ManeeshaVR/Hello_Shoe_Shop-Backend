package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.vimukthirajapaksha.shoe_shop_project.service.AdminPanelService;

@RestController
@RequestMapping("api/v1/adminPanel")
@RequiredArgsConstructor
public class AdminPanelController {

    private static final Logger logger = LoggerFactory.getLogger(AdminPanelController.class);
    private final AdminPanelService adminPanelService;

    @GetMapping("/health")
    public String adminPanelHealth(){
        return "OK";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPanelData(){
        logger.info("Received request for get admin panel details");
        try {
            return ResponseEntity.ok(adminPanelService.getPanelData());
        }catch (Exception e){
            logger.error("An exception occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
