/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.security;

import hu.elte.cinema.entities.Employee;
import hu.elte.cinema.repositories.EmployeeRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author p3uvid
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired 
    private AuthenticatedUser authenticatedUser;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> oUser = employeeRepository.findByUserName(username);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        Employee employee = oUser.get();
        authenticatedUser.setEmployee(employee);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(employee.toString()));

        return new org.springframework.security.core.userdetails.User(employee.getUserName(), employee.getPassword(), grantedAuthorities);
    }
}
