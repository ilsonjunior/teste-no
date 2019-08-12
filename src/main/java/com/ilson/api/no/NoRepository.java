package com.ilson.api.no;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NoRepository extends JpaRepository<NoEntity, Long>{
	
	@Transactional(readOnly=true)	
	@Query("SELECT new com.ilson.api.no.NoDTO(no) FROM NoEntity no WHERE no.parentId = :parentId")
	List<NoDTO> findByParentId(@Param("parentId")Long parentId);

	@Transactional(readOnly=true)
	NoEntity findByParentIdIsNull();


}
