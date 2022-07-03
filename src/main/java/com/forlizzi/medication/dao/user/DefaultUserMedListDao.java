package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultUserMedListDao implements UserMedListDao {
  @Autowired private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public User fetchUser(String userPK) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE user_pk = :user_pk";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", userPK);

    return jdbcTemplate.query(sql, params, new CustomerResultSetExtractor());
  }

//  DefaultUserMedListDao is handling `fetchUser`
  class CustomerResultSetExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return User.builder()
          .userPK(rs.getLong("user_pk"))
          .pseudoName(rs.getString("pseudo_name"))
          .age(rs.getInt("age"))
          .dateOfEval(rs.getString("date_of_eval"))
          .dateOfDischarge(rs.getString("date_of_discharge"))
          .medDxIcd(rs.getString("med_dx_icd"))
          .txDxIcd(rs.getString("tx_dx_icd"))
          .build();
      // @formatter:on
    }
  }

}