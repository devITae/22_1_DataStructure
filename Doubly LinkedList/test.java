public class test {
    public static void main(String [] args){
        CircularyLinkedList cl = new CircularyLinkedList();

        // 초기화
        for(int i = 0; i < 3; i++){
            cl.addLast(i);
        }
        for(int i = 10; i < 13; i++){
            cl.addFirst(i);
        }
        System.out.println("== cl init");
        cl.printList();

        // 첫 번째 노드 삭제
        cl.removeFirst();
        // 마지막 노드 삭제
        cl.removeLast();
        System.out.println("== cl remove first & last");
        cl.printList();

        DoublyLinkedList dl = new DoublyLinkedList();

        // 초기화
        for(int i = 0; i < 3; i++){
            dl.addLast(i);
        }
        for(int i = 10; i < 13; i++){
            dl.addFirst(i);
        }
        System.out.println("\n== dl init");
        dl.printList();

        // 첫 번째 노드 삭제
        dl.removeFirst();
        // 마지막 노드 삭제
        dl.removeLast();
        System.out.println("== dl remove first & last");
        dl.printList();
    }
}
