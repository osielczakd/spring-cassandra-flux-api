package nl.zwennesm.service;

import nl.zwennesm.model.User;
import nl.zwennesm.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> findOne(String id) {
        return userRepository.findOne(id);
    }
}
