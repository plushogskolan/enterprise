package se.coredev.jpa.extreme.repository;

import javax.persistence.EntityManagerFactory;

import se.coredev.jpa.extreme.model.User;

public final class JpaUserRepository extends AbstractJpaRepository<User> implements UserRepository {

	public JpaUserRepository(EntityManagerFactory factory) {
		super(factory, User.class);
	}

}
