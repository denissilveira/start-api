package tech.yotz.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.yotz.start.model.entity.Proposal;

public interface ProposalRepository extends MongoRepository<Proposal, String> {

}
