package com.company.timetable.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "OCCUPATION", indexes = {
        @Index(name = "IDX_OCCUPATION_AUDIENCE_ID", columnList = "AUDIENCE_ID"),
        @Index(name = "IDX_OCCUPATION_TEACHER_ID", columnList = "TEACHER_ID")
})
@Entity
public class Occupation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Size(message = "{msg://com.company.timetable.entity/Occupation.group.validation.Size}", min = 1, max = 10)
    @NotNull(message = "{msg://com.company.timetable.entity/Occupation.group.validation.NotNull}")
    @JoinTable(name = "OCCUPATION_GROUP_LINK",
            joinColumns = @JoinColumn(name = "OCCUPATION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"))
    @ManyToMany
    @OnDelete(DeletePolicy.UNLINK)
    private List<Group> group;

    @NotNull(message = "{msg://com.company.timetable.entity/Occupation.teacher.validation.NotNull}")
    @JoinColumn(name = "TEACHER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @NotNull(message = "{msg://com.company.timetable.entity/Occupation.audience.validation.NotNull}")
    @OnDelete(DeletePolicy.UNLINK)
    @JoinColumn(name = "AUDIENCE_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Audience audience;

    @NotNull
    @Column(name = "DATE_", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "TIME_", nullable = false)
    private LocalTime time;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<Group> getGroup() {
        return group;
    }

    public String toString(){
        String s = "";
        for(int i=0; i<group.size(); i++) {
            s += group.get(i) + " ";
        }
        return s;
    }
    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}