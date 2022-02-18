package exec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ProblemClass implements Comparable<MyPhone> {
    private  List<MyPhone> memberList = new ArrayList<MyPhone>();
    private final String file = "./phone.dat";
    
    // objs는 수정하지 않습니다.
    private Object[] objs = { "Hello", "Hi", 123, memberList, null };

    private String name;

    public ProblemClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<MyPhone> getList() {
        List<MyPhone> list = new ArrayList<>();
        list.add(null);
        list.add(new MyPhone("팬텀그린"));
        memberList.addAll(list);
        return list;
    }

    // objs안에 있는 요소들의 길이의 합을 반환하라. (문자열은 길이, 자연수는 숫자, 컬렉션은 size)
    public int getLengthSum() {
        int sum = 0;
        for (Object obj : objs) {
        	if(obj instanceof String) {
        		 String str = (String) obj;
                 sum += str.length();
        	}else if(obj instanceof Integer) {
        		sum += (Integer)obj;
        	}else if(obj instanceof Collection) {
        		sum += ((Collection) obj).size();
        	}
        }
        return sum;
    }

    public void sortPhones()  {
//    	TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator()); // 내림차순

//        TreeSet<MyPhone> mp = new TreeSet<>(new Comparator<MyPhone>() {
//			@Override
//			public int compare(MyPhone o1, MyPhone o2) {
//				return (o1.getColor().compareTo(o2.getColor())>0)? o1 : o2);
//			}
//		});
        mp.add(new MyPhone("팬텀블랙"));
        mp.add(new MyPhone("팬컴그린"));
        System.out.println(mp);
    }

    public void parsePhoneNumber() {
        String num = "010-1234-5678";
        int firstDash = num.indexOf("-");
        int lastDash = num.lastIndexOf("-");

//        System.out.println("f"+firstDash +" la"+lastDash);
        System.out.printf("전화 번호는 %s와 %s, %s로 구성되어있다.%n",num.substring(0, firstDash), num.substring(firstDash+1, lastDash), num.substring(lastDash + 1));
    }



    public void divide() {
        int num = 10;
        for(int i=num; i>0; i--) {
            System.out.print(num / i);
        }
        System.out.println();
    }

    public void serialize() {
    	try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(new File(file)))) {
    		oout.writeObject(memberList);
    		System.out.println("성공");
    	} catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void singleton() {
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        System.out.println(t1 == t2);
    }

    public void parse() {
        String name = "홍길동";
        System.out.printf("이름은 %d입니다.%n",name);
    }

    public void scan() {
        String src = "Hello";
        Scanner scanner = new Scanner(src);
        int a = scanner.nextInt();
        System.out.println(a);
    }

    public void printNameLength() {
        //Student s = new Student("홍길동");
        //System.out.println(s.name.length());
    }

    public void setTest() {
        Set<Book> set = new HashSet<>();
        set.add(new Book("123"));
        set.add(new Book("123"));
        System.out.println(set.size());
    }

	@Override
	public String toString() {
		return "ProblemClass [memberList=" + memberList + ", objs=" + Arrays.toString(objs) + ", name=" + name + "]";
	}

	@Override
	public int compareTo(MyPhone o) {
		
		return ;
	}
    
   
}
