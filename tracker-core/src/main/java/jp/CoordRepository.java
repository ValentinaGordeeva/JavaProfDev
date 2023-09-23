package jp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CoordRepository extends CrudRepository<CoordinatesTable, Integer> {
}


