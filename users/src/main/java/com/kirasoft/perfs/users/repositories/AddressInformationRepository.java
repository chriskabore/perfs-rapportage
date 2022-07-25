package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInformationRepository extends JpaRepository<AddressInformation,Long> {
}
