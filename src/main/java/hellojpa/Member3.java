package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member3 {

    @Id
    private Long id;

    //@Column(name= "name", insertable = false, updatable = false, nullable = false)
    // updatable = false 하면 값이 변경되지 않게 해줌.
    // nullable = false 하면 not null
    // unique = ture 제약 조건 만들어줌 잘안씀.
    // columnDefinition = "varchar(100) default 'EMPTY'" 직접 컬럼 정보 줌.
    @Column(name= "name")
    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 과거버젼 날짜
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP) // 과거버젼 날짜
    private Date lostModifiedDate;

    private LocalDate testLocalDate;

    private LocalDateTime testLocalDatetime; // 최신 버전 날짜

    @Lob
    private String description;

    @Transient // 디비 반영 안됨
    private int temp;

    public Member3() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLostModifiedDate() {
        return lostModifiedDate;
    }

    public void setLostModifiedDate(Date lostModifiedDate) {
        this.lostModifiedDate = lostModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
