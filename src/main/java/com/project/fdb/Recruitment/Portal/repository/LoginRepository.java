package com.project.fdb.Recruitment.Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fdb.Recruitment.Portal.Model.LoginDetails;


@Repository
public interface LoginRepository extends JpaRepository<LoginDetails,Integer>{

	@Query(value = "select * from login_details where  email = :username AND password = :password",nativeQuery = true)
	public LoginDetails findByUsernameAndPassword(@Param("email") String user_name, @Param("password") String password);

	@Query(value = "select * from login_details where email = :email",nativeQuery = true)
	public LoginDetails findByEmail(@Param("email") String email);
	
	@Query(value = "Update into login_details set password =:password where email=:email",nativeQuery=true)
	public void updatePassword(@Param("email") String email, @Param("password") String password);
}
