public class DoublyLinkedList {
    
    private static class Node{
        private int element;
        private Node prev;
        private Node next;
        public Node(int element, Node prev, Node next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public int getElement() { return element; }
        public Node getPrev() { return prev; }
        public Node getNext() { return next; }
        public void setPrev(Node prev) { this.prev = prev; }
        public void setNext(Node next) { this.next = next; }
    }

    private Node header, trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node(0, null, null);
        trailer = new Node(0, header, null);
        header.setNext(trailer);
    }

    // 이중 연결 목록에 저장된 노드의 수를 반환
    public int size() { return size; }
    // 이중 연결 목록이 비어있는지 여부를 반환
    public boolean isEmpty() { return size == 0; }
    // 이중 연결 목록의 첫 번째 노드를 반환
    public Node first() {
        if (isEmpty()) return null;
        // 첫 번째 노드는 머리 노드의 다음 노드
        return header.getNext();
    }

    // 이중 연결 목록의 마지막 노드를 반환
    public Node last() {
        if (isEmpty()) return null;
        // 마지막 노드는 꼬리 노드의 이전 노드
        return trailer.getPrev();
    }

    // 외부에서 접근할 수 있는 업데이트 메소드
    // 새로운 요소 e를 목록의 가장 앞에 삽입
    public void addFirst(int e) {
        // 머리 노드와 그 다음 노드 사이에 e를 삽입
        addBetween(e, header, header.getNext());
    }

    // 새로운 요소 e를 목록의 가장 뒤에 삽입
    public void addLast(int e) {
        // 꼬리 노드와 그 이전 노드 사이에 e를 삽입
        addBetween(e, trailer.getPrev(), trailer);
    }

    // 목록의 첫 번째 노드를 제거하고 그 노드를 반환
    public Node removeFirst() {
        // 지울 것이 없는 경우
        if (isEmpty()) return null;
        // 머리 노드의 다음 노드를 제거하고 반환
        return remove(header.getNext());
    }

    // 목록의 마지막 노드를 제거하고 그 노드를 반환
    public Node removeLast( ) {
        // 지울 것이 없는 경우
        if (isEmpty( )) return null;
        // 꼬리 노드 이전 노드를 제거하고 반환
        return remove(trailer.getPrev());
    }

    // 내부에서만 접근할 수 있는 업데이트 메소드
    // 인자로 주어진 두 노드 사이에 요소가 e인 노드를 추가
    private void addBetween(int e, Node predecessor, Node successor) {
    
        // 주어진 두 노드를 prev와 next로 갖고 요소가 e인 노드를 생성
        Node newest = new Node(e, predecessor, successor);
        // 새로 만든 노드를 두 번째 인자로 주어진 노드의 다음 노드로 설정
        predecessor.setNext(newest);
        // 새로 만든 노드를 세 번째 인자로 주어진 노드의 이전 노드로 설정
        successor.setPrev(newest);
        // 이중 연결 목록의 노드 수 증가
        size++;
    }
    
    // 주어진 노드를 목록에서 제거하고 반환
    private Node remove(Node node) {
        // 인자로 주어진 노드의 이전 노드를 변수 predecessor에 할당
        Node predecessor = node.getPrev();
        // 인자로 주어진 노드의 다음 노드를 변수 successor에 할당
        Node successor = node.getNext();
        // predecessor의 다음 노드를 successor로 설정
        predecessor.setNext(successor);
        // successor의 이전 노드를 predecessor로 설정
        successor.setPrev(predecessor);
        // 이중 연결 목록의 노드 수 감소
        size--;
        // 제거한 노드 반환
        return node;
    }

    // 첫 번째 노드부터 마지막 노드까지 출력
    public void printList(){        
        Node ptr = header.getNext();
        for(int i = 0; i < size; i++){
            System.out.println(i + ": " + ptr.getElement());
            ptr = ptr.getNext();
        }
    }
}

