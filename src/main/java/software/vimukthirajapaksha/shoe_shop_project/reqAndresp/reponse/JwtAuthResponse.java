package software.vimukthirajapaksha.shoe_shop_project.reqAndresp.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtAuthResponse {
    private String token;
}
