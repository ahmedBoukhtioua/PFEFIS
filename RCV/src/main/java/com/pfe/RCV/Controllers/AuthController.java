package com.pfe.RCV.Controllers;

import com.pfe.RCV.Models.ERole;
import com.pfe.RCV.Models.Role;
import com.pfe.RCV.Models.User;
import com.pfe.RCV.Repository.RoleRepository;
import com.pfe.RCV.Repository.UserRepository;
import com.pfe.RCV.Security.Services.UserDetailsImpl;
import com.pfe.RCV.Security.Services.UserDetailsServiceImpl;
import com.pfe.RCV.Security.jwt.JwtUtils;
import com.pfe.RCV.payload.request.LoginRequest;
import com.pfe.RCV.payload.request.SignupRequest;
import com.pfe.RCV.payload.response.JwtResponse;
import com.pfe.RCV.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDetailsServiceImpl userimpl;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private static JwtResponse connectedUser;

    public static JwtResponse getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(JwtResponse connectedUser) {
        AuthController.connectedUser = connectedUser;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("*/ JWT *"+ jwt);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getfName(),signUpRequest.getEmail(),signUpRequest.getAdress(),signUpRequest.getBirthDate(),encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role RHRole = roleRepository.findByName(ERole.ROLE_CANDIDAT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(RHRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role manRole = roleRepository.findByName(ERole.ROLE_MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(manRole);

                        break;
                    default:
                        Role RHRole = roleRepository.findByName(ERole.ROLE_RH)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(RHRole);
                }
            });
        }


        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping(value = "/user/{id}" )
    public User user(@PathVariable(name = "id") String id ) {
        return userRepository.findById(id).orElse(null);
    }

        @PutMapping(value = "/updateUser/{id}")
    public void updateProf(@PathVariable String id, @RequestBody User candidat){

        userimpl.updateProfil(id, candidat);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/nombreUser")
    public ArrayList<Integer> getNombreUser(){
        return userimpl.getNombreUser();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getAllNombreUser")
    public long getAllNombreUser(){
        return userimpl.getNombreAllUser();
    }
}
