public interface ISpecification<T> {
	boolean IsSatisfiedBy(T entity);
}
