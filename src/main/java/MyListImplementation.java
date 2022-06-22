import java.util.Arrays;

public class MyListImplementation<T> implements MyList<T> {
    private Object[] array = new Object[10];

    private int indexCurrent = 0; //nearest index for adding
    private final int RESIZE_STEP = 2;

    @Override
    public void addByIndex(T value, int indexAdd) {
        if (!checkIfIndexNegative(indexAdd) && !checkIfIndexMoreCurrent(indexAdd)) {
                if (indexAdd == array.length) {
                    resize();
                }
                System.arraycopy(array, indexAdd, array, indexAdd+1, indexCurrent - indexAdd);
                array[indexAdd] = value;
                indexCurrent++;
        }
    }
    @Override
    public void add(T value) {
        if (indexCurrent==array.length) {
            resize();
        }
        addByIndex(value,indexCurrent);
    }

    @Override
    public T get(int index)
    { if (!checkIfIndexNegative(index)&& !checkIfIndexMoreCurrent(index)&&!checkIfIndexEqualCurrent(index)) {
        return (T)array[index];
        }
            return null;
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
            if (array[i].equals(value)) {
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
    public T remove(int indexRemove){
        if (!checkIfIndexNegative(indexRemove)&& !checkIfIndexMoreCurrent(indexRemove)&&!checkIfIndexEqualCurrent(indexRemove)) {
              T removedValue = (T)array[indexRemove];
                if (indexRemove < indexCurrent - 1) {
                    System.arraycopy(array, indexRemove+1, array, indexRemove, indexCurrent - indexRemove- 1);
                    }
                indexCurrent--;
            return removedValue;
        }
 return null;
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
        Object[] arrayTemp = new Object[RESIZE_STEP * array.length];
        System.arraycopy(array, 0, arrayTemp, 0, array.length);
        array = arrayTemp;
    }

   private boolean checkIfIndexNegative(int index) {
       if (index < 0) {
           System.out.println("Invalid index");
           return true;
       }
           return false;
   }
   private boolean checkIfIndexMoreCurrent(int index) {
       if (index > indexCurrent) {
           System.out.println("Invalid index");
           return true;
       }
           return false;
       }

    private boolean checkIfIndexEqualCurrent(int index){
           if (index == indexCurrent) {
               return true;
           }
               return false;
           }

    public int getIndex() {
        return indexCurrent;
    }

}