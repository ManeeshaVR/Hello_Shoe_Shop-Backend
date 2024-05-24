package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.reponse.JwtAuthResponse;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignIn;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);
}
