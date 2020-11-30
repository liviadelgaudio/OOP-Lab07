package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	public OneListAcceptable(java.util.List<T> list) {
		this.list = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		// TODO Auto-generated method stub
		final Iterator<T> iterator = list.iterator();
		return new Acceptor<T>() {

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				try {
					if (newElement.equals(iterator.hasNext())){
						return;
					}
				}catch (ElementNotAcceptedException e) {
					System.out.println("Exception caused by element: " + e.getElement());
				}
				
			}

			@Override
			public void end() throws EndNotAcceptedException {
				try {
					if (!iterator.hasNext()) {
						return;
					}
				}catch (EndNotAcceptedException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		};
	}

}
