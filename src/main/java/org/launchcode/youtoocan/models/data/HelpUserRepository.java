package org.launchcode.youtoocan.models.data;

import org.launchcode.youtoocan.models.HelpUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;


@Repository
public interface HelpUserRepository extends CrudRepository<HelpUser, Integer>{
}

