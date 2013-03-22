import static org.junit.Assert.*;

import org.junit.Test;


public class MessageQueueTester {

	MessageQueueArray m = new MessageQueueArray();
	@Test
	public void testMessageArray() {
		testInit();
		testAdd();
		testRemove();
		testAdd();
		testDelete();
	}
	
	public void testInit() {
		Message returnMsg = m.peek();
		assertEquals(returnMsg, null);
		assertEquals(0, m.size());
		returnMsg = m.remove();
		assertEquals(returnMsg, null);
		m.delete(null);
		assertEquals(0, m.size());
	}
	
	public void testAdd() {
		Message msg = new Message("Hello");
		m.add(msg);
		assertEquals(1, m.size());
		msg = new Message("Today is Friday");
		m.add(msg);
		msg = new Message("COMP2121");
		m.add(msg);
		assertEquals(3, m.size());
		msg = new Message("COMP3331");
		m.add(msg);
		msg = new Message("COMP2111");
		m.add(msg);
		assertEquals(5, m.size());
	}
	
	public void testRemove() {
		Message returnMsg = m.remove();
		assertEquals("Hello", returnMsg.getText());
		assertEquals(4, m.size());
		returnMsg = m.remove();
		assertEquals("Today is Friday", returnMsg.getText());
		returnMsg = m.remove();
		assertEquals("COMP2121", returnMsg.getText());
		returnMsg = m.remove();
		assertEquals("COMP3331", returnMsg.getText());
		returnMsg = m.remove();
		assertEquals("COMP2111", returnMsg.getText());
		assertEquals(0, m.size());
		returnMsg = m.remove();
		assertEquals(null, returnMsg);
		assertEquals(0, m.size());
	}
	
	public void testDelete() {
		Message msgToDelete = new Message("COMP3331");
		m.delete(msgToDelete);
		assertEquals(4, m.size());
		Message msgToAdd = new Message("COMP1927");
		m.add(msgToAdd);
		msgToAdd = new Message("COMP1917");
		m.add(msgToAdd);
	}

}
