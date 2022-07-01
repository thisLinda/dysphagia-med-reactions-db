package com.forlizzi.medication.dao.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
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
    public List<Reaction> fetchReactions(ReactionSeverity severity, String reaction) {
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
                        .severity(ReactionSeverity.valueOf(rs.getString("severity")))
                        .reaction(rs.getString("reaction"))
                        .build();
                // @formatter:on
            }
        });
    }

}