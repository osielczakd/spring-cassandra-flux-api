package nl.zwennesm.repository;

import nl.zwennesm.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> findOne(String id);
}
