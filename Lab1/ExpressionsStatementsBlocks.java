/*
 expression
 - a construct made up of variables, operators, and method invocations
 - constructed according to the syntax of the language
 - evaluates to a single value
 - use parentheses when writing compund expressions
 statement
 - roughly equiv. to a sentence in a natural language
 - forms a complete unit of execution
 */
public class ExpressionsStatementsBlocks {
    public static void main(String[] args) {
        //int age = 20 // this expression returns an int (the assignment operator returns a value of the same type as left operand)

        //expression statements (expressions ending with a semicolon ;
        //assignment statement
        double d = 123.45;
        System.out.println("d= " + d);
        //increment statement
        d++;
        System.out.println("d= " + d);

        //method invocation statement
        System.out.println("+");

        //object creation statement
        Object name = new Object();
        System.out.println(name);

        int age = 20; //declaration statement

        //control flow statements
        if (true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}