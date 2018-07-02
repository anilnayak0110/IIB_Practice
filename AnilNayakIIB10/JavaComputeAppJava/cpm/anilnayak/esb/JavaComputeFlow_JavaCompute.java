package cpm.anilnayak.esb;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import com.ibm.broker.plugin.MbXMLNSC;

public class JavaComputeFlow_JavaCompute extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;
		try {
			// create new message as a copy of the input
			MbMessage outMessage = new MbMessage(inMessage);
			
			// Add user code below
             MbElement element = outMessage.getRootElement().getLastChild().getFirstChild().getFirstChild();
             
             String H1 = element.getFirstChild().getValueAsString();
             String H2 = element.getFirstChild().getNextSibling().getValueAsString();
             String H3 = element.getFirstChild().getNextSibling().getNextSibling().getValueAsString();
             
             
             
             MbElement outRoot = outMessage.getRootElement();
             MbElement outBody = outRoot.createElementAsLastChild(MbXMLNSC.PARSER_NAME);
             MbElement e1 = outBody.createElementAsLastChild(MbXMLNSC.FOLDER,"Result",null);
             MbElement e2 = e1.createElementAsLastChild(MbXMLNSC.FIELD,"H1",H1);
             MbElement e3 = e1.createElementAsLastChild(MbXMLNSC.FIELD,"H2",H2);
             MbElement e4 = e1.createElementAsLastChild(MbXMLNSC.FIELD,"H3",H3);
             
             outAssembly = new MbMessageAssembly(inAssembly, outMessage);
 			// ----------------------------------------------------------
             
			// End of user code
			// ----------------------------------------------------------
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		outAssembly.getMessage().getRootElement().getLastChild().getPreviousSibling().delete();
		out.propagate(outAssembly);

	}

}
