public class Main {
    public static void main(String[] args) {
        MyListImplementation<Integer> list = new MyListImplementation<>();

        for (int i = 0; i < 17; i++) {
            list.add(i);
            //System.out.println("Add()"+i+"" + list);
        }
        System.out.println("List before all. Current index= " + list.getIndex()+". "+list);
        System.out.println("Removed value= "+ list.remove(5)+ ". Current index= " + list.getIndex()+". "+list);
        list.add(111);
        System.out.println("Add index. Current index: " + list.getIndex()+" "+list);
        /*System.out.println("Get value = " + list.get(0));
        System.out.println("Get value = " + list.get(5));
        System.out.println("Get value = " + list.get(17));
        System.out.println("Get value = " + list.get(18));*/
        /* list.set(90,0);
        list.set(91,6);
        list.set(92,16);
        list.set(93,17);
        list.set(94,18);*/
        list.clear();
        System.out.println("Current index= " + list.getIndex()+". "+list);
/*
        list.addByIndex(100, 0);
        System.out.println("AddByIndex(), newArrayLength<existingArrayLength, first position:");
        System.out.println(list);

        list.addByIndex(200, 6);
        System.out.println("AddByIndex(), newArrayLength<existingArrayLength, middle position:");
        System.out.println(list);

        list.addByIndex(300, 19);
        System.out.println("AddByIndex(), newArrayLength=existingArrayLength, add to current position:");
        System.out.println(list);

        list.addByIndex(400, 20);
        System.out.println("AddByIndex(), newArrayLength=existingArrayLength, add to current position:");
        System.out.println(list);

        list.addByIndex(500, 25);
        System.out.println(list);
*/
    }
}