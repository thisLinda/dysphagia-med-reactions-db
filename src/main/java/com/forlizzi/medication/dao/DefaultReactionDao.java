package com.forlizzi.medication.dao;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.Severity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class DefaultReactionDao implements ReactionDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Reaction> fetchReaction(Severity severity, String reaction) {
        log.debug("DAO: severity={}, reaction={}", severity, reaction);

        // @formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM adverse_reactions "
                + "WHERE severity = :severity AND reaction = :reaction";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("severity", severity.toString());
        params.put("reaction", reaction);

        return jdbcTemplate.query(sql, params, new RowMapper<>() {
            @Override
            public Reaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Reaction.builder()
                        .basePrice(new BigDecimal(rs.getString("base_price")))
                        .modelId(JeepModel.valueOf(rs.getString("model_id")))
                        .modelPK(rs.getLong("model_pk"))
                        .numDoors(rs.getInt("num_doors"))
                        .trimLevel(rs.getString("trim_level"))
                        .wheelSize(rs.getInt("wheel_size"))
                        .build();
                // @formatter:on
            }
        });

        return null;
    }

}