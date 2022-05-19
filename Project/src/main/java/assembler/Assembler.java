package assembler;

import Spring.Member;
import Spring.MemberDao;

/**
 * packageName : assembler
 * fileName : Assembler
 * author : Seok
 * date : 2022-05-19
 * description : 다른 클래스의 객체를 대신 생성하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         Seok          최초 생성
 */

// 의존 객체 정의
public class Assembler {
    public static void main(String[] args) {
        Member member = new Member(); // 객체 생성

        member.setEmail("iooe9094@naver.com");
        member.setName("하보석");

        System.out.println(member.getEmail() + member.getName());

        MemberDao memberDao = new MemberDao();
        memberDao.insert(member);

        Member member2; // 단순 객체 정의이므로 값은 null

        member2 = memberDao.selectByEmail("iooe9094@naver.com");
    }
}