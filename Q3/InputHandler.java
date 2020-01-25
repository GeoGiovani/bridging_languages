import java.util.Stack;
import java.util.StringTokenizer;
import java.lang.Runtime;
import java.io.*;

public class InputHandler {

	private static Runtime rt = Runtime.getRuntime();

	private static double getVal(String op, double op1, double op2) {
		try {
			Process proc = rt.exec("./solver " + op + " " + op1 + " " + op2);

			BufferedReader stdInput = new BufferedReader(new 
			InputStreamReader(proc.getInputStream()));
			return Double.parseDouble(stdInput.readLine());
		} catch (Exception e) {
			System.out.println("SWW");
			e.printStackTrace();
			return 0.0;
		}
	}

	private static String evaluateInfix(String exps){
		// Assume that the expression is in valid format
		MyGenericsStack<String> stack = new MyGenericsStack<String>(exps.length());

		// Break the expression into tokens
		StringTokenizer tokens = new StringTokenizer(exps, "()*/+-", true);

		while(tokens.hasMoreTokens()){
			String tkn = tokens.nextToken();

			// Read each token and take action
			if(tkn.equals("(")
					|| tkn.matches("[0-9](.[0-9])?")
					|| tkn.equals("*")
					|| tkn.equals("/")
					|| tkn.equals("+")
					|| tkn.equals("-")) {
				stack.push(tkn);
			} else if(tkn.equals(")")){
				try {
					double op2 = Double.parseDouble(stack.pop());
					String oprnd = stack.pop();
					double op1 = Double.parseDouble(stack.pop());
					/**Below pop removes either } or ) from stack**/
					if(!stack.isStackEmpty()){
						stack.pop();
					}
					double result = 0;
					if(oprnd.equals("*")){
						result = getVal("*", op1, op2);
					} else if(oprnd.equals("/")){
						result = getVal("/", op1, op2);
					} else if(oprnd.equals("+")){
						result = getVal("+", op1, op2);
					} else if(oprnd.equals("-")){
						result = getVal("-", op1, op2);
					}

					/**push the result to the stack**/
					stack.push(result + "");
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}
		String finalResult = "";
		try {
			finalResult = stack.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalResult;
	}

	// CLI driver invoke method
	public static void main(String args[]) {

		if (args.length != 1) {
			System.out.println("Argument count isn't 1, exiting...");
			return;
		}

		System.out.println(evaluateInfix(args[0]));
	}
}

/**
 * Stack implementation
 */
class MyGenericsStack<T extends Object> {

	private int stackSize;
	private T[] stackArr;
	private int top;

	/**
	 * constructor to create stack with size
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public MyGenericsStack(int size) {
		this.stackSize = size;
		this.stackArr = (T[]) new Object[stackSize];
		this.top = -1;
	}

	/**
	 * This method adds new entry to the top
	 * of the stack
	 * @param entry
	 * @throws Exception
	 */
	public void push(T entry){
		if(this.isStackFull()){
			this.increaseStackCapacity();
		}
		this.stackArr[++top] = entry;
	}

	/**
	 * This method removes an entry from the
	 * top of the stack.
	 * @return
	 * @throws Exception
	 */
	public T pop() throws Exception {
		if(this.isStackEmpty()){
			throw new Exception("Stack is empty. Can not remove element.");
		}
		T entry = this.stackArr[top--];
		return entry;
	}

	/**
	 * This method returns top of the stack
	 * without removing it.
	 * @return
	 */
	public T peek() {
		return stackArr[top];
	}

	private void increaseStackCapacity(){

		@SuppressWarnings("unchecked")
		T[] newStack = (T[]) new Object[this.stackSize*2];
		for(int i=0;i<stackSize;i++){
			newStack[i] = this.stackArr[i];
		}
		this.stackArr = newStack;
		this.stackSize = this.stackSize*2;
	}

	/**
	 * This method returns true if the stack is
	 * empty
	 * @return
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}

	/**
	 * This method returns true if the stack is full
	 * @return
	 */
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}
}