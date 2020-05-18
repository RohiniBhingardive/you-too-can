package org.launchcode.youtoocan.models.data;


import org.launchcode.youtoocan.models.HelpCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpCategoryRepository extends CrudRepository<HelpCategory, Integer>{
}
