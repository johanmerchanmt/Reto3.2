package mintic.reto1.Repository.Crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import mintic.reto1.Model.Cookware;

public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {

}
