#include "../stdio.h"

#define NULL        0
#define FALSE       0


void path(int, char);
int  atoi(const char *str);

int tstCases = 6;
char[20] error = "Error. Empty string";
int maxProcess = 10;
int  pid[10];                   /* array with child process IDs                          */
char *executable;               /* exec file name for exec() method                      */
char *_argv[20];                /* argv used as testing the executable                   */
int  _argc;                     /* argc also used for testing the exexutable             */
int  exitstatus;                /* exit status of the child process                      */           
int  retValue;                    /* the return value of the system call                   */
int  boolValue;                 /* variable for storing boolean values                   */



int main(int argc, char *argv[]) { 

   
    int tstCase = 0;
    char dbg_flag = 'd';

    if(argc > 1)
        tstCase = atoi(argv[1]);

    printf("Test tstCases: ARG[1] is %d \n", tstCase);

    if (tstCase) {
        path(tstCase, dbg_flag);
    }
    else {
        printf("Run all the tstCases\n");
        for (int i = 1; i <= tstCases; i++){
            path(i, dbg_flag);
		}
    }


    return 0;
}

void path(int tstCase, char dbg_flag)   
{

    /******************************************************************/                
    /* Path to the proper Test Case                                  */
    /******************************************************************/                
    switch (tstCase)
    {
		
	

        case 1: //tstCase 1
            
            /*                                                           */
            /* tstCase 2: runs exec multiple times and checks each     */
            /* child gets unique PID                                     */
            /*                                                           */
        
            
            printf("Case 1: \n");
            printf("Test Case: runs exec multiple times and checks each child gets unique PID\n");
            executable = "original.coff";
            _argv[0] = executable;
            _argv[1] = "file1.coff";
            _argv[2] = "file2.coff";
            _argc = 3;

            for (int i = 0; i <  maxProcess; i++) {
                
                pid[i] = exec(executable, _argc, _argv);
                printf("The PID %d after exec cp.coff is \n", pid[i]);
            
                for (int j = 0; j < i; ++j)  {
                    if (pid[j] == pid[i]) {
                        printf("Test Case 1: FAILED, pid[%d] equals pid[%d]\n", pid[j], pid[i]);
                        exit(-1);
                    }
					else{
						printf("Test Case passed, child proccess IDs are unique.");
					}
                }
            }

            printf("Test Case 1 ended successfully \n");

            break;


        case 2: //tstCase 2
		
		
			
            /*                                                                       */
            /* tstCase 2:  tests exec with error arguments: bad file name)         */
            /*                                                                       */
       
         
            printf("tstCase 2: tests exec with bad file extension \n");
           
            executable = "somefile.docx"; //bad file extension, a word file
            _argv[0] = executable;
            _argv[1] = NULL;
            _argc = 1; 
            
            retValue = exec(executable, _argc, _argv);
            if (retValue == -1)
                printf("Test Case 2: function returned error (-1) as expected. Test passed. \n");
            else
                printf("Test Case 2: test has failed \n");

            break;
            

        case 3: //Test Case 3 
            
            /*                                                           */
            /* tstCase 3:  tests your syscall join to a child          */
            /*                                                           */
       
            
            printf("Test Case 3: tests your syscall join to a child\n");
            
            executable = "exittest.coff";
            _argv[0] = executable;
            _argv[1] = NULL;
            _argc = 1;
           
            pid[0] = exec(executable, _argc, _argv);
            printf("Test Case 3: Child process ID is %d\n", pid[0]);
            printf("test Case 3: Issue join to get exit status of child process\n");
            retValue = join(pid[0], &exitstatus);
            if (retValue == 0) {
                printf("Test case 3: join successful, exit status is %d\n", exitstatus);
                printf("Test Case 3: ended successfully \n");
            }
            else {
                printf("Test Case 3: return value of join is %d\n", retValue);
                printf("Test Case 3: join unsuccessful \n");
            }
            
            break;

        

        case 4: //test that a non child of a process cannot join it
        
         
            /*                                                                       */
            /* case 6 : tests the syscall join to a non-child                        */
            /*                                                                       */
           
            
            printf("Test Case 4: Issue join to a non-child with pid=0\n");
            
            retValue = join(0, &exitstatus);
            if (retValue == 0) {
                printf("Test Case 4 has ended, it has failed. \n");
                break;
            }

            printf("Test Case 4: Issue join to non-child  with pid=1\n");
            retValue = join(1, &exitstatus);
            if (retValue == 0) {
                printf("Test Case 4 has ended. Result is failed.\n");
                break;
            }

            printf("Test Case 4 ended succesfully \n");
        

        

        

        case 5: //Case 5 
           
            /*                                                                       */
            /* Test Case 8: tests that your exit syscall releases all resources  and terminates thread.           */
            /*                                                                       */
            
          

            
            printf("Test Case 5: tests that your exit syscall releases all resources\n");


            i = 0;

            while(i++ < maxProcess) {
                executable = "exit.coff";
                _argv[0] = executable;
                _argv[1] = NULL;
                _argc = 1;
                
                pid[0] = exec(executable, _argc, _argv);
                printf("Test Case 5: Child process ID is %d\n", pid[0]);

                printf("Test Case 5: Issue join to get exit status of child process\n", pid[0]);
                retValue = join(pid[0], &exitstatus);
                if (retValue == 0) {
                    printf("Test Case 5: join successful, exit status is %d\n", exitstatus);
                }
                else {
                    printf("Test Case 5: return value of join is %d\n", retValue);
                    printf("Test Case 5: test failed \n");
                    boolValue = FALSE;
                    break;
                }
            }

            if (boolValue) {
                printf("Test Case 5: test has passed.\n");
            }

            break;

		case 6: //last tst Case check if last process called halts the system. not sure how to test
		
        default:
            0;
    }


}




int atoi(const char *str) {
    if (str == NULL)
        return error;

    int sum = 0;
    int i = 0;
    while(str[i] != NULL) {
        sum = sum*10 + (str[i]-'0');
        i++;
    }

    return sum;
}