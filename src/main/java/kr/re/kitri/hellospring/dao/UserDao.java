package kr.re.kitri.hellospring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.re.kitri.hellospring.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User selectUserByKey(Integer userId) {
		String sql = "select * fro user where userid=?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		}, userId);
		return user;
	}
	
	public List<User> selectAllUsers() {
		List<User> listOfUser = new ArrayList<>();
		listOfUser.add(new User(1, "김순곤", 40));
		listOfUser.add(new User(2, "yoon", 30));
		listOfUser.add(new User(3, "kwon", 40));
		listOfUser.add(new User(4, "choi", 60));
		listOfUser.add(new User(5, "leee", 30));
		listOfUser.add(new User(6, "kim", 20));
		
		return listOfUser;
	}

	public User insertUser(User user) {
		String sql = "INSERT INTO user(userid, username ,age) VALUES (?,?,?)";
		jdbcTemplate.update(sql, user.getUserid(), user.getUsername(), user.getAge());
		return user;
	}
	
}




