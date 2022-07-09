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

//  @Override
//  public UserMedList saveUserMedList(User pseudoName, Medication brandName) {
//    SqlParams params = generateInsertSql(pseudoName, brandName);
//
//    KeyHolder keyHolder = new GeneratedKeyHolder();
//    jdbcTemplate.update(params.sql, params.source, keyHolder);
//
//    // note to self: key needs to be unique value so using PK
//    Long userMedsListPK = keyHolder.getKey().longValue();
//
//    // @formatter:off
//    return UserMedList.builder()
//            .userMedsListPK(userMedsListPK)
//            .user(pseudoName)
//            .medication(brandName)
//            .build();
//    // @formatter:on
//
//  }

  @Override
  public UserMedList saveUserMedList(User userPK, Medication medPK) {
    SqlParams params = generateInsertSql(userPK, medPK);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    // note to self: key needs to be unique value so using PK
    Long userMedsListPK = keyHolder.getKey().longValue();

    // @formatter:off
    return UserMedList.builder()
            .userMedsListPK(userMedsListPK)
            .user(userPK)
            .medication(medPK)
            .build();
    // @formatter:on

  }

  private SqlParams generateInsertSql(User userPK, Medication medPK) {
    SqlParams params = new SqlParams();
    // @formatter:off
    String sql = ""
            +"INSERT INTO user_meds_list ("
            + "user_pk , med_pk"
            + ") VALUES ("
            + ":user_pk , :med_pk"
            + ")";


    params.sql = sql;
    params.source.addValue("user_pk", userPK.getUserPK());
    params.source.addValue("med_pk", medPK.getMedPK());
    return params;
    // @formatter:on
  }

//  private SqlParams generateInsertSql(User pseudoName, Medication brandName) {
//    // @formatter:off
//    String sql = ""
//            +"INSERT INTO user_meds_list ("
//            + "pseudoName , brandName"
//            + ") VALUES ("
//            + ":pseudoName , :brandName"
//            + ")";
//
//    SqlParams params = new SqlParams();
//    params.sql = sql;
//    params.source.addValue("pseudoName", user.getPseudoName());
//    params.source.addValue("brandName", medication.getBrandName());
//    return params;
//    // @formatter:on
//  }

  @Override
  public Optional<User> fetchUser(String pseudoName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE pseudo_name = :pseudo_name";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("pseudoName", pseudoName);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Medication> fetchMedication(String brandName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM medications "
            + "WHERE brand_name = :brand_name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
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