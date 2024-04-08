#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
 // Include header file for omp
    #include<omp.h>
    #include<string.h>

    #define max(a,b) \
({ __typeof__ (a) _a = (a); \
    __typeof__ (b) _b = (b); \
    _a > _b ? _a : _b; })

int main(int argc, char *argv[])
{
    int m;
    int n;
    double tol; // = 0.0001;

    int i, j, iter;

    m = atoi(argv[1]);
    n = atoi(argv[2]);
    tol = atof(argv[3]);
    int num_thread =  atoi(argv[4]);
    printf(" num threads :%d , " , num_thread);
    double t[m + 2][n + 2], tnew[m + 1][n + 1], diff, difmax;
    double diffArray[m + 1][n + 1];

    //printf("%d %d %lf\n",m,n, tol);

    // initialise temperature array
    #pragma omp parallel for collapse(2)
    for (i = 0; i <= m + 1; i++)
    {
        for (j = 0; j <= n + 1; j++)
        {
            t[i][j] = 30.0;
        }
    }

    // fix boundary conditions
    for (i = 1; i <= m; i++)
    {
        t[i][0] = 30.0;     // Left Wall
        t[i][n + 1] = 40.0; // Right Wall
    }
    for (j = 1; j <= n; j++)
    {
        t[0][j] = 100.0;    // Top Wall
        t[m + 1][j] = 20.0; // Bottom Wall
    }

    // Timing using OpenMP
	double begin = omp_get_wtime();
    // main loop
    iter = 0;
    difmax = 1000000.0;
    while (difmax > tol)
    {
        iter++;

        // update temperature for next iteration
        // PARALLEL SECTION OF THE CODE
        // Set the number of threads to the given threads and execute parallel for loop.
        #pragma omp parallel for num_threads(num_thread) collapse(2) shared(diffArray)
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
            {
                tnew[i][j] = (t[i - 1][j] + t[i + 1][j] + t[i][j - 1] + t[i][j + 1]) / 4.0;
                diffArray[i][j] = fabs(tnew[i][j] - t[i][j]);
            }
            
                
        //Residual Computation Region
        // work out maximum difference between old and new temperatures
        // PARALLEL SECTION OF THE CODE;
        // Set the number of threads to the given threads and execute parallel for loop.
        difmax = 0.0;

        #pragma omp parallel for num_threads(num_thread) collapse(2) 
        for (i = 1; i <= m; i++)
        {
            for (j = 1; j <= n; j++)
            {  
                
                // copy new to old temperatures
                t[i][j] = tnew[i][j];
                
            }
        }

        #pragma omp parallel for num_threads(num_thread) collapse(2) reduction(max:difmax) 
        for (i = 1; i <= m; i++)
        {
            for (j = 1; j <= n; j++)
            {  
                double val =diffArray[i][j];
                // copy new to old temperatures
                difmax = max(val,difmax);
            }
        }

    }

    double end = omp_get_wtime();
    double time_spent = (double)(end - begin) ;

    // FILE *out_file = fopen("result_jacobi.csv", "w"); // write only

    printf("iter = %d ,  %f \n ", iter, time_spent);

    // for (i = 0; i <= m + 1; i++)
    // {
    //     fprintf(out_file, "\n");
    //     for (j = 0; j <= n + 1; j++)
    //     {
    //         fprintf(out_file, "%3.5lf ", t[i][j]);
    //     }
    // }
    // fprintf(out_file, "\n");
}
