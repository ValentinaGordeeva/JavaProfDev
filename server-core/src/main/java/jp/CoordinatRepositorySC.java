package jp;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface CoordinatRepositorySC extends CrudRepository<CoordinatTableSC, Integer> {
        }

