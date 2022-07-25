package com.kirasoft.perfs.users.repositories;

import com.kirasoft.perfs.users.model.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long> {
}
