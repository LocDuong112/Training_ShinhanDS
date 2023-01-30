package com.example.demo.repository;

import com.example.demo.dto.TodoDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoJDBCRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<TodoDto> getTodoById() {
        List<TodoDto> result = new ArrayList<>();

        // jdbcTemplate returns a List
        // Please cast to object
        result = jdbcTemplate.query(
                "select * from TODO",
                (rs, rowNum) -> new TodoDto(
                        rs.getString("title"),
                        rs.getString("detail")
                ));

        return result;
    }
}
