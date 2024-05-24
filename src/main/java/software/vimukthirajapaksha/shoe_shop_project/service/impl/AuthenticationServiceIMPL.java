package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.vimukthirajapaksha.shoe_shop_project.dao.EmployeeRepo;
import software.vimukthirajapaksha.shoe_shop_project.dao.UserRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.UserDTO;
import software.vimukthirajapaksha.shoe_shop_project.entity.EmployeeEntity;
import software.vimukthirajapaksha.shoe_shop_project.entity.UserEntity;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Role;
import software.vimukthirajapaksha.shoe_shop_project.exception.NotFoundException;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.reponse.JwtAuthResponse;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignIn;
import software.vimukthirajapaksha.shoe_shop_project.reqAndresp.secure.SignUp;
import software.vimukthirajapaksha.shoe_shop_project.service.AuthenticationService;
import software.vimukthirajapaksha.shoe_shop_project.service.JWTService;
import software.vimukthirajapaksha.shoe_shop_project.util.Mapper;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {

    private final UserRepo userRepo;
    private final EmployeeRepo employeeRepo;
    private final JWTService jwtService;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        EmployeeEntity employeeEntity = employeeRepo.findByEmail(signUp.getEmail())
                .orElseThrow(() -> new NotFoundException("Employee does not exists"));
        if (employeeEntity.getAccessRole().equals(Role.ADMIN)){
            signUp.setRole("ADMIN");
        }else if (employeeEntity.getAccessRole().equals(Role.USER)){
            signUp.setRole("USER");
        }

        Optional<UserEntity> userByEmail = userRepo.findByEmail(signUp.getEmail());
        if (userByEmail.isEmpty()) {
            var buildUser = UserDTO.builder()
                    .userId(UUID.randomUUID().toString())
                    .email(signUp.getEmail())
                    .password(passwordEncoder.encode(signUp.getPassword()))
                    .role(Role.valueOf(signUp.getRole()))
                    .build();
            UserEntity userEntity = mapper.toUserEntity(buildUser);
            userEntity.setEmployeeEntity(employeeEntity);
            var savedUser = userRepo.save(userEntity);
            var genToken = jwtService.generateToken(savedUser);
            return JwtAuthResponse.builder().token(genToken).build();
        } else {
            throw new RuntimeException("User already exists");
        }
    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}