import java.util.Stack;

public class BraceChecker {
  public boolean isValid(String braces) {
    if ((braces.length() & 1) == 1) return false;
    
    Stack<Character> open = new Stack<>();
    
    for (int i = 0; i < braces.length(); i++) {
      char brace = braces.charAt(i);
      if ((brace == '(') || (brace == '[') || (brace == '{'))
        open.push(brace);
      else {
        if (open.empty()) return false;
        
        char opend = open.pop();
        
        if (!(((opend == '(') && (brace == ')')) || ((opend == '{') && (brace == '}')) || ((opend == '[') && (brace == ']')))) return false;
      }
    }
    return open.empty();
  }
}
