package hello.hellospring.repository;

import org.springframework.stereotype.Repository;
import hello.hellospring.domain.Member;

import java.util.*;



public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();//키-값 쌍을 저정하는 클래스
    private static long sequence = 0L; //sequence는 0,1,2 이런식으로 키값을 생성해주는 기능
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //put(key, value)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional. ofNullable(store.get(id)); //get(key)값이 null인 경우에도 Optional 객체를 생성
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //store 값들에 대한 스틂 생성
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 멤버들을 반환
    }
    public void clearStore(){
        store.clear(); //repository를 비워줌
    }
}
