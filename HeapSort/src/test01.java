
public class test01 {

	public static void main(String[] args) {
		int n = 9;
		int A[] = {2,1,2,3,7,14,15,14,4};
		
		BUILD_HEAP(A,n);
		
		//마지막 노드 없애가며 크기를 줄이기 
		for(int i= n-1; i>=0; i--) {
			//root노드와 마지막노드 swap
			int temp= A[0];
			A[0]=A[i];
			A[i]=temp; 
			
			//나머지 트리 구조 힙정렬
			HEAPIFY(A,1,i-1);
		}
		for (int i=0;i<n;i++) {
			System.out.println(A[i]);
		}
	}
	
	public static void BUILD_HEAP(int A[], int n){
		//전체 트리 구조 힙정렬
		for(int i=1;i<n;i++) {
			int c=i;
			do {
				int root =(c-1)/2;
				if(A[root]<A[c]) {
					int temp = A[root];
					A[root] = A[c];
					A[c]=temp;
				}
				c= root;
			} while(c!=0);
		}
	}
	
	public static void HEAPIFY(int A[], int a, int b) {
		int root =0;
		int temp=1;
		do {
			a = 2 * root +1; 
			//자식 중에 더 큰 값 찾기
			if (a < b && A[a]<A[a+1]) {
				a++;
			}
			//루트보다 자식이 크다면 교환
			if (a<b+1 && A[root]<A[a]) {
				temp = A[root];
				A[root]=A[a];
				A[a]=temp;
			}
			root =a;
		}while(a<b+1);
	}

}
