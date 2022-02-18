package exec;

import java.util.List;

/**
 * 모든 예외를 없애보자.
 * 이 클래스의 내용은 수정하지 않는다.
 * @author itsme
 */
public class ExceptionTest {

    public static void main(String[] args) {
        ProblemClass et = new ProblemClass("홍길동");

        // 16. 다음오류의 원인과 대책은? 
        // name.toString()이 아니라 name을 print해야하고, getName에 return this.name을 해준다
        String name = et.getName();
        System.out.println(name);

        // 17. 다음 오류의 원인과 대책은? 
        // 생성자에서 this.color = color; 해줘야 함
        MyPhone mp = new MyPhone("펜텀그린");
        System.out.println(mp.color.length());

        // 18. 다음 오류의 원인과 대책은?
        // memberList 초기화 안해줌 + phone이 null인지 처리해줘야함 
        List<MyPhone> list = et.getList();
        for (MyPhone phone : list) {
        	if(phone != null)
        		System.out.println(phone.color);
        }

        // 19. 다음 오류의 원인과 대책은?
        // obj instanceof 로 각 케이스 별로 분리해야함
        int sum = et.getLengthSum();
        System.out.println(sum);

        // 20. 다음 오류의 원인과 대책은?
        // 잘 모르겠음 comparator써야하는거 같은데 해결안됨
//        et.sortPhones();

        // 21. 다음 오류의 원인과 대책은?
        // ㅡㅡ , -가 _로 바뀌어있었음
        et.parsePhoneNumber();


        // 22. 다음 오류의 원인과 대책은?
        // 0부터 나누면 안된다.
        et.divide();

        // 23. 다음 오류의 원인과 대책은?
        et.serialize();

        // 24. t1과 t2가 같은 객체가 되도록 처리하시오.
        et.singleton();

        // 25. 다음오류의 원인과 대책은?
        et.parse();

        // 26. 다음오류의 원인과 대책은?
        et.scan();

        // 27. 다음오류의 원인과 대책은? - 해당 메서드의 주석을 해제한 후 수행한다.
        et.printNameLength();

        // 28. 책의 ISBN이 같다면 한 권만 관리되어야 한다. 그렇지 않은 이유와 대책은?
        et.setTest();
    }





}
