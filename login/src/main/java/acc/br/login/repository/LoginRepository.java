package acc.br.login.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import acc.br.login.entity.LoginEntity;


public interface LoginRepository extends CrudRepository<LoginEntity, Long>{

	LoginEntity findById(long id);
	
	@Query (value="select * from login.login_entity where username = :username and password = :password", nativeQuery = true)
	public LoginEntity login(String username, String password);
}
