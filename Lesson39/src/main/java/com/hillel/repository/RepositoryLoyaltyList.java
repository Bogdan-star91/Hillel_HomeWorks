package com.hillel.repository;

import com.hillel.model.BonusLoyalty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLoyaltyList extends MongoRepository<BonusLoyalty, String> {
}
