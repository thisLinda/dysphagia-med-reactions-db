package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
  public UserMedList saveUserMedList(User user, Medication medication) {
    SqlParams params = generateInsertSql(user, medication);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    Long userMedsListPK = keyHolder.getKey().longValue();

    // @formatter:off
    return UserMedList.builder()
            .userMedsListPK(userMedsListPK)
            .user(user)
            .medication(medication)
            .build();
    // @formatter:on

  }

  private SqlParams generateInsertSql(User user, Medication medication) {
    // @formatter:off
    String sql = ""
            +"INSERT INTO user_meds ("
            + "user_fk , med_fk"
            + ") VALUES ("
            + ":user_fk , :med_fk"
            + ")";

    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("user_fk", user.getUserPK());
    params.source.addValue("med_fk", medication.getMedPK());
    return params;
    // @formatter:on
  }

  @Override
  public Optional<User> fetchUser(Long userPK) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE user_pk = :user_pk";
    // @formatter:on
    System.out.println(userPK);
    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", userPK.toString());

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Medication> fetchMedication(Long medPK) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM medications "
            + "WHERE med_pk = :med_pk";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("med_pk", medPK.toString());

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