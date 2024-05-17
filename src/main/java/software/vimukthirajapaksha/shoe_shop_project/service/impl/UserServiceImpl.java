package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import software.vimukthirajapaksha.shoe_shop_project.dao.UserRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.UserDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.UserService;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    //    private final Mapping map;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                (UserDetails) userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserDTO user) {
//        map.toUserDTO(userRepo.save(map.toUserEntity(user)));
    }

}
