import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoanTest {
    private final static Logger logger = LoggerFactory.getLogger(LoanTest.class);
    private static Member member1=null;
    private static Member member2=null;
    private static Member member3=null;
    private static Book book1=null;
    private static Book book2=null;
    private static Book book3=null;
    private static Book book4=null;

    public void generateData(){
        logger.info("初始化数据");
        
        //添加member
        member1=new Member("000001","小明",new ArrayList<Loan>());
        member2=new Member("000002","张三",new ArrayList<Loan>());
        member3=new Member("000003","静静",new ArrayList<Loan>());
        
        //添加book
        Book book1 = new Book("C01879771", "I247.57/L-911.3/2", "平凡的世界",member1);
        Book book2 = new Book("C01879772", "I247.57/L-911.3/2", "平凡的世界",null);
    	Book book3 = new Book("C01783426", "I313.45/D-918.11", "白夜行",member1);
    	Book book4 = new Book("C01783427", "I313.45/D-918.11", "白夜行",null);
    	Book book5 = new Book("C02172777", "TP312JA/S-927", "JavaEE编程及应用开发",member1);
    	Book book6 = new Book("C02172778", "TP312JA/S-927", "JavaEE编程及应用开发",null);
    	Book book7 = new Book("C01358763", "F831.9/S-372 ", "货币战争",member2);
    	Book book8 = new Book("C01358764", "F831.9/S-372 ", "货币战争",null);
    	

        //借书记录
        LocalDateTime now=LocalDateTime.now();
        Loan loan1=new Loan("1", now.minusDays(4),now.plusDays(6),null,book1,member1);
        Loan loan2=new Loan("2", now.minusDays(1),now.plusDays(5),null,book3,member1);
        Loan loan3=new Loan("3", now.minusDays(2),now.plusDays(8),null,book5,member1);
        Loan loan4=new Loan("4", now.minusDays(5),now.plusDays(5),null,book7,member2); 
        
        //借书
        member1.getLoans().add(loan1);
        member1.getLoans().add(loan2);
        member1.getLoans().add(loan3);
        member2.getLoans().add(loan4);
        
        logger.info("初始化数据完成");
    }
    
    @Test
    public void loanBook(){
        generateData();

        //正常借书
        logger.info("");
        logger.info("静静申请借书："+member3.toString());
        member3.getLoans().stream().forEach(loan -> {
            logger.info("静静借书历史："+loan.toString());
        });
        logger.info("所借书籍："+book2);
        logger.info("是否可借："+member3.CanLoan(book2));
        if(member3.CanLoan(book2)){
            Loan loan=member3.Loan(book2);
            logger.info("生成借书记录："+loan.toString());
            logger.info("所借图书状态："+book2.toString());
        }

        //正常还书
        logger.info("");
        logger.info("小明还书："+member1.toString());
        member1.getLoans().stream().forEach(loan -> {
            logger.info("小明借书历史："+loan.toString());
        });
        logger.info("要还书籍："+book1);
        member1.Return(book1);
        logger.info("已还图书状态："+book1.toString());
        
       

        //不可借同一本书
        logger.info("");
        logger.info("张三申请借书："+member2.toString());
        member2.getLoans().stream().forEach(loan -> {
            logger.info("张三借书历史："+loan.toString());
        });
        logger.info("所借书籍："+book4);
        logger.info("是否可借："+member2.CanLoan(book4));      
    }
}
