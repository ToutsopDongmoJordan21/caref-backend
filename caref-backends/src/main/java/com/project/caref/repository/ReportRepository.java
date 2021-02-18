package com.project.caref.repository;

import com.project.caref.models.Report;
import com.project.caref.models.User;
import com.project.caref.models.dto.ReportDto;
import com.project.caref.models.dto.ReportResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    public Report findById(long id);

    public List<Report> findAll();

    public List<Report> findAllByUser(User user);
}
