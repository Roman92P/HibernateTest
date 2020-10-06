package pl.coderslab.repo;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public PersonDetails savePersonDetails(PersonDetails personDetails) {
        entityManager.persist(personDetails);
        return personDetails;
    }

    public void updatePersonDetails(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public PersonDetails getPersondetailsById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void removePersonDetail(PersonDetails personDetails) {
        entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }

}
