# 2D-LinkedList
Creating a Matrix using Node from Doubly LinkedList 
•	Thought Process: The start of this structure began with understanding of Doubly Linked List as the nodes used in DLL will be used for this 2D linked list structure as well. The user can    create a row or a column in this 2D linked list but first this program creates a doubly linked list and then manipulates its nodes to connect it with the 2D “Matrix” appropriately.

Note: Rows and Columns are assumed to have index 1 for beginning position.

•	Node Class:
  Attributes:
    •	data: int
    •	down: Node
    •	right: Node
  Methods:
    •	Constructor(data: int)
      o	Initialize data with the given value
      o	Set down and right to null

•	List Class:
  Attributes:
    •	subHead: Node
    •	subTail: Node
    •	size: int
  Methods:
    •	Constructor(data: int)
      o	Create a new Node with data
      o	Set subHead and subTail to this new Node
      o	Set size to 1
    •	getSubHead(): Node
      o	Return subHead
    •	getSubTail(): Node
      o	 Return subTail
    •	getSize(): int
      o	Return size
    •	addFirst(data: int)
      o	Create a new Node with data
      o	Set new Node's right to current subHead
      o	Update subHead to new Node
      o	Increment size
    •	addLast(data: int)
      o	Create a new Node with data
      o	Set current subTail's right to new Node
      o	Update subTail to new Node
      o	Increment size
    •	addMiddle(data: int, position: int)
      o	If position is 1, call addFirst(data)
      o	If position is size + 1, call addLast(data)
      o	Otherwise:
      	Traverse to node before desired position
      	Create new Node with data
      	Insert new Node after current node
      	Increment size

•	Matrix Class:
  Attributes:
    •	list: List
    •	head: Node
    •	rows: int
    •	cols: int
  Methods:
    •	Constructor()
      o	Initialize empty matrix
    •	getRows(): int
      o	Return rows
    •	getCols(): int
      o	Return cols
    •	getHead(): Node
      o	Return head
    •	addRow(list: List, row_position: int)
      o	If adding at beginning:
      	Update head if matrix is empty
      	Link new row to existing rows
      o	If adding at end:
      	Link last row to new row
      o	If adding in middle:
      	Traverse to insertion point
      	Link new row to surrounding rows
      o	Update rows
    •	addColumn(list: List, col_position: int)
      o	If adding at beginning:
      	Update head if matrix is empty
      	Link new column to existing columns
      o	If adding at end:
      	Link last column to new column
      o	If adding in middle:
      	Traverse to insertion point
      	Link new column to surrounding columns
      o	Update cols
    •	printMatrix()
      o	Traverse matrix row by row
      o	Print each element in the current row
      o	Move to next row and repeat

•	Main Class:
  Attributes:
    •	None
  Methods:
    •	main()
      o	Initialize a Scanner object for user input.
      o	Create a Matrix object.
      o	Initialize an integer variable choice for menu selection.
      o	Enter an infinite loop to display a menu and handle user choices:
      	Print menu options:
        1.	Create Matrix
        2.	Add Row
        3.	Add Column
        4.	Print Matrix
        5.	Exit
      	Prompt user to enter a choice.
      	Use a switch statement to handle each choice:
        	Case 1: Create Matrix
          	Prompt user to enter the number of rows and columns.
          	Validate the input to ensure positive integers.
          	Prompt user to enter elements for each row:
          	Create a List object for each row and add elements to it.
          	Add each row to the matrix using matrix.addRow().
        	Case 2: Add Row
          	Check if the matrix is created.
          	If not, prompt the user to create a matrix first.
          	Prompt user to enter elements for the new row.
          	Create a List object for the new row and add elements to it.
          	Prompt user to enter the position to add the row (beginning, end, or specific index).
          	Add the row to the matrix using matrix.addRow().
        	Case 3: Add Column
          	Check if the matrix is created.
          	If not, prompt the user to create a matrix first.
          	Prompt user to enter elements for the new column.
          	Create a List object for the new column and add elements to it.
          	Prompt user to enter the position to add the column (beginning, end, or specific index).
          	Add the column to the matrix using matrix.addColumn().
        	Case 4: Print Matrix
          	Check if the matrix is created.
          	If not, prompt the user to create a matrix first.
          	Print the matrix using matrix.printMatrix().
        	Case 5: Exit
          	Close the Scanner object.
          	Print an exit message.
          	Terminate the program.
        	Default:
        	  Print an invalid choice message and prompt the user to try again.
