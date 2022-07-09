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
    public User createUser(String pseudoName) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO users "
                + "model_id, trim_level, num_doors, wheel_size, base_price"
                + ") VALUES ("
                + ":model_id, :trim_level, :num_doors, :wheel_size, :base_price"
                + ");";
        // @formatter:on
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

    private SqlParams generateUpdateSql(String newPseudoName, String oldPseudoName, Long userPK) {
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
    public void updateUser(String newPseudoName, String oldPseudoName, Long userPK) {
        SqlParams params = generateUpdateSql(newPseudoName, oldPseudoName, userPK);

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

    @Override
    public void deleteUser(Long userPK) {
        //@formatter:off
        String sql = ""
                + "DELETE FROM users "
                + "WHERE user_pk = :user_pk";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("user_pk", userPK);
        // @formatter:off
        jdbcTemplate.update(sql, params);

        // do I need an if here? (throw an exception)
        // do I need generateDeleteSql?
    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }

}