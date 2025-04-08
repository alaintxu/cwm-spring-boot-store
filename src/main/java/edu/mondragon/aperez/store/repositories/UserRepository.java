package edu.mondragon.aperez.store.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.mondragon.aperez.store.dtos.UserSummary;
import edu.mondragon.aperez.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    // @EntityGraph to fetch the user with its tags only in this case, instead of using fetch EAGER
    @EntityGraph(attributePaths = {"tags", "addresses"})  // It could also be "addresses.country"
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = {"addresses"})
    @Query("select u from User u")
    List<User> findAllWithAddresses();

    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :points order by u.email")
    List<UserSummary> findLoyalUserSummaries(@Param("points") int points);
}
