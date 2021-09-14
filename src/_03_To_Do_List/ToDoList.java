package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	private JFrame frame;
	private JPanel panel;
	private JButton addTask;
	private JButton viewTasks;
	private JButton removeTask;
	private JButton saveList;
	private JButton loadList;
	private ArrayList<String> list;
	public ToDoList() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton("Add Task");
		viewTasks = new JButton("View Tasks");
		removeTask = new JButton("Remove Task");
		saveList = new JButton("Save List");
		loadList = new JButton("Load List");
		list = new ArrayList<String>();
		
		
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		
		
		
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
			list.add(JOptionPane.showInputDialog("What task do you want to add to the To-Do List?"));
		}else if(e.getSource().equals(viewTasks)) {
			String s = "To-Do List:\n";
			int index = 1;
			for(String str: list) {
				s += index + ". " + str + "\n";
				index ++;
			}
			JOptionPane.showMessageDialog(null, s);
		}
		
	}
	
	
	public static void main(String[] args) {
		ToDoList toDo = new ToDoList();
	}
}
