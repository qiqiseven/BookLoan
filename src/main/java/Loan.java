import java.time.LocalDateTime;

public class Loan {
	private String Id;
	private LocalDateTime LoanDate;
	private LocalDateTime DateForReturn;
	private LocalDateTime ReturnDate;
	private Book Book;
	private Member Member;
	
	public Loan() {
    }
	
	public Loan(String Id, LocalDateTime LoanDate, LocalDateTime DateForReturn, LocalDateTime ReturnDate, Book Book, Member Member) {
        this.Id =Id;
        this.LoanDate = LoanDate;
        this.DateForReturn =DateForReturn;
        this.ReturnDate = ReturnDate;
        this.Book = Book;
        this.Member = Member;
    }

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public LocalDateTime getLoanDate() {
		return LoanDate;
	}

	public void setLoanDate(LocalDateTime loanDate) {
		LoanDate = loanDate;
	}

	public LocalDateTime getDateForReturn() {
		return DateForReturn;
	}

	public void setDateForReturn(LocalDateTime dateForReturn) {
		DateForReturn = dateForReturn;
	}

	public LocalDateTime getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		ReturnDate = returnDate;
	}

	public Book getBook() {
		return Book;
	}

	public void setBook(Book book) {
		Book = book;
	}

	public Member getMember() {
		return Member;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public boolean HasNotBeenRuturned() {
		return ReturnDate == null;
	}

	public void MarkAsReturned() {
		ReturnDate = LocalDateTime.now();
	}

	   @Override
	    public String toString() {
	        return "Loan{" +
	                "Id=" + Id +
	                ",LoanDate=" + LoanDate +
	                ", DateForReturn=" + DateForReturn +
	                ", ReturnDate=" + ReturnDate +
	                ", Book=" + Book +
	                ", ΩË‘ƒ»À=" +Member.getName() +
	                '}';
	    }
}
