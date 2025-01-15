package com.kurakabe.spring.FirstSecurityApp.services;

import com.kurakabe.spring.FirstSecurityApp.models.Person;
import com.kurakabe.spring.FirstSecurityApp.repositories.PeopleRepository;
import com.kurakabe.spring.FirstSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if(person.isEmpty()) {
            throw new UsernameNotFoundException("user not found!");
        }

        return new PersonDetails(person.get());
    }
}
