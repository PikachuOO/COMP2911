/**
   A first-in, first-out collection of messages.
   Implemented as an Array
*/
public class MessageQueueArray {
	private Message[] queue;
	private int arrayIndexNumber = 0;

	public MessageQueueArray() {
		// TODO Auto-generated constructor stub
		queue = new Message[20];
	}
	
	/**
       Remove message at head.
       @return message that has been removed from the queue
	 */
	 public Message remove() {
		Message returnMsg = queue[0];
	    for (int i = 1; i < queue.length; i++) {
	    	queue[i-1] = queue[i];
	    }
	    if (arrayIndexNumber != 0)
	    	arrayIndexNumber--;
	    return returnMsg;
	 }
	 
	 /**
	     Append message at tail.
	     @param newMessage the message to be appended
	  */
	  public void add(Message newMessage) {
		  if (arrayIndexNumber == queue.length) {
			  Message[] newQueue = new Message[queue.length + 20];
			  for (int i = 1; i < queue.length; i++) {
				  newQueue[i-1] = queue[i];
			  }
			  queue = newQueue;
		  }
	      queue[arrayIndexNumber] = newMessage;
	      arrayIndexNumber++;
	  }
	  
	  /**
	      Get the total number of messages in the queue.
	      @return the total number of messages in the queue
	   */
	  public int size() {
		  return arrayIndexNumber;
	  }
	  
	  /**
	      Get message at head.
	      @return message that is at the head of the queue, or null
	      if the queue is empty
	   */
	   public Message peek()
	   {
	      return queue[0];
	   }
	   
	   /**
	    * Delete a give message from the queue, do nothing when
	    * the given message is not contained in the queue
	    * @param message to be deleted
	    *
	    */
	   public void delete(Message message) {
		  int indexPoint = 0;
		  for (int i = 0; i < queue.length; i++) {
			  if (queue[i] != null && queue[i].getText().equals(message.getText())) {
				  indexPoint = i;
				  i = queue.length;
			  }
		  }
		  for (int i = indexPoint; i < arrayIndexNumber; i++) {
			  queue[i] = queue[i + 1];
		  }
		  if (arrayIndexNumber != 0)
			  arrayIndexNumber--;
	   }
}
