package se.coredev.jpa.extreme.repository;

import se.coredev.jpa.extreme.model.AbstractEntity;

public interface CrudRepository <E extends AbstractEntity>{

	E saveOrUpdate(E entity);
	E remove(E entity);
	E findByBy(Long id);
}
