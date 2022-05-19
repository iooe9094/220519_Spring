package Spring;

import main.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// Dao + Service => 웹개발 할때 설계를 위한 이름(Naming Rule) 약속
// XXXService 역할 : 비지니스(업무) 로직이 작성되어 있는 클래스
// XXXDao 활용 + Model ( Member, RegisterMember 클래스 ) 활용 => 업무로직 짧(코딩)
@Component
public class MemberRegisterService {
//    Dao 멤버변수로 등록 : Why? CRUD( Insert, Select, Update, Delete ) 위해서
    @Autowired
    private MemberDao memberDao;

//    생성자 : Dao 객체를 생성(외부에서 매개변수를 통해 생성 : DI(의존성 주입))
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

//    regist 메소드 : 새로운 회원 등록 서비스
    public Long regist(RegisterRequest req) {
//        이메일(키값)을 가지고 검색하는 메소드를 호출
//        반환값(return) : Member 객체가 반환
        Member member = memberDao.selectByEmail(req.getEmail());

//  기존에 회원이 있으면 : member 값이 null 아님
        if(member !=null) {
//            에러를 발생시킴
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }

//        member값이 null 이면 ( 회원이 없다는 것임 )
//        Member 생성자를 호출해서 객체를 생성 : 회원 등록위한 객체 생성
        Member newMember = new Member(
                req.getEmail(),req.getPassword(), req.getName(), LocalDateTime.now()
        );

//        회원 등록 메소드를 호출
        memberDao.insert(newMember);
        return newMember.getId();
    }
}






