package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.Role;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " +email));
        return UserDetailsImpl.build(user);

    }

    public User updateProfil(String id, User candidat) {

        User candidat1 = userRepository.findById(id).orElse(null);

        candidat1.setEmail(candidat.getEmail());
        String encrypted = encoder.encode(candidat.getPassword());
        candidat1.setPassword(encrypted);
        candidat1.setAdress(candidat.getAdress());
        candidat1.setFName(candidat.getFName());
        candidat1.setBirthDate(candidat.getBirthDate());    
        candidat1.setPhoto(candidat.getPhoto());
        userRepository.save(candidat1);
        return candidat1;
    }

    public ArrayList<Integer> getNombreUser()
    {
        int m=  userRepository.countByRoles(ERole.ROLE_MANAGER);
        int r=  userRepository.countByRoles(ERole.ROLE_RH);
        int c=  userRepository.countByRoles(ERole.ROLE_CANDIDAT);

        ArrayList<Integer> nb = new ArrayList<Integer>();
        nb.add(m);
        nb.add(r);
        nb.add(c);

        return nb;
    }
    public long getNombreAllUser()
    {  long w=  userRepository.count();

        return w;

    }


}
