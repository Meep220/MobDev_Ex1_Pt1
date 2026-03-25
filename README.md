Milestone 1:
For the Implementation of the UI Grid and button mapping i used two Constraint Layouts which are used for the Top Screen which contains the Calculator Screen and the
bottom layout for the grid and buttons. For the button layout i used a grid layout for evenly spaced buttons and uniform margins and alignment. It also make it easier to 
place buttons without hardcoding constraints and margins.

For the Button mapping, only the numbers are contained in a list/Array value and a loop assigns each event listener sequentially instead of mapping each 
individual button with repeated calls of Binding for each digit assignment. Only Operators are Assigned Manually as they use strings.

Milestone 2:
For the Java Logic, The Text Views are used to contain the digits and operators. The Approach I used is through 1 by 1 inputs which is, First operand is inputted, Then when
the user inputs an operator, the Input is saved on the First Operand Variable and the Operator is stored in a String Value that is assigned when the operator button is pressed
then the user can place the next input, afterwards if the user presses the equals symbol it save the second input on the second operand thenwill start a calculate function 
based on the user's inputs and operator.

Milestone 3:
For State Preservation, The Text Views are saved individually as Equation and input inside the bundle as String values with the use of ViewBinding.
Operators and Operands are also saved as String and Floats respectively inside the onSaveInstanceState function.
They are then restored respectively in the onRestoreInstanceState through the Keys that they are assigned in the onSaveInstanceState.
Equations and Input are Restored Via ViewBinding Assignment and Operands and Operators are restored via Assignment using the bundle or savedInstanceState.
