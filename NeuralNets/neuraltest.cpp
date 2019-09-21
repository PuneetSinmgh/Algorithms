
#include "NeuralNetwork.h"
#include <assert.h>
#include <stdlib.h>
#include <ctime>
#include <random>


int main(int argc, const char * argv[]) {    
    
    for (unsigned i = 0; i != 50; ++i) {
            
        vector<float> pred = sigmoid(dot(X, W, 4, 4, 1 ) ); // output of the neuron	
        vector<float> pred_error = y - pred;         // output delta i.e. difference of targeted and actual output values 
        vector<float> pred_delta = pred_error * sigmoid_d(pred);       
        vector<float> W_delta = dot(transpose( &X[0], 4, 4 ), pred_delta, 4, 4, 1);      
        W = W + W_delta;
    };
    return 0;
}


----------------------------------------------------------------------------------------------------------

        for ( int inputIdx = 0; inputIdx <= numInputs; inputIdx++ )
        {
            for ( int hiddenIdx = 0; hiddenIdx < numHidden; hiddenIdx++ )
            {
                int const weightIdx = GetInputHiddenWeightIndex( inputIdx, hiddenIdx );
                double const weight = normalDistribution( generator );
                m_weightsInputHidden[weightIdx] = weight;
            }
        }

        // Set weights to normally distributed random values between [-2.4 / numInputs, 2.4 / numInputs]
        for ( int32_t hiddenIdx = 0; hiddenIdx <= m_numHidden; hiddenIdx++ )
        {
            for ( int32_t outputIdx = 0; outputIdx < m_numOutputs; outputIdx++ )
            {
                int32_t const weightIdx = GetHiddenOutputWeightIndex( hiddenIdx, outputIdx );
                double const weight = normalDistribution( generator );
                m_weightsHiddenOutput[weightIdx] = weight;
            }
        }
    }