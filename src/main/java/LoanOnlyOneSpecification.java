import java.util.ArrayList;
import java.util.List;

public class LoanOnlyOneSpecification implements ISpecification<Member> {
	private Book wantbook;

	public LoanOnlyOneSpecification(Book wantbook) {
		this.wantbook = wantbook;
	}

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		List<Loan> Loans = new ArrayList<Loan>();
		Loans = member.getLoans();
		int count=0;
		for (Loan l : Loans) {
			if (l.getBook().getId()==wantbook.getId()&&!(l.getReturnDate() == null)){
					count=count+1;				
			}			
		}
		if(count<1){
			return true;
		}
		return false;
	}

}
