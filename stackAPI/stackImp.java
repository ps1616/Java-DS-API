package stackAPI;

public class stackImp<E> implements stack<E> {

	E[] a;
	int top;
	
	  @SuppressWarnings("unchecked")
	public stackImp(int n)
	{
		a= (E[]) new Object[n];
		top=-1;
	}
	
	@Override
	public void push(E val) {
		
		a[++top]=val;
	}

	@Override
	public E pop() {
		E x= (E)a[top];
		--top;
		return (E)x;
	}

	
}
