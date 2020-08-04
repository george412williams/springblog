package repositories;


import models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    // Ad is the reference type of the entity to CRUD
    // long is the ref type for the primary key of Ad
    // now for concept:  ______
        // after adding Ad controller for url testing getting data from ad table

}
