package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DefaultUserMedListDao implements UserMedListDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public UserMedList saveUserMedList(User user, Medication brandName) {
    SqlParams params = generateInsertSql(user, brandName);
  }

  private SqlParams generateInsertSql(User user, Medication brandName) {

  }

  @Override
  public Optional<User> fetchUser(Long userPK, String pseudoName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE user_pk = :user_pk "
            + "AND pseudo_name = :pseudo_name";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", userPK.toString());
    params.put("pseudo_name", pseudoName);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Medication> fetchBrandName(Long medPK, String brandName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM medications "
            + "WHERE medication_pk = :medication_pk "
            + "AND brand_name = :brand_name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("med_pk", medPK.toString());
    params.put("brand_name", brandName);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new BrandResultSetExtractor()));
  }

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

  class BrandResultSetExtractor implements ResultSetExtractor<Medication> {
    @Override
    public Medication extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return Medication.builder()
          .medPK(rs.getLong("med_pk"))
          .brandName(rs.getString("brand_name"))
          .hasReaction(rs.getBoolean("has_reaction"))
          .build();
      // @formatter:on
    }
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}