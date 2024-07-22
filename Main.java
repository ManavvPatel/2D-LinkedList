import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix();
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Matrix");
            System.out.println("2. Add Row");
            System.out.println("3. Add Column");
            System.out.println("4. Print Matrix");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Provide Size: ");
                    System.out.print("  Rows: ");
                    int rows = scanner.nextInt();
                    System.out.print("  Columns: ");
                    int columns = scanner.nextInt();

                    if (rows <= 0 || columns <= 0) {
                        System.out.println("Invalid size. Please provide positive integers.");
                        break;
                    }

                    System.out.println("Enter elements for your matrix:");

                    for (int i = 0; i < rows; i++) {
                        System.out.println("Enter elements for row " + (i + 1) + ":");
                        List row = new List(scanner.nextInt());
                        for (int j = 1; j < columns; j++) {
                            row.addLast(scanner.nextInt());
                        }
                        if (i == 0) {
                            matrix.addRow(row, 1);;
                        } else {
                            matrix.addRow(row, i+1);
                        }
                    }
                    break;

                case 2:
                    if (matrix.getHead() == null) {
                        System.out.println("Matrix not created. Please create a matrix first.");
                        break;
                    }
                    System.out.println("Enter row elements:");
                    List newRow = new List(scanner.nextInt());
                    for (int i = 1; i < matrix.cols; i++) {
                        newRow.addMiddle(scanner.nextInt(), i + 1);
                    }
                    System.out.print("Enter the position to add the row (1 for beginning, -1 for end, or any index in between): ");
                    int rowPosition = scanner.nextInt();
                    if (rowPosition == 0) {
                        matrix.addRow(newRow, 1);
                    } else if (rowPosition == -1) {
                        matrix.addRow(newRow, matrix.getRows()+1);
                    } else {
                        matrix.addRow(newRow, rowPosition);
                    }
                    break;

                case 3:
                    if (matrix.getHead() == null) {
                        System.out.println("Matrix not created. Please create a matrix first.");
                        break;
                    }
                    System.out.println("Enter column elements:");
                    List newCol = new List(scanner.nextInt());
                    for (int i = 1; i < matrix.rows; i++) {
                        newCol.addMiddle(scanner.nextInt(), i + 1);
                    }
                    System.out.print("Enter the position to add the column (1 for beginning, -1 for end, or any index in between): ");
                    int colPosition = scanner.nextInt();
                    if (colPosition == 0) {
                        matrix.addColumn(newCol, 1);
                    } else if (colPosition == -1) {
                        matrix.addColumn(newCol, matrix.getCols()+1);
                    } else {
                        matrix.addColumn(newCol, colPosition);
                    }
                    break;

                case 4:
                    if (matrix.getHead() != null) {
                        System.out.println("\nMatrix: ");
                        matrix.printMatrix();
                        System.out.println();
                    } else {
                        System.out.println("Matrix not created. Please create a matrix first.");
                    }
                    break;

                case 5:
                    scanner.close();
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}