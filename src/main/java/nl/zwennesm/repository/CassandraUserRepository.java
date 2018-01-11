package nl.zwennesm.repository;

import nl.zwennesm.model.User;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CassandraUserRepository implements UserRepository {

    private final ReactiveCassandraOperations cassandraTemplate;

    public CassandraUserRepository(ReactiveCassandraOperations cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public Mono<User> findOne(String id) {
        return cassandraTemplate.selectOneById(id, User.class);
    }
}
