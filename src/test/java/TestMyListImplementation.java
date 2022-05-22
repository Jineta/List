import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
public class TestMyListImplementation {
    @Test
    public void Add(){
      Integer[] listExpected = new Integer[10];
        for (int i = 0; i < 2; i++) {
            listExpected[i]=i;
        }
        MyListImplementation<Integer> listActual = new MyListImplementation<>();
           for (int i = 0; i < 2; i++) {
            listActual.add(i);
        }
        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(listExpected[i], listActual.get(i));
        }
    }

    @Test
    public void Add11(){
        String[] listExpected = new String[20];
        for (int i = 0; i < 12; i++) {
            listExpected[i]="El"+i;
        }
        MyListImplementation<String> listActual = new MyListImplementation<>();
        for (int i = 0; i < 12; i++) {
            listActual.add("El"+i);
        }
        for (int i = 0; i < 20; i++) {
            Assertions.assertEquals(listExpected[i], listActual.get(i));
        }
    }

    @Test
    public void AddByIndex_first(){
        String[] listExpected = new String[10];
        listExpected[0]="El100";
        for (int i = 1; i < 9; i++) {
            listExpected[i]="El"+(i-1);
        }
        MyListImplementation<String> listActual = new MyListImplementation<>();
        for (int i = 0; i <8; i++) {
            listActual.add("El"+i);
        }
        listActual.addByIndex("El100",0);
        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(listExpected[i], listActual.get(i));
        }
    }
    @Test
    public void AddByIndex_middle(){

        }
    @Test
    public void AddByIndex_outOfBound(){

    }
    }
