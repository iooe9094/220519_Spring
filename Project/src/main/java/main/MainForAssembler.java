package main;

import Spring.Member;
import assembler.Assembler;

/**
 * packageName : Spring
 * fileName : MainForAssembler
 * author : Seok
 * date : 2022-05-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19         Seok          최초 생성
 */

public class MainForAssembler {
    public static void main(String[] args) {
        // 생성자를 이용해서 객체를 생성
//        Member member = new Member();

        Assembler assembler = new Assembler();

        Member member; // 객체정의

        member = assembler.getMember(); // 객체 생성된 것을 받음(주입)

        long value = 1;

        // setter 저장
        member.setId(value);
        member.setName("하보석");

        System.out.println(member.getId() + "" + member.getName());
    }
}