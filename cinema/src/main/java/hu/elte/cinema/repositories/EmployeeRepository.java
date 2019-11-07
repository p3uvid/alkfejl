/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.repositories;

import hu.elte.cinema.entities.Employee;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author p3uvid
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Optional<Employee> findByUserName(String userName);
}
