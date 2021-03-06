package proxyband.testtask.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import proxyband.testtask.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
