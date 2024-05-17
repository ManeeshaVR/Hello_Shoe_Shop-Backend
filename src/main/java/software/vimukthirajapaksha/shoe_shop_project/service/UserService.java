package software.vimukthirajapaksha.shoe_shop_project.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import software.vimukthirajapaksha.shoe_shop_project.dto.UserDTO;

public interface UserService {
    UserDetailsService userDetailsService();
    void save(UserDTO user);
}
