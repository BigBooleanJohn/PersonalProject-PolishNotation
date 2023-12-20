
/* this is a program that performs math in  the 
scheme reverse polish style, in which the  */

public class SolutionPolish {
    /* fields */
    String operation;

    /* constructors */

    public SolutionPolish(String input) {
        this.operation = input;
    }

    /**
     * reset is a helper method to reset the array after coputation of elements
     * 
     * @Pre: none
     * 
     * @Post: none
     */
    public void reset(int start, String[] parsed) {
        /* reshifting the array after computation has been performed */
        for (int i = start; i < parsed.length - 2; i++) {
            parsed[i] = parsed[i + 2];
        }
        parsed[parsed.length - 1] = null;
        parsed[parsed.length - 2] = null;
    }

    /**
     * evalData utulized the operation field of the SolutionPolish object to modify
     * and compute the answer.
     * 
     * @Pre: this.operation is a valid String
     * 
     * @Post: returns an integer, or throws an Exception
     * 
     * @throws: exception, if input is erroneou
     */
    public int evalData() throws Exception {
        /* parse out the operators and integers */
        String[] parsed = this.operation.split("[ )(]+");
        if (parsed.length < 3 || parsed.length % 2 == 0) {
            throw new Exception("there is no computation to be performed as the input was too small");
        }
        int index = 0;
        /* while we haven't completely computed */
        while (parsed[1] != null) {
            if (parsed[index].compareTo("+") == 0) {
                parsed[index - 2] = Integer
                        .toString(Integer.parseInt(parsed[index - 2]) + Integer.parseInt(parsed[index - 1]));
                reset(index - 1, parsed);
                index = 0;
            }
            if (parsed[index].compareTo("-") == 0) {
                parsed[index - 2] = Integer
                        .toString(Integer.parseInt(parsed[index - 2]) - Integer.parseInt(parsed[index - 1]));
                reset(index - 1, parsed);
                index = 0;
            }
            if (parsed[index].compareTo("*") == 0) {
                parsed[index - 2] = Integer
                        .toString(Integer.parseInt(parsed[index - 2]) * Integer.parseInt(parsed[index - 1]));
                reset(index - 1, parsed);
                index = 0;
            }
            if (parsed[index].compareTo("/") == 0) {
                parsed[index - 2] = Integer
                        .toString(Integer.parseInt(parsed[index - 2]) / Integer.parseInt(parsed[index - 1]));
                reset(index - 1, parsed);
                index = 0;
            }
            index++;
        }
        /* return the final computed value at index 0 */
        return Integer.parseInt(parsed[0]);
    }
}