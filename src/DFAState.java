import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DFAState {
	
	public static class Builder {
		
		private Set<Character> transition;
		private List<DFAState> nextStates;
		private boolean accept;
		private boolean isStart;
		private List<Integer> idList;
		
		public Builder() {
			nextStates = new ArrayList<DFAState>();
			idList = new ArrayList<Integer>();
		}
		
		public Builder setTransition(Set<Character> transition) {
			this.transition = transition;
			return this;
		}
		
		public Builder setAccept(boolean accept) {
			this.accept = accept;
			return this;
		}
		
		public Builder setIsStart(boolean start) {
			this.isStart = start;
			return this;
		}
		
		public Builder setIdList(List<Integer> idList) {
			this.idList = idList;
			return this;
		}
		
		public Builder setNextStates(List<DFAState> nextStates) {
			this.nextStates = nextStates;
			return this;
		}
		
		public Builder addNextState(DFAState s) {
			nextStates.add(s);
			return this;
		}
		
		public Builder setFirstId(int startId) {
			this.idList.add(startId);
			return this;
		}
		
		public DFAState build() {
			return new DFAState(this);
		}
	}
	
	private Set<Character> transition;
	private List<DFAState> nextStates;
	private boolean accept;
	private boolean isStart;
	private List<Integer> idList;
	
	private DFAState(Builder b) {
		this.idList = b.idList;
		this.isStart = b.isStart;
		this.accept = b.accept;
		this.transition = b.transition;
		this.nextStates = b.nextStates;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	/**
	 * Returns the next state given a Character input 
	 * 
	 * @param c Character input to be found in a transition
	 * @return State given the provided character input
	 */
	public DFAState next(Character c) {
		DFAState nextState = null;
		
		for(DFAState d : nextStates) {
			if(d.acceptsChar(c)) {
				nextState = d;
			}
		}
		
		return nextState;
	}
	
	/**
	 * Returns the next state given a Set<Character> input
	 * 
	 * @param charSet A character set to be found in an adjacent transition
	 * @return 
	 */
	public DFAState next(Set<Character> charSet) {
		DFAState nextState = null;
		
		for(DFAState d : nextStates) {
			if(d.acceptsCharSet(charSet)) {
				nextState = d;
			}
		}
		
		return nextState;
	}
	
	public Set<Character> getTransition() {
		return transition;
	}
	
	public DFAState setTransition(Set<Character> transition) {
		this.transition = transition;
		
		return this;
	}
	
	public boolean acceptsChar(Character c) {
		return transition == null && c == null
			|| transition != null && transition.contains(c);
	}
	
	public boolean acceptsCharSet(Set<Character> charSet) {
		return transition == null && charSet == null
			|| transition != null && transition.containsAll(charSet);	// test
	}
	
	public boolean getAccept() {
		return accept;
	}
	
	public void setAccept(boolean isAccept) {
		accept = isAccept;
	}
	
	public boolean getIsStart() {
		return isStart;
	}
	
	public void setIsStart(boolean newIsStart) {
		isStart = newIsStart;
	}
	
	public void addNext(DFAState state) {
		nextStates.add(state);
	}
	
	public List<DFAState> getNextStates() {
		return nextStates;
	}
	
	public List<Integer> getIdList() {
		return idList;
	}
	
	public void addToIdList(int newId) {
		idList.add(newId);
	}
}
