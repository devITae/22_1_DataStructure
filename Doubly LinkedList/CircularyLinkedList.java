// Circulary Linked List
public class CircularyLinkedList {

    // 순환 연결 목록을 위한 노드 클래스
    private class Node{
        // 노드에 저장할 데이터 변수
        private int data;
        // 다음 노드를 가리키기 위한 변수
        private Node next;
        // 노드 클래스의 생성자로서 초기 데이터와 다음 노드를 받음
        public Node(int data, Node next){
            // 초기값을 인스턴스 변수에 할당
            this.data = data;
            this.next = next;
        }
        // 접근자 메소드
        // 노드에 저장된 데이터 반환
        public int getElement(){ return data; }
        // 현재 노드가 가리키는 다음 노드를 반환
        public Node getNext(){ return next; }
        // 새로운 노드를 인자로 받아 현재 노드의 다음 노드로 설정
        public void setNext(Node next){ this.next = next; }
    }

    // 순환 연결 목록의 인스턴스 변수 생성 및 초기화
    private Node tail = null;
    private int size = 0;

    // 순환 연결 목록에 저장된 노드의 수를 반환
    public int size() { return size; }
    // 순환 연결 목록이 비어있는지 여부를 반환
    public boolean isEmpty() { return size == 0; }
    // 순환 연결 목록의 마지막 노드를 반환
    public Node getTail(){ return tail; }

    // rotate 메소드, 첫 번째 요소가 리스트의 마지막 요소가 되도록 회전
    public void rotate(){
        // 만열 순환 연결 목록이 비어있다면 아무것도 하지 않음
        if(tail != null)
            // 이전 머리 노드를 새로운 꼬리 노드로 설정
            tail = tail.getNext();        
    }

    // 첫 번째 위치 즉, 꼬리 노드의 다음 위치에 새로운 노드 추가
    public void addFirst(int data){
        // 만일 순환 연결 목록이 비어있다면
        if(isEmpty()){
            // 새로운 노드를 만들어 꼬리 노드로 설정
            tail = new Node(data, null);
            // 꼬리 노드의 다음 노드를 꼬리 노드로 설정
            tail.setNext(tail);
        // 만일 순환 연결 목록에 노드가 있다면
        } else {
            // 새로운 노드를 만들고 꼬리 노드의 다음 노드를 가리키도록 설정
            Node newest = new Node(data, tail.getNext());
            // 꼬리 노드가 새로운 노드를 가리키도록 설정
            tail.setNext(newest);
        }
        // 순환 연결 목록의 노드 수 증가
        size++;
    }

    // 새로운 노드를 만들어 목록의 제일 끝에 추가
    public void addLast(int data){
        // 새로운 노드를 목록의 제일 처음에 추가
        addFirst(data);
        // 추가한 노드를 새로운 꼬리 노드로 설정
        tail = tail.getNext();
    }

    // 목록의 제일 첫 번째 노드를 제거
    public Node removeFirst(){
        // 만일 목록이 비어있다면
        if(isEmpty())
            // 아무것도 하지 않음
            return null;
        // 꼬리 노드의 다음 노드를 머리 노드로 설정
        Node head = tail.getNext();
        // 노드가 하나 뿐이라면
        if(head == tail)
            // 꼬리 노드를 null로 설정
            tail = null;
        // 만일 노드가 둘 이상이라면
        else
            // 머리 노드의 다음 노드를 꼬리 노드의 다음 노드로 설정
            tail.setNext(head.getNext());
        // 순환 연결 목록의 노드 수 감소
        size--;
        // 이전 머리 노드 반환
        return head;
    }

    // 단방향 링크 목록의 마지막 노드 제거
    public Node removeLast(){
        // 만일 단방향 링크 목록이 비어있다면
        if(isEmpty())
            // 메소드 종료
            return null;
        // 꼬리 노드의 다음 노드를 머리 노드로 설정
        Node head = tail.getNext();
        // 노드가 하나 뿐이라면
        if(head == tail){
            // 꼬리 노드를 null로 설정
            tail = null;
            return head;
        }
        // 만일 노드가 둘 이상이라면
        else{
            // 현재 노드와 다음 노드를 첫 번째 노드로 설정
            Node ptr = head, pre = head;
            // 현재 노드가 마지막 노드가 될 때까지 반복
            while(ptr != tail){
                // 이전 노드를 현재 노드로 설정
                pre = ptr;
                // "현재 노드의 다음 노드"를 "현재 노드"로 설정
                ptr = ptr.next;
            }
            // 이전 노드의 다음 노드가 없다고 설정
            pre.setNext(ptr.getNext());         
            // 순환 연결 목록의 노드 수를 하나 감소 시킴
            size--;
            // 삭제 전 순환 연결 목록의 마지막 노드 반환
            return ptr;
        }
    }

    // 첫 번째 노드부터 마지막 노드까지 출력
    public void printList(){        
        Node ptr = tail.getNext();
        for(int i = 0; i < size; i++){
            System.out.println(i + ": " + ptr.getElement());
            ptr = ptr.getNext();
        }
    }
}
