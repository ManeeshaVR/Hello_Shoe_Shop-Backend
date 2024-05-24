package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.reponse.JwtAuthResponse;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignIn;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignUp;
import software.vimukthirajapaksha.shoe_shop_project.service.AuthenticationService;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }

}