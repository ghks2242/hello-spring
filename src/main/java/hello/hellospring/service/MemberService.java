package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRespository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//@Service
@Transactional
public class MemberService {

    private final MemberRespository memberRespository;
//    @Autowired
    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    public long join(Member member) {
//        Optional<Member> result = memberRespository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

//        -> 좀더이쁘게 바꾸면
        validateDuplicateMember(member); // 중복회원 검증
        memberRespository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRespository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
    * 전체회원 조회
    * */
    public List<Member> findMembers() {
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
