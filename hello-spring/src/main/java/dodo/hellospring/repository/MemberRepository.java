package dodo.hellospring.repository;

import dodo.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 없으면 널이나오는데
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
