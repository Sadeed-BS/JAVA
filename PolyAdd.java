import java.util.*;

class Term {
    int coeff;
    int power;

    Term(int coeff, int power) {
        this.coeff = coeff;
        this.power = power;
    }

    public String toString() {
        return coeff + "x^" + power;
    }
}

class StackArray {
    private Term[] stackArray;
    private int top;

    public StackArray(int size) {
        stackArray = new Term[size];
        top = -1;
    }

    public void push(Term term) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = term;
    }

    public Term pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stackArray[top--];
    }

    public Term peek() {
        if (isEmpty()) {
            return null;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public Term get(int index) {
        if (index < 0 || index > top) return null;
        return stackArray[index];
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            if (stackArray[i].coeff == 0) continue;
            System.out.print(stackArray[i]);
            if (i != top) System.out.print(" + ");
        }
        System.out.println();
    }
}

public class PolyAdd {

    public static StackArray addPolynomials(StackArray poly1, StackArray poly2) {
        Map<Integer, Integer> termMap = new HashMap<>();

      
        for (int i = 0; i < poly1.size(); i++) {
            Term term = poly1.get(i);
            termMap.put(term.power, termMap.getOrDefault(term.power, 0) + term.coeff);
        }

     
        for (int i = 0; i < poly2.size(); i++) {
            Term term = poly2.get(i);
            termMap.put(term.power, termMap.getOrDefault(term.power, 0) + term.coeff);
        }

        List<Term> resultTerms = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : termMap.entrySet()) {
            if (entry.getValue() != 0) { 
                resultTerms.add(new Term(entry.getValue(), entry.getKey()));
            }
        }

        resultTerms.sort((a, b) -> b.power - a.power); 

        
        StackArray result = new StackArray(resultTerms.size());
        for (Term t : resultTerms) {
            result.push(t);
        }

        return result;
    }

    public static StackArray inputPolynomial(Scanner sc) {
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        StackArray poly = new StackArray(n);

        System.out.println("Enter terms (coeff power):");
        for (int i = 0; i < n; i++) {
            int coeff = sc.nextInt();
            int power = sc.nextInt();
            poly.push(new Term(coeff, power));
        }
        return poly;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Polynomial 1:");
        StackArray poly1 = inputPolynomial(sc);

        System.out.println("Input Polynomial 2:");
        StackArray poly2 = inputPolynomial(sc);

        System.out.print("Polynomial 1: ");
        poly1.printStack();

        System.out.print("Polynomial 2: ");
        poly2.printStack();

        StackArray sum = addPolynomials(poly1, poly2);

        System.out.print("Sum: ");
        sum.printStack();

        sc.close();
    }
}
