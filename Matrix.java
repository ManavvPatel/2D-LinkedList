public class Matrix {
    List list;
    Node head = null;
    int rows = 0;
    int cols = 0;

    public int getRows() {return rows;}

    public int getCols() {return cols;}

    public Node getHead() {return head;}

    public Matrix(){}

    public void addRow(List list, int row_position){
        if(row_position == 1){
            Node newRowHead = list.getSubHead();
            if(rows == 0){
                head = newRowHead;
                Node current = head;
                while (current != null){
                    current.down = null;
                    current = current.right;
                }
                head.down = null;
                rows = 1;
                cols = list.getSize();
            } else if(list.getSize() == cols) { 
                Node newRowCurrent = newRowHead;
                Node matrixCurrentRow = head;
        
                while(newRowCurrent != null){
                    newRowCurrent.down = matrixCurrentRow;
                    newRowCurrent = newRowCurrent.right;
                    matrixCurrentRow = matrixCurrentRow.right;
                }
                head = newRowHead;  
                rows += 1;
            } else {
                System.out.println("Error: Row size does not match.");
            }
        }else if(row_position == rows+1){
            Node newRowHead = list.getSubHead();
            Node matrixCurrentRow = head;
        
            while(matrixCurrentRow.down != null){
                matrixCurrentRow = matrixCurrentRow.down;
            }
        
            Node newRowCurrent = newRowHead;
            while(newRowCurrent != null){
                matrixCurrentRow.down = newRowCurrent;
                newRowCurrent.down = null;
                newRowCurrent = newRowCurrent.right;
                matrixCurrentRow = matrixCurrentRow.right;
            }
            rows += 1;
        }else{
            Node newRowHead = list.getSubHead();
            Node newRowCurrent = newRowHead;
            Node matrixCurrentRow = head;
        
            while(row_position != 2){
                matrixCurrentRow = matrixCurrentRow.down;
                row_position--;
            }
        
            while(newRowCurrent != null){                        //1, 2, 3 = 1.left,
                newRowCurrent.down = matrixCurrentRow.down;      // 2.down = 1.down (2->3)
                matrixCurrentRow.down = newRowCurrent;           // 1.down = 2 (1->2)
                matrixCurrentRow = newRowCurrent.right;          // 1 = 1.right (1 goes to next)
                newRowCurrent = newRowCurrent.right;             // 2 = 2.right (2 goes to next)
            }
            rows += 1;
        }
    }

    public void addColumn(List list, int col_position){
        if(col_position == 1){
            Node newColumnHead = list.getSubHead();
    
            if(cols == 0){
                head = newColumnHead;
                Node current = head;
                while(current != null){
                    current.down = current.right;
                    current.right = null;
                    current = current.down;
                }
                rows = list.getSize();
                cols = 1;
            } else if(list.getSize() == rows) { 
                Node newColumnCurrent = newColumnHead;
                Node matrixCurrentColumn = head;
        
                while(newColumnCurrent != null){
                    newColumnCurrent.down = newColumnCurrent.right;
                    newColumnCurrent.right = matrixCurrentColumn;
                    newColumnCurrent = newColumnCurrent.down;
                    matrixCurrentColumn = matrixCurrentColumn.down;
                }
                head = newColumnHead;  
                cols += 1;
            } else {
                System.out.println("Error: Column size does not match the number of rows.");
            }
        } else if (col_position == cols + 1){
            Node newColHead = list.getSubHead();
            Node matrixCurrentColumn = head;
        
            while(matrixCurrentColumn.right != null){
                matrixCurrentColumn = matrixCurrentColumn.right;
            }

            Node newColumnCurrent = newColHead;
            while(newColumnCurrent != null){
                newColumnCurrent.down = newColumnCurrent.right;
                newColumnCurrent.right = null;
                matrixCurrentColumn.right = newColumnCurrent;
                newColumnCurrent = newColumnCurrent.down;
                matrixCurrentColumn = matrixCurrentColumn.down;
            }
            cols += 1;   
        } else {
            Node newColHead = list.getSubHead();
            Node newColumnCurrent = newColHead;
            Node matrixCurrentColumn = head;
        
            while(col_position != 2){
                matrixCurrentColumn = matrixCurrentColumn.right;
                col_position--;
            }

            while(newColumnCurrent != null){                    
                newColumnCurrent.down = newColumnCurrent.right;
                newColumnCurrent.right = matrixCurrentColumn.right;
                matrixCurrentColumn.right = newColumnCurrent;
                newColumnCurrent = newColumnCurrent.down;
                matrixCurrentColumn = matrixCurrentColumn.down;
            }
            cols += 1; 
        }
    }
    
    public void printMatrix() {
        Node headColumn = head;
        while (headColumn != null){
            Node rowNode = headColumn;
            while (rowNode != null){
                System.out.print(rowNode.data + " ");
                rowNode = rowNode.right;
            }
            System.out.println();
            headColumn = headColumn.down;
        }
    }
}
