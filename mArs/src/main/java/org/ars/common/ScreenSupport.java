package org.ars.common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.ars.entity.Resrevation;
import org.ars.start.Ars;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMText;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractNode;
import org.dom4j.tree.DefaultElement;
import org.dom4j.tree.DefaultText;

/**
 * base screen(if you want to create a new screen class, can be extends this abstract class)
 * @author Administrator
 *
 */
public abstract class ScreenSupport extends State{
	
	protected static Resrevation resrevation = new Resrevation();
	private static Stack<Object> stack = new Stack<Object>();
	private static Scanner scanner = new Scanner(System.in);
	private String input;
	private String file;
	protected Element content;
	private String errorMessage;

	
	public ScreenSupport() {
		
	}
	
	public ScreenSupport(String file) {
		this.file = file;
		load();
	}

	
	public String getInput() {
		return input;
	}

	public String getFile() {
		return file;
	}

	/**
	 * set xml file (view)
	 * @param file
	 */
	public void setFile(String file) {
		this.file = file;
		load();
	}

	/**
	 * load xml file 
	 */
	private void load(){
		if(file!=null){
			try {
			SAXReader saxReader = new SAXReader();
			URL url = Thread.currentThread().getContextClassLoader().getResource(file);
			FileInputStream in = new FileInputStream(new File(url.toURI()));	
			Document doc = saxReader.read(in);
			Element root = doc.getRootElement();	
			content = root;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void execute() {
		try {
			beforeInput();
			input();
			afertInput();
		} catch (InputException e) {
			errorMessage = e.getMessage();
			Ars.transition(this);
		}
		cls();
		ScreenContainer.clear();
	}
	
	protected abstract void beforeInput();
	protected abstract void afertInput() throws InputException;
	
	private void input(){
		procInputError();
		System.out.print("Input: ");
		input = scanner.nextLine();
	}

	private void procInputError() {
		if(errorMessage!=null){
			List<String> array = new ArrayList<String>();
			ScreenContainer.parseText(errorMessage, array);
			for (String string : array) {
				String val = ScreenContainer.getValue(string);
				errorMessage = errorMessage.replace(string, val);
				errorMessage = errorMessage.replace("${", "");
				errorMessage = errorMessage.replace("}", "");
			}
			System.out.println("Message : ERROR!!! " + errorMessage);
			errorMessage=null;
		}
	}
	
//	/**
//	 * if input is error,the ars transition to current state
//	 * @return
//	 */
//	private boolean isInputError(){
//		if(input!=null){
//			if(isError()){
//				hasError = true;
//				Ars.transition(this);
//				return true;
//			}
//		}
//		return false;
//	}
	
	/**
	 * replace xml file element
	 * @param name {error|each}
	 * @param node
	 */
	private void replaceElement(){
		@SuppressWarnings("unchecked")
		List<AbstractNode> list = content.content();
		for (AbstractNode object : list) {
			if(object instanceof DefaultText){

			}
			if (object instanceof DefaultElement) {		
					procTag(object);
			}
		}
	}
	
	private void procTag(AbstractNode node){
		if("each".equals(node.getName())){
			procEachTag(node);
		}
//		if("error".equals(node.getName())){
//			procErrorTag(node);
//		}
	}
	
	
	/**
	 * replace each tag 
	 * @param node
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void procEachTag(AbstractNode node){
		if(node instanceof Element){
			String val = ((Element) node).attributeValue("list");			
			List<String> array = new ArrayList<String>();
			ScreenContainer.parseText(val, array);
			for (String string : array) {
				Object obj = ScreenContainer.getValue(string);
				if(obj instanceof List){
					String text = "";
					int len = ((List) obj).size();
					for(int i = 0;i<len;i++){
						text += String.valueOf(i+1) + ". " + ((List) obj).get(i);
						if(i!=len-1)
							text+='\n';
					}
					content.content().set(content.content().indexOf(node), new DOMText(text));
				}
			}
		}
	}
	
	/**
	 * a global value stack
	 * @return
	 */
	public Stack<Object> getStack(){
		return stack;
	}
	
	public void printXML(){
		replaceElement();
		System.out.println(content.getText().trim());
	}
	
	/**
	 * go to previous state
	 */
	public void toPrevScreen(){
		Ars.transition(getPrev());
	}
	
	/**
	 * go to next state
	 * @param name
	 */
	public void toNextScreen(String name){	
		State state = SpringUtils.getBean(name);
		state.setPrev(this);
		Ars.transition(state);
	}
	
	
	public static void quit(){
		Ars.shutdown();
	}
	/**
	 * Clear the screen
	 */
	protected void cls(){
		System.out.println("----------------------------------------------------Cls");
		//cls0();
	}
	/**
	 * failed
	 * system("cls");
	 */
	private static native void cls0();
	
	private static native void appendVal2InputCache(String val);
	
}
