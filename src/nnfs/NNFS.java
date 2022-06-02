package NNFS;

import java.util.Arrays;

/**
 *
 * @author Christopher Smith
 */
public class NNFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float inputs[][] = {{0, 0.1f, 1f, 2f}, {1f, 2f, -1f, 1f}, {0.2f, 0.5f, -0.6f, 0}};
        Layer l1 = new Layer(inputs[0].length, 5);
        System.out.println(l1.toString());
        float outputs[][] = l1.forward(inputs);
        Layer l2 = new Layer(l1.neurons, 2);
        Layer l3 = new Layer(l2.neurons, 10);
        float newOutputs[][] = l3.forward(l2.forward(outputs));
        System.out.println(Arrays.deepToString(newOutputs).replace("], ", "]\n"));
    }
}
