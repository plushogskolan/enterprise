package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;

import se.coredev.sdj.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
