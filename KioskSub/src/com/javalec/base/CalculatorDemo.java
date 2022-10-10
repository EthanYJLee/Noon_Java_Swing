package com.javalec.base;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class CalculatorDemo extends JFrame  {
    private static final long serialVersionUID = 1L;

    private StringBuffer inputBuffer = new StringBuffer();
    private String queuedOperator = null;
    private int leftHandSide = 0;
    private JLabel inputDisplay;
    private JLabel operatorIndicator;

    private class DigitButtonAction extends AbstractAction {
        private static final long serialVersionUID = 1L;
        private final int digit;
        public DigitButtonAction(final int digit) {
            super(Integer.toString(digit));
            this.digit = digit;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            enterDigit(digit);
        }
    }
    private class OperatorButtonAction extends AbstractAction {
        private static final long serialVersionUID = 1L;
        private final String operator;
        public OperatorButtonAction(final String operator) {
            super(operator);
            this.operator = operator;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            performOperation(operator);
        }
    }

    public CalculatorDemo() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(100, 200);

        // Create display text field
        inputDisplay = new JLabel();
        inputDisplay.setHorizontalAlignment(JLabel.RIGHT);
        inputDisplay.setText(Integer.toString(leftHandSide));

        operatorIndicator = new JLabel();
        operatorIndicator.setBorder(new EmptyBorder(0, 4, 0, 4));

        final JPanel display = new JPanel();
        display.setLayout(new BorderLayout());
        display.add(inputDisplay, BorderLayout.CENTER);
        display.add(operatorIndicator, BorderLayout.WEST);

        // Create number buttons
        final JPanel digitPanel = new JPanel();
        digitPanel.setLayout(new GridLayout(4,3));
        final int[] digitKeyOrder = new int[] { 7,8,9,4,5,6,1,2,3 };
        for (int digit : digitKeyOrder) {
            digitPanel.add(new JButton(new DigitButtonAction(digit)));
        }
        digitPanel.add(new JPanel()); // Blank spacer panel
        digitPanel.add(new JButton(new DigitButtonAction(0)));

        // Create operators
        final String[] OPERATORS = { "+","-","*","/","=" };
        final JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(OPERATORS.length, 1));
        for (String op : OPERATORS) {
            operatorPanel.add(new JButton(new OperatorButtonAction(op)));
        }

        add(digitPanel, BorderLayout.CENTER);
        add(operatorPanel, BorderLayout.EAST);
        add(display, BorderLayout.NORTH);

        pack();
    }

    private void enterDigit(final int digit) {
        if (digit == 0 && inputBuffer.length() == 0) return;
        inputBuffer.append(Integer.toString(digit));
        inputDisplay.setText(inputBuffer.toString());
    }

    private int calculate(final int leftHandSide, final String operator, final int rightHandSide) {
        if (operator == null) return rightHandSide;
        else if ("+".equals(operator)) return leftHandSide + rightHandSide;
        else if ("-".equals(operator)) return leftHandSide - rightHandSide;
        else if ("*".equals(operator)) return leftHandSide * rightHandSide;
        else if ("/".equals(operator)) return leftHandSide / rightHandSide;
        else if ("=".equals(operator)) return rightHandSide;
        else {
            throw new IllegalStateException("Unrecognised operator " + operator);
        }
    }

    private void performOperation(final String operator) {
        try {
            final int rightHandSide = Integer.parseInt(inputBuffer.toString());
            leftHandSide = calculate(leftHandSide, queuedOperator, rightHandSide);
        } catch (NumberFormatException e) {
            // Ignore failure to parse inputBuffer to integer
            // calculate() not called, just carry on and clear the
            // inputBuffer and queue a new operator
        } catch (ArithmeticException e) {
            // Divide by 0 in calculate()
            operatorIndicator.setText("");
            inputDisplay.setText(e.getMessage());
            queuedOperator = null;
            return;
        } catch (IllegalStateException e) {
            // Unrecognised operator
            operatorIndicator.setText("");
            inputDisplay.setText(e.getMessage());
            queuedOperator = null;
            return;
        }
        inputBuffer.setLength(0); // Clear inputBuffer
        queuedOperator = operator; // Queue next operator
        // Update display
        operatorIndicator.setText(queuedOperator);
        inputDisplay.setText(Integer.toString(leftHandSide));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorDemo().setVisible(true);
            }
        });
    }
}
