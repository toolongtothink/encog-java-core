package org.encog.ensemble.bagging;

import org.encog.ensemble.EnsembleML;
import org.encog.ensemble.data.EnsembleDataSet;
import org.encog.ml.MLMethod;
import org.encog.ml.data.MLData;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;

public class BaggingML implements EnsembleML {

	private EnsembleDataSet trainingSet;
	//TODO: this needs to become a generic type
	private BasicNetwork ml;
	private MLTrain trainer;
	
	public BaggingML(MLMethod fromML) {
		setMl(fromML);
	}
	
	@Override
	public void setTrainingSet(EnsembleDataSet dataSet) {
		this.trainingSet = dataSet;
	}

	@Override
	public EnsembleDataSet getTrainingSet() {
		return trainingSet;
	}

	@Override
	public void train(double targetError, boolean verbose) {
		double error;
		int iteration=0;
		do {
			trainer.iteration();
			iteration++;
			error = trainer.getError();
			if (verbose) System.out.println(iteration + " " + error);
		} while ((error > targetError) && trainer.canContinue());
		trainer.finishTraining();
	}

	@Override
	public void setMl(MLMethod newMl) {
		ml = (BasicNetwork) newMl;
	}

	@Override
	public MLMethod getMl() {
		return ml;
	}

	public int classify(MLData input) {
		return ml.classify(input);
	}
	
	public MLData compute(MLData input) {
		return ml.compute(input);
	}

	@Override
	public int getInputCount() {
		return ml.getInputCount();
	}

	@Override
	public int getOutputCount() {
		return ml.getOutputCount();
	}

	@Override
	public void train(double targetError) {
		train(targetError, false);
		
	}
	
	public int winner(MLData input) {
		return ml.winner(input);
	}

	@Override
	public void setTraining(MLTrain train) {
		trainer = train;
	}

	@Override
	public MLTrain getTraining() {
		return trainer;
	}

	@Override
	public void trainStep() {
		trainer.iteration();
	}
}
