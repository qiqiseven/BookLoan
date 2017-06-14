import java.util.ArrayList;
import java.util.List;

public class Member {
	private String Id;
	private String Name;
	private List<Loan> Loans = new ArrayList<Loan>();
	
	public Member() {
    }
	
    public Member(String Id, String Name, List<Loan> Loans) {
        this.Id = Id;
        this.Name = Name;
        this.Loans= Loans;
    }
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Loan> getLoans() {
		return Loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		Loans = loans;
	}

	public final void Return(Book book) {
		Loan loan = FindCurrentLoanFor(book);
		if (loan != null) {
			loan.MarkAsReturned();
			book.setLoanTo(null);
			System.out.println("还书成功！");
		}
	}
	
	public final boolean CanLoan(Book book) {
		return book.getLoanTo() == null;
	}

	public final Loan Loan(Book book) {
		Loan loan =null;
		if (CanLoan(book)) {
			loan = LoanFactory.CreateLoan(book, this);
			getLoans().add(loan);
			return loan;
		}else{
			return null;
		}
	}

	public final Loan FindCurrentLoanFor(Book book) {
		 for(Loan tmp:Loans){
	            if(tmp.getBook().getId().equals(book.getId())){
	        		return tmp;	
	            }
	        }
		return null;
	}

	public boolean validate(Book wantbook) {
		HasReachMaxSpecification hasmax = new HasReachMaxSpecification();
		LoanOnlyOneSpecification onlyone = new LoanOnlyOneSpecification(wantbook);
		return (hasmax.IsSatisfiedBy(this) & onlyone.IsSatisfiedBy(this));

	}

}
