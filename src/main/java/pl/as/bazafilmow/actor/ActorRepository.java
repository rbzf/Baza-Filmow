package pl.as.bazafilmow.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("SELECT a FROM Actor a WHERE a.lastName LIKE %?1% OR a.firstName LIKE %?1%")
    List<Actor> search(String keyword);
}

