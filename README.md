# C_M_P-405-Lehman college
In this project i was challenge to create a datagramSocket communication chat window in a local network using UDP .


When initiating a messaging session, you will specify the name of the person you are trying to reach. This should result in a message broadcast to everyone on the local network asking for the IP address of the person. This message will be a String formatted as follows: 

"????? name-of-other-person ##### your-name" 

Please note that the name of the person should be one word with no spaces.

Everyone will receive this message, but only the person wih that name will reply with a String formatted as follows: 

"##### name-of-other-person ##### ww.xx.yy.zz" 

Where ww.xx.yy.zz is the dotted decimal IP address of the person you are trying to message with.

The title of the messaging window should be the name of the person you are messaging plus their IP address.
