import java.util.Random;
import java.util.Scanner;

public class ProjectTaskEstimates {
	/**
	 * Global variables
	 */
	int[][] Task;
	int[] monteCarloEstimates;
	int monteCarloEstimateSize = 0;
	int taskSize = 0;
	int taskEstimateSize = 0;
	
	/**
	 * Main static function
	 */
	public static void main(String args[]){
		ProjectTaskEstimates PTE = new ProjectTaskEstimates();
		PTE.testProjectEstimate();
	}
	/**
	 * Input Function
	 */
	void testProjectEstimate(){
		//calling the task estimate initializer function
		intializeTaskEstimate();
		//calling the estimate function
		projectEstimate();
	}
	/**
	 * initializing all the Task Estimates
	 */
	void intializeTaskEstimate(){
		//initializing the scanner for user input
		Scanner inputScanner = new Scanner(System.in);
		
		//asking for the runs of montecarlo simulation user wants to do
		System.out.println("How many MonteCarlo runs do you want to do?");
		monteCarloEstimateSize = inputScanner.nextInt();
		//initializing the montecarlo estimate array
		monteCarloEstimates = new int[monteCarloEstimateSize];
		
		//asking for the number of tasks
		System.out.println("How many Tasks do you want to start?");
		taskSize = inputScanner.nextInt();
		//asking for the number of estimates per tasks
		System.out.println("How many estimates per task do you want to provide?");
		taskEstimateSize = inputScanner.nextInt();
		//initializing the task arrays
		Task = new int[taskSize][taskEstimateSize];
		
		//taking all the estimates for all tasks 
		//to initialize the tasks and get started
		for (int eachTask=0; eachTask<taskSize; eachTask++){
			for (int eachTaskEstimate=0; eachTaskEstimate<taskEstimateSize; eachTaskEstimate++){
				System.out.println("Provide Task "+(eachTask+1)+" Estimate "+(eachTaskEstimate+1)+" in # of weeks between 1 and 10");
				Task[eachTask][eachTaskEstimate] = inputScanner.nextInt();
				//invalid estimate input
				if (Task[eachTask][eachTaskEstimate]>10 || Task[eachTask][eachTaskEstimate]<1){
					//inform the user about the invalid input
					System.out.println("Input the estimate between 1 and 10");
					//get the input for the current task estimate again
					eachTaskEstimate--;
				}
			}
		}
		// closing the scanner
		inputScanner.close();
	}
	
	/**
	 * Project Estimate Function
	 * 
	 */
	
	void projectEstimate(){
		monteCarloEstimateCalculation();
		//sorting the estimate array
		java.util.Arrays.sort(monteCarloEstimates);
		//Maximum estimate 
		System.out.println("Maximum estimate "+monteCarloEstimates[monteCarloEstimateSize-1]+" weeks");
		// minimum estimate
		System.out.println("Minimum estimate "+monteCarloEstimates[0]+" weeks");
		//calculating the 95th percentile max estimate
		System.out.println("95th Percentile max estimate "+estimatePercentile(95)+" weeks");
		//calculating the 90th percentile max estimate
		System.out.println("90th Percentile max estimate "+estimatePercentile(90)+" weeks");
		//calculating the 80th percentile max estimate
		System.out.println("80th Percentile max estimate "+estimatePercentile(80)+" weeks");
		//calculating the 70th percentile max estimate
		System.out.println("70th Percentile max estimate "+estimatePercentile(70)+" weeks");
	}
	
	/**
	 * MonteCarlo Estimate Calculation function
	 */
	void monteCarloEstimateCalculation(){
		int totalProjectEstimate = 0;
		Random randomNumber = new Random();
		// each run of the monte carlo simulation
		for (int eachMonteCarloEstimate=0; eachMonteCarloEstimate<monteCarloEstimateSize; eachMonteCarloEstimate++){
			// for every task in each monte carlo simulation
			for (int eachTask=0; eachTask<taskSize; eachTask++){
				// randomly picking one estimate for each task
				int randomEstimateForTask = randomNumber.nextInt(taskEstimateSize);
				// adding the randomly picked estimate of the tak to the entire project estimate
				totalProjectEstimate += Task[eachTask][randomEstimateForTask];
			}
			// store the total Project Estimate in the Monte Carlo Estimate result array
			monteCarloEstimates[eachMonteCarloEstimate] = totalProjectEstimate;
			//initialize the totalProject Estimtate for the next run
			totalProjectEstimate=0;
		}
	}
	
	/**
	 * Calculating the percentile for the project estimate
	 */
	int estimatePercentile(int percentile){
		//calculating the index of array for the percentile 
		double index = ((double)percentile/100)*monteCarloEstimateSize;
		// returning the max value for the given percentile
		return monteCarloEstimates[(int)index-1];
	}
}
