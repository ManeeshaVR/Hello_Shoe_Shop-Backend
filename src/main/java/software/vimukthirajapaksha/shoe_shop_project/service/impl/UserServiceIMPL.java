package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.vimukthirajapaksha.shoe_shop_project.dao.UserRepo;
import software.vimukthirajapaksha.shoe_shop_project.service.UserService;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
