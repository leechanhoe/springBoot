package dodo.hellospring.repository;

import dodo.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    
    private final EntityManager em; // jpa는 이걸로 모든게 동작 jpa쓸려면 이걸 주입받아야함

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find((Member.class), id); // select문 나감
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { // 단건이아니라 리스트같은건 쿼리를 작성해줘야함
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
