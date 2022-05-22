import java.util.Arrays;

public class MyListImplementation<T> implements MyList<T> {
    private Object[] array = new Object[10];

    private int indexCurrent = 0; //nearest index for adding
    private int resizeStep = 2;

    @Override
    public void add(T value) {
        if (indexCurrent==array.length) {
            resize();
        }
        array[indexCurrent++] = value;
    }

    @Override
    public void addByIndex(T value, int indexAdd) {
        if (!checkIfIndexNegative(indexAdd) && !checkIfIndexMoreCurrent(indexAdd)) {
            if (checkIfIndexEqualCurrent(indexAdd)) {
                if (indexAdd == array.length) {
                    resize();
                }
                array[indexAdd] = value;
                indexCurrent++;
            } else { // indexAdd < indexCurrent<array.length
                int lengthOfArrayTemp = indexCurrent - indexAdd;
                Object[] arrayTemp = new Object[lengthOfArrayTemp];
                System.arraycopy(array, indexAdd, arrayTemp, 0, lengthOfArrayTemp);
                System.out.println("Temp" + Arrays.toString(array));
                array[indexAdd++] = value;
                System.arraycopy(arrayTemp, 0, array, indexAdd, lengthOfArrayTemp);

            }
            indexCurrent++;
        }
    }
   @Override
    public Object get(int index)
    { if (!checkIfIndexNegative(index)&& !checkIfIndexMoreCurrent(index)&&!checkIfIndexEqualCurrent(index))
    {return array[index];}
        else
            return "error";
    }

   @Override
   public void set(T value, int index) {
       if (!checkIfIndexNegative(index)&& !checkIfIndexMoreCurrent(index)&&!checkIfIndexEqualCurrent(index)) {
           array[index] = value;
       }
   }
    @Override
    public int indexOf(T value) {
        for (int i = 0; i < indexCurrent; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear(){
        Object[] arrayNew = new Object[10];
        array = arrayNew;
        indexCurrent = 0;
    };//удалить все элементы

    @Override
    public Object remove(int indexRemove){
        if (!checkIfIndexNegative(indexRemove)&& !checkIfIndexMoreCurrent(indexRemove)&&!checkIfIndexEqualCurrent(indexRemove)) {
              Object removedValue = array[indexRemove];
                if (indexRemove < indexCurrent - 1) {
                    for (int i = indexRemove; i < indexCurrent - 1; i++) {
                        array[i] = array[i + 1];
                    }
                }
                indexCurrent--;
            return removedValue;
        }
 return "error";
}

    @Override
    public boolean remove(T value) {
        int indexRemove = indexOf(value);
        if (indexRemove>-1){
            remove(indexRemove);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Object[] arrayTemp = new Object[indexCurrent];
        System.arraycopy(array, 0, arrayTemp, 0, indexCurrent);
        return Arrays.toString(arrayTemp);
    }

    private void resize() { // return type
        Object[] arrayTemp = new Object[resizeStep * array.length];
        System.arraycopy(array, 0, arrayTemp, 0, array.length);
        array = arrayTemp;
    }

   private boolean checkIfIndexNegative(int index) {
       if (index < 0) {
           System.out.println("Invalid index");
           return true;
       } else {
           return false;
       }
   }
   private boolean checkIfIndexMoreCurrent(int index) {
       if (index > indexCurrent) {
           System.out.println("Invalid index");
           return true;
       } else {
           return false;
       }
   }
    private boolean checkIfIndexEqualCurrent(int index){
           if (index == indexCurrent) {
               System.out.println("Invalid index");
               return true;
           } else {
               return false;
           }

   }
    public int getIndex() {
        return indexCurrent;
    }

}