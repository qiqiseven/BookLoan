public class Book {
	private String Id;
	private String ISBN;
	private String Title;
	private Member LoanTo;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Member getLoanTo() {
		return LoanTo;
	}
	public void setLoanTo(Member value) {
		LoanTo = value;
	}
	
    public Book(String Id, String ISBN, String Title, Member LoanTo) {
        this.Id = Id;
        this.ISBN = ISBN;
        this.Title = Title;
        this.LoanTo = LoanTo;
    }

}
