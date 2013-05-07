import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Presents a phone GUI for the voice mail system.
*/
public class Telephone
{
   /**
      Constructs a telephone with a speaker, keypad,
      and microphone.
   */
   public Telephone()
   {
//      JPanel speakerPanel = new JPanel();
//      speakerPanel.setLayout(new BorderLayout());
//      speakerPanel.add(new JLabel("Speaker:"),
//            BorderLayout.NORTH);
//      speakerField = new JTextArea(10, 25);
//      speakerPanel.add(speakerField,
//            BorderLayout.CENTER);
//
//      String keyLabels = "123456789*0#";
//      JPanel keyPanel = new JPanel();
//      keyPanel.setLayout(new GridLayout(4, 3));
//      for (int i = 0; i < keyLabels.length(); i++)
//      {
//         final String label = keyLabels.substring(i, i + 1);
//         JButton keyButton = new JButton(label);
//         keyPanel.add(keyButton);
//         keyButton.addActionListener(new
//            ActionListener()
//            {
//               public void actionPerformed(ActionEvent event)
//               {
//                  connect.dial(label);
//               }
//            });
//      }
//
//      final JTextArea microphoneField = new JTextArea(10,25);
//
//      JButton speechButton = new JButton("Send speech");
//      speechButton.addActionListener(new
//         ActionListener()
//         {
//            public void actionPerformed(ActionEvent event)
//            {
//               connect.record(microphoneField.getText());
//               microphoneField.setText("");
//            }
//         });
//
//      JButton hangupButton = new JButton("Hangup");
//      hangupButton.addActionListener(new
//         ActionListener()
//         {
//            public void actionPerformed(ActionEvent event)
//            {
//               connect.hangup();
//            }
//         });
//
//      JPanel buttonPanel = new JPanel();
//      buttonPanel.add(speechButton);
//      buttonPanel.add(hangupButton);
//
//      JPanel microphonePanel = new JPanel();
//      microphonePanel.setLayout(new BorderLayout());
//      microphonePanel.add(new JLabel("Microphone:"),
//            BorderLayout.NORTH);
//      microphonePanel.add(microphoneField, BorderLayout.CENTER);
//      microphonePanel.add(buttonPanel, BorderLayout.SOUTH);
//
//      JFrame frame = new JFrame();
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.add(speakerPanel, BorderLayout.NORTH);
//      frame.add(keyPanel, BorderLayout.CENTER);
//      frame.add(microphonePanel, BorderLayout.SOUTH);
	  
	  GridBagConstraints c = new GridBagConstraints();
	  c.fill = GridBagConstraints.HORIZONTAL;
	   
	  JPanel speakerPanel = new JPanel();
	  speakerPanel.setLayout(new GridBagLayout());
	  JLabel speakerLabel = new JLabel("Speaker:");
	  c.gridx = 0;
	  c.gridy = 0;
	  speakerPanel.add(speakerLabel, c);
	  speakerField = new JTextArea(10, 25);
	  c.gridx = 0;
	  c.gridy = 1;
	  speakerPanel.add(speakerField, c);
	  
	  String keyLabels = "123456789*0#";
	  JPanel keyPanel = new JPanel();
	  keyPanel.setLayout(new GridBagLayout());
	  for (int i = 0; i < keyLabels.length(); i++) {
		  final String label = keyLabels.substring(i, i + 1);
		  JButton keyButton = new JButton(label);
		  c.gridy = 0;
		  if (i > 2)
			  c.gridy = 1;
		  if (i > 5)
    	   c.gridy = 2;
		  if (i > 8)
			  c.gridy = 3;
		  c.gridx = GridBagConstraints.RELATIVE;
		  keyPanel.add(keyButton, c);
		  keyButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent event) {
				  connect.dial(label);
			  }
		  });
	  }
	  
	  final JTextArea microphoneField = new JTextArea(10 ,25);
	  
	  JButton speechButton = new JButton("Send speech");
	  speechButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent event) {
			  connect.record(microphoneField.getText());
			  microphoneField.setText("");
		  }
	  });

	  JButton hangupButton = new JButton("Hangup");
	  hangupButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent event) {
			  connect.hangup();
		  }
	  });
	  
	  JPanel microphonePanel = new JPanel();
	  JLabel microphoneLabel = new JLabel("Microphone:");
	  microphonePanel.setLayout(new GridBagLayout());
	  c.gridx = 0;
	  c.gridy = 0;
	  microphonePanel.add(microphoneLabel, c);
	  c.gridy++;
	  microphonePanel.add(microphoneField, c);
	  
	  JPanel buttonPanel = new JPanel();
	  buttonPanel.setLayout(new GridBagLayout());
	  c.gridx = 0;
	  c.gridy = 0;
	  buttonPanel.add(speechButton, c);
	  c.gridx = GridBagConstraints.RELATIVE;
	  buttonPanel.add(hangupButton, c);
	   
	  JFrame frame = new JFrame();
	  frame.setLayout(new GridBagLayout());
	  c.fill = GridBagConstraints.HORIZONTAL;
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  c.gridx = 0;
	  c.gridy = 0;
	  frame.add(speakerPanel, c);
	  c.gridx = 0;
	  c.gridy = 1;
	  frame.add(keyPanel, c);
	  c.gridy++;
	  frame.add(microphonePanel, c); 
	  c.gridy++;
	  frame.add(buttonPanel, c);
	  

      frame.pack();
      frame.setVisible(true);
   }

   /**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }

   private JTextArea speakerField;
   private Connection connect;
}
