package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.JwtAuthResponse;
import software.vimukthirajapaksha.shoe_shop_project.service.AuthenticationService;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthResponse> signIn (@RequestBody SignIn signIn){
        System.out.println(signIn);
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }

}
