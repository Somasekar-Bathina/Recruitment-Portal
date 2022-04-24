package com.project.fdb.Recruitment.Portal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.LoginDetails;


@Repository
public interface LoginRepository extends JpaRepository<LoginDetails,Integer>{

	@Query(value = "select * from login where  email = :email AND password = :password",nativeQuery = true)
	public LoginDetails findByUsernameAndPassword(@Param("email") String user_name, @Param("password") String password);

	@Query(value = "select * from login where email = :email",nativeQuery = true)
	public LoginDetails findByEmail(@Param("email") String email);
	
	@Query(value = "Update login set password =:password where email=:email",nativeQuery=true)
	@Modifying
	@Transactional
	public void updatePassword(@Param("email") String email, @Param("password") String password);
}
