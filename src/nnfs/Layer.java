package nnfs;

/**
 *
 * @author Christopher Smith
 */
public class Layer {
    private float bias[], weights[][];
    public int inputs, neurons;
    private final float BIAS = (float) 0.2;
    public float output[][];
    
    public Layer(int inputs, int neurons){
        this.bias = new float[neurons];
        this.weights = new float[neurons][inputs];
        
        this.inputs = inputs;
        this.neurons = neurons;
        
        this.initializeLayer();
    }
    
    private void initializeLayer(){
        for (int i = 0; i < neurons; i++){
            for (int j = 0; j < inputs; j++){
                this.weights[i][j] = (float) (Math.random() * 2 - 1);
            }
            
            this.bias[i] = this.BIAS;
        }
    }
    
    public float[][] forward(float inputs[][]){
        //Transposed weight matrix
        int r1 = inputs.length, r2 = this.inputs, c1 = inputs[0].length, c2 = this.neurons;
        if (r2 != c1){throw new MatrixSizeMismatchException("Matrix Size incompatible for dot product: " + r1 + "x" + c1 + " " + r2 + "x" + c2);}
        float[][] output = new float[r1][c2];
        for (int i = 0; i < r1; i++){
            for (int j = 0; j < c2; j++){
                output[i][j] = this.bias[j];
                for (int k = 0; k < c1; k++){
                    output[i][j] += inputs[i][k] * this.weights[j][k];
                }
            }
        }
        return output;
    }
    
    @Override
    public String toString(){
        String output = "Bias :\n";
        for (float b : bias){
            output += String.format("%.4f", b) + " ";
        }
        
        output += "\n\nWeights:\n";
        for (float row[] : weights){
            for (float val : row){
                output += String.format("%.4f", val) + " ";
            }
            output += "\n";
        }
        
        return output;
    }
    
}