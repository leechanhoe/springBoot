package dodo.hellospring.repository;

import dodo.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
 // extends JapRepo를 하면 스프링에서 자동으로 구현체를 만들어서 빈에 넣어줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //select m from Member m where m.name = ?  findBy"Name"을 보고 name 을 찾아줌
    @Override
    Optional<Member> findByName(String name);
}
