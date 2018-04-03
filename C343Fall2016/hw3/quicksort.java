public class quicksort{

public static void quicksort(int[] array, int first, int second){
    if(second<=first || first>=second){}

    else{ 
        int pivot = array[first]; 
        int inte = first+1;
        int temp; 


        for(int j = first+1; j<= second; j++){
            if(pivot > array[j]){
                temp = array[j]; 
                array[j] = array[inte]; 
                array[inte] = temp; 

                inte++; 
            }
        }

        array[first] = array[inte-1]; 
        array[inte-1] = pivot; 

        quicksort(array, first, inte-2); 
        quicksort(array, inte, second); 
    }
}
}
