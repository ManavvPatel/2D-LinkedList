public class List {
    Node subHead = null;
    Node subTail = null;
    int size = 0;

    public Node getSubHead() {return subHead;}

    public Node getSubTail() {return subTail;}

    public int getSize() {return size;}
    
    public List(int data){
        subHead = new Node(data);
        subTail = subHead;
        size++;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.right = subHead;
        subHead = newNode; 
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        subTail.right = newNode;
        subTail = newNode; 
        size++;
    }

    public void addMiddle(int data, int position){
        if(position == 1){
            Node newNode = new Node(data);
            subHead.down = newNode;
            newNode.right = subHead;
            subHead = newNode; 
            size++;
            return;
        }

        if(position == getSize()+1){
            Node newNode = new Node(data);
            subTail.right = newNode;
            newNode.down = subTail;
            subTail = newNode; 
            size++;
            return;
        }

        Node current = subHead;
        while(position != 2){
            current = current.right;
            position--;
        }

        Node newNode = new Node(data);
        newNode.down = current;
        newNode.right = current.right;
        current.right.down = newNode;
        current.right = newNode;
        size++; 
    }

    public void removeFirst(){
        if(subHead == null){
            return;
        }
        subHead = subHead.right;
        subHead.down = null;
        size--;
        if(size == 1){
            subTail = subHead;
        }
    }

    public void removeLast(){
        if(subHead == null){
            return;
        }

        Node current = subHead;
        while(current.right != subTail){
            current = current.right;
        }
        current.right = null;
        subTail = current;
        size--;
    }

    public void printList(){
        Node current = subHead;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.right;
        }
        System.out.println("Null");
    }
}