package edu.mondragon.aperez.store.repositories;

import org.springframework.data.repository.CrudRepository;
import edu.mondragon.aperez.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {}
