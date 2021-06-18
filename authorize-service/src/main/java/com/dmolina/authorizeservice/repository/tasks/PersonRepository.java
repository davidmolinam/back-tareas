package com.dmolina.authorizeservice.repository.tasks;

import com.dmolina.authorizeservice.models.vo.tasks.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
