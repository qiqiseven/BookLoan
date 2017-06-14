import java.util.ArrayList;
import java.util.List;

public class HasReachMaxSpecification implements ISpecification<Member> {
	int count=0;
	List<Loan> loans = new ArrayList<Loan>();

	@Override
	public boolean IsSatisfiedBy(Member member) {
		loans=member.getLoans();
		for(Loan l:loans){
			if(l.getReturnDate()==null)count=count+1;			
		}
		if(count<3){
			return true;
		}
		return false;
	}

}
