package com.example.practice.service;

import com.example.practice.model.Committee;
import com.example.practice.model.Request;
import com.example.practice.model.enums.Role;
import com.example.practice.model.User;
import com.example.practice.registration.registration.token.ConfirmationToken;
import com.example.practice.registration.registration.token.ConfirmationTokenService;
import com.example.practice.repository.AppUserRepository;
import com.example.practice.repository.CommitteeRepository;
import com.example.practice.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    private CommitteeRepository comRep;

    @Autowired
    private RequestRepository reqRep;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(User user) {
        boolean userExists = appUserRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);

        appUserRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            Long user_id = appUserRepository.getUserIdByEmail(currentUserName);
            return user_id;
    }

    public void updateUser(String email){
         appUserRepository.updateRole(email , Role.ADMIN);
    }

    public List<User> findAllByEmail(String email){
       return appUserRepository.findAllByEmailLikeIgnoreCase(email);
    }

    public Long findidByEmail(String email){
        return appUserRepository.getUserIdByEmail(email);
    }

    public Optional<User> getUserById(Long userid) {
        return appUserRepository.getUserByUserid(userid);
    }

    public String ifAmICommittee(Long id){
        Role role = appUserRepository.getUserByUserid(id).get().getRole();
        if(role.equals(Role.COMMITTEE)) {
            return "Yes";
        }
        return "no";

    }

    public List<Request> myCommittee(Long id) {
       if(ifAmICommittee(id).equals("Yes")){
            List<Long> array = comRep.getIds(id);
            List<Request> total = new ArrayList<Request>();

            for(Long d : array){
                total.add(reqRep.findByRequestId(d));
            }
            return total;

        }
        return null;
}
}
