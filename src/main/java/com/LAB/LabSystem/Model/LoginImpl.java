package com.LAB.LabSystem.Model;

import com.LAB.LabSystem.Repo.RegisterRepo;
import com.LAB.LabSystem.Repo.RegisterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements RegisterServiceInterface {

    @Autowired
    private RegisterRepo Rrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsers(Register register) {
        String encodedPassword = passwordEncoder.encode(register.getPassword());
        register.setPassword(encodedPassword);
        Rrepo.save(register);
        return register.getEmail();
    }

    @Override
    public LoginResponse LOGIN_RESPONSE(UserLoginDTO userLoginDTO) {
        Register register = Rrepo.findByEmail(userLoginDTO.getEmail());
        if (register != null) {
            boolean isPwdRight = passwordEncoder.matches(userLoginDTO.getPassword(), register.getPassword());
            if (isPwdRight) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public UserLoginDTO LogginUser(UserLoginDTO userLoginDTO) {
        // Implement this method if necessary
        return userLoginDTO;
    }
}
