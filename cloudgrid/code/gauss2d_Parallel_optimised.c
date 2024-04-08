	#include <stdio.h>
	#include <math.h>
	#include <stdlib.h>
	#include <time.h>
    
    // Include header file for omp
    #include<omp.h>

	    #define max(a,b) \
({ __typeof__ (a) _a = (a); \
    __typeof__ (b) _b = (b); \
    _a > _b ? _a : _b; })
	int main(int argc, char *argv[])
	{
	int m; 
	int n;
	double tol;// = 0.0001;

	int i, j, iter;

	m = atoi(argv[1]);
	n = atoi(argv[2]);
	tol = atof(argv[3]);
    int num_thread = atoi(argv[4]);

	double t[m+2][n+2], tnew[m+1][n+1], diff, difmax;
	double t_temp[m+1][n+1];
	// double diffArray[32];
	double diffArray[m + 1][n + 1];
	// printf("%d %d %lf\n",m,n, tol);

	// initialise temperature array
	#pragma omp parallel for num_threads(num_thread) collapse(2)
	for (i=0; i <= m+1; i++) {
		for (j=0; j <= n+1; j++) {
			t[i][j] = 30.0;
		}
	}

		// fix boundary conditions
	for (i=1; i <= m; i++) {
		t[i][0] = 30.0;    // Left Wall
		t[i][n+1] = 40.0;  // Right Wall
	}
	for (j=1; j <= n; j++) {
		t[0][j] = 100.0;  // Top Wall
		t[m+1][j] = 20.0; // Bottom Wall
	}



    // Timing using OpenMP
	double begin = omp_get_wtime();
	// main loop
	iter = 0;
	difmax = 1000000.0;
	while (difmax > tol) {
		iter++;

		difmax = 0.0;
		// update temperature for next iteration
		omp_set_num_threads(num_thread);
		
        // PARALLEL SECTION OF THE CODE 
        // Set the number of threads to the given threads and execute parallel for loo

        #pragma omp parallel for num_threads(num_thread) schedule(static,m/num_thread * (m-2)) collapse(2) reduction(max:difmax) shared(t,tnew)
		for (i=1; i <= m; i++) {
			for (j=1; j <= n; j++) {
				tnew[i][j] = (t[i-1][j]+t[i+1][j]+t[i][j-1]+t[i][j+1])/4.0;
				
				// work out maximum difference between old and new temperatures
				diff = fabs(tnew[i][j]-t[i][j]);
				difmax = max(difmax,diff) ;
				t[i][j]=tnew[i][j];
			}
		}
		

	


        // if(iter % 100 == 0)
		// 	printf("     %f \n",difmax);
	}

double end = omp_get_wtime();
double time_spent = (double)(end - begin) ;
FILE *out_file = fopen("result_gauss.csv", "w"); // write only 

// print results
printf("numthreads : %d, iter = %d ,  %f \n ",num_thread, iter, time_spent);
// printf("Time : %f \n", time_spent);
for (i=0; i <= m+1; i++) {
	fprintf(out_file,"\n");
	for (j=0; j <= n+1; j++) {
		fprintf(out_file,"%3.5lf ", t[i][j]);
	}
}
fprintf(out_file,"\n");

	}
