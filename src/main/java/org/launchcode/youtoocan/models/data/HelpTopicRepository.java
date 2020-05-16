package org.launchcode.youtoocan.models.data;

import org.launchcode.youtoocan.models.HelpCategory;
import org.launchcode.youtoocan.models.HelpTopic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HelpTopicRepository extends CrudRepository<HelpTopic, Integer> {
}
