include<iostream>

using namespace std;

//the structure to represent the BST BSTNode
struct BSTNode
{
    int nodeKey;
    struct BSTNode *leftBranch, *rightBranch;
};

//the auxilary fuunction to be used in insert function
struct BSTNode *createNew(int data)
{
    struct BSTNode *temp =  (struct BSTNode *)malloc(sizeof(struct BSTNode));
    temp->nodeKey = data;
    temp->leftBranch = temp->rightBranch = NULL;
    return temp;
}

//The serch and comparion return function
int iterativeSearch(struct BSTNode *bstRoot, int k)
{
       int count=0;

    while (bstRoot != NULL)
    {
              if(k == bstRoot->nodeKey)
              {
                     return count;
              }

        else if (k > bstRoot->nodeKey)
              {
                     count++;
            bstRoot = bstRoot->rightBranch;
              }
        
               else
              {
                     count++;
            bstRoot = bstRoot->leftBranch;
              }
    }

    return count;
}


//The insert function
struct BSTNode* insert(struct BSTNode* BSTNode, int nodeKey)
{
    if (BSTNode == NULL) return createNew(nodeKey);

    if (nodeKey < BSTNode->nodeKey)
        BSTNode->leftBranch  = insert(BSTNode->leftBranch, nodeKey);
    else
        BSTNode->rightBranch = insert(BSTNode->rightBranch, nodeKey);

    return BSTNode;
}

//the depth finding function
int bstDepth(struct BSTNode* BSTNode)
{
   if (BSTNode==NULL)
       return 0;
   else
   {

       int lDepth = bstDepth(BSTNode->leftBranch);
       int rDepth = bstDepth(BSTNode->rightBranch);
        if (lDepth > rDepth)
           return(lDepth+1);
       else return(rDepth+1);
   }
}

//The sequential comparison count function
int SequentialComp(int arr[], int k, int n)
{
       int c=0;
       for(int i=0; i<n; i++)
       {
              if(arr[i]==k)
                     return c;
              else
                     c++;
       }
}


int main()
{
       int A[100], B[10000];

       //for unsuccessful searches
       
       //create the Array A
       for (int i = 0; i < 100; ++i)
       {
              int num = rand() % 1000000;
              bool status=0;

              while(status==0)
              {
                     
                     status=1;
                     for(int j=0; j<i;j++)
                     {
                           if(num==A[j])
                           {
                                  status=0;
                                  break;
                           }
                     }
                     if(status==1)
                     {
                           A[i]=num;
                     }
              }
       }

       //create the arry B
       for (int i = 0; i < 10000; i++)
       {
              int num = rand() % 1000000;
              bool status=0;

              while(status==0)
              {
                     status=1;
                     for(int j=0; j<i;j++)
                     {
                           if(num==B[j])
                           {
                                  status=0;
                                  break;
                           }
                     }

                     for(int j=0; j<100;j++)
                     {
                           if(num==A[j])
                           {
                                  status=0;
                                  break;
                           }
                     }

                     if(status==1)
                     {
                           B[i]=num;
                     }
                     num = rand() % 1000000;
              }
       }


       //create the tree
    struct BSTNode *bstRoot = NULL;

       //perform the insertion
       for(int i=0; i<10000; i++)
       {
              bstRoot = insert(bstRoot, B[i]);
       }

       //cout<<"print the height"
       cout<<"Height of the tree: "<<bstDepth(bstRoot)<<endl<<endl;

       //compute the comparison in BST

       int comparison=0;

       for(int i=0; i<100; i++)
       {
       
                  comparison+=iterativeSearch(bstRoot, A[i]);
       }
       cout<<"For unsuccessful search\n"<<endl;
       cout<<"Comparisons made in BST is: "<<comparison<<endl;


       int comparisonArr=0;

       for(int i=0; i<100; i++)
       {
       
                  comparisonArr+=SequentialComp(B, A[i], 10000);
       }

       cout<<"Comparisons made in sequential search is: "<<comparisonArr<<endl;


       cout<<"\n\nFor successful searches"<<endl;
       
       
       //for successful searches
       //create the array A
       for (int i = 0; i < 100; ++i)
       {
              int num = rand() % 10000;
              A[i]=B[num];
       }


       int comparison1=0;

       for(int i=0; i<100; i++)
       {
       
                  comparison1+=iterativeSearch(bstRoot, A[i]);
       }

       cout<<"Comparisons made in BST is: "<<comparison1<<endl;


       int comparisonArr1=0;

       for(int i=0; i<100; i++)
       {
       
                  comparisonArr1+=SequentialComp(B, A[i], 10000);
       }

       cout<<"Comparisons made in sequential search is: "<<comparisonArr1<<endl;

       

       system("pause");
    return 0;
}