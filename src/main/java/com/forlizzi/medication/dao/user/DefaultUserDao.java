package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultUserDao implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

//    @Override
//    public User saveUser(String pseudoName) {
//        SqlParams params = generateInsertSql(pseudoName);
//
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(params.sql, params.source, keyHolder);
//
//        Long userPK = keyHolder.getKey().longValue();
//
//        // @formatter:off
//        return User.builder()
//                .pseudoName(pseudoName)
////                .userPK(userPK)
////                .age(age)
////                .dateOfEval(dateOfEval)
////                .dateOfDischarge(dateOfDischarge)
////                .medDxIcd(medDxIcd)
////                .txDxIcd(txDxICD)
//                .build();
//        // @formatter:on
//    }

//    private SqlParams generateInsertSql(String pseudoName) {
//        SqlParams params = new SqlParams();
//        // @formatter:off
//        String sql = ""
//                +"INSERT INTO users ("
//                + "pseudo_name"
//                + ") VALUES ("
//                + ":pseudo_name"
//                + ")";
//        // @formatter:on
//
//        params.sql = sql;
//        params.source.addValue("pseudo_name", pseudoName);
//        return params;
//    }

    @Override
    public int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                           String med_dx_icd, String tx_dx_icd) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO users ("
                + "user_pk, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd "
                + ") VALUES ("
                + ":user_pk, :pseudo_name, :age, :date_of_eval, :date_of_discharge, :med_dx_icd, :tx_dx_icd "
                + ");";
        // @formatter:on
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_pk", user_pk);
        parameters.put("pseudo_name", pseudo_name);
        parameters.put("age", age);
        parameters.put("date_of_eval", date_of_eval);
        parameters.put("date_of_discharge", date_of_discharge);
        parameters.put("med_dx_icd", med_dx_icd);
        parameters.put("tx_dx_icd", tx_dx_icd);

        return jdbcTemplate.update(sql, parameters);
    }

    @Override
    public List<User> getUser(int user_pk) {
        // formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM users "
                + "WHERE user_pk = :user_pk";
        Map<String, Object> params = new HashMap<>();
        params.put("user_pk", user_pk);

        return jdbcTemplate.query(sql, params, new RowMapper<>() {

        @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return User.builder()
                    .userPK(rs.getInt("user_pk"))
//                .pseudoName(pseudoName)
//                .age(user.getAge())
//                .dateOfEval(user.getDateOfEval())
//                .dateOfDischarge(user.getDateOfDischarge())
//                .medDxIcd(user.getMedDxIcd())
//                .txDxIcd(user.getTxDxIcd())
                    .build();
                // formatter:on
            }
        });
    }

    @Override
    public void updateUser(String newPseudoName, String oldPseudoName, int userPK) {
        SqlParams params = generateUpdateSql(newPseudoName, oldPseudoName, userPK);

        jdbcTemplate.update(params.sql, params.source);
    }

    private SqlParams generateUpdateSql(String newPseudoName, String oldPseudoName, int userPK) {
        SqlParams params = new SqlParams();
        //@formatter:off
        String sql = ""
                + ""
                + "UPDATE users "
                + "SET pseudo_name = :new_pseudo_name "
                + "WHERE pseudo_name = :old_pseudo_name "
                + "WHERE user_pk = :user_pk";
        //@formatter:on
        params.source.addValue("new_pseudo_name", newPseudoName);
        params.source.addValue("old_pseudo_name", oldPseudoName);
        params.source.addValue("user_pk", userPK);
        return params;
    }

    @Override
    public void deleteUser(int userPK) {
        //@formatter:off
        String sql = ""
                + "DELETE FROM"
                + "users "
                + "WHERE user_pk = :user_pk";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("user_pk", userPK);
        jdbcTemplate.update(sql, params);
    }

//    class UserResultSetExtractor implements ResultSetExtractor {
//        @Override
//        public User extractData(ResultSet rs) throws SQLException, DataAccessException {
//            rs.next();
//            // @formatter:off
//            return User.builder()
////                    .userPK(rs.getLong("user_pk"))
//                    .pseudoName(rs.getString("pseudo_name"))
////                    .age(rs.getInt("age"))
////                    .dateOfEval(rs.getString("date_of_eval"))
////                    .dateOfDischarge(rs.getString("date_of_discharge"))
////                    .medDxIcd(rs.getString("med_dx_icd"))
////                    .txDxIcd(rs.getString("tx_dx_icd"))
//                    .build();
//            // @formatter:on
//        }
//    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }

}