package com.owlsdonttalk.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<User> {

//    List<User> findUserByNameLike(String name);
//
//    @Query("select p from Product p " +
//            "where (p.name like :name or :name is null)")
//    List<User> findWithFilter(@Param("username") String usernameFilter);

}
