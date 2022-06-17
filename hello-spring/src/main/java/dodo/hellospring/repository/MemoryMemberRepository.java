package dodo.hellospring.repository;

import dodo.hellospring.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Optional 하면 널이나와도 감쌀수있다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 자바 실무에선 리스트를 많이씀
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
