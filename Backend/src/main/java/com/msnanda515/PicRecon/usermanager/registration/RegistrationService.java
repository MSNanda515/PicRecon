package com.msnanda515.PicRecon.usermanager.registration;

import com.msnanda515.PicRecon.usermanager.appuser.AppUser;
import com.msnanda515.PicRecon.usermanager.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }


        return appUserService.signUpUser(
                new AppUser()
        );
    }
}
