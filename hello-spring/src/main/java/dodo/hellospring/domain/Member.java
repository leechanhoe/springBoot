package dodo.hellospring.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 직접 ID를 지정해주는것을 아이덴티티라고함
    private Long id; // 고객 id 가아니라 시스템이 정하는 id
    
    //@Column(name = "username") db 컬럼명이 username 일때 이렇게하면 매핑됨
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
