package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public Person getPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void removePerson(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }
}
