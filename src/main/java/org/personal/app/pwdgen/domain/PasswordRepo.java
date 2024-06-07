package org.personal.app.pwdgen.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
interface PasswordRepo extends JpaRepository<PasswordEntity, Long>, PagingAndSortingRepository<PasswordEntity, Long> {

    boolean existsByUcidAndName(Long userId, String name);

    Page<PasswordEntity> findAllByUcid(final Long ucid, Pageable pageable);

}
