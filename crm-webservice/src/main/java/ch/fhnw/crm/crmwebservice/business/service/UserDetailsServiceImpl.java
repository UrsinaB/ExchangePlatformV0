package ch.fhnw.crm.crmwebservice.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ch.fhnw.crm.crmwebservice.data.domain.Client;
import ch.fhnw.crm.crmwebservice.data.repository.ClientRepository;





@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Client client = clientRepository.findByEmail(username);
        
        if (client == null) {
            throw new UsernameNotFoundException(username);
        }
        
        UserDetails user = User.builder()
                                .username(username)
                                .password(client.getPassword())
                                .authorities("READ","ROLE_" + client.getRole())
                                .build();

        return user;
    }

    
    
}
