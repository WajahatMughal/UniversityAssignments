	#include <stdio.h>
	#include <math.h>
	#include <stdlib.h>
	#include <time.h>

	int main(int argc, char *argv[])
	{
	int m; 
	int n;
	double tol;// = 0.0001;

	int i, j, iter;

	m = atoi(argv[1]);
	n = atoi(argv[2]);
	tol = atof(argv[3]);

	double t[m+2][n+2], tnew[m+1][n+1], diff, difmax;

	// printf("%d %d %lf\n",m,n, tol);

	// initialise temperature array
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
	clock_t begin = clock();
	// main loop
	iter = 0;
	difmax = 1000000.0;
	while (difmax > tol) {
		iter++;

		difmax = 0.0;
		// update temperature for next iteration
		for (i=1; i <= m; i++) {
			for (j=1; j <= n; j++) {
				tnew[i][j] = (t[i-1][j]+t[i+1][j]+t[i][j-1]+t[i][j+1])/4.0;
				
				// work out maximum difference between old and new temperatures
				diff = fabs(tnew[i][j]-t[i][j]);
				if (diff > difmax) {
					difmax = diff;
				}
				t[i][j]=tnew[i][j];
			}
		}


	}

clock_t end = clock();
double time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
FILE *out_file = fopen("result_gauss.csv", "w"); // write only 

// print results
printf("iter = %d ,  %f \n ", iter, time_spent);
// printf("Time : %f \n", time_spent);
for (i=0; i <= m+1; i++) {
	fprintf(out_file,"\n");
	for (j=0; j <= n+1; j++) {
		fprintf(out_file,"%3.5lf ", t[i][j]);
	}
}
fprintf(out_file,"\n");

	}
