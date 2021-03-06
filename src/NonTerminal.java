import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We assume any symbol whose first and last characters are '<' and '>' are 
 * nonterminals. The first and follow sets of each nonterminal live here. Also 
 * contains a list of rules.
 * 
 * @author dgreenhalgh
 *
 */
public class NonTerminal extends Symbol {
	
	private List<Rule> rules = new ArrayList<Rule>();
	
	Set<NonTerminal> firstSet = new HashSet<NonTerminal>();
	Set<NonTerminal> followSet = new HashSet<NonTerminal>();
	
	public NonTerminal() {}
	
	public NonTerminal(String text) {
		super(text);
	}
	
	public NonTerminal(String text, boolean isStart) {
		super(text);
	}
	
	public List<Rule> getRules() {
		return rules;
	}
	
	public void addRule(Rule rule) {
		if(!rules.contains(rule))
			rules.add(rule);
	}

	public String toString() {
		return super.toString();
	}
}
