package nl.zwennesm.service;

import nl.zwennesm.model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findOne(String id);
}
