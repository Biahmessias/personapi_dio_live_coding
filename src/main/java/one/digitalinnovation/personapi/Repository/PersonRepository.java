package one.digitalinnovation.personapi.Repository;

import one.digitalinnovation.personapi.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> {
}
