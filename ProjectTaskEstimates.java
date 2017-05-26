import java.util.Random;

public class ProjectTaskEstimates {
	/**
	 * Global variables
	 */
	int[][] Task;
	int[] monteCarloEstimates;
	final int monteCarloEstimateSize = 10000;
	final int taskSize = 10;
	final int taskEstimateSize = 10;
	
	/**
	 * Constructor
	 */
	ProjectTaskEstimates(){
		//initializing for 10 tasks and 10 estimates 
		Task = new int[taskSize][taskEstimateSize];
		//initializing Monte Carlo estimates to be 100
		monteCarloEstimates = new int[monteCarloEstimateSize];
	}
	
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
		//input all estimates (between 1-10) for all the tasks
		/**
		 * Task 1
		 */
		Task[0][0] = 6;
		Task[0][1] = 3;
		Task[0][2] = 5;	
		Task[0][3] = 1;
		Task[0][4] = 8;
		Task[0][5] = 9;
		Task[0][6] = 4;
		Task[0][7] = 2;
		Task[0][8] = 7;
		Task[0][9] = 10;
		/**
		 * Task 2
		 */
		Task[1][0] = 6;
		Task[1][1] = 3;
		Task[1][2] = 5;
		Task[1][3] = 1;
		Task[1][4] = 8;
		Task[1][5] = 9;
		Task[1][6] = 4;
		Task[1][7] = 2;
		Task[1][8] = 7;
		Task[1][9] = 10;
		/**
		 *  Task 3
		 */
		Task[2][0] = 6;
		Task[2][1] = 3;
		Task[2][2] = 5;
		Task[2][3] = 1;
		Task[2][4] = 8;
		Task[2][5] = 9;
		Task[2][6] = 4;
		Task[2][7] = 2;
		Task[2][8] = 7;
		Task[2][9] = 10;
		/**
		 * Task 4
		 */
		Task[3][0] = 6;
		Task[3][1] = 3;
		Task[3][2] = 5;
		Task[3][3] = 1;
		Task[3][4] = 8;
		Task[3][5] = 9;
		Task[3][6] = 4;
		Task[3][7] = 2;
		Task[3][8] = 7;
		Task[3][9] = 10;
		/**
		 * Task 5
		 */
		Task[4][0] = 6;
		Task[4][1] = 3;
		Task[4][2] = 5;
		Task[4][3] = 1;
		Task[4][4] = 8;
		Task[4][5] = 9;
		Task[4][6] = 4;
		Task[4][7] = 2;
		Task[4][8] = 7;
		Task[4][9] = 10;
		/**
		 * Task 6
		 */
		Task[5][0] = 6;
		Task[5][1] = 3;
		Task[5][2] = 5;
		Task[5][3] = 1;
		Task[5][4] = 8;
		Task[5][5] = 9;
		Task[5][6] = 4;
		Task[5][7] = 2;
		Task[5][8] = 7;
		Task[5][9] = 10;
		/**
		 * Task 7
		 */
		Task[6][0] = 6;
		Task[6][1] = 3;
		Task[6][2] = 5;
		Task[6][3] = 1;
		Task[6][4] = 8;
		Task[6][5] = 9;
		Task[6][6] = 4;
		Task[6][7] = 2;
		Task[6][8] = 7;
		Task[6][9] = 10;
		/**
		 * Task 8
		 */
		Task[7][0] = 6;
		Task[7][1] = 3;
		Task[7][2] = 5;
		Task[7][3] = 1;
		Task[7][4] = 8;
		Task[7][5] = 9;
		Task[7][6] = 4;
		Task[7][7] = 2;
		Task[7][8] = 7;
		Task[7][9] = 10;
		/**
		 * Task 9
		 */
		Task[8][0] = 6;
		Task[8][1] = 3;
		Task[8][2] = 5;
		Task[8][3] = 1;
		Task[8][4] = 8;
		Task[8][5] = 9;
		Task[8][6] = 4;
		Task[8][7] = 2;
		Task[8][8] = 7;
		Task[8][9] = 10;
		/**
		 * Task 10
		 */
		Task[9][0] = 6;
		Task[9][1] = 3;
		Task[9][2] = 5;
		Task[9][3] = 1;
		Task[9][4] = 8;
		Task[9][5] = 9;
		Task[9][6] = 4;
		Task[9][7] = 2;
		Task[9][8] = 7;
		Task[9][9] = 10;
	}
	
	/**
	 * Project Estimate Function
	 * 
	 */
	
	void projectEstimate(){
		monteCarloEstimateCalculation();
		java.util.Arrays.sort(monteCarloEstimates);
		System.out.println("Maximum estimate "+monteCarloEstimates[monteCarloEstimateSize-1]+" weeks");
		System.out.println("Minimum estimate "+monteCarloEstimates[0]+" weeks");
		System.out.println("95th Percentile estimate "+estimatePercentile(95)+" weeks");
		System.out.println("90th Percentile estimate "+estimatePercentile(90)+" weeks");
		System.out.println("80th Percentile estimate "+estimatePercentile(80)+" weeks");
		System.out.println("70th Percentile estimate "+estimatePercentile(70)+" weeks");
	}
	
	/**
	 * MonteCarlo Estimate Calculation function
	 */
	void monteCarloEstimateCalculation(){
		int totalProjectEstimate = 0;
		Random randomNumber = new Random();
		for (int eachMonteCarloEstimate=0; eachMonteCarloEstimate<monteCarloEstimateSize; eachMonteCarloEstimate++){
			for (int eachTask=0; eachTask<taskSize; eachTask++){
				int randomEstimateForTask = randomNumber.nextInt(taskEstimateSize);
				totalProjectEstimate += Task[eachTask][randomEstimateForTask];
			}
			monteCarloEstimates[eachMonteCarloEstimate] = totalProjectEstimate;
			totalProjectEstimate=0;
		}
	}
	
	/**
	 * Calculating the percentile for the project estimate
	 */
	int estimatePercentile(int percentile){
		//calculating the index of array for the percentile 
		double index = ((double)percentile/100)*monteCarloEstimateSize;
		return monteCarloEstimates[(int)index-1];
	}
}
