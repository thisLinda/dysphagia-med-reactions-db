package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultUserDao implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(String pseudoName) {
        SqlParams params = generateInsertSql(pseudoName);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(params.sql, params.source, keyHolder);

        Long userPK = keyHolder.getKey().longValue();

        // @formatter:off
        return User.builder()
                .pseudoName(pseudoName)
//                .userPK(userPK)
//                .age(age)
//                .dateOfEval(dateOfEval)
//                .dateOfDischarge(dateOfDischarge)
//                .medDxIcd(medDxIcd)
//                .txDxIcd(txDxICD)
                .build();
        // @formatter:on
    }

    @Override
    public User createUser(User user) {
        // @formatter:off
        return User.builder()
                .pseudoName(pseudoName)
//                .userPK(userPK)
//                .age(age)
//                .dateOfEval(dateOfEval)
//                .dateOfDischarge(dateOfDischarge)
//                .medDxIcd(medDxIcd)
//                .txDxIcd(txDxICD)
                .build();
        // @formatter:on
        return null;
    }

    @Override
    public User getUser(String user) {
        // formatter:off
        String sql = ""
                + "SELECT * FROM "
                + "watchlist WHERE "
                + "name = :watchlistName";
        // formatter:on

        // what's next? template or map and build?
    }

    @Override
    public void updateUser(String pseudoName) {
        SqlParams params = generateUpdateSql(pseudoName);

        jdbcTemplate.update(params.sql, params.source);
    }

    private SqlParams generateInsertSql(String pseudoName) {
        SqlParams params = new SqlParams();
        // @formatter:off
        String sql = ""
                +"INSERT INTO users ("
                + "pseudo_name"
                + ") VALUES ("
                + ":pseudo_name"
                + ")";
        // @formatter:on
        params.sql = sql;
        params.source.addValue("pseudo_name", pseudoName);
        return params;
    }

    private SqlParams generateUpdateSql(String newPseudoName, String oldPseudoName) {
        SqlParams params = new SqlParams();
        //@formatter:off
        String sql = ""
                + ""
                + "UPDATE users "
                + "SET pseudo_name = :new_pseudo_name "
                + "WHERE pseudo_name = :old_pseudo_name";
        //@formatter:on
        params.source.addValue("new_pseudo_name", newPseudoName);
        params.source.addValue("old_pseudo_name", oldPseudoName);
        return params;
    }

    @Override
    public void deleteUser(String pseudoName) {
        //@formatter:off
        String sql = ""
                + "DELETE FROM users "
                + "WHERE pseudo_name = :pseudo_name";
        //@formatter:on
        Map<String, Object> params = new HashMap<>();
        params.put("pseudo_name", pseudoName);

        jdbcTemplate.update(sql, params);
    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }

}