package edu.mondragon.aperez.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.mondragon.aperez.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths = {"user"})
    List<Profile> findByLoyaltyPointsGreaterThan(int points);

    @EntityGraph(attributePaths = {"user"})
    List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(int points);

    @EntityGraph(attributePaths = {"user"})
    @Query("select p from Profile p where p.loyaltyPoints > :points order by p.user.email")
    List<Profile> findLoyalProfiles(@Param("points") int points);
}
