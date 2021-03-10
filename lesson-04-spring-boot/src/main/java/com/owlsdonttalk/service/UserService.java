package com.owlsdonttalk.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserRepr> findAll();

    Page<UserRepr> findWithFilter(String usernameFilter, Integer minAge, Integer maxAge,
                                  Integer page, Integer size);

    Optional<UserRepr> findById(Long id);

    void save(UserRepr user);

    void delete(long id);
}
